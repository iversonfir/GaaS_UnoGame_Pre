package tw.egh;

import tw.egh.card.Card;
import tw.egh.card.colorCard.*;
import tw.egh.card.colorCard.Number;
import tw.egh.card.specialCard.WildCard;
import tw.egh.card.specialCard.WildDrawFourCard;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    public static List<Card> getStandardCards108() {
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            cards.add(new WildCard());
            cards.add(new WildDrawFourCard());
        }


        Color[] colors = Color.values();
        Number[] numbers= Number.values();
            for (int i = 0; i < colors.length; i++) {
                for (int j = 0; j < 2; j++) {
                for (int k = 1; k < numbers.length; k++) {
                    cards.add(new NumberCard(colors[i],numbers[k]));
                }

                cards.add(new SkipCard(colors[i]));
                cards.add(new ReverseCard(colors[i]));
                cards.add(new DrawTwoCard(colors[i]));
            }

                //numberCard 0
                cards.add(new NumberCard(colors[i],Number.ZERO));
        }
        return cards;
    }
}
