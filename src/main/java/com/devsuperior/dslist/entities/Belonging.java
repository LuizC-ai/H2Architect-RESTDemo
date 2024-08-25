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
