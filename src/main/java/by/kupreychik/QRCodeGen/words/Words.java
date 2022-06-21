package by.kupreychik.QRCodeGen.words;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Words {

    Random randomV = new Random();

    public static final List<String> myWords = new ArrayList<>();

    static  {
        myWords.add("привет");
        myWords.add("как твои дела");
        myWords.add("пупсик");
        myWords.add("это новое слово");
        myWords.add("а это старое");
    }

    public String getRandomWord() {
        int maxSize = myWords.size();
        int random = randomV.nextInt(maxSize);
        return myWords.get(random);
    }
}
