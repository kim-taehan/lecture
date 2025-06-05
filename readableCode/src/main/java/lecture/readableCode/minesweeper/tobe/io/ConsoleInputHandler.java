package lecture.readableCode.minesweeper.tobe.io;

import lecture.readableCode.minesweeper.tobe.BoardIndexConverter;
import lecture.readableCode.minesweeper.tobe.position.CellPosition;
import lecture.readableCode.minesweeper.tobe.user.UserAction;

import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler{

    public static final Scanner SCANNER = new Scanner(System.in);

    private final BoardIndexConverter boardIndexConverter = new BoardIndexConverter();


    @Override
    public UserAction getUserActionFromUser() {
        String userInput = SCANNER.nextLine();
        if ("1".equals(userInput)) {
            return UserAction.OPEN;
        }
        if ("2".equals(userInput)) {
            return UserAction.FLAG;
        }
        return UserAction.UNKNOW;
    }

    @Override
    public CellPosition getCellPositionFromUser() {
        String userInput = SCANNER.nextLine();
        int rowIndex = boardIndexConverter.getSelectedRowIndex(userInput);
        int colIndex = boardIndexConverter.getSelectedColIndex(userInput);
        return CellPosition.of(rowIndex, colIndex);
    }

}
