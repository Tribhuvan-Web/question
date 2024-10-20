package com.example.gkQuestion.Controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.gkQuestion.Exception.QuestionNotFoundException;

@RestController
public class QuestionService {

    private QuestionResource resource;

    public QuestionService(QuestionResource resource) {
        this.resource = resource;
    }

    @GetMapping("/question")
    public List<Question> retrieveAllQuestion() {
        return resource.findAll();
    }

    @GetMapping("/question/{id}")
    public Question retrieveOneQuestion(@PathVariable int id) {
        Question question = resource.findOne(id);
        if (question == null) {
            throw new QuestionNotFoundException(
                    "Question Not found with the specific id " + id + " Please try another one ");
        }

        return question;
    }

    @DeleteMapping("/question/{id}")
    public void deleteAQuestino(@PathVariable int id) {
        resource.deleteById(id);
    }

    @PostMapping("/question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) {
        Question saveQuestion = resource.savQuestion(question);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveQuestion.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
