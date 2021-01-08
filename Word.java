package Crossword;

/*
 * @startX и @endX - координаты строки.
 * @startY и @endY - координаты столбца.
 * */
class Word {
    private String text;
    private int startX;
    private int startY;
    private int endX;
    private int endY;

    public Word(String text) {
        this.text = text;
    }

    public void setStartPoint(int x, int y) {
        startX = x;
        startY = y;
    }

    public void setEndPoint(int x, int y) {
        endX = x;
        endY = y;
    }

    @Override
    public String toString() {
        return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
    }
}
