package board.vo;

public class boardVO {
	private int id;
	private String name;
	private String content;
	private String password;
	private String wdate;
	private String subject;
	
	public boardVO( String name, String content, String password, String subject) {
		super();

		this.name = name;
		this.content = content;
		this.password = password;
		this.wdate = wdate;
		this.subject = subject;
	}
	
	public boardVO(int id,  String content, String password,String subject) {
		super();
		this.id = id;
		this.content = content;
		this.password = password;

		this.subject = subject;
	}
	
	public boardVO(int id,  String content, String password,String subject,String name) {
		super();
		this.id = id;
		this.content = content;
		this.password = password;
		this.name=name;
		this.subject = subject;
	}


	public boardVO( String name, String content, String password) {
		super();

		this.name = name;
		this.content = content;
		this.password = password;


	}
	public boardVO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "boardVO [id=" + id + ", name=" + name + ", content=" + content + ", password=" + password + ", wdate="
				+ wdate + ", subject=" + subject + "]";
	}
	
	

	
	

}
