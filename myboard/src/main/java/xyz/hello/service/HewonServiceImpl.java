package xyz.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.hello.dao.HewonDAO;
import xyz.hello.dto.Hewon;
import xyz.hello.exception.HewonNotFoundException;
import xyz.hello.exception.LoginAuthFailException;

@Service
@RequiredArgsConstructor
public class HewonServiceImpl implements HewonService {

	private final HewonDAO hewonDAO;
	
	@Transactional
	@Override
	public void addHewon(Hewon hewon) {
		hewonDAO.insertHewon(hewon);
	}

	@Transactional
	@Override
	public void modifyHewon(Hewon hewon) throws HewonNotFoundException {
		hewonDAO.updateHewon(hewon);
	}

	@Override
	public Hewon getHewon(String id) throws HewonNotFoundException {
		Hewon hewon=hewonDAO.selectHewon(id);
		return hewon;
	}

	@Override
	public List<Hewon> getHewonList() {
		return null;
	}

	@Override
	public Hewon loginAuth(Hewon hewon) throws LoginAuthFailException {
		Hewon authHewon=hewonDAO.selectHewon(hewon.getId());
		if(authHewon ==null || authHewon.getId().equals("")) {
			throw new LoginAuthFailException("���̵��� ȸ�������� �������� �ʽ��ϴ�.", hewon.getId());
		}
		if(!hewon.getPw().equals(authHewon.getPw())) {
			throw new LoginAuthFailException("��й�ȣ�� ��ġ���� �ʽ��ϴ�.", hewon.getId());			
		}
		return authHewon;
	}

}
