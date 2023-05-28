package xyz.hello.mapper;

import java.util.List;

import xyz.hello.dto.Reply;

public interface ReplyMapper {
	int insertReply(Reply reply);
	int updateRestep(Reply reply);
	List<Reply> selectreplylist(int rbidx);
}
