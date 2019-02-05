package br.com.senaigo.clientesandubas.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
	private T data;
	private List<String> erros;
	
	public Response() {}
	public Response(T data, List<String> erros) {
		this.data = data;
		this.erros = erros;
	}
	
	public List<String> getErros() {
		if(this.erros == null) {
			this.erros = new ArrayList<>();
		}
		return erros;
	}

	@Override
	public String toString() {
		return "Response [data=" + data + ", erros=" + erros + "]";
	}
}