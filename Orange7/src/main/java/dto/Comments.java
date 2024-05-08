package dto;

public class Comments {
	private int commentId;
	private int boardId;
	private int count;
	private String commentWriter;
	private String comment;
	private String commentTime;
	
	
	
	public Comments(int count) {
		this.count = count;
	}

	public Comments(String commentWriter, String comment) {
		this.commentWriter = commentWriter;
		this.comment = comment;
	}

	public Comments(int boardId, String commentWriter, String comment) {
		super();
		this.boardId = boardId;
		this.commentWriter = commentWriter;
		this.comment = comment;
	}

	public Comments(int boardId, String commentWriter, String comment, String commentTime) {
		this.boardId = boardId;
		this.commentWriter = commentWriter;
		this.comment = comment;
		this.commentTime = commentTime;
	}
	public Comments(int commentId, int boardId, String commentWriter, String comment, String commentTime) {
		this.commentId = commentId;
		this.boardId = boardId;
		this.commentWriter = commentWriter;
		this.comment = comment;
		this.commentTime = commentTime;
	}
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", boardId=" + boardId + ", commentWriter=" + commentWriter
				+ ", comment=" + comment + ", commentTime=" + commentTime + "]";
	}
	
	
}
