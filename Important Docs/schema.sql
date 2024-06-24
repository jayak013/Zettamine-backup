-- Table: EQPT_CATG
CREATE TABLE EQPT_CATG (
    catg_id SERIAL PRIMARY KEY,
    catg_name VARCHAR(50) NOT NULL UNIQUE,
    notes VARCHAR(150)
);

-- Table: OEM_MD
CREATE TABLE OEM_MD (
    oem_id VARCHAR(50) PRIMARY KEY,
    oem_name VARCHAR(50)
);

-- Table: EQPT_VEND
CREATE TABLE EQPT_VEND (
    vend_id SERIAL PRIMARY KEY,
    vend_reg_name VARCHAR(50) NOT NULL UNIQUE
    -- Add address related fields here
);


-- Table: EQPT_TYP
CREATE TABLE EQPT_TYP (
    typ_id SERIAL PRIMARY KEY,
    eqpt_catg_id INTEGER NOT NULL REFERENCES EQPT_CATG(catg_id),
    typ_name VARCHAR(50) NOT NULL UNIQUE,
    mntc_freq INTEGER,
    var_exist BOOLEAN,
    notes VARCHAR(200)
);

-- Table: EQPT_VAR
CREATE TABLE EQPT_VAR (
    var_id SERIAL PRIMARY KEY,
    eqpt_typ_id INTEGER NOT NULL REFERENCES EQPT_TYP(typ_id),
    var_name VARCHAR(50) NOT NULL UNIQUE,
    notes VARCHAR(300)
);

-- Table: EQPT
CREATE TABLE EQPT (
    eqpt_id SERIAL PRIMARY KEY,
    eqpt_name VARCHAR(50) NOT NULL UNIQUE,
    eqpt_typ_id INTEGER NOT NULL REFERENCES EQPT_TYP(typ_id),
    eqpt_var_id INTEGER REFERENCES EQPT_VAR(var_id),
    oem_id VARCHAR(50) REFERENCES OEM_MD(oem_id),
    eqpt_vend_id INTEGER NOT NULL REFERENCES EQPT_VEND(vend_id),
    mfr_model VARCHAR(50) NOT NULL,
    load_cpcty INTEGER,
    load_cpcty_uom VARCHAR(5),
    mfg_dt DATE,
    pur_dt DATE,
    wrty_exp_dt DATE,
    wrty_doc_link VARCHAR(255),
    status VARCHAR(50),
    eqpt_notes VARCHAR(500),
    loc_id VARCHAR(20)
);

-- Table: REPL_LOG_H
CREATE TABLE REPL_LOG_H (
    log_id SERIAL PRIMARY KEY,
    eqpt_id INTEGER NOT NULL REFERENCES EQPT(eqpt_id),
    repl_trigger VARCHAR(50),
    repl_log_cl_dt DATE
);
-- Table: USERS
CREATE TABLE USERS (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(50) NOT NULL UNIQUE,
    designation VARCHAR(50)
);










-- Table: EQPT_MNTC_TASK
CREATE TABLE EQPT_MNTC_TASK (
    task_id SERIAL PRIMARY KEY,
    task_name VARCHAR(50) NOT NULL UNIQUE,
    eqp_typ_id INTEGER NOT NULL REFERENCES EQPT_TYP(typ_id),
    eqp_var_id INTEGER REFERENCES EQPT_VAR(var_id),
    task_desc TEXT NOT NULL
);

-- Table: SPARE_PART
CREATE TABLE SPARE_PART (
    part_id SERIAL PRIMARY KEY,
    part_name VARCHAR(50) NOT NULL UNIQUE,
    qoh INTEGER,
    uom VARCHAR(50),
    costing_method VARCHAR(50), -- possible values include "FIFO Method", "Specific Identification Method", and "Standard Cost Method"
    std_cost DECIMAL(15,2)
);

-- Table: SPARES_SUPPLIER
CREATE TABLE SPARES_SUPPLIER (
    supplier_id SERIAL PRIMARY KEY,
    supplier_name VARCHAR(50) NOT NULL
    -- Add address related fields here
);

-- Table: SPARES_SUPPLIER_PARTS
CREATE TABLE SPARES_SUPPLIER_PARTS (
    supplier_id INTEGER REFERENCES SPARES_SUPPLIER(supplier_id),
    part_id INTEGER REFERENCES SPARE_PART(part_id),
    lead_time INTEGER,
    PRIMARY KEY (supplier_id, part_id)
);

-- Table: SPARES_PUR_HIST
CREATE TABLE SPARES_PUR_HIST (
    pur_id SERIAL PRIMARY KEY,
    part_id INTEGER NOT NULL REFERENCES SPARE_PART(part_id),
    oem_id VARCHAR(50) REFERENCES OEM_MD(oem_id),
    supplier_id INTEGER NOT NULL REFERENCES SPARES_SUPPLIER(supplier_id),
    invoice_id VARCHAR(30) NOT NULL,
    part_no VARCHAR(50),
    qty INTEGER NOT NULL,
    unit_price DECIMAL(15,2) NOT NULL
);

-- Table: MNTC_LOG_H
CREATE TABLE MNTC_LOG_H (
    log_id SERIAL PRIMARY KEY,
    eqpt_id INTEGER NOT NULL REFERENCES EQPT(eqpt_id),
    created_on DATE,
    created_by INTEGER REFERENCES USERS(user_id),
    start_dt DATE,
    closure_dt DATE,
    closed_by INTEGER REFERENCES USERS(user_id),
    next_due_dt DATE,
    log_notes TEXT,
    mntc_method VARCHAR(50),
    mntc_inv_doc VARCHAR(255),
    repl_log_id INTEGER REFERENCES REPL_LOG_H(log_id),
    status VARCHAR(50) NOT NULL
);

-- Table: MNTC_LOG_I
CREATE TABLE MNTC_LOG_I (
    log_id INTEGER REFERENCES MNTC_LOG_H(log_id),
    task_id INTEGER REFERENCES EQPT_MNTC_TASK(task_id),
    notes TEXT,
    user_id INTEGER REFERENCES USERS(user_id),
    repl_notes TEXT
);

-- Table: DMG_MF_LOG
CREATE TABLE DMG_MF_LOG (
    log_id SERIAL PRIMARY KEY,
    eqpt_id INTEGER NOT NULL REFERENCES EQPT(eqpt_id),
    created_on DATE,
    created_by INTEGER REFERENCES USERS(user_id),
    start_dt DATE,
    closure_dt DATE,
    closed_by INTEGER REFERENCES USERS(user_id),
    dmg_mf_notes TEXT,
    repl_notes TEXT,
    handling_method VARCHAR(50),
    inv_doc VARCHAR(255),
    repl_log_id INTEGER REFERENCES REPL_LOG_H(log_id),
    status VARCHAR(50) NOT NULL
);



-- Table: REPL_LOG_I
CREATE TABLE REPL_LOG_I (
    log_id INTEGER REFERENCES REPL_LOG_H(log_id),
    part_id INTEGER REFERENCES SPARE_PART(part_id),
    repl_dt DATE,
    qty INTEGER,
    unit_cost DECIMAL(17,2),
    repl_notes TEXT,
    tech_id INTEGER
);





-- Table: SPARES_OEM_PUR_HIST
CREATE TABLE SPARES_UID_PUR_HIST (
	spare_id serial PRIMARY KEY,
    uid VARCHAR(50) UNIQUE,
    pur_id INTEGER REFERENCES SPARES_PUR_HIST(pur_id)
);
