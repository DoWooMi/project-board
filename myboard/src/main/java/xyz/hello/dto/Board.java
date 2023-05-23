package xyz.hello.dto;

import lombok.Data;

/*
이름      널?       유형             
------- -------- -------------- 
B_IDX   NOT NULL NUMBER(10)     
TITLE   NOT NULL VARCHAR2(100)  
CONTENT NOT NULL VARCHAR2(2000) 
C_DATE  NOT NULL DATE           
U_DATE           DATE           
CNT     NOT NULL NUMBER(10)     
IMG              VARCHAR2(500)  
B_HIDX  NOT NULL NUMBER(10) 
 */

@Data
public class Board {
	private int bIdx;
	private String title;
	private String content;
	private String cDate;
	private String uDate;
	private int cnt;
	private String img;
	private int bHidx;
	
	
}
