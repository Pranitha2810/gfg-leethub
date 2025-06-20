# Write your MySQL query statement below
SELECT eu.unique_id AS unique_id,
    e.name AS name
FROM employees e 
LEFT JOIN employeeUNI as eu
ON e.id=eu.id