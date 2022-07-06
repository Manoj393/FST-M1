REM   Script: Activity10
REM   Activity10


SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE city='Paris');

select * from salesman;

SELECT * FROM orders 
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE SALESMAN_CITY='Paris');

SELECT grade, COUNT(*) FROM customers 
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

SELECT order_no, purchase_amount, order_date, salesman_id FROM orders 
WHERE salesman_id IN( SELECT salesman_id FROM salesman 
WHERE commission=( SELECT MAX(commission) FROM salesman));
