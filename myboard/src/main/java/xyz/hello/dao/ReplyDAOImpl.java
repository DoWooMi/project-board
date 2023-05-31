package xyz.hello.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.hello.dto.Reply;
import xyz.hello.mapper.ReplyMapper;

@Repository
@RequiredArgsConstructor
public class ReplyDAOImpl implements ReplyDAO {

	private final SqlSession sqlSession;

	@Override
	public int insertReply(Reply reply) {
		return sqlSession.getMapper(ReplyMapper.class).insertReply(reply);
	}

	@Override
	public int updateRestep(Reply reply) {
		return sqlSession.getMapper(ReplyMapper.class).updateRestep(reply);
	}

	@Override
	public List<Reply> selectreplylist(int rbidx) {
		return sqlSession.getMapper(ReplyMapper.class).selectreplylist(rbidx);
	}

	@Override
	public int deletereply(int ridx) {
		return sqlSession.getMapper(ReplyMapper.class).deletereply(ridx);
	}

	@Override
	public int updateRelevel(Reply reply) {
		return sqlSession.getMapper(ReplyMapper.class).updateRelevel(reply);
	}

	@Override
	public int updateRegroup(int ridx) {
		return sqlSession.getMapper(ReplyMapper.class).updateRegroup(ridx);
	}
	

}
