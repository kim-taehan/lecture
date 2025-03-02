package lecture.mid2.cardgame;

import java.util.Set;

public class Player {

    private final String name;
    private final Set<Card> hand;

    public Player(String name, Set<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}
