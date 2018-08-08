package Test02;

public class Test {
	public static void main(String[] args) {
		ActionProxy aProxy =  new ActionProxy(new UserAction());
		aProxy.doAction();
	}
	
}

class ActionProxy implements Action{
	private Action target;
	
	public ActionProxy(Action target) {
		this.target = target;
	}
	public void doAction() {
		long startTime = System.currentTimeMillis();
		target.doAction();
//		for (int i = 0; i < 1000; i++) {
//			System.out.println(i);
//		}
		long endTime = System.currentTimeMillis();
		System.out.println("cast time:"+(endTime-startTime));
	}
}

interface Action{
	void doAction();
}

class UserAction implements Action{

	@Override
	public void doAction() {
		System.out.println("doAction");
		
	}
	
}