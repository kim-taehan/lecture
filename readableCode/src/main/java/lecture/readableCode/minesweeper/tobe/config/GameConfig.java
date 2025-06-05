package lecture.readableCode.minesweeper.tobe.config;

import lecture.readableCode.minesweeper.tobe.gamelevel.GameLevel;
import lecture.readableCode.minesweeper.tobe.io.InputHandler;
import lecture.readableCode.minesweeper.tobe.io.OutputHandler;

public class GameConfig {

    private final GameLevel gameLevel;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public GameConfig(GameLevel gameLevel, InputHandler inputHandler, OutputHandler outputHandler) {
        this.gameLevel = gameLevel;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public GameLevel getGameLevel() {
        return gameLevel;
    }

    public InputHandler getInputHandler() {
        return inputHandler;
    }

    public OutputHandler getOutputHandler() {
        return outputHandler;
    }
}
