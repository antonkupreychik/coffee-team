package by.kupreychik.qc.coffee.controller;

import by.kupreychik.qc.coffee.service.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RandomWordController {

    @Autowired
    private WordsService wordsService;

    @GetMapping("/randomWord")
    public ModelAndView getRandom() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("random", wordsService.getRandomWord());
        return modelAndView;
    }
}
