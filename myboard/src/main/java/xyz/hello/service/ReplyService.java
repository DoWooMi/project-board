package xyz.hello.service;

import java.util.List;

import xyz.hello.dto.Reply;

public interface ReplyService {
	void addBoard(Reply reply);
	List<Reply> getReplyList(int rbidx);
}
