package com.example.character;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
@RequiredArgsConstructor

public class AsterixController {
    private final CharacterService service;

    @GetMapping
    List<Character> findAll() {
        return service.findAll();
    }
}
