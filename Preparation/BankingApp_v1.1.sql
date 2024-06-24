CREATE SCHEMA BANK;
 COMMENT ON SCHEMA BANK
     IS 'Bank Application Schema';
	 
-------------------------------
/* 
	Is it necessary to have address as a separate db table? 
	Can't these fields be added to Admin & Customer tables individually so as to avoid joins in 
	  the query at the time of retrival data.  Not separating address as a separate table - does
	  this voilate Normalization rules (Normalization is not just about creating more no.of tables)
	Will the same adress info have 1-to-M relation with any of the other entites (practically) with
     	which is holds a relation.  
*/
CREATE TABLE bank.address
 (
     addr_id serial PRIMARY KEY,
     addr_line1 varchar(60) NOT NULL,
	 addr_line2 varchar(60),
     city varchar(25) NOT NULL,
     state varchar(25) NOT NULL,
     pincode varchar(6) NOT NULL CHECK (pincode ~ '^[0-9]{6}$')
 );

 COMMENT ON TABLE bank.address
  	IS 'Address data for admins and customers - Master Data';

-------------------------------	
CREATE SEQUENCE bank.user_id_seq START WITH 1000;

CREATE TABLE bank.user (
   user_id INTEGER DEFAULT nextval('bank.user_id_seq') PRIMARY KEY,
   user_type  char(1) NOT NULL ,
   pwd VARCHAR(50) NOT NULL,
   CONSTRAINT "user_type" CHECK (user_type = 'A' or user_type = 'C')
);	

COMMENT ON TABLE bank.user
  IS 'Application user details for authentication - Master Data';

create table bank.admin (
    admin_id INTEGER PRIMARY KEY,
    admin_name varchar(30) not null,
    email varchar(30) unique not null,
    phone_no varchar(10) unique not null CHECK (phone_no ~ '^[0-9]{10}$'),
    /* accomodate address fields here itself */
	constraint "admin_id_FK" foreign key (admin_id) references bank.user (user_id)
  );

/*
  Notes:
  1) ADMIN table (entity) has 1-to-1 relation with USER table (entity)
  2) The primary key field of ADMIN table, admin_id, apart from PK constraint also has a FK constraint with the PK field of USER table. Therefore, one row in ADMIN table can be relate on only one row of USER table; and vice-versa is also true - this makes the Cardinal Relationship between USER table and ADMIN table a 1-to-1 relationship.
*/ 
  COMMENT ON TABLE bank."admin"
  	IS 'Admin data for Bank Application - Master data';

CREATE TABLE bank.customer
 (
    cust_id INTEGER  PRIMARY KEY,
    cust_name VARCHAR(50) NOT NULL, 
    email VARCHAR(50) UNIQUE NOT NULL,
    gender VARCHAR(1) CHECK (gender IN ('M', 'F', 'O')),
    martial_status VARCHAR(10) CHECK (martial_status IN ('SINGLE', 'MARRIED','WIDOWED','DIVORCED')),
    /* accomodate address fields of customer here itself */
    aadhar_no VARCHAR(12) UNIQUE NOT NULL CHECK (aadhar_no ~ '^[0-9]{12}$') , 
    pan_no VARCHAR(10) UNIQUE CHECK (LENGTH(pan_no) = 10),
    phone_no VARCHAR(10) NOT NULL CHECK (phone_no ~ '^[0-9]{10}$'),
    CONSTRAINT "cust_id_FK" FOREIGN KEY (cust_id) REFERENCES bank.user (user_id)
 );
COMMENT ON TABLE bank."admin"
  	IS 'Customer data for Bank Application - Master data';
/*
  Notes: The 1-to-1 relationship concept also applies to USER & CUSTOMER entities (tables).
*/
	
-------------------------------

CREATE SEQUENCE bank.account_id_seq START WITH 100000;

 CREATE TABLE bank.account
 ( 
     account_no INTEGER DEFAULT nextval('bank.account_id_seq') PRIMARY KEY,
     balance DECIMAL(10,2) NOT NULL,
     date_of_open DATE NOT NULL,
     status BOOLEAN NOT NULL,
     cust_id INTEGER NOT NULL,
     CONSTRAINT "customer_FK" FOREIGN KEY (cust_id) REFERENCES bank.customer (cust_id)
 );

 COMMENT ON TABLE bank."account"
     IS 'Account Information of a Customer';

/*
  Notes: 
  1) The cust_id field of ACCOUNT table has a FK relation with cust_id field of CUSTOMER table, but there is no PK or UNIQUE key constraint on cust_id field of ACCOUNT table.  This means for multiple rows of ACCOUNT table the same cust_id can be used.
  2) The cardinal relationship between CUSTOMER entity and ACCOUNT entity 1-to-M.
*/
-------------------------------

CREATE TABLE bank.bank_tx
 (	
     tx_id SERIAL PRIMARY KEY,
     account_no INTEGER NOT NULL,
     tx_amt DECIMAL(10,2) NOT NULL,
	 bal_amount decimal(10,2) NOT NULL,
     tx_type VARCHAR(2) NOT NULL CHECK (tx_type IN ('DR', 'CR')),
     date_of_transaction DATE NOT NULL,
     admin_id INTEGER NOT NULL,
     contra_tx_id INTEGER,  
     CONSTRAINT "account_FK" FOREIGN KEY (account_no) REFERENCES bank.account (account_no),
     CONSTRAINT "admin_FK" FOREIGN KEY (admin_id) REFERENCES bank.admin (admin_id),
	 CONSTRAINT "contra_tx_id" FOREIGN KEY (contra_tx_id) REFERENCES bank.bank_tx (tx_id)
 );

 COMMENT ON TABLE bank.bank_tx
      IS 'Transaction information of account';
/*
Notes about contra_tx_id and related bank transaction data: 
1) In accounts contra-entry is a balancing entry where for every Debit there is a corresponding Credit

2) What does the data in contra_tx column indicate:
   2a) When contra_tx_id is NOT NULL the row is it is a transfer tx
   2b) When contra_tx_id is NULL and tx_type = 'DR' the row is an withdrawal
   2c) When contra_tx_id is NULL and tx_type = 'CR' the row is an deposit

3) Data in column contra_tx will always be populated by an UPDATE statement after the SUCCESSFUL
	pair of INSERT commands related to a transfer transaction are done.

4) The complete database transaction (JBDC tx in application) for a bank transafer tx will include 6 SQL statements:
		i)   INSERT a Debit tx for sender account                     
					[bank_tx table]
		ii)  UPDATE to reduce the balance of sender account                     
					[bank.account]
		iii) INSERT a Credit tx for receiver Account                
					[bank_tx table]
		iv)  UPDATE to increase the balance of receiver account      
					[bank.account]
		v)   UPDATE of contra_tx of Sender's Debit tx entry with corresponding Credit tx_id 
		
		vi)  UPDATE of contra_tx of Reciver's Credit tx entry with corresponding Debit tx_id
		
5) In case of deposit or withdrawal only the first 4 SQL statemets listed in above point will be applicable.	

6) This db table desing reduces the number of SQL joins we will have to use while fetching data.  Fewer the joins means better performance of SELECT statements. --- @@@ An important performance optimization rule that was pointed out by Mr. Srinivas during the project demo session. @@@	

7) Join tables with composite PK and each column that is part of PK having FK constraint with another table becomes mandatory only in the case of M-to-M relationship between db tables.
*/