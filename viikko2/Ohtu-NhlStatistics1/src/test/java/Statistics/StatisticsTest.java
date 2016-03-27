/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Statistics;

import java.util.*;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arto
 */
public class StatisticsTest {
    Reader stub;
    Statistics s;
    List<Player> p;
    public StatisticsTest() {

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        stub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };
        this.s = new Statistics(stub);
        this.p = stub.getPlayers();
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testSearch(){
        for(Player player: this.p){
            Player foundPlayer = s.search(player.getName());
            assertEquals(player.toString(), foundPlayer.toString());
        }
    }
    @Test
    public void testSearchNotFound(){
        assertNull(s.search("Matti Nykänen"));
        assertNotNull(s.search("Semenko"));
    }
    @Test
    public void testTeam(){
        List<Player> EDM = s.team("EDM");
        List<Player> PIT = s.team("PIT");
        List<Player> DET = s.team("DET");
        
        assertEquals(3,EDM.size());
        assertEquals(1,PIT.size());
        assertEquals(1,DET.size());
    }
    @Test
    public void testTeamNotFound(){
        List<Player> t1 = s.team("HUMPPA");
        assertEquals(0,t1.size());
    }
    @Test
    public void testTopScores(){
        Collections.sort(this.p);
        List<Player> top = s.topScorers(this.p.size()-1);
        Iterator<Player> itop1 = top.iterator();
        assertTrue(itop1.hasNext());
        Iterator<Player> itop2 = this.p.iterator();
        assertTrue(itop2.hasNext());
        assertEquals(this.p.size(),top.size());
        while(itop1.hasNext()){
            Player a = itop1.next();
            Player b = itop2.next();
            assertEquals(a.toString(),b.toString());     
        }
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
