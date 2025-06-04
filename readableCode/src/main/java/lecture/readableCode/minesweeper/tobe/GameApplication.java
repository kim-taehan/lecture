package lecture.readableCode.minesweeper.tobe;

import lecture.readableCode.minesweeper.tobe.gamelevel.Advanced;
import lecture.readableCode.minesweeper.tobe.io.ConsoleInputHandler;
import lecture.readableCode.minesweeper.tobe.io.ConsoleOutputHandler;

public class GameApplication {

    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper(new Advanced(), new ConsoleInputHandler(), new ConsoleOutputHandler());
        minesweeper.initialize();
        minesweeper.run();
    }

    /**
     * DIP (Dependency Inversion Principle)
     * - 고수준 모듈은 저수준 모듈에 의존하면 안되면
     * DI (Dependency Injection)
     * - 의존성 주입 (필요한 의존성을 외부에서 주입)
     * IoC (Inversion of Control)
     * -
     */

}
