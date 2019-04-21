package task_1;

import task_1.Exceptions.NameAlreadyExsist;
import task_1.Games.Game;

import java.util.*;

public class Service {

    private Map<String, Player> players =  new HashMap<String, Player>();

    public void add(String name, List games) throws Exception{
        if (players.containsKey(name)){
            throw new NameAlreadyExsist();
        }
        Player player = new Player();
        player.setPlayer(name, games);
        players.put(name, player);
    }

    public Map getPlayers(){
        return players;
    }

    public void win(String name, Game game){
        if (!players.containsKey(name)){
            throw new NullPointerException();
        }
        players.get(name).changeRating(game, 10);
        System.out.println(name + " get rating: " + players.get(name).getRating(game) + " in - " + game);
    }

    public void lose(String name, Game game){
        if (!players.containsKey(name)){
            throw new NullPointerException();
        }
        players.get(name).changeRating(game ,-10);
        System.out.println(name + " get rating: " + players.get(name).getRating(game) + " in - " + game);
    }

    public List topGames() {
        List<Game> gameList = new ArrayList<Game>();
        int count = 0;
        for (Game game : Game.values()) {
            for (Player player : players.values()) {
                if (!player.getGames().contains(game)){ count++; }
            }
            if (count != 0) { break;}
            gameList.add(game);
        }
        if (gameList.size() == 0) { System.out.println("No popular games"); }
        return gameList;
    }

    public int rating(String name, Game game){
        return players.get(name).getRating(game);
    }

    public List topPlayersInGame(Game game){
        List<String> PlayerList = new ArrayList<String>();
            for (Player player : players.values()) {
                if (player.getGames().contains(game)){
                    PlayerList.add(player.getRating(game) + " - " + player.getName());
                }
            }
            Collections.sort(PlayerList);
            for (int i = PlayerList.size() - 10; i > 0 ; i--){
                PlayerList.remove(i);
            }
        if (PlayerList.size() == 0) { System.out.println("No players"); }
        return PlayerList;
    }

    public List topPlayers(){
        List<String> PlayerList = new ArrayList<String>();
        List<Integer> rating = new ArrayList<Integer>();
        for (Game game : Game.values()) {
            for (Player player : players.values()) {
                if (player.getGames().contains(game)) {
                    if (PlayerList.contains(player.getName())){
                        rating.set(PlayerList.indexOf(player.getName()), rating.get(PlayerList.indexOf(player.getName())) + player.getRating(game));
                    } else {
                        rating.add(player.getRating(game));
                        PlayerList.add(player.getName());
                    }
                }
            }
        }
        for (int i = 0; i < PlayerList.size(); i++){
            PlayerList.set(i, rating.get(i) + " - " + PlayerList.get(i));
        }
        Collections.sort(PlayerList);
        for (int i = PlayerList.size() - 10; i > 0 ; i--){
            PlayerList.remove(i);
        }
        if (PlayerList.size() == 0) { System.out.println("No players"); }
        return PlayerList;
    }

    public List topPlayersByHashMap(){
        Map<String, Integer> top = new HashMap<String, Integer>();
        List<String> topPlayer = new ArrayList<String>();
        for (Game game : Game.values()){
            for (Player player : players.values()){
                if (player.getGames().contains(game)){
                    if (top.containsKey(player)){
                        top.put(player.getName(), player.getRating(game) + top.get(player));
                    } else {
                        top.put(player.getName(), player.getRating(game));
                    }
                }
            }
        }
        for (String name : top.keySet()){
            topPlayer.add(top.get(name) + " - " + name);
        }
        Collections.sort(topPlayer);
        for (int i = topPlayer.size() - 10; i > 0 ; i--){
            topPlayer.remove(i);
        }
        if (topPlayer.size() == 0) { System.out.println("No players"); }
        return topPlayer;
    }

}
