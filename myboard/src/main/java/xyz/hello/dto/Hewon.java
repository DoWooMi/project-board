package xyz.hello.dto;

import lombok.Data;

/*
�̸�    ��?       ����            
----- -------- ------------- 
ID    NOT NULL VARCHAR2(20)  
PW    NOT NULL VARCHAR2(100) 
PHONE NOT NULL VARCHAR2(100) 
NAME  NOT NULL VARCHAR2(20)  
EMAIL NOT NULL VARCHAR2(100) 
*/

@Data
public class Hewon {
	private String id;
	private String pw;
	private String phone;
	private String name;
	private String email;
}
