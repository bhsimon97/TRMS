-- Initial Tables --

CREATE TABLE employees(
    employee_id NUMBER(10) PRIMARY KEY,
    first_name VARCHAR2(50),
    last_name VARCHAR2(50),
    department_id NUMBER(10),
    position NUMBER(10),
    email VARCHAR2(50),
    username VARCHAR2(50) UNIQUE,
    password VARCHAR2(14),
    supervisor_id number(10),
    balance number(10));
    
CREATE TABLE departments(
    department_id NUMBER(10) PRIMARY KEY,
    department_name VARCHAR2(50),
    department_head_id NUMBER(10));
    
CREATE TABLE requests (
    request_id NUMBER(10) PRIMARY KEY,
    employee_id NUMBER(10),
    supervisor_id NUMBER(10),
    supervisor_approval NUMBER(10),
    supervisor_comments VARCHAR2(500),
    department_head_id NUMBER(10),
    department_head_approval NUMBER(10),
    department_head_comments VARCHAR2(500),
    benco_id NUMBER(10),
    benco_approval NUMBER(10),
    benco_comments VARCHAR2(500),
    course_type VARCHAR2(50),
    req_amount NUMBER(10),
    grading_format VARCHAR2(50),
    location VARCHAR2(100),
    date_requested DATE,
    date_completed DATE,
    hours_missed NUMBER(10,2),
    misc_info VARCHAR2(1000));
    
CREATE TABLE reimbursements(
    reimbursement_id NUMBER(10) PRIMARY KEY,
    employee_id NUMBER(10),
    supervisor_id NUMBER(10),
    supervisor_comments VARCHAR2(500),
    dh_id NUMBER(10),
    dh_comments VARCHAR2(500),
    benco_id NUMBER(10),
    benco_comments VARCHAR2(500),
    course_type VARCHAR2(50),
    grading_format VARCHAR2(50),
    grade VARCHAR2(25),
    completion_proof VARCHAR2(25),
    amount NUMBER(10),
    date_requested DATE,
    date_completed DATE);
    
    
    
-- Foreign Key Restraints --
    
ALTER TABLE employees ADD CONSTRAINT fk_employees_department FOREIGN KEY
(department_id) REFERENCES departments(department_id);

ALTER TABLE departments ADD CONSTRAINT fk_departments_employees FOREIGN KEY 
(department_head_id) REFERENCES employees(employee_id);

ALTER TABLE requests ADD CONSTRAINT fk_requests_employees FOREIGN KEY
(employee_id) REFERENCES employees(employee_id);

ALTER TABLE requests ADD CONSTRAINT fk_requests_supervisor FOREIGN KEY 
(supervisor_id) REFERENCES employees(employee_id);

ALTER TABLE requests ADD CONSTRAINT fk_requests_dh FOREIGN KEY 
(department_head_id) REFERENCES employees(employee_id);

ALTER TABLE requests ADD CONSTRAINT fk_requests_benco FOREIGN KEY 
(benco_id) REFERENCES employees(employee_id);



-- Sequences --

CREATE sequence employee_seq
    start with 1
    increment by 1;
    
CREATE sequence department_seq
    START WITH 1
    INCREMENT BY 1;
    
CREATE sequence request_seq
    START WITH 1
    INCREMENT BY 1;
    
    
    
-- Callable Statements --

CREATE OR REPLACE PROCEDURE add_employee(first_name VARCHAR2, last_name VARCHAR2, position NUMBER, email VARCHAR2, department_id NUMBER, supervisor_id NUMBER, username VARCHAR2, password VARCHAR2, dh_id NUMBER, benco_id NUMBER)
IS
BEGIN

INSERT INTO employees VALUES(employee_seq.nextval, first_name, last_name, department_id, position, email, username, password, supervisor_id, 1000, dh_id, benco_id);

END;

--

CREATE OR REPLACE PROCEDURE add_department(department_name VARCHAR2)
IS
BEGIN

INSERT INTO departments VALUES(department_seq.nextval, department_name, null);

END;

--

CREATE OR REPLACE PROCEDURE add_request(employee_id NUMBER, supervisor_id NUMBER, department_head_id NUMBER, benco_id NUMBER, course_type VARCHAR2, req_amount NUMBER, grading_format VARCHAR2, location VARCHAR2, date_requested VARCHAR2, hours_missed NUMBER, misc_info VARCHAR2, date_completed VARCHAR2)
IS
BEGIN

INSERT INTO requests VALUES(request_seq.nextval, employee_id, supervisor_id, 0, null, department_head_id, 0, null, benco_id, 0, null, course_type, req_amount, grading_format, location, TO_DATE(date_requested, 'YYYY-MM-DD'), TO_DATE(date_completed, 'YYYY-MM-DD'), hours_missed, misc_info);
END;