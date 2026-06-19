CREATE TABLE customers (
    customer_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(50),
    age NUMBER,
    balance NUMBER,
    isvip VARCHAR2(5)
);
CREATE TABLE loans (
    loan_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    interest_rate NUMBER(5,2),
    due_date DATE,
    FOREIGN KEY (customer_id)
    REFERENCES customers(customer_id)
);
INSERT INTO customers VALUES (1,'John',65,15000,'FALSE');
INSERT INTO customers VALUES (2,'David',45,9000,'FALSE');
INSERT INTO customers VALUES (3,'Mary',70,20000,'FALSE');
INSERT INTO customers VALUES (4,'Sam',55,12000,'FALSE');
COMMIT;
INSERT INTO loans VALUES (101,1,10,SYSDATE+20);
INSERT INTO loans VALUES (102,2,9,SYSDATE+40);
INSERT INTO loans VALUES (103,3,11,SYSDATE+10);
INSERT INTO loans VALUES (104,4,8,SYSDATE+25);
COMMIT;
select * from customers;
select * from loans;


SET SERVEROUTPUT ON;
DECLARE
BEGIN
    FOR c IN (
        SELECT c.customer_id,
               c.age,
               l.loan_id,
               l.interest_rate
        FROM customers c
        JOIN loans l
        ON c.customer_id = l.customer_id
    )
    LOOP
        IF c.age > 60 THEN
            UPDATE loans
            SET interest_rate = interest_rate - 1
            WHERE loan_id = c.loan_id;

            DBMS_OUTPUT.PUT_LINE(
                'Discount applied to Customer ID '
                || c.customer_id
            );
        END IF;
    END LOOP;
END;
/


update customers set balance = 80000 where customer_id = 1;
select * from customers;

set serveroutput on;
BEGIN
    FOR c IN(select * from customers where balance > 10000)
    LOOP 
        update customers set isvip = 'TRUE' where customer_id = c.customer_id;
        dbms_output.put_line('Customer ID'|| c.customer_id || 'is now a VIP customer');
    END LOOP;
END;
/


SET SERVEROUTPUT ON;

DECLARE
BEGIN
    FOR c IN (
        SELECT *
        FROM loans
        WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Loan ID ' || c.loan_id ||
            ' is due within the next 30 days'
        );
    END LOOP;
END;
/


   