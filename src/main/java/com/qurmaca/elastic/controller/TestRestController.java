package com.qurmaca.elastic.controller;

import com.qurmaca.elastic.entity.Test;
import com.qurmaca.elastic.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestRestController {

    private final TestRepository testRepository;

    @PostConstruct
    public void createTest()
    {
        Test test= new Test();
        test.setId("1");
        test.setName("ilham");
        test.setSurname("ahmadzada");
        testRepository.save(test);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById (@PathVariable String id)
    {
        return ResponseEntity.ok(testRepository.findByCustomQuery(id));
    }

}
