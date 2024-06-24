CREATE OR REPLACE PROCEDURE HIKE_SALARY(
	IN eno int,
	IN hike decimal default 0,
	INOUT updated_sal decimal default 0
)
AS
$$
	BEGIN 
		update emp set sal = (sal+(sal*hike*0.01)) 
		where empno = eno;
		updated_sal = (select sal 
					   from emp 
					   where empno = eno);
	END;
$$  LANGUAGE PLPGSQL;

CALL HIKE_SALARY(101,10);