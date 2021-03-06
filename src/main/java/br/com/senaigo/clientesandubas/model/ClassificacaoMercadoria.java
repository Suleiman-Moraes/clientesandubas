package br.com.senaigo.clientesandubas.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassificacaoMercadoria {
	private Long id;
	private String nome;
	private String descricao;

	public ClassificacaoMercadoria() {}
	public ClassificacaoMercadoria(Long id, String nome, String descricao) {
		this(nome, descricao);
		this.id = id;
	}
	public ClassificacaoMercadoria(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassificacaoMercadoria other = (ClassificacaoMercadoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ClassificacaoMercadoria == id=" + id + ", nome=" + nome + ", descricao=" + descricao;
	}
}
