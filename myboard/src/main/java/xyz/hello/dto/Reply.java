package xyz.hello.dto;

import lombok.Data;

/*
이름      널?       유형           
------- -------- ------------ 
R_IDX   NOT NULL NUMBER(10)   	//답글번호
R_BIDX  NOT NULL NUMBER(10)   	//게시글번호
REGROUP NOT NULL NUMBER(4)    	//답글그룹
RESTEP  NOT NULL NUMBER(4)    	//답글그룹중에서 순서
RELEVEL NOT NULL NUMBER(4)    	//답글깊이
R_HID   NOT NULL VARCHAR2(20) 	//답글작성자
R_DATE  NOT NULL DATE  			//답글작성일자
 */

//create sequence c_idx;

@Data
public class Reply {
	private int ridx;
	private int rbidx;
	private int regroup;
	private int restep;
	private int relevel;
	private String rhid;
	private String rdate;
}
