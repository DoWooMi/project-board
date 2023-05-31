package xyz.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.hello.dao.ReplyDAO;
import xyz.hello.dto.Reply;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
	
	private final ReplyDAO replyDAO;

	@Override
	public void addBoard(Reply reply) {
		int regroup = reply.getRegroup();
		if(regroup==0) {
			replyDAO.insertReply(reply);
			regroup=reply.getRidx();
			replyDAO.updateRegroup(regroup);
		} else {
			replyDAO.insertReply(reply);
			replyDAO.updateRestep(reply);
			replyDAO.updateRelevel(reply);
		}
	}

	@Override
	public List<Reply> getReplyList(int rbidx) {
		return replyDAO.selectreplylist(rbidx);
	}

}
