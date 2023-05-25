package xyz.hello.dto;

import lombok.Data;

/*
이름      널?       유형             
------- -------- -------------- 
B_IDX   NOT NULL NUMBER(10)     
TITLE   NOT NULL VARCHAR2(100)  
CONTENT NOT NULL VARCHAR2(2000) 
C_DATE  NOT NULL DATE           
CNT     NOT NULL NUMBER(10)     
IMG              VARCHAR2(500)  
B_HID  NOT NULL VARCHAR2(20) 
 */

//create sequence b_idx;

@Data
public class Board {
	private int bidx;
	private String title;
	private String content;
	private String cdate;
	private int cnt;
	private String img;
	private String bhid;
	
	private int rn;
	
	
}
