package com.example.character;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNumberOfSmallCharacters {

    @Test
    void testNumberOfSmallCharacters_when2_thenReturn1() {
        // GIVEN
        AsterixRepo asterixRepoMock = Mockito.mock(AsterixRepo.class);

        List<Character> mockCharacters = Arrays.asList(
                new Character("Character","Peter", "Peter"),
                new Character("klein Character","Paul","Paul")
        );
        Mockito.when(asterixRepoMock.findAll()).thenReturn(mockCharacters);

        CharacterService service = new CharacterService(asterixRepoMock);

        // WHEN
        int actual = service.getNumberOfSmallCharacters();

        // THEN
        assertEquals(1, actual);
    }
}
