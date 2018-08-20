
package ZQY.first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import javax.print.attribute.standard.Sides;

import org.omg.CORBA.SystemException;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class Example {

	/**
	 * 主方法
	 */
	public static void main(String[] args) {

		/*
		 * my_function function = new my_function(3); function.info(); my_instanceof();
		 * my_break(); my_enum enums = new my_enum(); enums.my_enums(); //可变参数 int
		 * sum=my_varargs(new int[] {10,20,5,45,2,1}); System.out.println(sum);
		 */

		// 文件操作
		//FileWrite();
		
		// 目录的操作 
		my_Directories();
	}

	
	/*
	 *  集合
	 */
	public static void my_Gather() {
		
	}
	
	/*
	 * 目录的操作
	 */
	public static void my_Directories() {
				
		File file = new File("D:\\a\\i");
	
		// 目录的创建
		//boolean result = file.mkdirs();
			if(file.isDirectory())
			{										
				// 目录是否存在
				 if (file.list().length > 0) {					 
					 System.out.println("存在该目录");
					 					 					 					 					 			
				}
				 else
				{
					System.out.println("目录不存在");
				}				
			}				
			else
			{
				System.out.println("不是一个目录");	
			}
		}

	

	/*
	 * 文件的写入和读取
	 */
	public static void FileWrite() {
		try {

			// *****文件的写入
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\文件的读写.txt"));
			out.write("写入文件成功！！");
			out.close();
			System.out.println("创建成功！");

			// *****文件的读取
			// BufferedReader reds =new BufferedReader(new
			// FileReader("C:\\Users\\Administrator\\Desktop\\文件的读写.txt"));
			// String str;
			// while ((str = reds.readLine()) != null)
			// {
			// System.out.println(str);
			// }

			// **** 文件删除
			/*
			 * File file =new File("C:\\Users\\Administrator\\Desktop\\文件的读写.txt");
			 * 
			 * if(file.delete()) { System.out.println(file.getName() +"已经被删除"); }else {
			 * System.out.println("文件删除失败！"); }
			 */

			// **** 文件的追加
			/*
			 * out=new BufferedWriter(new
			 * FileWriter("C:\\Users\\Administrator\\Desktop\\文件的读写.txt",true));
			 * out.write("我是追加数据2"); out.close(); System.out.println("数据追加成功！");
			 */

			// **** 文件是否存在
			File file = new File("C:\\Users\\Administrator\\Desktop\\文件的读写.txt");
			System.out.println("文件是否存在：" + file.exists());
			System.out.println("是否为一个文件：" + file.isFile());
			System.out.println("文件大小是：" + file.length());
					
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	/*
	 * instanceof 关键字用法
	 */
	public static void my_instanceof() {

		Object testObject = new ArrayList();
		// 获取 getClass 类的名称
		System.out.println(testObject.getClass());

		if (testObject instanceof Vector)
			System.out.println("对象是 java.util.Vector 类的实例");
		else if (testObject instanceof ArrayList)
			System.out.println("对象是 java.util.ArrayList 类的实例");

	}

	/*
	 * 循环的跳出..
	 */
	public static void my_break() {
		StringBuffer searchstr = new StringBuffer(
				"Java continue 语句语句用来结束当前循环，并进入下一次循环，即仅仅这一次循环结束了，不是所有循环结束了，后边的循环依旧进行。");

		int length = searchstr.length();
		int count = 0;
		for (int i = 0; i < length; i++) {
			// continue 语句语句用来结束当前循环，并进入下一次循环，即仅仅这一次循环结束了，不是所有循环结束了，后边的循环依旧进行
			if (searchstr.charAt(i) != '循')
				continue;
			count++;
			searchstr.setCharAt(i, '*');

		}
		System.out.println("发现" + count + "个 循 字符");
		System.out.println(searchstr);

	}

	/*
	 * 可变参数的使用
	 */
	public static int my_varargs(int... intArrays) {

		int sum, i;
		sum = 0;
		for (i = 0; i < intArrays.length; i++) {
			sum += intArrays[i];
		}
		return (sum);
	}
}

/*
 * 方法的重构
 */
class my_function {
	int height;

	// 构造函数的重构
	my_function(int i) {
		height = i;
		System.out.println("您的高度是：" + height);
	}

	my_function() {
		System.out.println("您正在调用CLASS");
	}

	public void info() {
		System.out.println("房子高度为" + height + "米");
	}

	// 普通方法的重构
	public void info(String i) {
		System.out.println("房子高度为" + height + "米");
	}
}

/*
 * 数组作为参数
 */
class ClassArray {

	// 纯数字的数组作为参数
	public static void printArray(Integer[] inputArray) {

	}

	// 浮点数数组作为参数
	public static void printArray(Double[] inputArray) {

	}

	// 字符数组作为参数
	public static void printArray(Character[] inputArray) {

	}

	// 字符串数组作为参数
	public static void printArray(String[] inputArray) {

	}
}

/*
 * enum 和 switch 的使用
 */

enum Car {
	lamborghini, tata, audi, fiat, honda
}

class my_enum {
	my_enum() {

	}

	Car _car;

	public void my_enums() {
		_car = _car.tata;
		switch (_car) {
		case lamborghini:
			System.out.println("你选择了 lamborghini!");
			break;
		case tata:
			System.out.println("你选择了 tata!");
			break;
		case audi:
			System.out.println("你选择了 audi!");
			break;
		case fiat:
			System.out.println("你选择了 fiat!");
			break;
		case honda:
			System.out.println("你选择了 honda!");
			break;
		default:
			System.out.println("我不知道你的车型。");
			break;
		}

	}
}
