package lecture.readableCode.studycafe.tobe.io;

import lecture.readableCode.studycafe.tobe.model.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StudyCafeFileHandler {

    public StudyCafePasses readStudyCafePasses() {
        try {
            InputStream inputStream = StudyCafeFileHandler.class.getClassLoader()
                    .getResourceAsStream("cleancode/studycafe/pass-list.csv");
            List<String> lines = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().toList();
            List<StudyCafePass> studyCafePasses = new ArrayList<>();
            for (String line : lines) {
                String[] values = line.split(",");
                StudyCafePassType studyCafePassType = StudyCafePassType.valueOf(values[0]);
                int duration = Integer.parseInt(values[1]);
                int price = Integer.parseInt(values[2]);
                double discountRate = Double.parseDouble(values[3]);

                StudyCafePass studyCafePass = StudyCafePass.of(studyCafePassType, duration, price, discountRate);
                studyCafePasses.add(studyCafePass);
            }

            return StudyCafePasses.of(studyCafePasses);
        } catch (Exception e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    public StudyCafeLockerPasses readLockerPasses() {
        try {
            InputStream inputStream = StudyCafeFileHandler.class.getClassLoader()
                    .getResourceAsStream("cleancode/studycafe/locker.csv");
            List<String> lines = new BufferedReader(new InputStreamReader(inputStream))
                    .lines().toList();
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
