package br.com.senaigo.clientesandubas.testecomum;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;

public class PassandoTokenViaHeaders {
	public static void main(String[] args) {

		Client client = Client.create();
		final String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjbGllbnRlQHlhaG9vLmNvbSIsImNyZWF0ZWQiOjE1NDgwNzM0MzE2MDEsImV4cCI6MTU0ODY3ODIzMX0.mK2Z5pvDe6P3J_6Eydy9iolZ8XGU9b2GjaQN5qFVtE78iVgvD5VjHB-3IRz4l7f-yur4Nr5jfVCcnmaDdbn_ZA";

		WebResource webResource = client.resource("https://helpdesk-web-service.herokuapp.com/api/ticket/5c38d95844528a0b4e6d2ff1");

		Builder x = webResource.type("application/json");
		x.header("Authorization", token);
		ClientResponse response = x.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			System.out.println("Failed : HTTP error code : " + response.getStatus());

			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}

		System.out.println("Output from Server .... \n");

		String output = response.getEntity(String.class);

		System.out.println(output);

	}
}
