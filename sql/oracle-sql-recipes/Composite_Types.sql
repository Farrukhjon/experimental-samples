set serveroutput on;
declare 
  type type_record is record(
    field1 varchar2(10)
  );
  
  var_record type_record;
begin
  var_record.field1:='hello';
  dbms_output.put_line(var_record.field1);
end;
