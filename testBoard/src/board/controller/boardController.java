package board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import board.dao.boardDAO;
import board.vo.boardVO;
import board.vo.commentVO;
import board.vo.pageVO;

@Controller
public class boardController {

	@Autowired
	boardDAO dao;
	
	@RequestMapping("list.do")
	public String showAllItem(Model model,@RequestParam String name,HttpSession session
				,@RequestParam String nowBlock,@RequestParam String nowPage) {

		pageVO page=new pageVO();
		List<boardVO> list =dao.AllList();
		
		page.setPage(list.size(), Integer.parseInt(nowPage),Integer.parseInt(nowBlock));
		
		System.out.println(page);
		
		List<boardVO> data=new ArrayList<>();
		
		for(int i=page.getBeginPerPage();i<page.getEndPage();i++){
			
			if(i==page.getTotalRecord()){
				break;
			}
			
			data.add(list.get(i));
			
		}
		
		session.setAttribute("name", name);
		model.addAttribute("page", page);
		model.addAttribute("item", data);

		return "list.jsp";
	}

	@RequestMapping("writeForm.do")
	public String writeForm(HttpSession session,HttpServletRequest req) {
		req.setAttribute("user", session.getAttribute("name"));
		return "writeForm.jsp";
	}

	@RequestMapping("write.do")
	public String write(@ModelAttribute boardVO vo,HttpSession session) {

		String name=(String) session.getAttribute("name");
		int cnt = dao.insertItem(vo);

		return "redirect:/list.do?name="+name+"&nowPage=1&nowBlock=1";
	}

	@RequestMapping("content.do")
	public String content(@RequestParam String id, Model model) {
		boardVO vo = dao.selectOne(Integer.parseInt(id));
		model.addAttribute("item", vo);
		List<commentVO> list=dao.selectComment(Integer.parseInt(id));
		model.addAttribute("comment", list);
		return "content.jsp";
	}

	@RequestMapping("deleteForm.do")
	public String deleteForm(@RequestParam String id, Model model) {
		model.addAttribute("id", id);
		return "deleteForm.jsp";
	}

	@RequestMapping("delete.do")
	public String delete(@RequestParam String id, @RequestParam String password,HttpSession session) {

		String pass = dao.selectPass(Integer.parseInt(id));
		String name=(String) session.getAttribute("name");
		if (pass.equals(password)) {
			
			int cnt = dao.deleteItem(Integer.parseInt(id));
			return "redirect:/list.do?name="+name+"&nowPage=1&nowBlock=1";
		} else {
			return "error.jsp?name="+name;
		}

	}

	@RequestMapping("editeForm.do")
	public String editeForm(@RequestParam String id, Model model) {
		boardVO vo = dao.selectOne(Integer.parseInt(id));
		model.addAttribute("item", vo);
		return "editeForm.jsp";
	}
	
	@RequestMapping("edite.do")
	public String edite(@ModelAttribute boardVO vo, @RequestParam String password,HttpSession session) {

		String pass = dao.selectPass(vo.getId());
		String name=(String) session.getAttribute("name");
		if (pass.equals(password)) {
			
			int cnt = dao.updateItem(vo);
			return "redirect:/list.do?name="+name+"&nowPage=1&nowBlock=1";
		} else {
			return "error.jsp?name="+name;
		}

	}
	
	@RequestMapping("insertComment.do")
	@ResponseBody
	public Map listJson(@RequestParam int bnum,@RequestParam String name,
			@RequestParam String ccomment,@RequestParam String password){
		
		commentVO comment=new commentVO(ccomment, password, name, bnum);
		
		dao.insertComment(comment);
		
		Map map=new HashMap<>();
		List<commentVO> list=dao.selectComment(comment.getBnum());
		map.put("jsondata", list);
		
		return map;
	}
	

}
