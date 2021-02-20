package rpajdak.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import rpajdak.demo.model.Note;
import rpajdak.demo.service.NotesService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {rpajdak.demo.AppTestConfig.class})
@WebAppConfiguration
public class NotesControllerIntegrationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private NotesService notesService;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

    }

    @Test
    public void should_return_note_by_id() throws Exception {
        long id = 1;
        when(notesService.getNoteById(id))
                .thenReturn(Note.builder()
                        .title("note #1 title")
                        .content("note #1 content")
                        .build());

        mockMvc.perform(get("/notes/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("note #1 title"));

    }

    @Test
    public void should_return_created_status_code_when_note_added() throws Exception {
        Note note = Note.builder()
                .title("note #1 title")
                .content("note #1 content")
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(note)))
                .andExpect(status().isCreated());

    }

    @Test
    public void should_return_no_content_code_when_user_removed() throws Exception {

        Note note = new Note();
        note.setId(1L);

        mockMvc.perform(delete("/notes/{id}", 1))
                .andExpect(status().isNoContent());

        verify(notesService, times(1)).deleteNote(any(Long.class));

    }

}
