package br.com.senaigo.clientesandubas;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import br.com.senaigo.clientesandubas.model.ClassificacaoMercadoria;

public class GetJsonAsObject {

	public static void main(String[] args) {

		ClientConfig clientConfig = new DefaultClientConfig();

		// Create Client based on Config
		Client client = Client.create(clientConfig);

		WebResource webResource = client.resource("http://localhost:8080/classificacaomercadoria/3");

		Builder builder = webResource.accept(MediaType.APPLICATION_JSON) //
				.header("content-type", MediaType.APPLICATION_JSON);

		ClientResponse response = builder.get(ClientResponse.class);

		// Status 200 is successful.
		if (response.getStatus() != 200) {
			System.out.println("Failed with HTTP Error code: " + response.getStatus());
			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}

		System.out.println("Output from Server .... \n");

		ClassificacaoMercadoria employee = (ClassificacaoMercadoria) response.getEntity(ClassificacaoMercadoria.class);

		System.out.println("Id .... " + employee.getId());
		System.out.println("Nome .... " + employee.getNome());
		System.out.println("Descricao .... " + employee.getDescricao());

	}

}