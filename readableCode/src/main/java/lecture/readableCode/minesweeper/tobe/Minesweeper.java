package lecture.readableCode.minesweeper.tobe;

import lecture.readableCode.minesweeper.tobe.game.GameRunnable;
import lecture.readableCode.minesweeper.tobe.gamelevel.GameLevel;
import lecture.readableCode.minesweeper.tobe.io.InputHandler;
import lecture.readableCode.minesweeper.tobe.io.OutputHandler;
import lecture.readableCode.minesweeper.tobe.position.CellPosition;
import lecture.readableCode.minesweeper.tobe.user.UserAction;

public class Minesweeper implements GameRunnable, GameInitializable{

    private final GameBoard gameBoard;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private int gameStatus = 0; // 0: 게임 중, 1: 승리, -1: 패배

    public Minesweeper(GameLevel gameLevel, InputHandler inputHandler, OutputHandler outputHandler) {
        this.gameBoard = new GameBoard(gameLevel);
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    @Override
    public void initialize() {
        gameBoard.initializeGame();
    }

    public void run() {
        outputHandler.showGameStartComments();

        while (true) {
            try {
                outputHandler.showBoard(gameBoard);

                if (doesUserWinTheGame()) {
                    outputHandler.showGameWinningComment();
                    break;
                }
                if (doesUserLoseTheGame()) {
                    outputHandler.showGameLosingComment();
                    break;
                }

                CellPosition cellInput = getCellInputFromUser();
                UserAction userAction = getUserActionInputFromUser();
                actOnCell(cellInput, userAction);
            } catch (GameException e) {
                outputHandler.showExceptionMessage(e);
            } catch (Exception e) {
                outputHandler.showSimpleMessage("프로그램에 문제가 생겼습니다.");
            }
        }
    }

    private void actOnCell(CellPosition cellPosition, UserAction userAction) {

        if (doesUserChooseToPlantFlag(userAction)) {
            gameBoard.flagAt(cellPosition);
            checkIfGameIsOver();
            return;
        }

        if (doesUserChooseToOpenCel(userAction)) {
            if (gameBoard.isLandMineCellAt(cellPosition)) {
                gameBoard.openAt(cellPosition);
                changeGameStatusTOLose();
                return;
            }

            gameBoard.openSurroundedCells(cellPosition);
            checkIfGameIsOver();
            return;
        }

        System.out.println("잘못된 번호를 선택하셨습니다.");
    }

    private void changeGameStatusTOLose() {
        gameStatus = -1;
    }

    private boolean doesUserChooseToOpenCel(UserAction userAction) {
        return userAction == UserAction.OPEN;
    }

    private boolean doesUserChooseToPlantFlag(UserAction userAction) {
        return userAction == UserAction.FLAG;
    }


    private UserAction getUserActionInputFromUser() {
        outputHandler.showCommentForUserAction();
        return inputHandler.getUserActionFromUser();
    }

    private CellPosition getCellInputFromUser() {
        outputHandler.showCommentForSelectingCell();
        CellPosition cellPosition = inputHandler.getCellPositionFromUser();

        if (gameBoard.isInvalidCellPosition(cellPosition)) {
            throw new GameException("잘못된 좌표를 선택하셨습니다.");
        }

        return cellPosition;
    }

    private  boolean doesUserLoseTheGame() {
        return gameStatus == -1;
    }

    private  boolean doesUserWinTheGame() {
        return gameStatus == 1;
    }

    private  void checkIfGameIsOver() {
        if (gameBoard.isAllChecked()) {
            changeGameStatusToWin();
        }
    }

    private void changeGameStatusToWin() {
        gameStatus = 1;
    }

}
