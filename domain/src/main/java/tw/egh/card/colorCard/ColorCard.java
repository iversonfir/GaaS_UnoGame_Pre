package tw.egh.card.colorCard;

import tw.egh.card.Card;

public class ColorCard extends Card {
    private Color color;

    public ColorCard(Color color) {
        this.color=color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}