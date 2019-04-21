import task_1.Exceptions.NameAlreadyExsist;

import org.junit.Assert;
import org.junit.Test;
import task_1.Service;

import java.util.ArrayList;
import java.util.List;

import static task_1.Games.Game.EAGAME;
import static task_1.Games.Game.UBGAME;
import static task_1.Games.Game.VALVEGAME;

public class ServiceTest {

    private List<Object> games = new ArrayList<Object>();
    private Service service = new Service();

    @Test
    public void ServiceAddTestPositive() throws Exception{
        service.add("name1", games);
        service.add("name2", games);
        service.add("name3", games);
        service.add("name4", games);
        service.add("name5", games);
        service.add("name6", games);

        Assert.assertTrue(
                service.getPlayers().containsKey("name1")
                && service.getPlayers().containsKey("name2")
                && service.getPlayers().containsKey("name3")
                && service.getPlayers().containsKey("name4")
                && service.getPlayers().containsKey("name5")
                && service.getPlayers().containsKey("name6"));
    }

    @Test
    public void ServiceAddTestNegative() throws Exception{
        try {
            service.add("name", games);
            service.add("name", games);
        } catch (NameAlreadyExsist e) {
            Assert.assertNotNull(e);
            Assert.assertTrue(service.getPlayers().containsKey("name"));
        }
    }

    @Test
    public void ServiceWinTest() throws Exception{
        games.add(EAGAME);
        games.add(VALVEGAME);
        games.add(UBGAME);

        service.add("name1", games);
        service.add("name2", games);
        service.add("name3", games);
        service.add("name4", games);
        service.add("name5", games);
        service.add("name6", games);
        service.win("name1", EAGAME);
        service.win("name1", EAGAME);
        service.win("name5", VALVEGAME);
        service.win("name1", UBGAME);

        try {
            service.win("name0", UBGAME);
        } catch (NullPointerException e){
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void ServiceLoseTest()throws Exception{
        games.add(EAGAME);
        games.add(VALVEGAME);
        games.add(UBGAME);

        service.add("name1", games);
        service.add("name2", games);
        service.add("name3", games);
        service.add("name4", games);
        service.add("name5", games);
        service.add("name6", games);
        service.lose("name1", EAGAME);
        service.lose("name1", EAGAME);
        service.lose("name5", VALVEGAME);
        service.lose("name1", UBGAME);

        try {
            service.lose("name0", UBGAME);
        } catch (NullPointerException e){
            Assert.assertNotNull(e);
        }
    }

    @Test
    public void ServiceTopGamesTest() throws Exception{
        games.add(EAGAME);
        games.add(VALVEGAME);
        games.add(UBGAME);

        service.add("name1", games);
        service.add("name2", games);
        service.add("name3", games);
        service.add("name4", games);
        service.add("name5", games);
        service.add("name6", games);

        Assert.assertNotNull(service.topGames());
        Assert.assertEquals(3, service.topGames().size());
    }

    @Test
    public void ServiceGetRatingTest() throws Exception{
        games.add(EAGAME);
        games.add(VALVEGAME);
        games.add(UBGAME);

        service.add("name1", games);
        service.add("name2", games);
        service.add("name3", games);
        service.add("name4", games);
        service.add("name5", games);
        service.add("name6", games);
        service.lose("name1", EAGAME);
        service.win("name1", EAGAME);
        service.lose("name5", VALVEGAME);
        service.win("name1", EAGAME);
        service.win("name5", VALVEGAME);

        System.out.println("Rating :" + service.rating("name1", EAGAME));
        System.out.println("Rating :" + service.rating("name5", VALVEGAME));
    }

    @Test
    public void  ServiceTopPlayersInGameTest() throws Exception{
        games.add(EAGAME);
        games.add(VALVEGAME);
        games.add(UBGAME);

        service.add("name1", games);
        service.add("name2", games);
        service.add("name3", games);
        service.add("name4", games);
        service.add("name5", games);
        service.add("name6", games);

        service.lose("name2", EAGAME);
        service.win("name1", EAGAME);
        service.lose("name5", VALVEGAME);
        service.win("name1", EAGAME);
        service.win("name5", VALVEGAME);
        service.win("name3", UBGAME);

        System.out.println(service.topPlayersInGame(EAGAME) );
    }

    @Test
    public void  ServiceTopPlayersByHashMapTest() throws Exception{
        games.add(EAGAME);
        games.add(VALVEGAME);
        games.add(UBGAME);

        service.add("name1", games);
        service.add("name2", games);
        service.add("name3", games);
        service.add("name4", games);
        service.add("name5", games);
        service.add("name6", games);

        service.win("name1", EAGAME);
        service.win("name2", EAGAME);
        service.win("name3", EAGAME);
        service.win("name4", EAGAME);
        service.win("name5", EAGAME);
        service.win("name6", EAGAME);

        service.lose("name2", EAGAME);

        System.out.println(service.topPlayersByHashMap());  // can be realize by HashMap
        /*
        name1 get rating: 10 in - EAGAME
        name2 get rating: 10 in - EAGAME
        name3 get rating: 10 in - EAGAME
        name4 get rating: 10 in - EAGAME
        name5 get rating: 10 in - EAGAME
        name6 get rating: 10 in - EAGAME
        name2 get rating: 0 in - EAGAME
              [0 - name2, 10 - name1, 10 - name3, 10 - name4, 10 - name5, 10 - name6]
         */
    }

    @Test
    public void  ServiceTopPlayersTest() throws Exception{
        games.add(EAGAME);
        games.add(VALVEGAME);
        games.add(UBGAME);

        service.add("name1", games);
        service.add("name2", games);
        service.add("name3", games);
        service.add("name4", games);
        service.add("name5", games);
        service.add("name6", games);

        service.win("name1", EAGAME);
        service.win("name2", EAGAME);
        service.win("name3", EAGAME);
        service.win("name4", EAGAME);
        service.win("name5", EAGAME);
        service.win("name6", EAGAME);

        service.lose("name2", EAGAME);

        System.out.println(service.topPlayers());  // can be realize by HashMap
        /*
        name1 get rating: 10 in - EAGAME
        name2 get rating: 10 in - EAGAME
        name3 get rating: 10 in - EAGAME
        name4 get rating: 10 in - EAGAME
        name5 get rating: 10 in - EAGAME
        name6 get rating: 10 in - EAGAME
        name2 get rating: 0 in - EAGAME
              [0 - name2, 10 - name1, 10 - name3, 10 - name4, 10 - name5, 10 - name6]
         */
    }
}
