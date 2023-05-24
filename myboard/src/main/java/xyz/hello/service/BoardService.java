package xyz.hello.service;

import java.util.List;
import java.util.Map;

import xyz.hello.dto.Board;
import xyz.hello.exception.BoardNotFoundException;

public interface BoardService {

	void addBoard(Board board);
	void modifyBoard(Board board) throws BoardNotFoundException;
	void removeBoard(int bidx) throws BoardNotFoundException;
	Board getBoard(int bidx) throws BoardNotFoundException;
	List<Board> getBoardList(Map<String, Object> map);
	
}
