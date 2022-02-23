package com.schulzmarcos.bookservice.api.resources;

import com.schulzmarcos.bookservice.api.response.Cambio;
import com.schulzmarcos.bookservice.domain.models.Book;
import com.schulzmarcos.bookservice.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("book-service")
public class BookResource {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency){
        var book = repository.getById(id);

        if (book == null){
            throw new RuntimeException("Book not found");
        }

        HashMap<String, String> params = new HashMap<>();
        params.put("amount", book.getPrice().toString());
        params.put("from", "USD");
        params.put("to", currency);

        var cambio = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
                Cambio.class, params);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment(port);
        book.setPrice(cambio.getBody().getConvertedValue());
        return book;
    }
}
