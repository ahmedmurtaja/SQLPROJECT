select	 
	 COURSES.CNAME as CNAME,
	 COURSES.HOURS as HOURS 
 from TAKES,STUDENTS,COURSES where COURSES.CID=TAKES.CID and STUDENTS.SID=1;

 -- insert into takes(cid,sid) values(4041,1)
--  create procedure to 