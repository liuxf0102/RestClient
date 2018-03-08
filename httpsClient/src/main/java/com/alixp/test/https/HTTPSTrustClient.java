package com.alixp.test.https;  
  
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;  
  
public class HTTPSTrustClient extends HTTPSClient {  
  
    public HTTPSTrustClient() {  
  
    }  
  
    @Override  
    public void prepareCertificate() throws Exception {  
        // 璺宠繃璇佷功楠岃瘉  
           
        SSLContext sc = SSLContext.getInstance("TLS");  
        
        // 瀹炵幇涓�涓猉509TrustManager鎺ュ彛锛岀敤浜庣粫杩囬獙璇侊紝涓嶇敤淇敼閲岄潰鐨勬柟娉�  
        X509TrustManager trustManager = new X509TrustManager() {  
            @Override  
            public void checkClientTrusted(  
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,  
                    String paramString) throws CertificateException {  
            }  
      
            @Override  
            public void checkServerTrusted(  
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,  
                    String paramString) throws CertificateException {  
            }  
      
            @Override  
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {  
                return null;  
            }  
        };  
        // 璁剧疆鎴愬凡淇′换鐨勮瘉涔�
        sc.init(null, new TrustManager[] { trustManager }, null);  
        //return sc;  
    
        this.connectionSocketFactory  =new SSLConnectionSocketFactory(sc, NoopHostnameVerifier.INSTANCE);
    }  
}  