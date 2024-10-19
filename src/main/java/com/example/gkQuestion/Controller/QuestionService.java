package com.example.gkQuestion.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.gkQuestion.Exception.QuestionNotFoundException;

@RestController
public class QuestionService {

    private QuestionResource resource;

    public QuestionService(QuestionResource resource) {
        this.resource = resource;
    }

    @GetMapping("/questions")
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
}
