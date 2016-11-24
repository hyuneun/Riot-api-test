package pack.model.board;

public class ReplyDto {
	private int reply_num,reply_delete,board_num,reply_report;
	private String reply_writer,reply_password,reply_content,reply_ip,reply_wdate,reply_gnum;
	
	public int getReply_report() {
		return reply_report;
	}
	public void setReply_report(int reply_report) {
		this.reply_report = reply_report;
	}
	public int getReply_num() {
		return reply_num;
	}
	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}
	public int getReply_delete() {
		return reply_delete;
	}
	public void setReply_delete(int reply_delete) {
		this.reply_delete = reply_delete;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getReply_writer() {
		return reply_writer;
	}
	public void setReply_writer(String reply_writer) {
		this.reply_writer = reply_writer;
	}
	public String getReply_password() {
		return reply_password;
	}
	public void setReply_password(String reply_password) {
		this.reply_password = reply_password;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_ip() {
		return reply_ip;
	}
	public void setReply_ip(String reply_ip) {
		this.reply_ip = reply_ip;
	}
	public String getReply_wdate() {
		return reply_wdate;
	}
	public void setReply_wdate(String reply_wdate) {
		this.reply_wdate = reply_wdate;
	}
	public String getReply_gnum() {
		return reply_gnum;
	}
	public void setReply_gnum(String reply_gnum) {
		this.reply_gnum = reply_gnum;
	}

}
