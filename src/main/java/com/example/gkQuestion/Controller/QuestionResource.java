package com.example.gkQuestion.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class QuestionResource {
        private static List<Question> list = new ArrayList<>();
        private static int count = 0;

        static {
                list.add(new Question(++count, "Who is the chief minister of bihar?", "Shree nitish kumar"));
                list.add(new Question(++count,
                                "Grand Central Terminal, Park Avenue, New York is the world's",
                                "largest railway station"));
                list.add(new Question(++count, "Who was the first woman to win a Nobel Prize?",
                                "Marie Curie, for Physics in 1903."));
                list.add(new Question(++count, "Who painted the Mona Lisa?", " Leonardo da Vinci."));
                list.add(new Question(++count, "Which country is known as the Land of the Rising Sun?", "Japan"));
                list.add(new Question(++count, "What is the chemical symbol for iron?", "Fe"));
                list.add(new Question(++count, "Who is known as the father of modern physics? ", "Albert Einstein."));
                list.add(new Question(++count, "What is the chemical symbol for the element gold?", "Au."));
                list.add(new Question(++count, "Who wrote the play “Romeo and Juliet”? ", " William Shakespeare."));
                list.add(new Question(++count, "What is the capital city of Australia? ", " Canberra."));
                list.add(new Question(++count, "Which planet is known as the Red Planet? ", "Mars."));
                list.add(new Question(++count, "What is the longest river in the United States?",
                                "The Missouri River."));
                list.add(new Question(++count, "What is the highest mountain peak in India?", "Kangchenjunga."));
                list.add(new Question(++count, "Which river is the longest in India?", "The Ganges River."));
                list.add(new Question(++count, "Which beach holds the title for being the longest in India?",
                                "Marina Beach in Chennai, Tamil Nadu."));
                list.add(new Question(++count, "What is the highest civilian award given in India?", "Bharat Ratna."));
                list.add(new Question(++count, "Which lake is the largest in terms",
                                "Wular Lake in Jammu and Kashmir."));
                list.add(new Question(++count, "What is the name of the highest waterfall in India?", //
                                "Jog Falls, located in Karnataka."));
                list.add(new Question(++count, "Which national park is the largest in India?",
                                "Hemis National Park in Ladakh."));
                list.add(new Question(++count, "Which mountain peak is the highest in the world?",
                                "Mount Everest located in the Himalayas."));
        }

        public List<Question> findAll() {
                return list;
        }

        public Question findOne(int id) {
                Predicate<? super Question> predicate = que -> que.getId().equals(id);
                return list.stream().filter(predicate).findFirst().orElse(null);
        }

        public void deleteById(int id) {
                Predicate<? super Question> predicate = que -> que.getId().equals(id);
                list.removeIf(predicate);
        }

        public Question savQuestion(Question question) {
                question.setId(++count);
                list.add(question);
                return question;
        }
}
