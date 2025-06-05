package lecture.readableCode.studycafe.tobe.io;

import lecture.readableCode.studycafe.tobe.model.StudyCafeLockerPass;
import lecture.readableCode.studycafe.tobe.model.StudyCafePass;
import lecture.readableCode.studycafe.tobe.model.StudyCafePassType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudyCafeFileHandler {

    public List<StudyCafePass> readStudyCafePasses() {
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

            return studyCafePasses;
        } catch (Exception e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

    public List<StudyCafeLockerPass> readLockerPasses() {
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

            return lockerPasses;
        } catch (Exception e) {
            throw new RuntimeException("파일을 읽는데 실패했습니다.", e);
        }
    }

}
