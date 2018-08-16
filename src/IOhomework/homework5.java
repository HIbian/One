package IOhomework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * 五、题目四:模拟用户登录功能实现。两个功能：登录、注册  
  
	登录：接收用户输入的用户名和密码，然后和文件中存储的用户名、密码匹配

	注册：将用户信息存入到文档中

	注意：文档中可以有多个用户信息
 */
public class homework5 {
	static ArrayList<User> users = new ArrayList<>();
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String getNum;
		Scanner scanner = new Scanner(System.in);
		users = getUsersObject();
		do {
			System.out.println("输入要执行的操作1，登陆；2，注册；3，打印");
			getNum = scanner.next();
			//scanner.close();
			switch (getNum) {
			case "1":
				//输入账号密码
				System.out.println("请输用户名");
				String name = scanner.next();
				System.out.println("请输入密码");
				String passwd = scanner.next();
				User thisuser = new User(name, passwd);
				if (login(thisuser)) {
					System.out.println("登陆成功");
				}else {
					System.out.println("登陆失败");
				}
				break;
			case "2":
				//输入账号密码
				System.out.println("请输入账号");
				String name1 = scanner.next();
				System.out.println("请输入密码");
				String passwd1 = scanner.next();
				User thisuser1 = new User(name1, passwd1);
				if (registered(thisuser1)) {
					System.out.println("注册成功");
				}else {
					System.out.println("注册失败");
				}
				break;
			case "3":
				if (users==null) {
					break;
				}
				for (User user : users) {
					System.out.println(user);
				}
				break;
			default:
			}
		} while (true);
		
	}
	//登陆
	public static boolean login(User thisuser) throws IOException, ClassNotFoundException {
		//合法性
		//获取arraylist
		users =getUsersObject();
		//判断是否账号密码正确
		if (users==null) {
			return false;
		}
		if (!users.contains(thisuser)) {
			return false;
		}
		return true;
	}
	//注册
	public static boolean registered(User thisuser) throws IOException, ClassNotFoundException {

		//合法性
			//获取arraylist
		users = getUsersObject();
			//账号是否重复
		if (users!=null) {
			for (User user : users) {
				if (user.getUserName().equals(thisuser.getUserName())) {
					return false;
				}
			}
		}
		//添加到arraylist
		if (users==null) {
			users = new ArrayList<>();
		}
		users.add(thisuser);
		//添加到文件
		writeUsersToFile(users);
		return true;
	}
	//从文件获取用户集合,读入
	@SuppressWarnings("unchecked")
	public static ArrayList<User> getUsersObject() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("F:\\iotest2\\stu");
		if (!file.exists()) {
			return null;
		}
		@SuppressWarnings("resource")
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		return (ArrayList<User>) ois.readObject();
	}
	//将arraylist写入文件
	public static void writeUsersToFile(ArrayList<User> users) throws IOException {
		File file = new File("F:\\iotest2\\stu");
		if (!file.exists()) {
			file.createNewFile();
		}
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(users);
		oos.close();
	}
}
class User implements Comparable<User>,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String passWorld;
	public User() {}
	public User(String userName, String passWorld) {
		super();
		this.userName = userName;
		this.passWorld = passWorld;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWorld=" + passWorld + "]";
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWorld() {
		return passWorld;
	}
	public void setPassWorld(String passWorld) {
		this.passWorld = passWorld;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((passWorld == null) ? 0 : passWorld.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (passWorld == null) {
			if (other.passWorld != null)
				return false;
		} else if (!passWorld.equals(other.passWorld))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public int compareTo(User o) {
		return this.userName.compareTo(o.userName);
	}
}