CREATE USER book_ex IDENTIFIED BY book_ex default tablespace users temporary tablespace temp;

grant connect, dba to book_ex;

SELECT dbms_xdb.gethttpport() from dual; -- 8080 포트 사용중

-- exec dbms_xdb.sethttpport(9090);
-- 이클립스에서 지원되지 않는 명령어 -> sqlplus에서 함.