package lecture.mid2.cardgame;

import java.util.*;

public class Deck {

    private List<Card> cards = new LinkedList<>();
    public Deck() {
        for (int i = 1; i < 13; i++) {
            for (Suit suit : Suit.values()) {
                cards.add(new Card(i, suit));
            }
        }
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }
    public void startGame() {
        shuffle();

        Player player1 = new Player("Player 1", getCard());
        Player player2 = new Player("Player 1", getCard());
        System.out.println("player1 = " + player1);
        System.out.println("player2 = " + player2);
    }
    private Card drawCard() {
        return cards.removeFirst();
    }
    private Set<Card> getCard() {
        TreeSet<Card> drawCards = new TreeSet<>();
        drawCards.add(drawCard());
        drawCards.add(drawCard());
        drawCards.add(drawCard());
        drawCards.add(drawCard());
        drawCards.add(drawCard());
        return drawCards;
    }


    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.startGame();
    }


}
