package xyz.hello.util;

import lombok.Data;

//����¡ ó�� ���� ���� �ʵ忡 �����ϱ� ���� Ŭ����
@Data
public class Pager {
	//�����ڸ� �̿��Ͽ� �ʱⰪ�� ���޹޾� �ʵ忡 ����
	private int pageNum;//��û �������� ��ȣ
	private int totalQuestion;//��ü �Խñ��� ����
	private int pageSize;//�ϳ��� �������� ��µ� �Խñ��� ����
	private int blockSize;//�ϳ��� ���� ��µ� ������ ��ȣ�� ����

	//�����ڷ� �ʱ�ȭ�� �ʵ尪�� ����Ͽ� ������� �ʵ忡 ����
	private int totalPage;//��ü �������� ����
	private int startRow;//��û �������� ��µ� �Խñ��� ���� ���ȣ
	private int endRow;//��û �������� ��µ� �Խñ��� ���� ���ȣ
	private int startPage;//���� ���� ��µ� ���� ������ ��ȣ
	private int endPage;//���� ���� ��µ� ���� ������ ��ȣ
	private int prevPage;//���� ���� ��µ� ���� ������ ��ȣ
	private int nextPage;//���� ���� ��µ� ���� ������ ��ȣ
	
	
	public Pager(int pageNum, int totalQuestion, int pageSize, int blockSize) {
		super();
		this.pageNum = pageNum;
		this.totalQuestion = totalQuestion;
		this.pageSize = pageSize;
		this.blockSize = blockSize;
		
		calcPage();
	}
	
	//���� ������� �ʵ忡 �����ϴ� �޼ҵ� - �����ڿ��� ȣ���Ͽ� ���
	private void calcPage() {
		totalPage=(int)Math.ceil((double)totalQuestion/pageSize);
		if(pageNum<=0 || pageNum>totalPage) {
			pageNum=1;
		}
		
		startRow=(pageNum-1)*pageSize+1;
 		endRow=pageNum*pageSize;
		if(endRow>totalQuestion) {
			endRow=totalQuestion;
		}
		
		startPage=(pageNum-1)/blockSize*blockSize+1;
		endPage=startPage+blockSize-1;
		if(endPage>totalPage) {
			endPage=totalPage;
		}
		
		prevPage=startPage-blockSize;
		nextPage=startPage+blockSize;
	}
	
}