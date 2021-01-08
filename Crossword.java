package Crossword;

/*
Create by Willi27
*/

import java.util.*;

class Crossword {
    private int[][] crossword = new int[][] {
            {'f', 'd', 'e', 'r', 'l', 'k'},
            {'u', 's', 'a', 'm', 'e', 'o'},
            {'l', 'n', 'g', 'r', 'o', 'v'},
            {'m', 'l', 'p', 'r', 'r', 'h'},
            {'p', 'o', 'e', 'e', 'j', 'j'}
    };

    public void setCrossword(int[][] crossword) {
        if (crossword != null && crossword.length > 0) this.crossword = crossword;
    }

    public int[][] getCrossword() {
        return crossword;
    }

    public List<Word> wordSearch(int[][] crossword, String... words) {
        List<Word> result = new ArrayList<>();
        List<Direction> directions = Arrays.asList(
                Direction.LEFT, Direction.RIGTH, Direction.UP, Direction.DOWN,
                Direction.LEFT_UP, Direction.RIGTH_UP, Direction.LEFT_DOWN, Direction.RIGTH_DOWN);

        for (String currentWord : words) {

            for (int y = 0; y < crossword.length; y++) {
                for (int x = 0; x < crossword[y].length; x++) {

                    if ((char) crossword[y][x] == currentWord.toLowerCase().charAt(0)) {
                        for (Direction dir : directions) {
                            wordCheck(crossword, y, x, currentWord.toLowerCase(), dir, result);
                        }
                    }
                }
            }
        }

        result.forEach(System.out::println);
        return result;
    }

    private void wordCheck(int[][] matrix, int coordinateY, int coordinateX, String currentWord, Direction direction, List<Word> result) {
        int thisY = coordinateY;
        int thisX = coordinateX;
        StringBuilder builder = new StringBuilder();
        builder.append((char) matrix[thisY][thisX]);

        try {
            for (int i = 0; i < currentWord.length()-1; i++) {
                builder.append((char) matrix[thisY += direction.y][thisX += direction.x]);
            }
            if (currentWord.equals(builder.toString())) {
                Word word = new Word(currentWord);
                word.setStartPoint(coordinateX, coordinateY);
                word.setEndPoint(thisX, thisY);
                result.add(word);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Для массива @matrix указан неверный индекс.");
//            e.printStackTrace();
        }
    }
}