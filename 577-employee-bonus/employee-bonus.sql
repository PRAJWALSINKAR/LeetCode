# Write your MySQL query statement below
SELECT E.NAME , B.BONUS
FROM Employee E LEFT JOIN BONUS B
ON B.EMPID = E.EMPID
WHERE  IFNULL(B.bonus, 0) < 1000;