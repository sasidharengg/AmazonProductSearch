package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertiesFile {

    /**
     * Loads the properties file
     *
     * @param inputFileName Name of the properties file, inputKeyName Name of the Key value
     */
    public String loadInputFromPropertiesFile(String inputFileName, String inputKeyName) {

        String currentDir = System.getProperty("user.dir");
        Properties properties = new Properties();
        try {
            FileInputStream propFile = new FileInputStream(currentDir + "\\src\\test\\resources\\TestData\\TestData.properties");
            properties.load(propFile);
        } catch (IOException e) {
            System.out.println("Exception at Properties File Loading " + e);
        }
finally {
            return properties.getProperty(inputKeyName);
        }

    }
}
