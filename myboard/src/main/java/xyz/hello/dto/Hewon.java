package xyz.hello.dto;

import lombok.Data;

/*
이름    널?       유형            
----- -------- ------------- 
H_IDX NOT NULL NUMBER(10)    
ID    NOT NULL VARCHAR2(20)  
PW    NOT NULL VARCHAR2(100) 
PHONE NOT NULL VARCHAR2(20)  
NAME  NOT NULL VARCHAR2(20)  
EMAIL NOT NULL VARCHAR2(100)
*/

//create sequence h_idx;

@Data
public class Hewon {
	private int hIdx;
	private String id;
	private String pw;
	private String phone;
	private String name;
	private String email;
}
