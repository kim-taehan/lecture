package lecture.readableCode.studycafe.tobe.io.provider;

import lecture.readableCode.studycafe.tobe.model.pass.StudyCafePassType;
import lecture.readableCode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import lecture.readableCode.studycafe.tobe.model.pass.StudyCafeSeatPasses;
import lecture.readableCode.studycafe.tobe.provider.SeatPassProvider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SeatPassFileReader implements SeatPassProvider {

    public static final String LOCKER_LIST_CSV_PATH = "cleancode/studycafe/pass-list.csv";

    @Override
    public StudyCafeSeatPasses getSeatPasses() {
        try {

            InputStream inputStream = lecture.readableCode.studycafe.tobe.io.StudyCafeFileHandler.class.getClassLoader()
                    .getResourceAsStream(LOCKER_LIST_CSV_PATH);
            List<String> lines = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().toList();
            //List<String> lines = Files.readAllLines(Paths.get("src/main/resources/cleancode/studycafe/pass-list.csv"));
            List<StudyCafeSeatPass> studyCafePasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);
                double discountRate = Double.parseDouble(values[3]);

                StudyCafeSeatPass studyCafePass = StudyCafeSeatPass.of(studyCafePassType, duration, price, discountRate);
                studyCafePasses.add(studyCafePass);
            }

            return StudyCafeSeatPasses.of(studyCafePasses);
        } catch (RuntimeException e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }
}
