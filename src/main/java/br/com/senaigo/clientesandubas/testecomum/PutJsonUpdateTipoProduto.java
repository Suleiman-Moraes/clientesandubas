package br.com.senaigo.clientesandubas.testecomum;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.senaigo.clientesandubas.model.TipoProduto;

public class PutJsonUpdateTipoProduto {

	public static void main(String[] args) {

		Client client = Client.create();

		WebResource webResource = client.resource("http://localhost:8080/tipoproduto");

		// Data send to web service.
		TipoProduto objeto = new TipoProduto(new Long(10), "teste nomex", "Teste descricao");

		ClientResponse response = webResource.type("application/json").put(ClientResponse.class, objeto);

		if (response.getStatus() != 200) {
			System.out.println("Failed : HTTP error code : " + response.getStatus());

			String error = response.getEntity(String.class);
			System.out.println("Error: " + error);
			return;
		}

		System.out.println("Output from Server .... \n");

		TipoProduto output = response.getEntity(TipoProduto.class);

		System.out.println(output.getNome()+ " ### " + output.getDescricao());

	}

}