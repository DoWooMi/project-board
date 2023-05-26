package xyz.hello.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xyz.hello.dao.BoardDAO;
import xyz.hello.dto.Board;
import xyz.hello.dto.Hewon;
import xyz.hello.exception.BoardNotFoundException;
import xyz.hello.exception.HewonNotFoundException;
import xyz.hello.service.BoardService;
import xyz.hello.service.HewonService;
import xyz.hello.util.Pager;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	private final WebApplicationContext context;
	private final BoardDAO boardDAO;
	private final HewonService hewonService;
	
	//게시글등록폼
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String write(HttpSession session, Model model) {
		Hewon loginHewon= (Hewon)session.getAttribute("loginHewon");
		model.addAttribute("loginHewon", loginHewon);
		return "blog/write";
	}
	
	
	//파일 업로드하여 삽입 후 업로드 이름으로 이미지 이름 변경
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam MultipartFile uploadFile, Model model, @ModelAttribute Board board) throws BoardNotFoundException, IOException {
		String uploadDirectory=context.getServletContext().getRealPath("/resources/img");
		String originalFilename=uploadFile.getOriginalFilename();
		File file=new File(uploadDirectory, originalFilename);
		String uploadFilename=originalFilename;
		
		int i=0;
		while(file.exists()) {
			i++;
			int index=originalFilename.lastIndexOf(".");
			uploadFilename=originalFilename.substring(0, index)+"_"+i+originalFilename.substring(index);
			file=new File(uploadDirectory, uploadFilename);
		}
		uploadFile.transferTo(file);
		
		model.addAttribute("originalFilename", originalFilename);
		model.addAttribute("uploadFilename", uploadFilename);
		
		boardService.addBoard(board);
		Board boardinfo=boardService.getBoard(board.getBidx());
		boardinfo.setImg(uploadFilename);
		boardService.modifyBoard(boardinfo);
		
		return "redirect:/blog";
	}
	
	//게시글리스트출력
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String blogmain() {
		return "blog/main";
	}
	
	@RequestMapping(value = "/blogList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> blogList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam Map<String, Object> params) {
		
		int totalQuestion = boardDAO.selectBoardCount(params);
		int pageSize=6;
		int blockSize=5;
		
		Pager pager= new Pager(pageNum, totalQuestion, pageSize, blockSize);
		
		Map<String, Object> pageMap = new HashMap<String, Object>();
		pageMap.put("startRow", pager.getStartRow());
		pageMap.put("endRow", pager.getEndRow());
		pageMap.put("sDate", params.get("sDate"));
		pageMap.put("eDate", params.get("eDate"));
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Board> boardList = boardService.getBoardList(pageMap);
		
		resultMap.put("boardList", boardList);
		resultMap.put("pager", pager);
		
		return resultMap; 
	}
	
	//게시글출력폼
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String blogview(@RequestParam int bidx, Model model) throws BoardNotFoundException, HewonNotFoundException {
		Board board= boardService.getBoard(bidx);
		board.setCnt(board.getCnt()+1);
		boardService.modifyBoard(board);
		model.addAttribute("boardview", board);
		model.addAttribute("hewoninfo", hewonService.getHewon(boardService.getBoard(bidx).getBhid()));
		return "blog/view";
	}
	
	//게시글삭제
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteblog(@RequestParam int bidx) throws BoardNotFoundException {
		boardService.removeBoard(bidx);
		return "redirect:/blog";
	}
	
	
	//예외처리
	@ExceptionHandler(BoardNotFoundException.class)
	public String userinfoExceptionHandler(BoardNotFoundException exception) {
		return "exception/exception";
	}

}








