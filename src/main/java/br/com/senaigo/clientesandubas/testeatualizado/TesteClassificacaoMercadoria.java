package br.com.senaigo.clientesandubas.testeatualizado;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

import org.springframework.http.HttpMethod;

import com.google.gson.reflect.TypeToken;

import br.com.senaigo.clientesandubas.model.ClassificacaoMercadoria;
import br.com.senaigo.clientesandubas.response.Response;
import br.com.senaigo.clientesandubas.util.ClientHelp;

public class TesteClassificacaoMercadoria {
	private static final String URL_ENTIDADE = ClientHelp.URL + "/classificacaomercadoria";
	
	public static void main(String[] args) {
		try {
			Scanner leia = new Scanner(System.in);
			ClassificacaoMercadoria x = new ClassificacaoMercadoria("teste nome", "teste descrição");
			findAll();
			findById("3");
			newObject(x);
			findAll();
			x.setNome("teste update");
			update(x);
			findAll();
			System.out.println("\n\nQual ID deseja deletar?");
			deleteById(leia.next());
			leia.close();
			findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void findAll() {
		Type type = new TypeToken<Response<List<ClassificacaoMercadoria>>>() {}.getType();
		ClientHelp.metodo(URL_ENTIDADE, HttpMethod.GET, type);
    }
	
 
    public static void findById(String id) {
    	Type type = new TypeToken<Response<ClassificacaoMercadoria>>() {}.getType();
		ClientHelp.metodo(URL_ENTIDADE + "/" + id, HttpMethod.GET, type);
    }
    
 
    public static void newObject(ClassificacaoMercadoria objeto) {
    	Type type = new TypeToken<Response<ClassificacaoMercadoria>>() {}.getType();
		ClientHelp.metodo(URL_ENTIDADE, HttpMethod.POST, type, objeto);
    }
    
 
    public static void update(ClassificacaoMercadoria objeto) {
    	Type type = new TypeToken<Response<ClassificacaoMercadoria>>() {}.getType();
		ClientHelp.metodo(URL_ENTIDADE, HttpMethod.PUT, type, objeto);
    }
    
 
    public static void deleteById(String id) {
    	Type type = new TypeToken<Response<Boolean>>() {}.getType();
		ClientHelp.metodo(URL_ENTIDADE + "/" + id, HttpMethod.DELETE, type);
    }
}
