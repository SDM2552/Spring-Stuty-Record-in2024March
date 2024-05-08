package dto;

public class Board {
	private int num;
	private String title;
	private String content;
	private String regtime;
	private int hits;
	private int memberno;
	private String name;
	private int cCount;
	
	public Board(String title, String content, int memberno) {
		this.title = title;
		this.content = content;
		this.memberno = memberno;
	}
	
	public Board(int num, String title, String content) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
	}

	public Board(int num, String title, String content, String regtime, int hits, int memberno) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
		this.memberno = memberno;
	}

	public Board(int num, String title, String content, String regtime, int hits, String name) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
		this.name = name;
	}
	

	public Board(int num, String title, String content, String regtime, int hits, String name, int cCount) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.regtime = regtime;
		this.hits = hits;
		this.name = name;
		this.cCount = cCount;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getMemberno() {
		return memberno;
	}
	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}
	public int getcCount() {
		return cCount;
	}
	public void setcCount(int cCount) {
		this.cCount = cCount;
	}

	@Override
	public String toString() {
		return "Board [num=" + num + ", title=" + title + ", content=" + content + ", regtime=" + regtime + ", hits="
				+ hits + ", memberno=" + memberno + ", name=" + name + "]";
	}

	
	
}
