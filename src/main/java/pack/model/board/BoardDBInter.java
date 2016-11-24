package pack.model.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.Controller.BoardBean;

public interface BoardDBInter {
	
	@Select("select board_category,count(board_num) as count from board"
			+ " where id=#{id} and"
			+ " board_delete=0"
			+ " group by board_category")
	public List<BoardDto> getBoardCategoryGroup(BoardBean bean);
	@Select("select * from board"
			+ " where id=#{id} and"
			+ " board_delete=0"
			+ " order by board_num desc"
			+ " limit #{page},#{pagesize}")
	public List<BoardDto> getBoardListAll(BoardBean bean);
	@Select("select count(*) from board where board_delete=0 and id=#{id}")
	public int getBoardAllCount(BoardBean bean);
	
	@Select("select * from board"
			+ " where board_delete=0 and id=#{id} and board_category like CONCAT('%',#{board_category},'%')"
			+ " and ${search_category} like CONCAT('%',#{search_value},'%')"
			+ " order by board_num desc"
			+ " limit #{page},#{pagesize}")
	public List<BoardDto> getBoardSearchList(BoardBean bean);
	@Select("select count(*) from board"
			+ " where board_delete=0 and id=#{id} and board_category like CONCAT('%',#{board_category},'%')"
			+ " and ${search_category} like CONCAT('%',#{search_value},'%')")
	public int getBoardSearchListCount(BoardBean bean);
	
	@Select("select board_num,board_category,board_subject,board_content,board_ip,board_wdate,id,board_writer from board where board_delete=0 and board_num=#{board_num}")
	public BoardDto getBoardByBoardnum(BoardBean bean);
	@Select("select * from board where board_delete=0 and board_num=#{board_num} and board_password=#{board_password}")
	public BoardDto ConfirmPassword(BoardBean bean);
	
	@Insert("insert into board"
			+ "(board_writer,board_password,board_subject,board_content,"
			+ "board_ip,board_wdate,id,board_category)"
			+ " values(#{board_writer},#{board_password},"
			+ "#{board_subject},#{board_content},#{board_ip},"
			+ "now(),#{id},#{board_category}) ")
	public boolean insertBoard(BoardBean bean);
	
	@Update("update board set"
			+ " board_subject=#{board_subject},board_content=#{board_content},"
			+ " board_category=#{board_category} "
			+ " where board_num=#{board_num} and board_password=#{board_password}")
	public boolean updateBoard(BoardBean bean);
	
	@Update("update board set"
			+ " board_delete=1"
			+ " where board_num=#{board_num}"
			+ " and board_password=#{board_password}")
	public boolean deleteBoard(BoardBean bean);
	
}
