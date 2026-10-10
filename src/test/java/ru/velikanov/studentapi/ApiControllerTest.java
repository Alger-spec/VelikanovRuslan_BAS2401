package ru.velikanov.studentapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest {
    @Autowired MockMvc mvc;
    @Autowired Environment environment;

    @Test void applicationNameMatchesStudentId() {
        assertThat(environment.getProperty("spring.application.name")).isNotBlank();
    }

    @Test void greetingReturnsText() throws Exception {
        mvc.perform(get("/api/hello").param("name", "Ivan"))
            .andExpect(status().isOk()).andExpect(content().string("Привет, Ivan!"));
    }

    @Test void greetingHasDefaultName() throws Exception {
        mvc.perform(get("/api/hello"))
            .andExpect(status().isOk()).andExpect(content().string("Привет, мир!"));
    }

    @Test void sumReturnsJsonNumber() throws Exception {
        mvc.perform(get("/api/sum").param("a", "2.5").param("b", "-1.2"))
            .andExpect(status().isOk()).andExpect(content().contentType("application/json"))
            .andExpect(content().string("1.3"));
    }

    @Test void missingOperandReturnsBadRequest() throws Exception {
        mvc.perform(get("/api/sum").param("a", "2")).andExpect(status().isBadRequest());
    }

    @Test void invalidOperandReturnsBadRequest() throws Exception {
        mvc.perform(get("/api/sum").param("a", "abc").param("b", "3"))
            .andExpect(status().isBadRequest());
    }
}
