# Spring Boot 2.x

----------------------------------
Pasos para instalación de SPRING BOOT REST
----------------------------------

1.- Crear un proyecto mediante Initialzr
https://start.spring.io/

2.- Java Project
* Maven Project
* Group: com.neos.university
* Artifact: neosuniversity-boot-rest
* Dependenies: Web, Lombok

3.- Generar el proyecto

4.- Importar el proyecto mediante IntelliJ-->Opcion Import maven Projects Automatically


5.- Crear un paquete  controllers

6.- Crear un controlador MessageRestService
```ruby
import com.neos.university.neosuniversitybootrest.domain.Information;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageRestService {

    @GetMapping("/greetings")
    public Information processMessage(
            @RequestParam(defaultValue = "Desconocido", required = false)String name){

        return new Information("Hola "+name + " bienvenido a Spring Boot 2.x- RestService");
    }

}
```
7.- Ejecutar el siguiete comando
```ruby
$ curl http://localhost:8080/api/greetings?name=hugo
{"message":"Hola hugo bienvenido a Spring Boot 2.x- RestService
```
8.- Crear una clase Test MessageRestServiceTest
```ruby
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
```
9.- Ejecutar pruebas unitarias
