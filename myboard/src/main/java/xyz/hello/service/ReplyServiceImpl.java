package xyz.hello.service;

import java.util.List;
import java.util.Map;

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
			regroup=reply.getRidx();
		} else {
			replyDAO.updateRestep(reply);
			int restep = reply.getRestep()+1;
			int relevel = reply.getRelevel()+1;
			reply.setRestep(restep);
			reply.setRelevel(relevel);
		}
		replyDAO.insertReply(reply);
	}

	@Override
	public List<Reply> getReplyList(Map<String, Object> map) {
		return replyDAO.selectreplylist(map);
	}

}
