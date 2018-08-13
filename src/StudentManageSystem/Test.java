package StudentManageSystem;


import java.util.ArrayList;

public class Test implements Type{
	public static void main(String[] args) {
		StudentManagerSystem sms = new StudentManagerSystem();
		RandomStrudentObject rso = new RandomStrudentObject();
		
		for (int i = 0; i < 100000; i++) {
			sms.add(rso.CreatStudent());
		}
		//		sms.add(new Student("11",19, '女', "2233", "123"));//deleted
//		sms.add(new Student("cc",21, '男', "1000", "001"));
//		sms.add(new Student("cc",21, '男', "1001", "001"));
//		sms.add(new Student("cc1",25, '男', "2000", "002"));
//		sms.add(new Student("cc2",23, '女', "3000", "003"));
//		sms.add(new Student("cc3",22, '女', "1000", "004"));
//		sms.add(new Student("cc4",26, '男', "1000", "005"));
//		sms.add(new Student("cc5",26, '男', "1000", "003"));
//		sms.print();
//		System.out.println("-------------Delete--------------------");
//		sms.delete(new Student("253",1, '男', "2233", "123"));
//		sms.print();
//		System.out.println("-------------Query---------------------");
//		ArrayList<Student> qList = sms.query(ID,"005");
//		if (qList!=null) {
//			for (Student student : qList) {
//				System.out.println(student);
//			} 
//		}
//		System.out.println("-----------------Update-----------------");
//		sms.update(new Student("cc5",26, '男', "1000", "003"), ID, "002");
//		sms.print();
		System.out.println("count:"+sms.getSize());
		ArrayList<Student> query = sms.query(NAME,"陈昕");
		if (query==null) {
			return;
		}
		for (Student student : query) {
			System.out.println(student);
		}
	}
}
