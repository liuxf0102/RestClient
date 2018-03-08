package com.alixp.test.https;  
  
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;  
  
public class HTTPSClientTest {  
  
    public static void main(String[] args) throws Exception {  
        HttpClient httpClient = null;  
        String encoding = Base64.getEncoder().encodeToString(("admin:Welcome1").getBytes("utf-8"));

        httpClient = new HTTPSTrustClient().init();  
        //httpClient = new HTTPSCertifiedClient().init();  
  
        String url = "https://160.34.13.194:1080/restproxy/topics/gse00002994-tiger";  
        //String url = "https://1.2.6.2:8011/xxx/api/getHealth";  
  
        Map<String, String> paramHeader = new HashMap<>();  
        paramHeader.put("Content-Type", "application/vnd.kafka.json.v1+json");  
        paramHeader.put("Authorization", "Basic "+encoding);  
        
        String postBody="{ \"records\": [ { \"key\":\"myKey11\",\"value\":\"mySpecialValue1\"}] }";
        String result = HTTPSClientUtil.doPost(httpClient, url, paramHeader, postBody);  
          
        //String result = HTTPSClientUtil.doGet(httpsClient, url, null, null);  
          
        System.out.println(result);  
    }  
  
}  
