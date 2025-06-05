package lecture.readableCode.minesweeper.tobe.io;

import lecture.readableCode.minesweeper.tobe.position.CellPosition;
import lecture.readableCode.minesweeper.tobe.user.UserAction;

public interface InputHandler {


    UserAction getUserActionFromUser();

    CellPosition getCellPositionFromUser();
}
