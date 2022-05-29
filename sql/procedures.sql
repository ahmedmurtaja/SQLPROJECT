create or replace procedure enroll (num1 in number ,num2 in number)

as
begin
	insert into TAKES(cid,sid,takesid) values(num1,num2,seq_takes.nextval);
end;
/
create or replace procedure update_course_name (id in number,coname in varchar)

as
begin
	UPDATE courses SET cname=coname WHERE cid=id;
end;

/
create or replace procedure delcourse(id in number)

as
begin
	DELETE FROM courses WHERE cid=id;
end;

/
CREATE OR REPLACE function get_result (id in number)
 return varchar2

IS
rc varchar2(500);
rh number;

BEGIN
 SELECT cname INTO rc
 FROM courses WHERE cid=id;
 return rc;
END;
/
