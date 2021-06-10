package tests;

import com.codeborne.selenide.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import utils.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadFileTests {

    @Test
    void selenideDownloadReadmeTest() throws IOException {
        // download
        Configuration.downloadsFolder = "downloads";
        open("https://github.com/selenide/selenide/blob/master/README.md");
        File downloadedFile = $("#raw-url").download();
        String fileContent = Files.readTextFromFile(downloadedFile);
        // assertTrue(fileContent.contains("Selenide = UI Testing Framework powered by Selenium WebDriver"));
        assertThat(fileContent, containsString("Selenide = UI Testing Framework powered by Selenium WebDriver")); // лучший способ сказать об ошибке
    }

}
