package by.kupreychik.qc.coffee.controller;

import by.kupreychik.qc.coffee.service.WordsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequiredArgsConstructor
@RequestMapping("/random")
@Tag(name = "words", description = "Words controller")
public class RandomWordController {

    public static final String RANDOM = "random";
    public static final String INDEX_PATH = "/index";

    private final WordsService wordsService;

    @GetMapping
    public ModelAndView getRandom(ModelAndView modelAndView) {
        modelAndView.setViewName(INDEX_PATH);
        modelAndView.addObject(RANDOM, wordsService.getRandomWord());
        return modelAndView;
    }

    @GetMapping("/my")
    public ModelAndView getMyRandom(ModelAndView modelAndView) {
        modelAndView.setViewName(INDEX_PATH);
        modelAndView.addObject(RANDOM, wordsService.getRandomWord());
        return modelAndView;
    }


}
