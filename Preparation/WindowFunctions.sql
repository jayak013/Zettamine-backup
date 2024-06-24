-- Window function 
/*
A window function performs an aggregate-like operation on a set of query rows. However, whereas an aggregate operation groups query rows into a single result row, a window function produces a result for each query row:
https://dev.mysql.com/doc/refman/8.0/en/window-functions-usage.html
*/

SELECT empno, sal FROM emp;

SELECT sum(sal) TOT_SAL FROM EMP;

SELECT DEPTNO, SUM(SAL) TOT_DEPT_SAL
FROM EMP
GROUP BY DEPTNO;

SELECT  EMPNO, DEPTNO, SAL,
       SUM(SAL) OVER() AS TOT_SAL, 
       SUM(SAL) OVER(PARTITION BY DEPTNO) AS TOT_DEPT_SAL 
FROM EMP 
GROUP BY EMPNO, DEPTNO, SAL;