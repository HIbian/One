package Login_Design;

abstract public class BasicManager {
	//验证权限的框架，只解决验证的问题
	public void action(String name,String methed) {
		if ("admin".equals(name)) {
			//执行功能，子类实现
			execute(methed);
		}
		else {
			System.out.println("你没有操作权限");
		}
	}
	//具体实现延迟到子类中实现
	abstract public void execute(String methed);
}
