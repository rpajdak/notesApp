package rpajdak.demo;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import rpajdak.demo.controller.NotesController;
import rpajdak.demo.service.NotesService;

@EnableWebMvc
@Configuration
public class AppTestConfig {


    @Bean
    public NotesService notesService() {
        return Mockito.mock(NotesService.class);
    }

    @Bean
    public NotesController notesController() {
        return new NotesController(notesService());
    }


}
