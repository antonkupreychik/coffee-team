package by.kupreychik.qc.coffee.controller;

import by.kupreychik.qc.coffee.enums.Types;
import by.kupreychik.qc.coffee.service.WordsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Tag(name = "words", description = "Words controller")
public class RandomWordController {

    @Autowired
    private WordsService wordsService;

    @GetMapping("/randomWord")
    public ModelAndView getRandom() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("random", wordsService.getRandomWord(Types.RANDOM));
        return modelAndView;
    }

    @GetMapping("/my/randomWord")
    public ModelAndView getMyRandom() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("random", wordsService.getRandomWord(Types.ME));
        return modelAndView;
    }

    @PostMapping("/my/randomWord")
    @Operation(summary = "Add word to my new list", description = "Add word to my list")
    public ResponseEntity<String> addNewWord(String word) {
        wordsService.addWord(word);
        return ResponseEntity.ok().build();
    }
}
