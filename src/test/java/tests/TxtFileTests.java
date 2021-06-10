package tests;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static utils.Files.readTextFromPath;

public class TxtFileTests {

    @Test
    void checkTxtTest() throws IOException {
        String txtFilePath = "./src/test/resources/files/1.txt";
        String expectedData = "hello qa.guru students!";

        String actualData = readTextFromPath(txtFilePath);
        assertThat(actualData, containsString(expectedData)); // лучший способ сказать об ошибке
    }

    @Test
    void checkCsvTest() throws IOException {
        String csvFilePath= "./src/test/resources/files/1.csv";
        String expectedData = "hello qa.guru students!";

        String actualData = readTextFromPath(csvFilePath);
        assertThat(actualData, containsString(expectedData)); // лучший способ сказать об ошибке
    }

}
