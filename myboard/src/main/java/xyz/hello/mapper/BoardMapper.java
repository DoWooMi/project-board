package xyz.hello.mapper;

import java.util.List;
import java.util.Map;

import xyz.hello.dto.Board;

public interface BoardMapper {
	
	int insertBoard(Board board);
	int updateBoard(Board board);
	int deleteBoard(int bidx);
	Board selectBoard(int bidx);
	List<Board> selectBoardList(Map<String, Object> map);

}
