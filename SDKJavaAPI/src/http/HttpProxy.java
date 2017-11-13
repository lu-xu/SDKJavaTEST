package http;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class HttpProxy {

	/**
	 * GET ���󣬷����ַ�
	 * @param url
	 * @return
	 */
	public  String doGet(String url){
		HttpClient httpClient = new HttpClient();
		HttpMethod method = new GetMethod(url);
		try {
			httpClient.setConnectionTimeout(1000*20);
			httpClient.executeMethod(method);
			if(method.getStatusCode()==200){
				return method.getResponseBodyAsString();
			}else {
				System.err.println(method.getResponseBodyAsString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(method!=null)
				method.releaseConnection();
		}
		return null;
	}
	/**
	 * POST ���󣬷����ַ�
	 * @param url
	 * @param params
	 * @return
	 */
	public  String doPost(String url,Map<String,String> params){
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(url);
		int state = 0;
		String result = "";
		try {
			
			NameValuePair[] pairs = new NameValuePair[params.size()];
			int i = 0;
			for(String key : params.keySet()){
				pairs[i]=new NameValuePair(key,params.get(key));
				i++;
			}
			post.setRequestBody( pairs);
		    httpClient.setConnectionTimeout(1000*20);
		    state = httpClient.executeMethod(post);
		  //  System.out.println(state);
			if(state==HttpStatus.SC_OK){
				result= post.getResponseBodyAsString();
			}else {
				result = state+"";
			}
			post.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(post!=null)
				post.releaseConnection();
		}
		return result;
	}
	

	
	public static  String doHeadPost(String url,String hearder,String content){
		HttpClient httpClient = new HttpClient();
		PostMethod post = new PostMethod(url);
		int state = 0;
		String result = "";
		try {
		    httpClient.setConnectionTimeout(1000*2);
		    httpClient.getState().setCredentials(new AuthScope(AuthScope.ANY), new UsernamePasswordCredentials("Bearer", hearder));
//		    httpClient.getState().setCredentials(
//		            new AuthScope("api.wyqcd.cn", 8004, "realm"),
//		            new UsernamePasswordCredentials("username", "password")
//		        );
		    httpClient.getParams().setAuthenticationPreemptive(true);
//		    Header header = new Header("Authorization", "Bearer "+hearder);
//		    post.addRequestHeader(header);
//		    post.setDoAuthentication(true);
		    post.addRequestHeader("Content-Type", "application/json;charset=utf-8");
		   // post.addParameter("content", content);
		    RequestEntity requestEntity = new StringRequestEntity(new String(content.getBytes("utf-8")));
		    post.setRequestEntity(requestEntity);
		    state = httpClient.executeMethod(post);
		  //  System.out.println(state);
			if(state==HttpStatus.SC_OK){
				//result= post.getResponseBodyAsString();
				BufferedReader br = new BufferedReader(new InputStreamReader(
						post.getResponseBodyAsStream()));
	            StringBuffer stringBuffer = new StringBuffer();
	            String str = "";
	            while ((str = br.readLine()) != null) {
	                  stringBuffer.append(str);
	            }
	            result= stringBuffer.toString();
			}else {
				//System.err.println(post.getResponseBodyAsString());
				result = state+"";
			}
			post.releaseConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(post!=null)
				post.releaseConnection();
		}
		return result;
	}
	
	public static void main(String[] args) {
	}
}
