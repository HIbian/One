package IOhomework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 
	六、将学生对象写入到流中
	
	功能：按照学号查找该学生的信息
	      显示所有学生信息，按照学号的大小排序将学生所有信息输出到控制台。


	要求：学生对象的属性：学号，名字，车

	      车对象的属性：名字，型号

	注意：车这个属性可加也可以不加
 * 
 *
 */
public class homework6 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ArrayList<StudentIO> sios = new ArrayList<>();
		File file = new File("F:\\iotest2\\stus");
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(new StudentIO("cx",33));
		oos.writeObject(new StudentIO("cn",22));
		oos.writeObject(new StudentIO("whq",11));
		oos.writeObject(new StudentIO("cx1",99));
		oos.writeObject(new StudentIO("cn1",66));
		oos.writeObject(new StudentIO("whq1",88));
		oos.close();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		sios.add((StudentIO)ois.readObject());
		sios.add((StudentIO)ois.readObject());
		sios.add((StudentIO)ois.readObject());
		sios.add((StudentIO)ois.readObject());
		sios.add((StudentIO)ois.readObject());
		sios.add((StudentIO)ois.readObject());
		ois.close();
		for (StudentIO studentIO : sios) {
			System.out.println(studentIO);
		}
		sios.sort(new Comparator<StudentIO>() {
			@Override
			public int compare(StudentIO o1, StudentIO o2) {
				return (int)(o1.id - o2.id);
			}
		});
		System.out.println("-------------------------");
		for (StudentIO studentIO : sios) {
			System.out.println(studentIO);
		}
	}
}

class StudentIO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	long id;
	public StudentIO(String name, long id) {
		super();
		this.name = name;
		this.id = id;
	}
	public StudentIO() {}
	@Override
	public String toString() {
		return "StudentIO [name=" + name + ", id=" + id + "]";
	}
}




