package pack.model.board;

public class BoardDto {
	private int board_num,board_delete,board_report,count;
	private String board_writer,board_password,board_subject,board_content,board_ip,board_wdate,board_category;
	private long id;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getBoard_report() {
		return board_report;
	}
	public void setBoard_report(int board_report) {
		this.board_report = board_report;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public int getBoard_delete() {
		return board_delete;
	}
	public void setBoard_delete(int board_delete) {
		this.board_delete = board_delete;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_password() {
		return board_password;
	}
	public void setBoard_password(String board_password) {
		this.board_password = board_password;
	}
	public String getBoard_subject() {
		return board_subject;
	}
	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_ip() {
		return board_ip;
	}
	public void setBoard_ip(String board_ip) {
		this.board_ip = board_ip;
	}
	public String getBoard_wdate() {
		return board_wdate;
	}
	public void setBoard_wdate(String board_wdate) {
		this.board_wdate = board_wdate;
	}
	public String getBoard_category() {
		return board_category;
	}
	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
