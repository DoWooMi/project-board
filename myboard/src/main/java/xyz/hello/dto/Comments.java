package xyz.hello.dto;

import lombok.Data;

/*
이름     널?       유형             
------ -------- -------------- 
C_IDX  NOT NULL NUMBER(10)     
REPLY  NOT NULL VARCHAR2(1000) 
C_DATE NOT NULL DATE           
U_DATE          DATE           
C_HID NOT NULL VARCHAR2(20)    
C_BIDX NOT NULL NUMBER(10) 
 */

//create sequence c_idx;

@Data
public class Comments {
	private int cidx;
	private String reply;
	private String cdate;
	private String udate;
	private String chid;
	private int cbidx;
}
