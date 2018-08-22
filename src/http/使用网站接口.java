package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class 使用网站接口 {
	public static void main(String[] args) throws IOException {
		//创建url对象
		URL url = new URL("http://www.kuaidi100.com/query?type=yuantong&postid=800971297400636446");
		
		HttpURLConnection conn =  (HttpURLConnection)url.openConnection();
		conn.setConnectTimeout(5000);
		conn.setReadTimeout(5000);
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		
		int responseCode = conn.getResponseCode();
		
		if (responseCode==HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String info;
			while ((info = br.readLine())!=null) {
				System.out.println(info);
			}
		}else {
			System.out.println(responseCode);
		}
	}
}
