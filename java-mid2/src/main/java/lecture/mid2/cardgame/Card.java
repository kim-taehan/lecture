package lecture.mid2.cardgame;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@RequiredArgsConstructor
@Getter
public class Card implements Comparable<Card> {

    private final int rank;
    private final Suit suit;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Card card = (Card) object;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }

    @Override
    public int compareTo(Card anotherCard) {
        if (this.rank != anotherCard.rank) {
            return Integer.compare(this.rank, anotherCard.rank);
        }
        return this.suit.compareTo(anotherCard.suit);
    }

    @Override
    public String toString() {
        return rank + "(" + this.suit + ")";
    }
}
