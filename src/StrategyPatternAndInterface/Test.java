package StrategyPatternAndInterface;

public class Test {

	public static void main(String[] args) {
		UserService uService = new UserService();
		uService.setISave(new NetSave());
		uService.setISave(new EmailSave());
		uService.add("223312121");
		
	}

}

interface ISave{
	void save(String data);
}

class FileSave implements ISave{
	public void save(String data) {
		System.out.println("把数据保存到本地..."+data);
	}
}
class NetSave implements ISave{
	public void save(String data) {
		System.out.println("把数据保存到网络..."+data);
	}
}
class EmailSave implements ISave{
	public void save(String data) {
		System.out.println("把数据保存到Email..."+data);
	}
}

abstract class BaseService{
	private ISave iSave;
	public void setISave(ISave iSave) {
		this.iSave = iSave;
	}
	
	public 	void add(String data) {
		System.out.println("检查数据合法性。。。");
		iSave.save(data);
		System.out.println("保存完毕");
	}
}
class UserService extends BaseService{
	
}