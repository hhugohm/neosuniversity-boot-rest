package com.neos.university.neosuniversitybootrest;


import com.neos.university.neosuniversitybootrest.domain.Information;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageRestServiceTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void testGreetingsWithOutname() throws Exception {
        ResponseEntity<Information> entity = template.getForEntity("/api/greetings",Information.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON_UTF8,entity.getHeaders().getContentType());
        Information response = entity.getBody();
        assertEquals("Hola Desconocido bienvenido a Spring Boot 2.x- RestService",response.getMessage());
    }

    @Test
    public void testGreetingsWithName() throws Exception {
        Information response = template.getForObject("/api/greetings?name=HUGO", Information.class);
        assertEquals("Hola HUGO bienvenido a Spring Boot 2.x- RestService",response.getMessage());
    }

}
