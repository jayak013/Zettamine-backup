--SET OPERATOR--
--1. UNION OPERATOR - REMOVES DUPLICATE RESULTSET
SELECT ID,DEPARTMENT 
FROM EMPLOYEE
UNION
SELECT ID,DEPARTMENT
FROM MANAGER;
--2. UNION ALL OPERATOR - PROCESSES ALL, NO DUPLICATES REMOVED
SELECT ID,DEPARTMENT 
FROM EMPLOYEE
UNION ALL
SELECT ID,DEPARTMENT
FROM MANAGER;
--3. INTERSECT - ONLY GIVES MATCHED RESULTSETS
SELECT ID,DEPARTMENT 
FROM EMPLOYEE
INTERSECT
SELECT ID,DEPARTMENT
FROM MANAGER;
--4. EXCEPT - ALL RESULT SETS EXCEPT THOSE ARE IN CORRESPONDING GIVEN RESULTSET
-- DOES NOT PROCESS THE SECOND RESULTSET REMAINING UNIQUE RESULTSETS
SELECT ID,DEPARTMENT 
FROM EMPLOYEE
EXCEPT
SELECT ID,DEPARTMENT
FROM MANAGER;