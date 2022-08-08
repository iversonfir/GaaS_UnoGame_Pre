package tw.egh.card.colorCard;

public class NumberCard extends ColorCard {

    private Number number;

    public NumberCard(Color color, Number number) {
        super(color);
        this.number=number;
    }

    public Number getNumber() {
        return number;
    }
}
