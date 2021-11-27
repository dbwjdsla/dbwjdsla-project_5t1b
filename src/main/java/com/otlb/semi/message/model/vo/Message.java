package com.otlb.semi.message.model.vo;

import java.sql.Date;

public class Message {
	private int no;
	private String content;
	private int senderEmpNo;
	private int receiverEmpNo;
	private Date sentDate;
	private Date readDate;

}


//create table message (
//	no number,
//	content varchar2(2000) not null,
//	sender_emp_no number not null,
//	receiver_emp_no	number not null,
//	sent_date date default sysdate not null,
//	read_date date,
//	emp_no	number not null,
//	sender_del_yn	varchar(1)	default 'N' not null,
//	receiver_del_yn varchar(1)	default 'N' not null,
//    constraint pk_message_no primary key(no),
//    constraint ck_message_sender_del_yn check(sender_del_yn in ('Y', 'N')),
//    constraint ck_message_receiver_del_yn check(receiver_del_yn in ('Y', 'N')),
//    constraint fk_message_sender_emp_no foreign key(sender_emp_no) references emp(no),
//    constraint fk_message_receiver_emp_no foreign key(receiver_emp_no) references emp(no)
//);
