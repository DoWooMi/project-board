package xyz.hello.dao;

import java.util.List;

import xyz.hello.dto.Reply;

public interface ReplyDAO {
	int insertReply(Reply reply);
	int updateRestep(Reply reply);
	List<Reply> selectreplylist(int rbidx);

}
