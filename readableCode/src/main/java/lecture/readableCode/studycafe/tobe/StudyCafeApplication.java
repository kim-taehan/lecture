package lecture.readableCode.studycafe.tobe;

import lecture.readableCode.studycafe.tobe.io.provider.LockerPassFileReader;
import lecture.readableCode.studycafe.tobe.io.provider.SeatPassFileReader;

public class StudyCafeApplication {

    public static void main(String[] args) {
        StudyCafePassMachine studyCafePassMachine = new StudyCafePassMachine(new SeatPassFileReader(), new LockerPassFileReader());
        studyCafePassMachine.run();
    }

}
