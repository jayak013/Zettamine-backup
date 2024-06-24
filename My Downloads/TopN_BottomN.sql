Top-N/Bottom-N Analysis:
~~~~~~~~~~~~~~~~~~~~~~~~~

SELECT SAL FROM EMP WHERE SAL IS NOT NULL ORDER BY SAL DESC LIMIT 3;

SELECT DISTINCT SAL FROM EMP WHERE SAL IS NOT NULL ORDER BY SAL DESC LIMIT 3;

SELECT * FROM EMP
WHERE SAL IN (SELECT DISTINCT SAL FROM EMP WHERE SAL IS NOT NULL ORDER BY SAL DESC LIMIT 3);

SELECT MIN(SAL) THIRD_HIGH_SAL
FROM (SELECT DISTINCT SAL FROM EMP WHERE SAL IS NOT NULL ORDER BY SAL DESC LIMIT 3) AS A;

Find 6 lowest salary values being paid.

Find employee data of those receiving 6 lowest salaries.

Find the 4th lowest salary value.

Find employee data of those receiving 4th lowest salary.

SALES_ORDERS:
Find the top-2 sales 