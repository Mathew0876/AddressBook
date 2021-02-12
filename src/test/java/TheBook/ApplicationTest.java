package TheBook;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }

    @Test
    public void createAddressBook() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/addressBooks/")
                .content("{ \"name\" : \"book2\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void deleteAddressBook() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/addressBooks/")
                .content("{ \"name\" : \"book2\"}"))
                .andExpect(status().isCreated());

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/addressBooks/4")
                .content(""))
                .andExpect(status().isNoContent());

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/addressBooks/4"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void addAndDeleteBuddy() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/addressBooks/")
                .content("{ \"name\" : \"book2\"}"))
                .andExpect(status().isCreated());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .post("/addressBooks/5/addBuddyInfo")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content("{\"name\": \"ggggggggggggg\",\"address\": \"fffff\",\"phoneNumber\": \"111111\"}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("ggggggggggggg"));

        result = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/addressBooks/5/6"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertFalse(result.getResponse().getContentAsString().contains("ggggggggggggg"));
    }

}
