package xyz.hello.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import xyz.hello.dao.BoardDAO;
import xyz.hello.dto.Board;
import xyz.hello.exception.BoardNotFoundException;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	private final BoardDAO boardDAO;

	@Transactional
	@Override
	public void addBoard(Board board) {
		boardDAO.insertBoard(board);
		
	}

	@Override
	public void modifyBoard(Board board) throws BoardNotFoundException {
		if(boardDAO.selectBoard(board.getBidx())==null) {
			throw new BoardNotFoundException("해당 게시글을 찾을 수 없습니다.");
		}
		boardDAO.updateBoard(board);
	}

	@Override
	public void removeBoard(int bidx) throws BoardNotFoundException {
		if(boardDAO.selectBoard(bidx)==null) {
			throw new BoardNotFoundException("해당 게시글을 찾을 수 없습니다.");
		}
		boardDAO.deleteBoard(bidx);
	}

	@Override
	public Board getBoard(int bidx) throws BoardNotFoundException {
		if(boardDAO.selectBoard(bidx)==null) {
			throw new BoardNotFoundException("해당 게시글을 찾을 수 없습니다.");
		}
		return boardDAO.selectBoard(bidx);
	}

	@Override
	public List<Board> getBoardList(Map<String, Object> map) {
		return boardDAO.selectBoardList(map);
	} 
}
