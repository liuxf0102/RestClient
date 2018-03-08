package com.alixp.test.https;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSVersion {
	public static void main(String[] args) throws Exception {
		System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,SSLv3,SSLv2Hello");
		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, null, null);

		SSLSocketFactory factory = (SSLSocketFactory) context.getSocketFactory();
		SSLSocket socket = (SSLSocket) factory.createSocket();

		String[] protocols = socket.getSupportedProtocols();

		System.out.println("Supported Protocols: " + protocols.length);
		for (int i = 0; i < protocols.length; i++) {
			System.out.println(" " + protocols[i]);
		}

		protocols = socket.getEnabledProtocols();

		System.out.println("Enabled Protocols: " + protocols.length);
		for (int i = 0; i < protocols.length; i++) {
			System.out.println(" " + protocols[i]);
		}

	}
}
