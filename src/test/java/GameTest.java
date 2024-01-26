import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.QaCollections.Game;
import ru.netology.QaCollections.NotRegisteredException;
import ru.netology.QaCollections.Player;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Petr1995", 10);
    Player player2 = new Player(2, "Nagibator", 1);
    Player player3 = new Player(3, "Zorro", 5);

    @BeforeEach

    public void setup() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
    }

    @Test

    public void shouldPlayer1strongerPlayer2() {
        Assertions.assertEquals(1, game.round("Petr1995",
                "Nagibator"));
    }

    @Test
    public void shouldPlayer2strongerPlayer1() {
        Assertions.assertEquals(2, game.round("Nagibator",
                "Zorro"));
    }
    @Test
    public void shouldPlayer1EqualPlayer2 (){
        Player player4 = new Player(4, "Vasya", 5);
        game.register(player4);
        Assertions.assertEquals(0, game.round("Zorro" , "Vasya"));
    }

    @Test
    public void shouldPlayer1DoNotFound(){
        Assertions.assertThrows(NotRegisteredException.class, () -> {
        game.round("Vetl","Zorro");
        });
    }
    @Test
    public void shouldPlayer2DoNotFound(){
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Zorro","Vetl");
        });
    }
}
