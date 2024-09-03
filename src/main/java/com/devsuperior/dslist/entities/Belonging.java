package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    private Integer position;


    public Belonging() {
    }

    /* Note que no construtor colocamos como parâmetros o Game e o GameList, para depois ser jogado para o 
     * BelongingPK. Isso só é feito porque o BelongingPK é uma classe auxiliar que encapsula os atributos game e gamelist.
     * e para que isto seja possivel, observe que o BelongingPK já está instanciado.
    */
    public Belonging(Game game, GameList gameList, Integer position) {
        id.setGame(game);
        id.setGameList(gameList);
        this.position = position;
    }

    public Game getGame() {
        return id.getGame();
    }

    public GameList getGameList() {
        return id.getGameList();
    }

    public Integer getPosition() {
        return position;
    }

    public void setGame(Game game) {
        id.setGame(game);
    }

    public void setGameList(GameList gameList) {
        id.setGameList(gameList);
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Belonging belonging = (Belonging) o;

        return id != null ? id.equals(belonging.id) : belonging.id == null;
    }
}
