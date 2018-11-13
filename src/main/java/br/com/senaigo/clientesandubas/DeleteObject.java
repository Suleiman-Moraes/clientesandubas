package br.com.senaigo.clientesandubas;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class DeleteObject {
	public static void main(String[] args) {

		ClientConfig clientConfig = new DefaultClientConfig();

		// Create Client based on Config
		Client client = Client.create(clientConfig);

		WebResource webResource = client.resource("http://localhost:8080/classificacaomercadoria/9");

		ClientResponse rs = webResource.accept("application/json").type("application/json")
				.delete(ClientResponse.class);

		System.out.println("Output from Server .... \n");
		System.out.println(rs);

		// System.out.println(response);

	}
}
