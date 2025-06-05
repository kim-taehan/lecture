package lecture.readableCode.minesweeper.tobe.minesweeper.io;

import lecture.readableCode.minesweeper.tobe.minesweeper.board.GameBoard;

public interface OutputHandler {

    void showGameStartComments();

    void showBoard(GameBoard board);

    void showGameWinningComment();

    void showGameLosingComment();

    void showCommentForSelectingCell();

    void showCommentForUserAction();

    void showExceptionMessage(Exception exception);

    void showSimpleMessage(String message);
}
