package xyz.hello.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xyz.hello.dto.Board;
import xyz.hello.dto.Hewon;
import xyz.hello.exception.BoardNotFoundException;
import xyz.hello.service.BoardService;

@Controller
@RequiredArgsConstructor
public class BoardController {
	
	private final BoardService boardService;
	private final WebApplicationContext context;
	
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
	
	
	@RequestMapping(value = "/blog")
	public String blogmain() {
		return "blog/main";
	}

}
