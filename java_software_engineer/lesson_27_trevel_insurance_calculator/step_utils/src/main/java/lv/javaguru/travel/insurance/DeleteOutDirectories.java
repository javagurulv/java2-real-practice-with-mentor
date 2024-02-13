package lv.javaguru.travel.insurance;

import org.apache.tomcat.util.http.fileupload.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteOutDirectories {

    public static void main(String[] args) {

        for (int i = 0; i <= 188; i++) {
            String stepDirPath = "C:\\javaguru\\projects\\java2-real-practice-with-mentor\\java_software_engineer\\lesson_27_trevel_insurance_calculator\\step_";

            stepDirPath = stepDirPath + i;
            String stepLogDirPath = stepDirPath + "\\out";
            deleteDirIfExist(stepLogDirPath);
        }

    }

    private static void deleteDirIfExist(String dirPath) {
        try {
            // Create Path object for log directory
            Path logDirPath = Paths.get(dirPath);

            // Delete the directory
            if (Files.exists(logDirPath)) {
                FileUtils.deleteDirectory(logDirPath.toFile());
            }

            System.out.println("Directory deleted successfully " + dirPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
