package by.kupreychik.qc.coffee.controller;

import by.kupreychik.qc.coffee.enums.Types;
import by.kupreychik.qc.coffee.service.WordsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Tag(name = "words", description = "Words controller")
@RequiredArgsConstructor
@RequestMapping("/randomWord")
public class RandomWordController {

    private static final String RANDOM = "random";
    private static final String INDEX_PATH = "/index";
    private final WordsService wordsService;

    @GetMapping
    @Operation(
            summary = "Get random world",
            description = "Add word to my list"
    )
    public ModelAndView getRandom(ModelAndView modelAndView) {
        modelAndView.setViewName(INDEX_PATH);
        modelAndView.addObject(RANDOM, wordsService.getRandomWord(Types.RANDOM));
        return modelAndView;
    }

    @GetMapping("/my")
    @Operation(
            summary = "Get random world",
            description = "Add word to my list"
    )
    public ModelAndView getMyRandom(ModelAndView modelAndView) {
        modelAndView.setViewName(INDEX_PATH);
        modelAndView.addObject(RANDOM, wordsService.getRandomWord(Types.ME));
        return modelAndView;
    }

    @PostMapping("/my")
    @Operation(
            summary = "Add word to my new list",
            description = "Add word to my list"
    )
    public ResponseEntity<String> addNewWord(String word) {
        wordsService.addWord(word);
        return ResponseEntity.ok().build();
    }
}
