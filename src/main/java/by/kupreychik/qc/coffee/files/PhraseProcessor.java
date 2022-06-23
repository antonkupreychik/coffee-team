package by.kupreychik.qc.coffee.files;

import by.kupreychik.qc.coffee.exception.FileReaderException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class PhraseProcessor {

    public List<String> getPhasesList() throws FileReaderException {
        List<String> phases = new ArrayList<>();
        try {
            phases = Files.readAllLines(Paths.get("src/main/resources/phrases.txt"), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileReaderException("File reading error");
        }
        return phases;
    }
}
