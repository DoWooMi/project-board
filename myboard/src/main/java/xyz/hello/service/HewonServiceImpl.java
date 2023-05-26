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
			throw new LoginAuthFailException("아이디의 회원정보가 존재하지 않습니다.", hewon.getId());
		}
		if(!hewon.getPw().equals(authHewon.getPw())) {
			throw new LoginAuthFailException("비밀번호가 일치하지 않습니다.", hewon.getId());			
		}
		return authHewon;
	}

}
