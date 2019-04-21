package task_1;

import task_1.Games.Game;

import java.util.*;

public class Player {
    private Map<Game, Integer> rating = new HashMap<Game, Integer>();
    private String name;
    private List games;

    public void setPlayer(String name, List games){
        this.name = name;
        this.games = games;
        Object[] gamesAr = games.toArray();
        for (int i = 0; i < gamesAr.length; i++)
        rating.put((Game) gamesAr[i], 0);
    }

    public String getName (){ return name; }

    public List getGames (){ return games; }

    public int getRating (Game game){
        return rating.get(game);
    }

    public  void changeRating (Game game, int rating){
        this.rating.put(game, (this.rating.get(game) + rating));
    }

}
