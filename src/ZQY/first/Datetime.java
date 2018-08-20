/*
 *  java 基础篇章
 */
import java.awt.event.MouseWheelEvent;
import org.omg.CORBA.PUBLIC_MEMBER;
import java.text.SimpleDateFormat;
import java.util.Calendar; //日期
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.print.attribute.standard.MediaSize.ISO;
import javax.swing.plaf.synth.SynthScrollBarUI;

import java.util.ArrayList;
import java.util.Arrays; //数组
import java.util.Collections; // 数组的最大最小

import org.omg.CORBA.SystemException;
import org.omg.PortableServer.ImplicitActivationPolicyOperations;

@SuppressWarnings("unused")
public class Datetime {

	/// 静态方法之间才能够相互调用	
	public static void main(String[] args) {
		
	   my_DateTime();
	    my_Array();
	    my_exception();
	    my_string();
	}
	
	/*
	 **时间的处理  
	 */
	public static void my_DateTime() {
		// 格式化时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(date));

		// 获取年月日
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH) + 1;
		int year = cal.get(Calendar.YEAR);
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		int dom = cal.get(Calendar.DAY_OF_MONTH);
		int doy = cal.get(Calendar.DAY_OF_YEAR);

		System.out.println("当期时间: " + cal.getTime());
		System.out.println("日期: " + day);
		System.out.println("月份: " + month);
		System.out.println("年份: " + year);
		System.out.println("一周的第几天: " + dow); // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
		System.out.println("一月中的第几天: " + dom);
		System.out.println("一年的第几天: " + doy);

	}
		
	/*
	 **数组
	 */	
	public static void my_Array() {
		
		/*
		 * 1.java数组的初始化分为2种；分别是静态初始化和动态初始化。
		 * 2. 
		　　整型类型（byte，short，int，double）默认初始值是0
		　　浮点类型（double，float）默认初始值0.0
		　　布尔类型(boolean)默认初始值false
		　　引用类型（数组、类、接口、String）默认初始值为null
		　　字符类型（char）默认初始值'\u0000'
		 * */
		
		//静态初始
		int[] intarr=new int[11];
		String[] strarr =new String[] {"我是","静态","的"};
			
		//动态初始化		
		for(int i=0; i<10 ; i++)
		{					
			intarr[i] = i;
		}
		
		//多维数组		
		int[][] ismore =new int[3][];
		System.out.println(ismore.length);				
		for(int i=0; i<ismore.length;i++)
		{
			//遍历一维数组，指定成员个数
		    ismore[i] = new int[4];
		}		
		
		for (int i = 0; i < 4 ;i++) {
			System.out.print(ismore[0][i] +" ");			
		}
		
	    /********************数组的操作***************************/
		
		//排序
		Arrays.sort(intarr);
		for(int x: intarr )
		{
			 System.out.print(x);
		}
		
		//查找 5 在数组中的下标数		
		int arrIndex =  Arrays.binarySearch(intarr, 5);	    
		System.out.println("元素 5  在第 " + arrIndex + " 个位置");
		
		// 最大最小值
		/*
		 * int和 integer 的区别
		 * 1. integer是int的包装类， int则是java的一种基本类型
		 * 2.integer变量必须实例化后才能使用， 而int变量不需要
		 * 3.integer实际是对象的引用,当new 当new一个Integer时，实际上是生成一个指针指向此对象；而int则是直接存储数据值
		 * 4.Integer的默认值是null，int的默认值是0*/		
		Integer[] numbers = {0,25,465,65,656,5,55,656,1,5};
		int max = (int) Collections.max(Arrays.asList(numbers));
		int min = (int) Collections.min(Arrays.asList(numbers));
		System.out.println(min);
		
		//查找数组的重复数据
		for (int i = 0; i < numbers.length-1; i++) {
			for (int j = i+1 ; j < numbers.length; j++) {
				if(numbers[i] == numbers[j]) {
					
				   System.out.println("重复元素："+numbers[i]);				
				}
			}
		}
		
		// 数组的删除
		ArrayList<String>  listArray = new ArrayList<String>();
	
		listArray.clear();//清除已有成员变量
		listArray.add(0,"第 1 个元素");
		listArray.add(1,"第 2 个元素");
		System.out.println("数组删除元素前："+listArray);
		listArray.remove(1); //索引删除
		listArray.remove("第 0 个元素"); // 名字删除
		System.out.println("数组删除元素前："+listArray);
		
		
		// 判断数组是否相等		
		int[] ary1 = {1,25,4,564};
		int[] ary2 = {1,25,4,564};
		System.out.println("数组 ary 是否与数组 ary1 相等"+ Arrays.equals(ary1, ary2));
							
	}
	
	
	/*
	 * 异常处理的方法
	 */
	public static void my_exception() {
		try {	
			int d =10/0;
			
		} catch (Exception e) {
			System.err.println("getMessage():" + e.getMessage());
			System.err.println("getLocalizedMessage():" + e.getLocalizedMessage());
			System.err.println("toString():" + e);

		}
	}
	
	public static void my_string() {
		 
	    String str="Hello Word";
	    String anth="hello word";
	    Object objstr = str;
	    /*
	     *compareTo(); 如果相同：0 ，不同的是: < 0 
	     */
	    System.out.println(str.compareTo(anth));
	    //忽略大小写
	    System.out.println(str.compareToIgnoreCase(anth));
	    System.out.println(str.compareTo(objstr.toString()));
	    // 返回true--false
	    System.out.println("equals比较是否相同"+str.equals(anth));   
	    System.out.println("***********************");
	        
	    
	    int lastIndex =  str.lastIndexOf("0");
	    // 字符串的检索
	    System.out.println(str.endsWith("d"));
	    System.out.println(str.endsWith("h"));
	    int strIndex =  str.indexOf("h");
	    /// 查找字符串最后一次出现的位置	    
	    if(lastIndex == -1) {
	    	System.out.println("如果最后一个不存在就返回"+ lastIndex);
	    }
	    if(strIndex >0 ) {
	    	System.out.println("如果已经存在字符串返回的数值是："+ strIndex);
	    }
	        
	    System.out.println("***********************");
	    //删除字符串
	    String removestr = "this is Java";
	    System.out.println(removeCharAt(removestr, 3));
	    
	    // 长度
	   System.out.println(str.length());
	   
	   //字符串的连接
	   String string = str.concat(anth);
	   System.out.println(string);
	        	        	   
	   // charAt() 字符串的提取
	   System.out.println(str.charAt(1));
  	   
	   //初始化类的方式链接字符串
	   char[] c= {'1','0','0','1'};
	   String strchar =new String(c);
	  
	   // StringBuffer 缓冲字符串 ，属于字符串变量  
	   StringBuffer sb1 =new StringBuffer("我是缓冲字符变量");	   
	   sb1.append("添加成员1");
	   sb1.append("添加成员2");	   
	   sb1.setLength(5); //限制输出长度	   
	   sb1.setCharAt(0, '你'); //指定下标的字符替换
	   sb1.reverse(); //  字符的翻转
	   System.out.println(sb1);
	   
	   // 子符串大小写的转化
	   str.toUpperCase(); //大写
	   str.toLowerCase(); //小写
	   
	   // 字符串的分割
	   String string2 = "sfsdf,sf,sf,s,fsfsf";	   	   
	   String[]  temp; 
	   temp=string2.split(",");	   
	   for(String x: temp) {
		  System.out.println(x);		   
	   }
	   
	   
	   
	 }
	 
	 /*
	  * JAVA的类不是静态类也可以编写静态方法
	  */		
	private static String removeCharAt(String str, int i) {	
			
			//substring(x)：从x下标开始截取到字符串最后一位数		
			return  str.substring(0,i)+str.substring(i+1);
	}
}

























