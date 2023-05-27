package xyz.hello.mapper;

import java.util.List;

import xyz.hello.dto.Hewon;

public interface HewonMapper {
	
	int insertHewon(Hewon hewon);
	int updateHewon(Hewon hewon);
	int updatePassword(Hewon hewon);
	Hewon selectHewon(String id);
	List<Hewon> selectHewonList();
	int deleteHewon(String id);
}
