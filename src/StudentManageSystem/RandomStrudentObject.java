package StudentManageSystem;

import java.util.Random;

public class RandomStrudentObject  implements ICreatStudent{
	Random random = new Random();
	
	public Student CreatStudent() {
		Student stu = new Student();
		//姓名
		stu.setName(setName());
		//年龄	
		stu.setAge(setAge());
		//性别
		stu.setSex(setSex());
		//ClassId
		stu.setClassid(setClassId());
		//Id
		stu.setId(setId());
		return stu;
	}

	@Override
	public String setName() {
		String baijiaxing ="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严"+ 
				"华金魏陶姜戚谢邹喻水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐"
				+ "费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄" + 
				"和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁" + 
				"杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍" + 
				"虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚" + 
				"程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓" + 
				"牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙" + 
				"叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双" + 
				"闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农" + 
				"温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘" + 
				"匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空" + 
				"曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳" + 
				"夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠" + 
				"公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车" + 
				"颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦" + 
				"段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门" + 
				"商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
		char[] xin = baijiaxing.toCharArray();
		String xinStr = String.valueOf(xin[random.nextInt(xin.length)]);
		//名
		String[] ming = {"曦","昕","暖","怀瑾","淑离","煜月","俊贤","余馨","若光","望舒","离","月","灵雨","朝雨","以琼","陶子","清漪","昕雁","向彩","鸿永","嘉志","俊彦","承宇","阳"};
		String mingStr = String.valueOf(ming[random.nextInt(ming.length)]);
		
		return xinStr+mingStr;
	}

	@Override
	public int setAge() {
		return random.nextInt(8)+18;//18-26
	}

	@Override
	public char setSex() {
		int nextInt = random.nextInt(2);
		if (nextInt==0) {
			return '男';
		}
		return '女';
	}

	@Override
	public String setClassId() {
		String classId="";
		for(int i =0 ; i<4 ;i++) {
			classId+=random.nextInt(9);
		}
		return classId;
	}

	@Override
	public String setId() {
		String Id="";
		for(int i =0 ; i<3 ;i++) {
			Id+=random.nextInt(9);
		}
		return Id;
	}
	
}
