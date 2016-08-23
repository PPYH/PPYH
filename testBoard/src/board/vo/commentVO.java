package board.vo;

public class commentVO {
	private int id;
	private String ccomment;
	private String password;
	private String name;
	private String wdate;
	private int bnum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	
	

	public String getCcomment() {
		return ccomment;
	}

	public void setCcomment(String ccomment) {
		this.ccomment = ccomment;
	}

	@Override
	public String toString() {
		return "commentVO [id=" + id + ", comment=" +ccomment + ", password=" + password + ", name=" + name + ", wdate="
				+ wdate + ", bnum=" + bnum + "]";
	}

	public commentVO(int id, String comment, String password, String name, String wdate, int bnum) {
		super();
		this.id = id;
		this.ccomment = comment;
		this.password = password;
		this.name = name;
		this.wdate = wdate;
		this.bnum = bnum;
	}
	
	public commentVO( String comment, String password, String name, int bnum) {
		super();
		this.ccomment = comment;
		this.password = password;
		this.name = name;
	
		this.bnum = bnum;
	}


	public commentVO() {
		// TODO Auto-generated constructor stub
	}
}
