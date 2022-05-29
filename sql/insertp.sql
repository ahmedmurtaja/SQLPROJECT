create or replace procedure insertS(num1 in number ,num2 in number)

as
begin
	insert into TAKES values(seq_takes.nextval,num1,num2);
end;
