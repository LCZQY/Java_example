package ZQY.first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;// ��ȡָ��������IP
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import javax.swing.text.Document;
import org.w3c.dom.html.HTMLScriptElement;
import java.io.File;

import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.omg.CORBA.SystemException;


/*
 *  JAVA ����ʵ��
 */
public class JavaWeb {

	// Java ���쳣�Ǽ������е� �� ������ʱ��Ҫ����
	public static void main(String[] args) {
 
		try {
		// ��ȡԴ��
		String htmls = GetWebCoent("https://movie.douban.com/subject/24852545/reviews?start=0");	  
		Document document = (Document) Jsoup.parse(htmls);
		Elements elements = ((Element) document).getElementsByClass("review-item");
		
		for(Element item : elements)
		{ 
			
			System.out.println(item.getElementsByTag("header").text());
			
		}
		
		
				
		}catch (Exception e) {

			System.out.println(e.getMessage());
		}
	}

	/*
	 * ��ȥ��ҳԴ��
	 */
	public static String GetWebCoent(String _url) {

		String html = "";
		String r = "";
		try {

			// �½�URL����
			URL url = new URL(_url);
			// ��http ���� ���������Ӷ��� urlconnection
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			// ��ʵ������
			urlConnection.connect();
			// ��ȡ��Ӧ��״̬��
			int responseCode = urlConnection.getResponseCode();
			// �����ȡ�ɹ��� ��URLconnection�����ȡ����������ȡ������ҳ��Դ����
			if (responseCode == 200) {

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
				while ((r = reader.readLine()) != null) {
					html += r + "\n";
				}
				return html;

			} else {
				return "��ȡ����Դ�룬����������Ӧ����Ϊ��" + responseCode;

			}

		} catch (Exception e) {
			return e.getMessage();
		}

	}

	/*
	 * ��ȡ��ҳIP
	 */
	public static void WebServersIp() {
		InetAddress address = null;
		try {

			// ��ȡ����ַ��IP
			address = InetAddress.getByName("www.baidu.com");
		} catch (Exception e) {
			System.exit(2);
		}

		System.out.println(address.getHostName() + "= " + address.getHostAddress());
		System.exit(0);

	}
}
