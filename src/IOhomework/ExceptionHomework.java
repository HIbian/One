package IOhomework;
/**
 * 异常：
一、编写一个自定义异常类（为第二题做准备）。
二、编写一个员工类
	(1) 有属性：编号，姓名，年龄，工资，员工工资总额(20000)
	(2) 有构造器：
		构造器1：设置编号，年龄，姓名；如果年龄小于18，抛出年龄低异常；如果年龄大于60
		抛出年龄高异常，如果姓名为null或为空字符串，抛出空异常。
		构造器2：设置工资；如果工资低于600，抛出工资低异常。
	(3) 有方法增加工资 addSalary(double addSalary)，抛出工资高异常，当增加后的工资大于员工工资总额(20000)时，抛出此异常。
	    减少工资 minusSalary(double minusSalary), 抛出工资低异常，当减少后的工资低于政府最低工资(3500)时，抛出工资低异常。
	(4) 写一个测试类，创建一个员工，调方法，看控制台的效果
结果(或者其他结果)：
	cn.qf.testlist.LowException: 工资大于员工工资总额异常
	at cn.qf.testlist.Employee.addSalary(Employee.java:62)
	at cn.qf.testlist.TestThrow.main(TestThrow.java:10)
 */
public class ExceptionHomework {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Worker sl = new Worker(500);
		Worker sh = new Worker(90000);
		Worker al = new Worker(00, "绫波",16);
		Worker ah = new Worker(01, "asd", 61);
		sl.addSalary(90000);
		sh.minuSalary(87000);
	}
}
class Worker{
	final static int totalSalary = 20000;
	int id;
	String name;
	int salary;
	int age;
	public void addSalary(int num) {
		this.salary+=num;
		if (this.salary>totalSalary) {
			try {
				throw new SalaryHighException();
			} catch (SalaryHighException e) {
				e.printStackTrace();
			}finally {
				this.salary = 20000;
			}
		}
	}
	public void minuSalary(int num) {
		this.salary-=num;
		if (this.salary<600) {
			try {
				throw new SalaryLowException();
			} catch (SalaryLowException e) {
				e.printStackTrace();
			}finally {
				this.salary = 600;
			}
		}
	}
	public Worker() {}
	public Worker(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		if (this.age<18) {
			try {
				throw new AgeLowException();
			} catch (AgeLowException e) {
				e.printStackTrace();
			}
		}
		if (this.age>60) {
			try {
				throw new AgeHighException();
			} catch (AgeHighException e) {
				e.printStackTrace();
			}
		}
	}
	public Worker(int salary) {
		this.salary = salary;
		if (this.salary<600) {
			try {
				throw new SalaryLowException();
			} catch (SalaryLowException e) {
				e.printStackTrace();
			}finally {
				this.salary = 600;
			}
		}
		if (this.salary>totalSalary) {
			try {
				throw new SalaryHighException();
			} catch (SalaryHighException e) {
				e.printStackTrace();
			}finally {
				this.salary = 20000;
			}
		}
	}
	
	
}
class SalaryHighException extends Exception{
	private static final long serialVersionUID = -4462376683096331910L;
	@Override
	public String toString() {
		return this.getClass().toString()+":工资太高";
	}
}
class SalaryLowException extends Exception{
	private static final long serialVersionUID = 8958101604416625490L;
	@Override
	public String toString() {
		return this.getClass().toString()+":工资太低";
	}
}
class AgeLowException extends Exception{
	private static final long serialVersionUID = 1816994364643404129L;
	@Override
	public String toString() {
		return this.getClass().toString()+":年龄太小";
	}
}
class AgeHighException extends Exception{
	private static final long serialVersionUID = 8058740083913982308L;
	@Override
	public String toString() {
		return this.getClass().toString()+":年龄太大";
	}
}