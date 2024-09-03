package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


/* Uma classe auxiliar para representar o Belonging. Por que nao usamos a classe Belonging diretamente? 
Porque ela tem um atributo do tipo GameList e um do tipo Game, 
e o JPA nao permite que uma classe tenha dois atributos do tipo @Entity
*/



/*Embeddable: Está sendo usado porque temos um tipo representando dois campos (game, gamelist),
 * E vamos colocar este tipo (BelongingPK) dentro de outra entidade (Belonging). Mas o que isto importa?
 * Isto importa porque o JPA vai entender que os campos game e gamelist são representados por um tipo composto (BelongingPK).
 * Então estamos basicamente encapsulando dois atributos em uma classe auxiliar (BelongingPK).
*/
@Embeddable 
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
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
