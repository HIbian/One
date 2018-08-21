package zhuceStudy;

import java.io.Serializable;

public class Usertest implements Serializable{
	private static final long serialVersionUID = 419015757030649415L;
	String userName;
	String passwd;
	
	public Usertest(String userName, String passwd) {
		super();
		this.userName = userName;
		this.passwd = passwd;
	}

	public Usertest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Usertest [userName=" + userName + ", passwd=" + passwd + "]";
	}
}
