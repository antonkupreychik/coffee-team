package by.kupreychik.qc.coffee.service;

import by.kupreychik.qc.coffee.enums.Types;
import by.kupreychik.qc.coffee.exception.FileReaderException;
import by.kupreychik.qc.coffee.files.PhraseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class WordsService {


    @Autowired
    private PhraseProcessor phraseProcessor;

    private List<String> phrases = new ArrayList<>();

    private Map<Types, List<String>> wordsContainer = new HashMap<>();
    private final Random random = new Random();

    @PostConstruct
    public void initPhrases() throws FileReaderException {
        phrases = phraseProcessor.getPhasesList();
        wordsContainer.put(Types.RANDOM, phrases);
        wordsContainer.put(Types.ME, new ArrayList<>());
    }

    public void addWord(String word) {
        wordsContainer.get(Types.ME).add(word);
    }

    public String getRandomWord(Types type) {
        List<String> words = wordsContainer.get(type);
        return words.get(random.nextInt(words.size() - 1));
    }
}
