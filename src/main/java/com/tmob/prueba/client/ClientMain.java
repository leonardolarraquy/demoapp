package com.tmob.prueba.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClientMain {
	public static void main(String[] args) {

		for (int i = 0; i<5000; i++) {

			try {
				String id = "" + System.currentTimeMillis();


				String endpointUrl = "http://alb-demo-350604738.sa-east-1.elb.amazonaws.com/demoapp/RestService?id=" + id;
				//				String endpointUrl = "http://localhost:80/demoapp/RestService?id=" + id;

				URL url = new URL(endpointUrl);

				// Abrir la conexión HTTP
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				// Configurar el método HTTP GET
				connection.setRequestMethod("GET");

				// Leer la respuesta del servidor
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line;
				StringBuilder response = new StringBuilder();

				while ((line = reader.readLine()) != null) {
					response.append(line);
				}
				reader.close();

				int responseCode = connection.getResponseCode();
				System.out.println("HTTP: " + responseCode + response.toString());

				connection.disconnect();

				Thread.currentThread().sleep(250);
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
