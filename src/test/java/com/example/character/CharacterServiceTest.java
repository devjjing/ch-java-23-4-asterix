package com.example.asterixapp;

import com.example.character.AsterixRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


class CharacterServiceTest {

    @Test
    void findAll() {
        AsterixRepo repo = Mockito.mock(AsterixRepo.class);
        Mockito.when(repo.findAll()).thenReturn(
                List.of(
                        new Character("1", "Asterix", "klein"),
                        new Character("2", "Obelix", "dick")
                )
        );

        CharacterService service = new CharacterService(repo);

        List<Character> actual = service.findAll();

        List<Character> expected = List.of(
                new Character("1", "Asterix", "klein"),
                new Character("2", "Obelix", "dick")
        ) ;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void expect2_ifAsterixAndIdefixArePresent() {
        AsterixRepo exampleTown = Mockito.mock(AsterixRepo.class);
        Mockito.when(exampleTown.findAll()).thenReturn(List.of(
                new Character("1", "Asterix", "klein"),
                new Character("2", "Idefix", "klein")
        ));

        CharacterService underTest = new CharacterService(exampleTown);

        int actual = underTest.getNumberOfSmallCharacters();

        Assertions.assertEquals(2, actual);
        Mockito.verify(exampleTown).findAll();
    }
}