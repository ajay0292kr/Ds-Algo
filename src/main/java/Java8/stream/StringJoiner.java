package Java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Game {
    String name;
    int ranking;

    public Game(String name, int ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
public class StringJoiner {
    public static void main(String[] args) {
        List<Game> list = Arrays.asList(
                new Game("Dragon Blaze", 5),
                new Game("Angry Bird", 5),
                new Game("Candy Crush", 5)
        );

        //{Dragon Blaze, Angry Bird, Candy Crush}
        String str = list.stream().map(Game::getName).collect(Collectors.joining(",","{", "}"));
        System.out.print(str);

        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        boolean result = IntStream.of(number).anyMatch(e ->e == 4);
        if(result) {
            System.out.print("Where is number 4");
        }else {
            System.out.print("Where is number 4 ?");
        }


    }
}
