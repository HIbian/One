package Test02;

public class Test02 {

	public static void main(String[] args) {
		//PowerA pA = new PowerAImpl();
		PowerB pB = new PowerBImpl();
		Adapter adapter = new Adapter(pB);
		
		
		Work(adapter);
		
	}
	public static void Work(PowerA pA) {
		pA.insert();
	}
}

//适配器
class Adapter implements PowerA{
	private PowerB pB;
	public Adapter(PowerB pB) {
		this.pB = pB;
	}
	@Override
	public void insert() {
		pB.connect();
	}
}


interface PowerB{
	void connect();
}
class PowerBImpl implements PowerB{
	@Override
	public void connect() {
		System.out.println("B Power");
	}
}


interface PowerA{
	void insert();
}
class PowerAImpl implements PowerA{
	@Override
	public void insert() {
		System.out.println("A Power");
	}
}