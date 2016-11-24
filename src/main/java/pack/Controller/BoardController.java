package pack.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pack.model.BoardManager;

@CrossOrigin(origins="*")
@RestController
public class BoardController {
	@Autowired
	BoardManager boardManager;
	
	
	@RequestMapping(value="/board/{id}/category",method=RequestMethod.GET)
	@ResponseBody
	public Object getBoardcategory(@PathVariable("id") long id) {
		BoardBean bean=new BoardBean();
		bean.setId(id);
		return boardManager.getCategory(bean);
	}
	@RequestMapping(value="/board/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Object getBoardList(@PathVariable("id") long id) {
		BoardBean bean=new BoardBean();
		bean.setId(id);
		bean.setPage(1);
		return boardManager.getBoardList(bean);
	}
	@RequestMapping(value="/board/{id}/{page}",method=RequestMethod.GET)
	@ResponseBody
	public Object getBoardpageList(@PathVariable("id") long id,@PathVariable("page") int page) {
		BoardBean bean=new BoardBean();
		bean.setId(id);
		bean.setPage(page);
		return boardManager.getBoardList(bean);
	}
	@RequestMapping(value="/board/{id}/{page}/{board_category}",method=RequestMethod.GET)
	@ResponseBody
	public Object getBoardCategoryList(
			@PathVariable("id") long id,
			@PathVariable("page") int page,
			@PathVariable("board_category")String board_category) {
		BoardBean bean=new BoardBean();
		
		bean.setId(id);
		bean.setPage(page);
		bean.setBoard_category(board_category);
		bean.setSearch_category("board_subject");
		bean.setSearch_value("");
		return boardManager.getBoardSearchList(bean);
	}
	@RequestMapping(value="/board/{id}/{page}/{board_category}/{search_category}",method=RequestMethod.GET)
	@ResponseBody
	public Object getBoardSearchListnovalue(
			@PathVariable("id") long id,
			@PathVariable("page") int page,
			@PathVariable("board_category")String board_category,
			@PathVariable("search_category")String search_category) {
		BoardBean bean=new BoardBean();
		bean.setId(id);
		bean.setPage(page);
		bean.setBoard_category(board_category);
		bean.setSearch_category(search_category);
		bean.setSearch_value("");
		return boardManager.getBoardSearchList(bean);
	}
	@RequestMapping(value="/board/{id}/{page}/{board_category}/{search_category}/{search_value}",method=RequestMethod.GET)
	@ResponseBody
	public Object getBoardSearchList(
			@PathVariable("id") long id,
			@PathVariable("page") int page,
			@PathVariable("board_category")String board_category,
			@PathVariable("search_category")String search_category,
			@PathVariable("search_value")String search_value) {
		BoardBean bean=new BoardBean();
		bean.setId(id);
		bean.setPage(page);
		bean.setBoard_category(board_category);
		bean.setSearch_category(search_category);
		bean.setSearch_value(search_value);
		return boardManager.getBoardSearchList(bean);
	}
	
	@RequestMapping(value="/boarddetail/{num}",method=RequestMethod.GET)
	@ResponseBody
	public Object getBoardDetail(@PathVariable("num") int num) {
		BoardBean bean=new BoardBean();
		bean.setBoard_num(num);
		return boardManager.getBoardBynum(bean);
	}
	@RequestMapping(value="/boarddetail/{num}",method=RequestMethod.POST)
	@ResponseBody
	public Object confirmPassword(@PathVariable("num") int num,@RequestBody BoardBean bean) {
		bean.setBoard_num(num);
		return boardManager.confirmPassword(bean);
	}
	@RequestMapping(value="/boarddetail",method=RequestMethod.PUT)
	@ResponseBody
	public Object insertBoard(@RequestBody BoardBean bean,HttpServletRequest request) {
		bean.setBoard_ip(request.getLocalAddr());
		return boardManager.InsertBoard(bean);
	}
	@RequestMapping(value="/boarddetail/{num}",method=RequestMethod.PUT)
	@ResponseBody
	public Object updateBoard(@PathVariable("num") int num,@RequestBody BoardBean bean) {
		bean.setBoard_num(num);
		return boardManager.updateBoard(bean);
	}
	@RequestMapping(value="/boarddetail/{num}",method=RequestMethod.DELETE)
	@ResponseBody
	public Object deleteBoard(@PathVariable("num") int num,@ModelAttribute BoardBean bean) {
		bean.setBoard_num(num);
		return boardManager.deleteBoard(bean);
	}
	
	@RequestMapping(value="/reply",method=RequestMethod.PUT)
	@ResponseBody
	public Object insertReply(@RequestBody ReplyBean bean,HttpServletRequest request){
		bean.setReply_ip(request.getLocalAddr());
		return boardManager.InsertReply(bean);
	}
	@RequestMapping(value="/reply/{num}",method=RequestMethod.DELETE)
	@ResponseBody
	public Object insertReply(@PathVariable("num")int num,@ModelAttribute ReplyBean bean){
		bean.setReply_num(num);
		return boardManager.deleteReply(bean);
	}
	
	
	
}
