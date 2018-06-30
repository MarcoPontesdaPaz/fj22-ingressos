package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.caelum.ingresso.model.descontos.Desconto;

public class Ingresso {
	
	private Sessao sessao;
	private BigDecimal preco;
	
	
	/**
	 * @deprecated hibernate only
	 */
	public Ingresso(){
		
	}

	public Ingresso (	Sessao sessao,
						Desconto desconto){
		
		this.sessao = sessao;
		this.preco = desconto.aplicarDescontoSobre(sessao.getPreco());
	}
	
	public BigDecimal getPreco(){
		
		if (this.preco == null){
			return BigDecimal.ZERO;
		} else {
			return this.preco.setScale(2, RoundingMode.HALF_UP);
		}
	}
	
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
