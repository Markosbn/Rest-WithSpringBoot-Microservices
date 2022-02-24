package com.schulzmarcos.bookservice.api.resources;

import com.schulzmarcos.bookservice.api.proxy.CambioProxy;
import com.schulzmarcos.bookservice.api.response.Cambio;
import com.schulzmarcos.bookservice.domain.models.Book;
import com.schulzmarcos.bookservice.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookResource {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @GetMapping(value = "/{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency){
        var book = repository.getById(id);
        if (book == null){
            throw new RuntimeException("Book not found");
        }

        //instancia o cambio usando a chamada do proxy. Que por sua vez recebe os dados desta endpoint
        var cambio = proxy.getCambio(book.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment("Book port: "+ port +" Cambio port " + cambio.getEnvironment());
        book.setPrice(cambio.getConvertedValue());
        return book;
    }
}
