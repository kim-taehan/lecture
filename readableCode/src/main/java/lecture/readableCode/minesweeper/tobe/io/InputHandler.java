package lecture.readableCode.minesweeper.tobe.io;

import lecture.readableCode.minesweeper.tobe.position.CellPosition;

public interface InputHandler {

    String getUserInput();

    CellPosition getCellPositionFromUser();
}
