select emp_id,emp_name,sal as total_sal,sum(sal)
from emp 
group by sal,emp_id,emp_name 
order by sal desc;

insert into emp values(109,'laxmin','laxmi@gmail.com',6000);

select * from emp;

select sal,sum(sal) as sum_sal from emp group by sal;

select min(sal) from (select distinct sal from emp order by sal desc limit 3);

select distinct sal from emp order by sal desc limit 3;

select * 
from emp 
where sal = (select min(sal) from (select distinct sal 
								  from emp 
								  order by sal desc limit 4));
								  
select * from emp where sal = 2000 limit 1;

select *
from emp
where sal in (select distinct sal from emp order by sal desc limit 3);

select distinct sal from emp order by sal limit 6;

select max(sal) from (select distinct sal from emp order by sal limit 4);

select *
from emp
where sal = (select max(sal) from (select distinct sal from emp order by sal limit 4));

select distinct sal from emp order by sal limit 4;

select * from emp
where sal in (select distinct sal from emp order by sal limit 4);

SELECT emp_id, emp_name, sal, ROW_NUMBER() OVER (ORDER BY sal DESC) AS row_num
FROM emp;

SELECT emp_id, emp_name, sal, RANK() OVER (ORDER BY sal DESC) AS ranking
FROM emp;

SELECT emp_id, emp_name, sal, DENSE_RANK() OVER (ORDER BY sal DESC) AS ranking
FROM emp;

SELECT emp_id, emp_name, sal, LEAD(sal) OVER (ORDER BY sal DESC) AS next_salary
FROM emp;

SELECT emp_id, emp_name, sal, SUM(sal) OVER (PARTITION BY emp_id) AS total_salary
FROM emp;








