package xyz.hello.dto;

import lombok.Data;

/*
이름     널?       유형             
------ -------- -------------- 
C_IDX  NOT NULL NUMBER(10)     
REPLY  NOT NULL VARCHAR2(1000) 
C_DATE NOT NULL DATE           
U_DATE          DATE           
C_HIDX NOT NULL NUMBER(10)     
C_BIDX NOT NULL NUMBER(10) 
 */

//create sequence c_idx;

@Data
public class Comments {
	private int cIdx;
	private String reply;
	private String cDate;
	private String uDate;
	private int cHidx;
	private int cBidx;
}
