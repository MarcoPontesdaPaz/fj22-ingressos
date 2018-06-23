package br.com.caelum.ingresso.model;

import java.time.LocalTime;

public class Sessao {
	
		private Integer id;
		private LocalTime horario;
		private Sala sala;
		private Filme filme;
		
		public Sessao (	LocalTime horario,
						Filme filme,
						Sala sala){
		
			this.horario = horario;
			this.filme = filme;
			this.sala = sala;
		}
		
		public LocalTime getHorarioTermino(){
		
			return this.horario.plusMinutes(filme.getDuracao().toMinutes());
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
		
		public void setFilme (Filme filme){
			this.filme = filme;
		}
}
