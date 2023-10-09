package no.falldal.springboottask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PartsControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testConnectionOk() throws Exception {
        mockMvc.perform(get("/api/parts"))
                .andExpect(status().isOk());
    }

    @Test
    void testWelcomeMessage() throws Exception {
        mockMvc.perform(get("/api"))
                .andExpect(content().string("Welcome to my API page :)"));
    }
}