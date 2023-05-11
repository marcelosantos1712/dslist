package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//encapsular dois atributos num campo só
@Embeddable

	public class BelongingPK {
	
	//mapeamento objeto relacional
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList list;
	
	//construtor vazio
	private BelongingPK() {
		
	}
	//construtores
	public BelongingPK(Game game, GameList list) {
		
		this.game = game;
		this.list = list;
	}
	
	//gerando getters e setters
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public GameList getList() {
		return list;
	}
	public void setList(GameList list) {
		this.list = list;
	}
	
	//geração comparação pelos 2 campos do belongingPK
	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	

}
