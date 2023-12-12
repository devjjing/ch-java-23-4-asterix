package com.example.character;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private AsterixRepo repo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext
    void shouldReturnAsterixAndObelix_whenTheyAreStoredInDb() throws Exception {

        // given
        repo.save(new Character("1", "Asterix", "klein"));
        repo.save(new Character("2", "Idefix", "dick"));

        // when
        mockMvc.perform(MockMvcRequestBuilders.get("/api/characters"))

                // then
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().json("""
                                                [
                                                    {
                                                        "id": "1",
                                                        "name": "Asterix",
                                                        "description": "klein"
                                                    },
                                                    {
                                                        "id": "2",
                                                        "name": "Idefix",
                                                        "description": "dick"
                                                    }
                                                ]
                        """));


    }

    @Test
    @DirtiesContext
    void whenUsingPut_thenAddElement() throws Exception {

        // given

        // when
        mockMvc.perform(MockMvcRequestBuilders.put("/api/characters/42").content("""
                        {
                            "name": "Majestix",
                            "description": "Chef"
                        }
                        """).contentType(MediaType.APPLICATION_JSON))

                // then
                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().json("""
                                        {
                                            "id": "42",
                                            "name": "Majestix",
                                            "description": "Chef"
                                        }
                        """));

        List<Character> actual = repo.findAll();
        List<Character> expected = List.of(new Character("42", "Majestix", "Chef"));
        assertEquals(expected, actual);


    }

}