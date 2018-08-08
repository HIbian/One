package Login_Design;

public class UserManager extends BasicManager{
	//实现父类中没有实现的方法
	@Override
	public void execute(String methed) {
		if ("add".equals(methed)) {
			System.out.println("执行了添加操作");
		}else if ("delete".equals(methed)) {
			System.out.println("执行了删除操作");
		}
		
	}
}
