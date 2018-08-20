
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
	 * ������
	 */
	public static void main(String[] args) {

		/*
		 * my_function function = new my_function(3); function.info(); my_instanceof();
		 * my_break(); my_enum enums = new my_enum(); enums.my_enums(); //�ɱ���� int
		 * sum=my_varargs(new int[] {10,20,5,45,2,1}); System.out.println(sum);
		 */

		// �ļ�����
		//FileWrite();
		
		// Ŀ¼�Ĳ��� 
		my_Directories();
	}

	
	/*
	 *  ����
	 */
	public static void my_Gather() {
		
	}
	
	/*
	 * Ŀ¼�Ĳ���
	 */
	public static void my_Directories() {
				
		File file = new File("D:\\a\\i");
	
		// Ŀ¼�Ĵ���
		//boolean result = file.mkdirs();
			if(file.isDirectory())
			{										
				// Ŀ¼�Ƿ����
				 if (file.list().length > 0) {					 
					 System.out.println("���ڸ�Ŀ¼");
					 					 					 					 					 			
				}
				 else
				{
					System.out.println("Ŀ¼������");
				}				
			}				
			else
			{
				System.out.println("����һ��Ŀ¼");	
			}
		}

	

	/*
	 * �ļ���д��Ͷ�ȡ
	 */
	public static void FileWrite() {
		try {

			// *****�ļ���д��
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\�ļ��Ķ�д.txt"));
			out.write("д���ļ��ɹ�����");
			out.close();
			System.out.println("�����ɹ���");

			// *****�ļ��Ķ�ȡ
			// BufferedReader reds =new BufferedReader(new
			// FileReader("C:\\Users\\Administrator\\Desktop\\�ļ��Ķ�д.txt"));
			// String str;
			// while ((str = reds.readLine()) != null)
			// {
			// System.out.println(str);
			// }

			// **** �ļ�ɾ��
			/*
			 * File file =new File("C:\\Users\\Administrator\\Desktop\\�ļ��Ķ�д.txt");
			 * 
			 * if(file.delete()) { System.out.println(file.getName() +"�Ѿ���ɾ��"); }else {
			 * System.out.println("�ļ�ɾ��ʧ�ܣ�"); }
			 */

			// **** �ļ���׷��
			/*
			 * out=new BufferedWriter(new
			 * FileWriter("C:\\Users\\Administrator\\Desktop\\�ļ��Ķ�д.txt",true));
			 * out.write("����׷������2"); out.close(); System.out.println("����׷�ӳɹ���");
			 */

			// **** �ļ��Ƿ����
			File file = new File("C:\\Users\\Administrator\\Desktop\\�ļ��Ķ�д.txt");
			System.out.println("�ļ��Ƿ���ڣ�" + file.exists());
			System.out.println("�Ƿ�Ϊһ���ļ���" + file.isFile());
			System.out.println("�ļ���С�ǣ�" + file.length());
					
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	/*
	 * instanceof �ؼ����÷�
	 */
	public static void my_instanceof() {

		Object testObject = new ArrayList();
		// ��ȡ getClass �������
		System.out.println(testObject.getClass());

		if (testObject instanceof Vector)
			System.out.println("������ java.util.Vector ���ʵ��");
		else if (testObject instanceof ArrayList)
			System.out.println("������ java.util.ArrayList ���ʵ��");

	}

	/*
	 * ѭ��������..
	 */
	public static void my_break() {
		StringBuffer searchstr = new StringBuffer(
				"Java continue ����������������ǰѭ������������һ��ѭ������������һ��ѭ�������ˣ���������ѭ�������ˣ���ߵ�ѭ�����ɽ��С�");

		int length = searchstr.length();
		int count = 0;
		for (int i = 0; i < length; i++) {
			// continue ����������������ǰѭ������������һ��ѭ������������һ��ѭ�������ˣ���������ѭ�������ˣ���ߵ�ѭ�����ɽ���
			if (searchstr.charAt(i) != 'ѭ')
				continue;
			count++;
			searchstr.setCharAt(i, '*');

		}
		System.out.println("����" + count + "�� ѭ �ַ�");
		System.out.println(searchstr);

	}

	/*
	 * �ɱ������ʹ��
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
 * �������ع�
 */
class my_function {
	int height;

	// ���캯�����ع�
	my_function(int i) {
		height = i;
		System.out.println("���ĸ߶��ǣ�" + height);
	}

	my_function() {
		System.out.println("�����ڵ���CLASS");
	}

	public void info() {
		System.out.println("���Ӹ߶�Ϊ" + height + "��");
	}

	// ��ͨ�������ع�
	public void info(String i) {
		System.out.println("���Ӹ߶�Ϊ" + height + "��");
	}
}

/*
 * ������Ϊ����
 */
class ClassArray {

	// �����ֵ�������Ϊ����
	public static void printArray(Integer[] inputArray) {

	}

	// ������������Ϊ����
	public static void printArray(Double[] inputArray) {

	}

	// �ַ�������Ϊ����
	public static void printArray(Character[] inputArray) {

	}

	// �ַ���������Ϊ����
	public static void printArray(String[] inputArray) {

	}
}

/*
 * enum �� switch ��ʹ��
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
			System.out.println("��ѡ���� lamborghini!");
			break;
		case tata:
			System.out.println("��ѡ���� tata!");
			break;
		case audi:
			System.out.println("��ѡ���� audi!");
			break;
		case fiat:
			System.out.println("��ѡ���� fiat!");
			break;
		case honda:
			System.out.println("��ѡ���� honda!");
			break;
		default:
			System.out.println("�Ҳ�֪����ĳ��͡�");
			break;
		}

	}
}
