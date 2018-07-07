package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
		
		BigDecimal preco = BigDecimal.ZERO;
		
		@OneToMany(mappedBy = "sessao", fetch = FetchType.EAGER)
		private Set<Ingresso> ingressos = new HashSet<>();
		
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
			this.preco = this.sala.getPreco().add(this.filme.getPreco());
		}
		
		// corrigido da apostila página 53
		public LocalDateTime getHorarioTermino(){
		
			LocalDate hoje = LocalDate.now();
			
			return this.horario.atDate(hoje).plusMinutes(this.filme.getDuracao().toMinutes());
			
			//return this.horario.plusMinutes(getFilme().getDuracao().toMinutes());
		}
		
		public Map<String, List<Lugar>> getMapaDeLugares(){
			return sala.getMapaDeLugares();
		}
		
		
		public boolean isDisponivel(Lugar lugarSelecionado){
			return ingressos.stream().map(Ingresso::getLugar).noneMatch(lugar -> lugar.equals(lugarSelecionado));
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

		public BigDecimal getPreco() {
			
			if(this.preco==null){
				return BigDecimal.ZERO;
			} else {
				return this.preco.setScale(2, RoundingMode.HALF_UP);
			}			

		}

		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}
}
