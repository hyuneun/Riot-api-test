package pack.model;

import pack.Controller.BoardBean;
import pack.Controller.ReplyBean;
import pack.model.board.BoardDBInter;
import pack.model.board.BoardDto;
import pack.model.board.ReplyDBInter;
import pack.model.board.ReplyDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class BoardManager {
	@Autowired
	BoardDBInter dbinter;
	@Autowired
	ReplyDBInter replyInter;
	private int pagesize=7;
	
	public Map<String, Object> getBoardList(BoardBean bean){
		HashMap<String, Object> map=new HashMap<>();
		int page=bean.getPage();
		bean.setPage((page-1)*pagesize);
		bean.setPagesize(pagesize);
		try {
			map.put("board_list", dbinter.getBoardListAll(bean));
			map.put("board_count", dbinter.getBoardAllCount(bean));
			map.put("success",true);
		} catch (DataAccessException e) {
			map.put("success",false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> getBoardSearchList(BoardBean bean){
		HashMap<String,Object> map=new HashMap<>();
		int page=bean.getPage();
		bean.setPage((page-1)*pagesize);
		bean.setPagesize(pagesize);
		if(bean.getBoard_category().equals("all")){
			bean.setBoard_category("");
		}
		try {
			map.put("board_list", dbinter.getBoardSearchList(bean));
			map.put("board_count", dbinter.getBoardSearchListCount(bean));
			map.put("success",true);
		} catch (DataAccessException e) {
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> getBoardBynum(BoardBean bean){
		HashMap<String,Object> map=new HashMap<>();
		try {
			map.put("board_detail",dbinter.getBoardByBoardnum(bean));
			map.put("reply_list", replyInter.getReplyList(bean.getBoard_num()));
			map.put("success",true);
		} catch (DataAccessException e) {
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> InsertBoard(BoardBean bean){
		HashMap<String,Object> map=new HashMap<>();
		try {
			map.put("success",dbinter.insertBoard(bean));
		} catch (DataAccessException e) {
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> updateBoard(BoardBean bean){
		HashMap<String,Object> map=new HashMap<>();
		try {
			map.put("success",dbinter.updateBoard(bean));
		} catch (DataAccessException e) {
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> deleteBoard(BoardBean bean){
		HashMap<String,Object> map=new HashMap<>();
		try {
			map.put("success",dbinter.deleteBoard(bean));
		} catch (DataAccessException e) {
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	
	public Map<String,Object> InsertReply(ReplyBean bean){
		HashMap<String,Object> map=new HashMap<>();
		try {
			String selectgnum=bean.getSelectgnum();
			List<ReplyDto> list= replyInter.getReplyList(bean.getBoard_num());
			if(selectgnum==null){
				String gnum=Integer.toString(list.size()+1);
				bean.setReply_gnum(gnum);
				map.put("success", replyInter.insertReply(bean));
				//일반 댓글 작성시 gnum
			}else{
				//대댓글 작성시 gnum길이 검사
				String[] gnumArr=selectgnum.split("-");
				int nest=gnumArr.length;
				if(nest<2){
					int index=0;
					int i=Integer.parseInt(gnumArr[0]);
					
					for(ReplyDto r:list){
					  String[] gnumsplit=r.getReply_gnum().split("-");
					  int j=Integer.parseInt(gnumsplit[0]);
					  if(i>j){
						continue;
					  }else if(i==j){
						  index++;
					  }else{
						break;  
					  }
					}
					selectgnum+="-"+index;
					bean.setReply_gnum(selectgnum);
					map.put("success", replyInter.insertReply(bean));
				}
			}
		} catch (DataAccessException e) {
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	
	public Map<String,Object> confirmPassword(BoardBean bean){
		HashMap<String,Object> map=new HashMap<>();
		try {
			BoardDto dto=dbinter.ConfirmPassword(bean);
			if(dto==null){
				map.put("success", false);
			}else{
				map.put("success", true);
			}
		} catch (DataAccessException e) {
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> deleteReply(ReplyBean bean){
		HashMap<String,Object> map=new HashMap<>();
		try {
			map.put("success",replyInter.deleteReply(bean));
		} catch (DataAccessException e) {
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	public Map<String,Object> getCategory(BoardBean bean){
		HashMap<String,Object> map=new HashMap<>();
		try {
			List<BoardDto> list=dbinter.getBoardCategoryGroup(bean);
			if(list==null){
				map.put("errorMessage", "게시글이 없습니다");
				map.put("success",false);
			}else{
				map.put("success", true);
				map.put("categoryList", list);
			}
			
		} catch (DataAccessException e) {
			map.put("success", false);
			map.put("errorMessage", e.getMessage());
		}
		return map;
	}
	
}
