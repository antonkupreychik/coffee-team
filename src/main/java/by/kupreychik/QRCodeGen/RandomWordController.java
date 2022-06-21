package by.kupreychik.QRCodeGen;

import by.kupreychik.QRCodeGen.words.Words;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RandomWordController {

    @Autowired
    private Words words;

    @GetMapping("/randomWord")
    public ModelAndView getRandom() {
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("random", words.getRandomWord());
        return modelAndView;
    }
}
