package xyz.hello.service;

import java.util.List;
import java.util.Map;

import xyz.hello.dto.Reply;

public interface ReplyService {
	void addBoard(Reply reply);
	List<Reply> getReplyList(Map<String, Object> map);
}
