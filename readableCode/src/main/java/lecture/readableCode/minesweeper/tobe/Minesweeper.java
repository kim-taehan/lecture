package lecture.readableCode.minesweeper.tobe;

import lecture.readableCode.minesweeper.tobe.config.GameConfig;
import lecture.readableCode.minesweeper.tobe.game.GameRunnable;
import lecture.readableCode.minesweeper.tobe.io.InputHandler;
import lecture.readableCode.minesweeper.tobe.io.OutputHandler;
import lecture.readableCode.minesweeper.tobe.position.CellPosition;
import lecture.readableCode.minesweeper.tobe.user.UserAction;

public class Minesweeper implements GameRunnable, GameInitializable{

    private final GameBoard gameBoard;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;


    public Minesweeper(GameConfig gameConfig) {
        this.gameBoard = new GameBoard(gameConfig.getGameLevel());
        this.inputHandler = gameConfig.getInputHandler();
        this.outputHandler = gameConfig.getOutputHandler();
    }

    @Override
    public void initialize() {
        gameBoard.initializeGame();
    }

    public void run() {
        outputHandler.showGameStartComments();

        while (gameBoard.isInProgress()) {

            try {
                outputHandler.showBoard(gameBoard);
                CellPosition cellInput = getCellInputFromUser();
                UserAction userAction = getUserActionInputFromUser();
                actOnCell(cellInput, userAction);
            } catch (GameException e) {
                outputHandler.showExceptionMessage(e);
            } catch (Exception e) {
                outputHandler.showSimpleMessage("프로그램에 문제가 생겼습니다.");
            }
        }

        outputHandler.showBoard(gameBoard);

        if (gameBoard.isWinStatus()) {
            outputHandler.showGameWinningComment();
        }
        if (gameBoard.isLoseStatus()) {
            outputHandler.showGameLosingComment();
        }
    }

    private void actOnCell(CellPosition cellPosition, UserAction userAction) {

        if (doesUserChooseToPlantFlag(userAction)) {
            gameBoard.flagAt(cellPosition);
            return;
        }

        if (doesUserChooseToOpenCel(userAction)) {
            gameBoard.openAt(cellPosition);
            return;
        }

        System.out.println("잘못된 번호를 선택하셨습니다.");
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



}
