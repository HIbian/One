package StudentManageSystem;

public class IsStudent {
	public static boolean isStu(Student stu) {
		String name = stu.getName();
		int age = stu.getAge();
		char sex = stu.getSex();
		String classId = stu.getClassid();
		String id = stu.getId();
		
		if (!isName(name)||!isAge(age)||!isClassId(classId)||!isId(id)||!isSex(sex)) {
			return false;//返回不是
		}
		return true;
	}
	//名字长度2~5
	public static boolean isName(String name) {
		if (name.length()<1||name.length()>6) {
			return false;
		}
		return true;
	}
	//性别，只能是男或女
	public static boolean isSex(char sex) {
		if (sex!='男'&&sex!='女') {
			return false;
		}
		return true;
	}
	
	//年龄，只收18到26的
	public static boolean isAge(int age) {
		if (age<18||age>26) {
			return false;
		}
		return true;
	}
	
	//班级id为4位
	public static boolean isClassId(String classId) {
		if (classId.length()!=4) {
			return false;
		}
		return true;
	}
	//id为3位
	public static boolean isId(String id) {
		if (id.length()!=3) {
			return false;
		}
		return true;
	}
		
}
