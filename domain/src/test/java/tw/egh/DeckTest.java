package tw.egh;

import org.junit.jupiter.api.Test;
import tw.egh.card.Card;
import tw.egh.card.colorCard.Color;
import tw.egh.card.colorCard.ColorCard;
import tw.egh.card.colorCard.Number;
import tw.egh.card.colorCard.NumberCard;
import tw.egh.card.colorCard.SkipCard;
import tw.egh.card.specialCard.WildCard;
import tw.egh.card.specialCard.WildDrawFourCard;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static tw.egh.card.colorCard.Color.*;


class DeckTest {

    private final List<Card> standardCards108 = Deck.getStandardCards108();

    @Test
    public void givenDeckInit_whenGetStandardCards108_thenHasFourWildCards() {
        assertEquals(4, getColorCardsSize(WildCard.class));
    }
    @Test
    public void givenDeckInit_whenGetStandardCards108_thenHasFourWildDrawFourCards() {
        assertEquals(4, getColorCardsSize(WildDrawFourCard.class));
    }
    @Test
    public void givenDeckInit_whenGetStandardCards108_thenHas2RedSkipCardsShouldBeSuccess() {
        //獲得 two red skipCard 如果只是卡片張數還不夠?
        assertEquals(2, getColorCardsSize(SkipCard.class, RED));
    }
    @Test
    public void givenDeckInit_whenGetStandardCards108_thenHas2GreenSkipCardsBeSuccess() {
        assertEquals(2, getColorCardsSize(SkipCard.class, GREEN));
    }
    @Test
    public void givenDeckInit_whenGetStandardCards108_thenHas2BlueSkipCardsBeSuccess() {
        assertEquals(2, getColorCardsSize(SkipCard.class, BLUE));
    }
    @Test
    public void givenDeckInit_whenGetStandardCards108_thenHas2YellowSkipCardsBeSuccess() {
        assertEquals(2, getColorCardsSize(SkipCard.class, YELLOW));
    }

    @Test
    public void givenDeckInit_whenGetStandardCards108_thenHas3YellowSkipCardsBeFail() {
        assertNotEquals(3, getColorCardsSize(SkipCard.class, YELLOW));
    }


    @Test
    public void givenDeckInit_whenGetStandardCards108_thenHas19YellowNumberCardsBeSuccess() {
        assertEquals(19, getColorCardsSize(NumberCard.class, YELLOW));
    }
    @Test
    public void givenDeckInit_whenGetStandardCards108_thenHas1YellowZeroNumberCardsBeSuccess() {
        assertEquals(1, getNumberCardsSize(YELLOW,Number.ZERO));
    }

    @Test
    public void givenDeckInit_whenGetStandardCards108_thenHas76AllColorNumberCardsBeSuccess() {
        assertEquals(76, getColorCardsSize(NumberCard.class));
    }



    private int getColorCardsSize(Class cardType) {
        return standardCards108.stream()
                .filter(cardType::isInstance)
                .collect(Collectors.toList())
                .size();
    }

    private int getColorCardsSize(Class cardType, Color color) {
        return standardCards108.stream()
                .filter(cardType::isInstance)
                .map(ColorCard.class::cast)
                .filter(colorCard -> colorCard.getColor()==color)
                .collect(Collectors.toList())
                .size();
    }

    private int getNumberCardsSize(Color color, Number number) {
        return standardCards108.stream()
                .filter(NumberCard.class::isInstance)
                .map(NumberCard.class::cast)
                .filter(colorCard -> colorCard.getColor()==color)
                .filter(numberCard -> numberCard.getNumber()==number)
                .collect(Collectors.toList())
                .size();
    }
}