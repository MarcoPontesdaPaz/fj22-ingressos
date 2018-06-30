package br.com.caelum.ingresso.validacao;

import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	
	private List<Sessao> sessoesDaSala;
	
	public GerenciadorDeSessao (List<Sessao> sessoesDaSala) {
		
		this.sessoesDaSala = sessoesDaSala;
	}
	
	private boolean horarioIsConflitante (Sessao sessaoExistente, Sessao sessaoNova){
		
		//LocalDate hoje = LocalDate.now();
		
		//LocalDateTime horarioSessaoExistente 	= sessaoExistente.getHorario().atDate(hoje);
		//LocalDateTime horarioSessaonova 		= sessaoNova.getHorario().atDate(hoje);
		
		boolean terminaAntes = sessaoNova.getHorarioTermino().isBefore(sessaoExistente.getHorario());
		boolean comecaDepois = sessaoExistente.getHorarioTermino().isBefore(sessaoNova.getHorario());
		
		
		if (terminaAntes || comecaDepois) {
			return false;
		} else {
			return true;
		}
		/***
		 * ou ...
		 */
		//return ! (terminaAntes || comecaDepois);
	}

	public boolean cabe(Sessao sessaoNova){
		
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioIsConflitante(sessaoExistente, sessaoNova));
	
	}
}