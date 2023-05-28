package xyz.hello.dao;

import java.util.List;
import java.util.Map;

import xyz.hello.dto.Reply;

public interface ReplyDAO {
	int insertReply(Reply reply);
	int updateRestep(Reply reply);
	List<Reply> selectreplylist(Map<String, Object> map);

}
