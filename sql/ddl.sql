create table emp (
    emp_no number,
    emp_name varchar2(20) not null,
    password varchar2(300) not null,
    birthdate date,
    dept_code varchar2(10) not null,
    job_code varchar2(10) not null,
    emp_role    varchar2(1) default 'U',
    gender varchar2(1) not null,
    email varchar2(40) not null,
    phone    varchar2(11) not null,
    quit_yn varchar(1) default 'N' not null, 
    ban_yn varchar(1) default 'N' not null,
    constraint pk_emp_no primary key(emp_no),
    constraint ck_emp_emp_role check(emp_role in ('U', 'A')),
    constraint ck_emp_gender check(gender in ('M', 'F')),
    constraint ck_emp_quit_yn check(quit_yn in ('Y', 'N')),
    constraint ck_emp_ban_yn check(ban_yn in('Y', 'N')),
    CONSTRAINT uq_emp_email UNIQUE(email),
    CONSTRAINT uq_emp_phone unique(phone),
    CONSTRAINT fk_emp_dept_code FOREIGN KEY(dept_code) REFERENCES department(dept_code),
    CONSTRAINT fk_emp_job_code FOREIGN KEY(job_code) REFERENCES job(job_code)
);
CREATE TABLE department(
	dept_code varchar2(10),
	dept_name varchar2(30),
	CONSTRAINT pk_department_dept_code PRIMARY key(dept_code)
);
CREATE TABLE job(
	job_code varchar2(10),
	job_name varchar2(30),
	CONSTRAINT pk_job_job_code PRIMARY key(job_code)
);
create table report_type (
    id number,
    type varchar2(50),
    constraint pk_report_type_id primary key(id)
);

create table report (
    bulletin_id varchar2(1),
    board_no number,
    report_date date default sysdate not null,
    report_type_id number not null,
    issolved    varchar2(1)    default 'N' not null,
    reporter_id number not null,
    constraint pk_bulletin_id_board_no primary key(bulletin_id, board_no),
    constraint fk_reporter_id foreign key(reporter_id) references emp(emp_no),
    constraint fk_report_type_id foreign key(report_type_id) references report_type(id) 
);


create table message (
	no number,
	content varchar2(2000) not null,
	sender_emp_no number not null,
	receiver_emp_no	number not null,
	sent_date date default sysdate not null,
	read_date date default null,
	sender_del_yn	varchar(1)	default 'N' not null,
	receiver_del_yn varchar(1)	default 'N' not null,
    constraint pk_message_no primary key(no),
    constraint ck_message_sender_del_yn check(sender_del_yn in ('Y', 'N')),
    constraint ck_message_receiver_del_yn check(receiver_del_yn in ('Y', 'N')),
    constraint fk_message_sender_emp_no foreign key(sender_emp_no) references emp(emp_no),
    constraint fk_message_receiver_emp_no foreign key(receiver_emp_no) references emp(emp_no)
);

create table food_menu (
	menu_date date,
	main varchar2(30),
	soup varchar2(30),
	side1 varchar2(30),
	side2 varchar2(30),
	side3 varchar2(30),
	dessert varchar2(30),
    constraint pk_food_menu_menu_date primary key(menu_date)	
);

create table board (
    no number,
    title varchar2(100) not null,
    content varchar2(4000) not null,
    reg_date date default sysdate not null,
    read_count number default 0 not null,
    like_count number default 0 not null,
    report_yn  varchar(1) default 'N' not null,
    emp_no number not null,
	category varchar2(20) not null,
    delete_yn varchar2(1) default 'N' not null,
    constraint pk_board_no primary key(no),
    constraint fk_board_emp_no foreign key(emp_no) references emp(emp_no),
    constraint ck_board_report_yn check(report_yn in ('Y', 'N')),
    constraint ck_board_delete_yn check(delete_yn in ('Y', 'N'))
);
create SEQUENCE seq_board_no;

create table attachment (
	no number,
	original_filename	varchar2(255) not null,
	renamed_filename varchar2(255) not null,
	reg_date date  default sysdate not null,
	board_no number not null,
    constraint pk_attachment_no primary key(no),
    constraint fk_attachment_board_no foreign key(board_no) references board(no) on delete cascade
);

