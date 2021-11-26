

create table user (
	user_no	number not null,
	user_name varchar2(20) not null,
	password varchar2(300) not null,
	birthdate date,
	dept_name varchar2(15) not null,
	job_name varchar2(15) not null,
	role	varchar2(1),
	gender varchar2(1) not null,
	email varchar2(40) not null,
	phone	varchar2(11) not null,
	quit_yn varchar(1) default N	not null,
	ban_yn varchar(1) default N not null
);

create table report (
	id	number not null,
	report_date date not null,
	report_type varchar2 not null,
	reason varchar2(500) not null,
	board_no varchar2 not null,
	issolved	varchar(1)	default N not null,
	repotee_id	number not null,
	reporter_id number not null
);

create table message (
	no nunber not null,
	content varchar2(2000) not null,
	sender varchar2(20) not null,
	receiver	varchar2(20) not null,
	sent_date date not null,
	read_date	date ,
	user_no	number not null,
	sender_del_yn	varchar(1)	default N not null,
	receiver_del_yn varchar(1)	default N not null
);

create table menu (
	date date not null,
	main varchar2(30),
	soup varchar2(30),
	side1 varchar2(30),
	side2 varchar2(30),
	side3 varchar2(30),
	dessert varchar2(30)		
);

create table board (
    board_no number not null,
    title varchar2(100) not null,
    content varchar2(4000) not null,
    reg_date date default sysdate not null,
    read_count number default 0 not null,
    like_count number default 0 not null,
    report_yn  varchar(1) default n not null,
    user_no number not null,
	category varchar2(20) not null
);

create table attachment (
	no number not null,
	original_filename	varchar2(255) not null,
	renamed_filename varchar2(255) not null,
	reg_date date  default sysdate not null,
	board_no number not null
);

create table board_comment (
	no number not null,
	comment_level	number default 1	not null,
	content varchar2(2000)	not null,
	report_yn varchar(1) default N not null,
	comment_ref number,
	reg_date date default sysdate	not null,
	board_no number not null
);

create table anonymous_board (
	board_no number not null,
	title	varchar2(100) not null,
	content varchar2(4000) not null,
	reg_date date default sysdate	not null,
	read_count number	default 0 not null,
	category varchar2(20) not null,
	like_count	number default 0 not null,
	report_yn varchar(1) default N	not null,
	user_no number not null
);

create table deleted_board (
	board_no number not null,
	origin	varchar2(1) not null,
	title	varchar2(100) not null,
	content varchar2(4000)	not null,
	reg_date date not null,
	read_count number	not null,
	category varchar(20)	not null,
	like_count	number not null,
	report_yn varchar(1) not null,
	user_no	number	not null
);

create table anonymous_board_comment (
	no number not null,
	comment_level	number default 1	not null,
	content varchar2(2000) not null,
	report_yn varchar(1) default N	not null,
	comment_ref number,
	reg_date date default sysdate	not null,
	board_no number not null
);

create table anonymous_attachment (
	no number	not null,
	original_filename	varchar2(255) not null,
	renamed_filename varchar2(255) not null,
	reg_date date default sysdate not null,
	board_no number not null
);

create table notice (
	board_no number not null,
	title	varchar2(100) not null,
	content varchar2(4000) not null,
	reg_date date default sysdate not null,
	read_count number	default 0 not null,
	user_no	number not null
);

create table notice_comment (
	no number not null,
	original_filename	varchar2(255) not null,
	renamed_filename varchar2(255) not null,
	reg_date date not null,
	board_no	number		not null
);

create table survey (
	date2	date		not null,
	user_no	varchar2()		not null,
	answer1	number		not null,
	answer2	number		not null,
	answer3	number		not null,
	answer4	number		not null,
	answer5	number		not null,
	short-answer	varchar2(100)		
);
alter table board add constraint pk_board primary key ( board_no );

alter table attachment add constraint pk_attachment primary key ( no );

alter table user add constraint pk_user primary key ( user_no );

alter table report add constraint pk_report primary key ( id );

alter table message add constraint pk_message primary key ( no );

alter table menu add constraint pk_menu primary key ( date );

alter table anonymous_board add constraint pk_anonymous_board primary key ( board_no );

alter table board_comment add constraint pk_board_comment primary key ( no );

alter table deleted_board add constraint pk_deleted_board primary key ( board_no,
                                                                        origin );

alter table anonymous_board_comment add constraint pk_anonymous_board_comment primary key ( no );

alter table anonymous_attachment add constraint pk_anonymous_attachment primary key ( no );

alter table notice add constraint pk_notice primary key ( board_no );

alter table notice_comment add constraint pk_notice_comment primary key ( no );

alter table survey add constraint pk_survey primary key ( date2,
                                                          user_no );

alter table survey
    add constraint fk_menu_to_survey_1 foreign key ( date2 )
        references menu ( date );

alter table survey
    add constraint fk_user_to_survey_1 foreign key ( user_no )
        references user ( user_no );

