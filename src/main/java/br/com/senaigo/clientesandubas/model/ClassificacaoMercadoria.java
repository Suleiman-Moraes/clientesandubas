package br.com.senaigo.clientesandubas.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ClassificacaoMercadoria{
	private Long id;
	private String nome;
	private String descricao;

	public ClassificacaoMercadoria() {}
	public ClassificacaoMercadoria(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
}
