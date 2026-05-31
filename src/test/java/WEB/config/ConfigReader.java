package WEB.config;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class ConfigReader {

    WebDriver driver;
    public ConfigReader (WebDriver driver){
        this.driver=driver;
    }

    public void takeScreenshot(String screenshotName, Path foderPath, String testCaseNo) {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            // for screenshot not to have same name
            FileUtils.copyFile(screenshot, new File(foderPath+"/"+testCaseNo+" "+screenshotName+" screenshot.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties readProperties() throws Exception {
        Properties properties = new Properties();

        // Load properties file from resources folder
        InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("resources.properties");

        if (input == null) {
            System.out.println("Sorry, unable to find resources.properties in resources folder.");
        }
        // Load the properties from the input stream
        properties.load(input);
        // Access properties
        return properties;
    }


    public Path createFolder() throws Exception {
        // Define the base directory where the folder will be created
        Properties config = readProperties();
        String baseDir = config.getProperty("baseDir"); // Change this to your desired path

        // Create a timestamp string (e.g., 2026-05-29 14-35-22)
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));

        // Combine base directory and timestamp to form the folder path
        Path folderPath = Paths.get(baseDir, "TestResults_" + timestamp);

        try {
            // Create the directory
            Files.createDirectories(folderPath);
            System.out.println("Folder created: " + folderPath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error creating folder: " + e.getMessage());
        }
        return folderPath;
    }

}
