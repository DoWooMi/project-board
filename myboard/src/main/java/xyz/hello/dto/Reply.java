package xyz.hello.dto;

import lombok.Data;

/*
�̸�      ��?       ����           
------- -------- ------------ 
R_IDX   NOT NULL NUMBER(10)   	//��۹�ȣ
R_BIDX  NOT NULL NUMBER(10)   	//�Խñ۹�ȣ
REGROUP NOT NULL NUMBER(4)    	//��۱׷�
RESTEP  NOT NULL NUMBER(4)    	//��۱׷��߿��� ����
RELEVEL NOT NULL NUMBER(4)    	//��۱���
R_HID   NOT NULL VARCHAR2(20) 	//����ۼ���
R_DATE  NOT NULL DATE  			//����ۼ�����
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
