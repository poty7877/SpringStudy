-- 프로젝트에 ojdbc8.jar 연결 한후에 진행
-- 프로젝트 우클릭 -> build path -> config build path -> Libraries 탭 -> classpath에 삽입-> apply
-- Deployment Assembly -> java buildpath Entries -> ojdbc8.jar추가 ->apply
-- 결과 : Referenced Libraries에 ojdbc8.jar 보이면 성공
create sequence seq_board;

create table tbl_board(
	bno			number(10,0),
	title 		varchar2(200) not null,
	content		varchar2(2000) not null,
	writer		varchar2(50) not null,
	regdate		date default sysdate,
	updateDate	date default sysdate
);

alter table tbl_board add constraint pk_board primary key(bno);

insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, 'test제목1', 'test내용1', 'user01');
insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, 'test제목2', 'test내용2', 'user02');
insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, 'test제목3', 'test내용3', 'user03');
insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, 'test제목4', 'test내용4', 'user04');
insert into tbl_board (bno, title, content, writer)
values(seq_board.nextval, 'test제목5', 'test내용5', 'user05');

select * from tbl_board;

create sequence seq_member;

create table tbl_member(
	mno			number(10,0),
	name 		varchar2(20) not null,
	email		varchar2(200) not null unique,
	id			varchar2(50) not null unique,
	pw			varchar2(50) not null,
	regdate 	date default sysdate
);

alter table tbl_member add constraint pk_member primary key(mno);

insert into tbl_member (mno, name, email, id, pw)
values(seq_member.nextval, 'test이름1', 'test메일1', 'user01', 'user01');
insert into tbl_member (mno, name, email, id, pw)
values(seq_member.nextval, 'test이름2', 'test메일2', 'user02', 'user02');
insert into tbl_member (mno, name, email, id, pw)
values(seq_member.nextval, 'test이름3', 'test메일3', 'user03', 'user03');
insert into tbl_member (mno, name, email, id, pw)
values(seq_member.nextval, 'test이름4', 'test메일4', 'user04', 'user04');
insert into tbl_member (mno, name, email, id, pw)
values(seq_member.nextval, 'test이름5', 'test메일5', 'user05', 'user05');

select * from tbl_member;