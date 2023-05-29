package xyz.hello.dao;

import java.util.List;

import xyz.hello.dto.Reply;

public interface ReplyDAO {
	int insertReply(Reply reply);
	int updateRestep(Reply reply);
	int updateRelevel(Reply reply);
	int deletereply(int ridx);
	List<Reply> selectreplylist(int rbidx);

}
