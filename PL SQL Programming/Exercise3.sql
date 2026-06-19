CREATE TABLE accounts (
    account_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    account_type VARCHAR2(20),
    balance NUMBER(12,2)
);
CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(50),
    department VARCHAR2(30),
    salary NUMBER(10,2)
);
INSERT INTO accounts VALUES (101,1,'Savings',5000);
INSERT INTO accounts VALUES (102,2,'Savings',8000);
INSERT INTO accounts VALUES (103,3,'Current',12000);

select * from accounts;


create or replace procedure ProcessMonthlyInterest is 
begin
    update accounts set balance = balance + (balance *0.01) where account_type = 'Savings';
    dbms_output.put_line('Monthly interest processed for Savings accounts');
end;
/

execute  ProcessMonthlyInterest;
select * from accounts;

INSERT INTO employees VALUES (1,'John','HR',30000);
INSERT INTO employees VALUES (2,'David','IT',50000);
INSERT INTO employees VALUES (3,'Mary','IT',45000);

COMMIT;
select * from employees;


CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
IS
BEGIN
    UPDATE employees
    SET salary = salary + (salary * p_bonus_percent / 100)
    WHERE department = p_department;
    DBMS_OUTPUT.PUT_LINE('Bonus updated successfully.');
END;
/

execute UpdateEmployeeBonus('IT', 10);
select * from employees;

CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    -- Get source account balance
    SELECT balance
    INTO v_balance
    FROM accounts
    WHERE account_id = p_from_account;

    -- Check sufficient balance
    IF v_balance >= p_amount THEN

        -- Deduct from source account
        UPDATE accounts
        SET balance = balance - p_amount
        WHERE account_id = p_from_account;

        -- Add to destination account
        UPDATE accounts
        SET balance = balance + p_amount
        WHERE account_id = p_to_account;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Fund transfer successful.');

    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Account not found.');

    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/


SET SERVEROUTPUT ON;

BEGIN
    TransferFunds(103,101,2000);
END;
/

select * from accounts;