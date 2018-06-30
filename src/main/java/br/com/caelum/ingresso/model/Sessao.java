package br.com.caelum.ingresso.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {

		@Id
		@GeneratedValue
		private Integer id;
		private LocalTime horario;
		
		@ManyToOne
		private Sala sala;
		
		@ManyToOne
		private Filme filme;
		
		/**
		 * @deprecated hibernate only
		 */
		public Sessao(){}
		
		public Sessao (	LocalTime horario,
						Filme filme,
						Sala sala){
		
			this.horario = horario;
			this.setFilme(filme);
			this.sala = sala;
		}
		
		public LocalTime getHorarioTermino(){
		
			return this.horario.plusMinutes(getFilme().getDuracao().toMinutes());
		}
		
		public void setId (Integer id){
			this.id = id;
		}
		public Integer getId(){
			return this.id;
		}
		
		public void setHorario(LocalTime horario){
			this.horario = horario;
		}
		public LocalTime getHorario(){
			return this.horario;
		}
		
		public void setSala (Sala sala){
			this.sala = sala;
		}
		public Sala getSala (){
			return this.sala;
		}

		public Filme getFilme() {
			return filme;
		}

		public void setFilme(Filme filme) {
			this.filme = filme;
		}
		
	
}