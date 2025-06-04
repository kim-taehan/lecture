package lecture.readableCode.minesweeper.tobe;

import lecture.readableCode.minesweeper.tobe.gamelevel.Advanced;

public class GameApplication {

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper(new Advanced());

        minesweeper.run();
    }

}
