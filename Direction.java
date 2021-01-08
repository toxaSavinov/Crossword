package Crossword;

/*
* Направления для поиска слова в матрице.
* */
enum Direction {
    LEFT(0,-1), RIGTH(0, 1),
    UP(-1, 0), DOWN(1, 0),
    LEFT_UP(-1, -1), RIGTH_UP(-1, 1),
    LEFT_DOWN(1,-1), RIGTH_DOWN(1, 1);

    int y;
    int x;

    Direction(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
