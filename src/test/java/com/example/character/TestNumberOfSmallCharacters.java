package com.example.character;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestNumberOfSmallCharacters {
    @Test

    void testNumberOfSmallCharacters_when2_thenReturn1() {

    //GIVEN
    int number = 2;
    AsterixRepo asterixRepoMock = Mockito.mock(AsterixRepo.class);
    CharacterService service = new CharacterService(asterixRepoMock);


    //WHEN
    int actual = service.numberOfSmallCharacters(number);

    //THEN
    assertEquals(1, actual);
}


}
