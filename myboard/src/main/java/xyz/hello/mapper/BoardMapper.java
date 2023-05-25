package xyz.hello.mapper;

import java.util.List;
import java.util.Map;

import xyz.hello.dto.Board;

public interface BoardMapper {
	
	int insertBoard(Board board);
	int updateBoard(Board board);
	int deleteBoard(int bidx);
	int selectBoardCount(Map<String, Object> params);
	Board selectBoard(int bidx);
	List<Board> selectBoardList(Map<String, Object> map);

}