create table board_comment (
	no number,
	comment_level	number default 1	not null,
	content varchar2(2000)	not null,
	report_yn varchar(1) default 'N' not null,
	comment_ref number,
	reg_date date default sysdate	not null,
	board_no number not null,
    emp_no number not null,
    delete_yn varchar2(1) default 'N' not null,
    constraint pk_board_comment_no primary key(no), 
    constraint fk_board_comment_board_no foreign key(board_no) references board(no) on delete cascade,
    constraint fk_board_comment_emp_no foreign key(emp_no) references emp(no),
    constraint fk_board_comment_comment_ref foreign key(comment_ref) references board_comment(no),
    constraint ck_board_comment_report_yn check(report_yn in('Y', 'N')),
    constraint ck_board_comment_delete_yn check(delete_yn in('Y', 'N'))
);
create SEQUENCE seq_board_comment_no;

create table anonymous_board (
	no number,
	title	varchar2(100) not null,
	content varchar2(4000) not null,
	reg_date date default sysdate	not null,
	read_count number	default 0 not null,
	category varchar2(20) not null,
	like_count	number default 0 not null,
	report_yn varchar(1) default 'N' not null,
	emp_no number not null,
    delete_yn varchar2(1) default 'N' not null,
    constraint pk_anonymous_board_no primary key(no),
    constraint fk_anonymous_board_emp_no foreign key(emp_no) references emp(emp_no),
    constraint ck_anonymous_board_report_yn check(report_yn in('Y', 'N')),
    constraint ck_anonymous_board_delete_yn check(delete_yn in ('Y', 'N'))
);
create SEQUENCE seq_anonymous_board_no;

create table anonymous_board_comment (
	no number,
	comment_level number default 1 not null,
	content varchar2(2000) not null,
	report_yn varchar(1) default 'N' not null,
	comment_ref number,
	reg_date date default sysdate	not null,
	board_no number not null,
    emp_no number not null,
    delete_yn varchar2(1) default 'N' not null,
    constraint pk_anonymous_board_comment_no primary key(no),
    constraint fk_anonymous_board_comment_board_no foreign key(board_no) references anonymous_board(no) on delete cascade,
    constraint fk_anonymous_board_comment_emp_no foreign key(emp_no) references emp(emp_no),
    constraint fk_anonymous_board_comment_comment_ref foreign key(comment_ref) references board_comment(no),
    constraint ck_anonymous_board_comment_delete_yn check(delete_yn in('Y', 'N'))
);
create SEQUENCE seq_anonymous_board_comment_no;

create table anonymous_attachment (
	no number,
	original_filename	varchar2(255) not null,
	renamed_filename varchar2(255) not null,
	reg_date date default sysdate not null,
	board_no number not null,
    constraint pk_anonymous_attachment_no primary key(no),
    constraint fk_anonymous_attachment_board_no foreign key(board_no) references anonymous_board(no) on delete cascade
);

create table notice (
	no number,
	title	varchar2(100) not null,
	content varchar2(4000) not null,
	reg_date date default sysdate not null,
	read_count number	default 0 not null,
	emp_no	number not null,
    delete_yn varchar2(1) default 'N' not null,
    constraint pk_notice_no primary key(no),
    constraint fk_notice_emp_no foreign key(emp_no) REFERENCES emp(emp_no),
    constraint ck_notice_delete_yn check(delete_yn in ('Y', 'N'))
);
create SEQUENCE seq_notice_no;

create table survey (
	survey_date date,
	emp_no	number not null,
	answer1	number not null,
	answer2 number not null,
	answer3 number not null,
	answer4 number not null,
	answer5 number not null,
	short_answer varchar2(100),
    constraint pk_survey_date primary key(survey_date),
    constraint ck_survey_answer1 check(answer1 in (1, 2, 3, 4, 5)),
    constraint ck_survey_answer2 check(answer1 in (1, 2, 3, 4, 5)),
    constraint ck_survey_answer3 check(answer1 in (1, 2, 3, 4, 5)),
    constraint ck_survey_answer4 check(answer1 in (1, 2, 3, 4, 5)),
    constraint ck_survey_answer5 check(answer1 in (1, 2, 3, 4, 5)),
    constraint fk_survey_food_menu foreign key(survey_date) REFERENCES food_menu(menu_date),
    constraint fk_survey_emp foreign key(emp_no) REFERENCES emp(emp_no)
);

