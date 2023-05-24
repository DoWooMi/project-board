package xyz.hello.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.hello.dto.Hewon;
import xyz.hello.mapper.HewonMapper;

@Repository
@RequiredArgsConstructor
public class HewonDAOImpl implements HewonDAO {

	private final SqlSession sqlsession;
	
	@Override
	public int insertHewon(Hewon hewon) {
		return sqlsession.getMapper(HewonMapper.class).insertHewon(hewon);
	}

	@Override
	public int updateHewon(Hewon hewon) {
		return sqlsession.getMapper(HewonMapper.class).updateHewon(hewon);
	}

	@Override
	public int updatePassword(Hewon hewon) {
		return 0;
	}

	@Override
	public Hewon selectHewon(String id) {
		return sqlsession.getMapper(HewonMapper.class).selectHewon(id);
	}

	@Override
	public List<Hewon> selectHewonList() {
		return sqlsession.getMapper(HewonMapper.class).selectHewonList();
	}

}
