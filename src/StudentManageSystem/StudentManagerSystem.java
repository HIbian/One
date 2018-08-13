package StudentManageSystem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;



public class StudentManagerSystem extends ManagerSystem<Student> implements Type{
	
	ArrayList<Student> stulist = new ArrayList<>();
	
	@Override
	public int add(Student t) {
		//判断合法性
		if (!IsStudent.isStu(t)) {
			return -1;
		}
		//查询是否有该学生
		if (query(t)!=-1) {
			return -2;
		}
		//添加
		stulist.add(t);
		System.out.println(t+" "+stulist.size());
		return 1;
	}

	@Override
	public int delete(Student t) {
		if (t == null) {
			return -1;
		}
		if (!stulist.contains(t)) {
			return -2;
		}
		stulist.remove(t);
		return 1;
	}

	@Override
	public int query(Student t) {
		//需要重写Student的equls方法
		return stulist.indexOf(t);
	}

	@Override
	public ArrayList<Student> query(int type, Object... values) {
		ArrayList<Student> relist = new ArrayList<>();
		switch (type) {
		case NAME:
			//存放查询名字的集合
			HashSet<String> names = new HashSet<>();
			//判断每个名字的合法性，删除不合法的
			for (int i = 0; i < values.length; i++) {
				//类型是否符合
				if (!(values[i] instanceof String)) {
					continue;
				}
				//名字是否合法
				if (!IsStudent.isName((String)values[i])) {
					continue;
				}
				//添加到名字列表
				names.add((String)values[i]);
			}
			
			//根据名字添加元素到relist
			for (String string : names) {
				for (Student student : stulist) {
					if (student.getName().equals(string)) {
						relist.add(student);
					}
				}
			}
			if (relist.size()!=0) {
				return relist;
			}
			return null;
		case AGE:
			
			//输入是否合法
			if (values.length!=2) {
				return null;
			}
			if (!(values[0] instanceof Integer &&values[1] instanceof Integer)) {
				return null;
			}
			//获得年龄的区间
			Integer min = (Integer)values[0];
			Integer max = (Integer)values[1];
			//查询
			for (Student student : stulist) {
				if (student.getAge()>=min&&student.getAge()<=max) {
					relist.add(student);
				}
			}
			return relist;
			
		case SEX:
			//输入是否合法
			if (values.length!=1) {
				return null;
			}
			if (!(values[0] instanceof Character)) {
				return null;
			}
			if (!IsStudent.isSex((Character)values[0])){
				return null;
			}
			//查询
			for (Student student : stulist) {
				if (student.getSex().equals((Character)values[0])) {
					relist.add(student);
				}
			}
			return relist;
		case CLASS_ID:
			//输入是否合法
			//存放查询classid的集合
			HashSet<String> classids = new HashSet<>();
			//判断每个名字的合法性，删除不合法的
			for (int i = 0; i < values.length; i++) {
				//类型是否符合
				if (!(values[i] instanceof String)) {
					continue;
				}
				//classid是否合法
				if (!IsStudent.isClassId((String)values[i])) {
					continue;
				}
				//添加到classid列表
				classids.add((String)values[i]);
			}
			
			//根据名字添加元素到relist
			for (String string : classids) {
				for (Student student : stulist) {
					if (student.getClassid().equals(string)) {
						relist.add(student);
					}
				}
			}
			if (relist.size()!=0) {
				return relist;
			}
			return null;
		case ID:
			//输入是否合法
			//存放查询id的集合
			HashSet<String> ids = new HashSet<>();
			//判断每个id的合法性，删除不合法的
			for (int i = 0; i < values.length; i++) {
				//类型是否符合
				if (!(values[i] instanceof String)) {
					continue;
				}
				//id是否合法
				if (!IsStudent.isId((String)values[i])) {
					continue;
				}
				//添加到id列表
				ids.add((String)values[i]);
			}
			
			//根据id添加元素到relist
			for (String string : ids) {
				for (Student student : stulist) {
					if (student.getId().equals(string)) {
						relist.add(student);
					}
				}
			}
			if (relist.size()!=0) {
				return relist;
			}
			return null;
		default:
			break;
		}
		return null;
	}

	@Override
	public int update(Student t,int type, Object values) {
		//判断该学生是否存在
		int index = query(t);
		if (index==-1) {
			return -1;
		}
		switch (type) {
		case NAME:

			//判断类型合法性
			if (!(values instanceof String)) {
				return -2;
			}
			if (!(IsStudent.isName((String)values))) {
				return -3;
			}
			stulist.get(index).setName((String)values);
			return 1;
		case AGE:
			//判断类型合法性
			if (!(values instanceof Integer)) {
				return -2;
			}
			if (!(IsStudent.isAge((Integer)values))) {
				return -3;
			}
			stulist.get(index).setAge((Integer)values);
			return 1;
		case SEX:
			//判断类型合法性
			if (!(values instanceof Character)) {
				return -2;
			}
			if (!(IsStudent.isSex((Character)values))) {
				return -3;
			}
			stulist.get(index).setSex((Character)values);
			return 1;
		case CLASS_ID:
			//判断类型合法性
			if (!(values instanceof String)) {
				return -2;
			}
			if (!(IsStudent.isClassId((String)values))) {
				return -3;
			}
			//判断是否重复
			ArrayList<Student> query = query(ID,t.getId());
			int count =0;
			for (Student student : query) {
				if (student.getClassid().equals((String)values)) {
					count++;
				}
			}
			if (count!=0) {
				return -4;
			}
			stulist.get(index).setClassid((String)values);
			return 1;
		case ID:
			//判断类型合法性
			if (!(values instanceof String)) {
				return -2;
			}
			if (!(IsStudent.isId((String)values))) {
				return -3;
			}
			//判断是否重复
			ArrayList<Student> query1 = query(CLASS_ID,t.getClassid());
			int count1 =0;
			for (Student student : query1) {
				if (student.getId().equals((String)values)) {
					count1++;
				}
			}
			if (count1!=0) {
				return -4;
			}
			stulist.get(index).setId((String)values);
			return 1;

		default:
			break;
		}
		return 0;
	}

	@Override
	public void print() {
		Iterator<Student> iterator = stulist.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	public int getSize() {
		return stulist.size();
	}

}
