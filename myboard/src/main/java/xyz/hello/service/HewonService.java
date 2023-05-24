package xyz.hello.service;

import java.util.List;

import xyz.hello.dto.Hewon;
import xyz.hello.exception.HewonNotFoundException;
import xyz.hello.exception.LoginAuthFailException;

public interface HewonService {
	void addHewon (Hewon hewon);
	void modifyHewon (Hewon hewon) throws HewonNotFoundException;
	Hewon getHewon(String id) throws HewonNotFoundException ;
	List<Hewon> getHewonList();
	
	Hewon loginAuth(Hewon hewon) throws LoginAuthFailException;
	
}
