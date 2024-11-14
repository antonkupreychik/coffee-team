package by.kupreychik.qc.coffee.controller;

import by.kupreychik.qc.coffee.service.WordsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "words-rest", description = "rest Words controller")
@RequiredArgsConstructor
@RequestMapping("/api/random")
public class RandomWordRestController {

    private final WordsService wordsService;

    @GetMapping
    @Operation(
            summary = "Get words",
            description = "Get words"
    )
    public ResponseEntity<List<String>> getAllWords() {
        return ResponseEntity.ok(wordsService.getWords());
    }

    @PostMapping
    @Operation(
            summary = "Add word to my new list",
            description = "Add word to my list"
    )
    public ResponseEntity<String> addNewWord(String word) {
        wordsService.addWord(word);
        return ResponseEntity.ok().build();
    }
}
