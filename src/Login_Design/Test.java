package Login_Design;

public class Test {

	public static void main(String[] args) {
		UserManager uManager = new UserManager();
		uManager.action("admin000", "delete");
		uManager.action("admin", "add");
		uManager.action("admin", "delete");
	}

}
