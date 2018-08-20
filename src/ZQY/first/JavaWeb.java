package ZQY.first;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;// 获取指定主机的IP
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
 *  JAVA 爬虫实例
 */
public class JavaWeb {

	// Java 对异常是极其敏感的 ， 所以随时都要处理
	public static void main(String[] args) {
 
		try {
		// 获取源码
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
	 * 爬去网页源码
	 */
	public static String GetWebCoent(String _url) {

		String html = "";
		String r = "";
		try {

			// 新建URL对象
			URL url = new URL(_url);
			// 打开http 链接 ，返回链接对象 urlconnection
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			// 打开实际连接
			urlConnection.connect();
			// 获取相应的状态码
			int responseCode = urlConnection.getResponseCode();
			// 如果获取成功， 从URLconnection对象获取输入流来获取请求网页的源代码
			if (responseCode == 200) {

				BufferedReader reader = new BufferedReader(
						new InputStreamReader(urlConnection.getInputStream(), "utf-8"));
				while ((r = reader.readLine()) != null) {
					html += r + "\n";
				}
				return html;

			} else {
				return "获取不到源码，服务器的响应代码为：" + responseCode;

			}

		} catch (Exception e) {
			return e.getMessage();
		}

	}

	/*
	 * 获取网页IP
	 */
	public static void WebServersIp() {
		InetAddress address = null;
		try {

			// 获取该网址的IP
			address = InetAddress.getByName("www.baidu.com");
		} catch (Exception e) {
			System.exit(2);
		}

		System.out.println(address.getHostName() + "= " + address.getHostAddress());
		System.exit(0);

	}
}
