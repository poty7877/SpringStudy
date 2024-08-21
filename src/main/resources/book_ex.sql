create sequence seq_board; -- 자동 번호 생성

create table tbl_board (
	bno			number(10,0),
	title		varchar2(200) not null,
	content		varchar2(2000) not null,
	writer		varchar2(50) not null,
	regdate		date default sysdate,
	updatedate	date default sysdate 
) -- tbl_board 테이블 생성 (번호, 제목, 내용, 작성자, 작성일, 수정일)

alter table tbl_board add constraint pk_board primary key (bno);
select * from dual;
select * from tbl_board;

insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test 제목', 'test 내용', 'user00' );
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test 제목1', 'test 내용1', 'user01' );
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test 제목2', 'test 내용2', 'user02' );
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test 제목3', 'test 내용3', 'user03' );
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test 제목4', 'test 내용4', 'user04' );
insert into tbl_board (bno, title, content, writer) values(seq_board.nextval, 'test 제목5', 'test 내용5', 'user05' );
