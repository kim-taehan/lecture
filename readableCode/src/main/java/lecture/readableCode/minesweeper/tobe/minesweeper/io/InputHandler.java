package lecture.readableCode.minesweeper.tobe.minesweeper.io;

import lecture.readableCode.minesweeper.tobe.minesweeper.board.position.CellPosition;
import lecture.readableCode.minesweeper.tobe.minesweeper.user.UserAction;

public interface InputHandler {


    UserAction getUserActionFromUser();

    CellPosition getCellPositionFromUser();
}
