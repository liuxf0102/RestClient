package com.alixp.test.https;  
  
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;  
  
public class HTTPSClientTest2 {  
  
	public static void main(String[] args) throws Exception {

		HttpClient httpClient = null;

		httpClient = new HTTPSTrustClient().init();

		String url = "https://129.150.78.7:9074/LedgerSyncService/LedgerSyncRest";

		Map<String, String> paramHeader = new HashMap<>();
		paramHeader.put("Content-Type", "application/json");

		String postBody = "{ \"param1\": \"2018-1-1 23:59:59\" }";
		String result = HTTPSClientUtil.doPost(httpClient, url, paramHeader, postBody);
		// String result = HTTPSClientUtil.doGet(httpClient, url, paramHeader,
		// null);

		// String result = HTTPSClientUtil.doGet(httpsClient, url, null, null);

		System.out.println(result);
	}  
  
}  
