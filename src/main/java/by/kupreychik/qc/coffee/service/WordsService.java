package by.kupreychik.qc.coffee.service;

import by.kupreychik.qc.coffee.exception.FileReaderException;
import by.kupreychik.qc.coffee.model.entity.Phrase;
import by.kupreychik.qc.coffee.repository.PhraseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WordsService {

    private final PhraseRepository phraseRepository;
    private final Random random;

    private List<String> phrases = new ArrayList<>();

    @PostConstruct
    public void initPhrases() throws FileReaderException {
        phrases = phraseRepository.findAll()
                .stream()
                .map(Phrase::getDescription)
                .collect(Collectors.toList());
    }

    public List<String> getWords() {
        return phrases;
    }


    public void addWord(String word) {
        phraseRepository.save(new Phrase(word));
        phrases.add(word);
    }

    public String getRandomWord() {
        return phrases.get(random.nextInt(phrases.size()));
    }
}
