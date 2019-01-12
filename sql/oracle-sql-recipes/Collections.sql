SET SERVEROUTPUT ON;
DECLARE
  type list IS TABLE OF VARCHAR2(100);
  l_list list := list('a', 'b', 'c', 'c', 'd', 'e', 'f', 'f');
BEGIN
  FOR i IN l_list.first..l_list.last
  LOOP
    dbms_output.put_line(l_list(i));
  END LOOP;
END;
