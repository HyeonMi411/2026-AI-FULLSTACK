package com.the703.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.api.ApiOpenAi;
import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;
import com.the703.util.UtilPaging;

@Controller
@RequestMapping("/board")    // 怨듯넻 prefix  #1)
public class Sboard2Controller { 
	@Autowired   private Sboard2Service service; 
	
	//////////////////////////// 이부분동작확인1
	@GetMapping("/search")
	@ResponseBody
	public List<Sboard2Dto> searchBoard(@RequestParam("keyword") String keyword) {
	    return service.searchByKeyword(keyword); 
	}
	
	@Autowired    ApiOpenAi  ai;
	@PostMapping(value="/openai"  , produces = MediaType.APPLICATION_JSON_VALUE  )
	@ResponseBody
	public String ai_post(@RequestBody   String content) {
	    return ai.getAIResponse(content); 
	}
	
	/*														*/
	/*														*/
	//1. �쟾泥대━�뒪�듃  /board/list
	@GetMapping("/list")//   view媛믩꽆湲곌린     �럹�씠吏�踰덊샇   
	public String list(   Model   model  ,  @RequestParam(value="pageNo"  , defaultValue = "1")  int pageNo) {  
		model.addAttribute("paging" , new UtilPaging(     service.selectCnt() , pageNo  ));
		model.addAttribute("list"   , service.list10(pageNo));
		return "board/list"; 
	} // prefix(/templates) + board/list  +  suffix(.html)

	/*														*/
	/*														*/
	//2. 湲��벐湲� �뤌    GET: /board/write      
	//3. 湲��벐湲� 湲곕뒫   POST: /board/write   
	@GetMapping("/write")  public String write_get() {   return "board/write"; }  
	@PostMapping("/write") public String write_post( MultipartFile file , Sboard2Dto dto, RedirectAttributes rttr) {
		String  result ="湲��벐湲� �떎�뙣";
		if(service.insert(file, dto) > 0) { result ="湲��벐湲� �꽦怨�"; }
		rttr.addFlashAttribute("success", result);
		return "redirect:/board/list"; 
	} 
	
	//4. �긽�꽭蹂닿린     GET: /board/detail    
	@GetMapping("/detail") public String detail_get( Model model, Sboard2Dto dto ) {
		model.addAttribute("dto" , service.detail(dto));
		return "board/detail";
	} 
	 
	//5. �닔�젙 �뤌     GET: /board/edit
	//6. �닔�젙 湲곕뒫   POST: /board/edit
	@GetMapping("/edit")  public String edit_get(Model model,   Sboard2Dto dto  ) { 
		model.addAttribute("dto" , service.updateForm(dto));
		return "board/edit"; 
	} 
	
	@PostMapping("/edit")  public String edit_post(MultipartFile file , Sboard2Dto dto, RedirectAttributes rttr) {  
		String  result ="湲��닔�젙 �떎�뙣";
		if(service.update(file, dto) > 0) { result ="湲��닔�젙 �꽦怨�"; }
		rttr.addFlashAttribute("success", result);
		return "redirect:/board/detail?id=" + dto.getId(); 
	} 

	
	//7. �궘�젣 �뤌     GET: /board/delete
	//8. �궘�젣 湲곕뒫   POST: /board/delete 
	@GetMapping("/delete") public String delete_get() {   return "board/delete"; } 
	
	@PostMapping("/delete")public String delete_post(  Sboard2Dto dto, RedirectAttributes rttr ) {   
		String  result ="湲��궘�젣 �떎�뙣";
		if(service.delete(dto) > 0) { result ="湲��궘�젣 �꽦怨�"; }
		rttr.addFlashAttribute("success", result);
		return "redirect:/board/list"; 
	} 
	
}
/*
1. controller  (�꽌鍮꾩뒪 鍮쇨퀬 �뿰�룞)
- view
- 寃쎈줈

2. controller  (�꽌鍮꾩뒪�뿰寃�)  
*/