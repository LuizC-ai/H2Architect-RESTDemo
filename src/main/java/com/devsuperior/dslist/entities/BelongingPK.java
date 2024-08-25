package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable // Ele basicamente o seguinte: "Eu sou um subtipo de outra entidade", isto é: "Eu sou um tipo que pertence a outra entidade"
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
    @JoinColumn(name = "list_id")
    private GameList gameList;

    public BelongingPK() {
    }

    public BelongingPK(Game game, GameList gameList) {
        this.game = game;
        this.gameList = gameList;
    }

    public Game getGame() {
        return game;
    }

    public GameList getGameList() {
        return gameList;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void setGameList(GameList gameList) {
        this.gameList = gameList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BelongingPK that = (BelongingPK) o;

        if (game != null ? !game.equals(that.game) : that.game != null) {
            return false;
        }
        return gameList != null ? gameList.equals(that.gameList) : that.gameList == null;
    }

    @Override
    public int hashCode() {
        int result = game != null ? game.hashCode() : 0;
        result = 31 * result + (gameList != null ? gameList.hashCode() : 0);
        return result;
    }
}
