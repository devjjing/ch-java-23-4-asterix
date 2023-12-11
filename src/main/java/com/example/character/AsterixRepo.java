package com.example.character;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsterixRepo extends MongoRepository<Character, String> {
    // Datenbankabfragen und -operationen
}