SELECT e.empno, e.ename, e.deptno
FROM emp AS e INNER JOIN dept AS d 
ON e.deptno = d.deptno
WHERE 1 =
	CASE
	WHEN d.loc = 'HYDERABAD'
		THEN 0
	ELSE 1
	END;
	
SELECT empno,ename, sal
from emp
where sal in (SELECT max(sal) from emp
			UNION
			SELECT min(sal) from emp);