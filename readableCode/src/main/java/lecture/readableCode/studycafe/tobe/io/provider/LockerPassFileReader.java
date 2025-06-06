package lecture.readableCode.studycafe.tobe.io.provider;

import lecture.readableCode.studycafe.tobe.io.StudyCafeFileHandler;
import lecture.readableCode.studycafe.tobe.model.pass.StudyCafePassType;
import lecture.readableCode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import lecture.readableCode.studycafe.tobe.model.pass.locker.StudyCafeLockerPasses;
import lecture.readableCode.studycafe.tobe.provider.LockerPassProvider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LockerPassFileReader implements LockerPassProvider {

    public static final String PATH_LIST_CSV = "cleancode/studycafe/locker.csv";

    @Override
    public StudyCafeLockerPasses getLockerPasses() {
        try {
            InputStream inputStream = StudyCafeFileHandler.class.getClassLoader()
                    .getResourceAsStream(PATH_LIST_CSV);
            List<String> lines = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .toList();
            List<StudyCafeLockerPass> lockerPasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);

                StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(studyCafePassType, duration, price);
                lockerPasses.add(lockerPass);
            }

            return StudyCafeLockerPasses.of(lockerPasses);
        } catch (Exception e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }
}
