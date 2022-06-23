package by.kupreychik.qc.coffee.service;

import by.kupreychik.qc.coffee.exception.FileReaderException;
import by.kupreychik.qc.coffee.files.PhraseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class WordsService {


    @Autowired
    private PhraseProcessor phraseProcessor;

    private List<String> phrases = new ArrayList<>();
    private final Random random = new Random();

    @PostConstruct
    public void initPhrases() throws FileReaderException {
        phrases = phraseProcessor.getPhasesList();
    }

    public String getRandomWord() {
        return phrases.get(random.nextInt(phrases.size()));
    }
}
