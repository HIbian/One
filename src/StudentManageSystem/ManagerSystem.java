package StudentManageSystem;

import java.util.ArrayList;


public abstract class ManagerSystem<T> {
	
	//添加
	public abstract int add(T t);
	//删除
	public abstract int delete(T t);
	//查询
	public abstract int query(T t);
	public abstract ArrayList<T> query(int type,Object...values);
	//修改
	public abstract int update(T t,int type,Object values);
	//打印
	public abstract void print();
}
