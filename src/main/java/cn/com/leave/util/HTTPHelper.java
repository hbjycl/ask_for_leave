package cn.com.leave.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HTTPHelper {
    private final static String charset = "UTF-8";

    public static String[] apiPost(String url, List<NameValuePair> params) {
	CloseableHttpClient client = null;
	String[] result = null;
	try {
	    client = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost(url);
	    UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params, charset);
	    httpPost.setEntity(entity);
	    HttpResponse response = client.execute(httpPost);
	    int statusCode = response.getStatusLine().getStatusCode();
	    InputStream in = response.getEntity().getContent();
	    BufferedReader br = new BufferedReader(new InputStreamReader(in, charset));
	    String line = null;
	    StringBuilder sb = new StringBuilder();
	    while ((line = br.readLine()) != null) {
		sb.append(line);
	    }
	    try {
		br.close();
		in.close();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    result = new String[] { statusCode + "", sb.toString() };
	} catch (Exception e) {
	    result = new String[] { "-1", "异常错误" };
	    e.printStackTrace();
	} finally {
	    try {
		client.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return result;
    }

    public static String[] apiPost(String url, JSONObject param) {
	System.out.println(param);
	CloseableHttpClient client = null;
	String[] result = null;
	try {
	    client = HttpClients.createDefault();
	    HttpPost httpPost = new HttpPost(url);
	    StringEntity entity = new StringEntity(param.toString(), ContentType.APPLICATION_JSON);
	    httpPost.setEntity(entity);
	    HttpResponse response = client.execute(httpPost);
	    int statusCode = response.getStatusLine().getStatusCode();
	    InputStream in = response.getEntity().getContent();
	    BufferedReader br = new BufferedReader(new InputStreamReader(in, charset));
	    String line = null;
	    StringBuilder sb = new StringBuilder();
	    while ((line = br.readLine()) != null) {
		sb.append(line);
	    }
	    try {
		br.close();
		in.close();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	    result = new String[] { statusCode + "", sb.toString() };
	} catch (Exception e) {
	    result = new String[] { "-1", "异常错误" };
	    e.printStackTrace();
	} finally {
	    try {
		client.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return result;
    }
}
