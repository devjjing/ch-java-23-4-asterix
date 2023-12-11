package com.example.character;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    private final AsterixRepo asterixRepo;

    public CharacterService(AsterixRepo asterixRepo) {
        this.asterixRepo = asterixRepo;
    }

    public List<Character> findAll() {
        return asterixRepo.findAll();
    }
    public int getNumberOfSmallCharacters() {
        List<Character> allCharacters = asterixRepo.findAll();

        int numberOfSmallCharacters = 0;
        for (Character character : allCharacters) {
            if (character.description().contains("klein")) {
                numberOfSmallCharacters = numberOfSmallCharacters + 1;
            }
        }
        return numberOfSmallCharacters;
    }
}