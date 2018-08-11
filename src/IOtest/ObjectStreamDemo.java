package IOtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class ObjectStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog dog = new Dog("ww", 16, "girl");
		//序列化，对象存入文件
		writeOject(dog);
		//反序列化，把文件中的对象还原
		readObject();
	}
	
	public static void readObject() throws IOException, ClassNotFoundException {
		
		//需要反序列化的文件
		File file = new File("F:\\test\\1.txt");
		InputStream in = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(in);
		//获取对象
		Dog dog = (Dog)ois.readObject();
		ois.close();
		System.out.println(dog);
	}
	
	
	
	public static void writeOject(Dog dog) throws IOException {
		File file = new File("F:\\test\\1.txt");
		OutputStream out = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(dog);
		oos.close();
	}
}

//该类对象需要被序列化，需要实现Serializable接口，标记接口，告诉jvm该对象可以序列化
//对象保存到文件中
//对象需要在网络上传输
class Dog implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5675658440438806390L;
	String name;
	int age;
	String sex;
	
	public Dog() {}
	public Dog(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
}