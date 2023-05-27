package xyz.hello.dao;

import java.util.List;

import xyz.hello.dto.Hewon;

public interface HewonDAO {
	int insertHewon(Hewon hewon);
	int updateHewon(Hewon hewon);
	int updatePassword(Hewon hewon);
	Hewon selectHewon(String id);
	List<Hewon> selectHewonList();
	int deleteHewon(String id);
}
