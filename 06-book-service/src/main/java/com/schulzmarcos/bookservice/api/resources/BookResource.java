package com.schulzmarcos.bookservice.api.resources;

import com.schulzmarcos.bookservice.api.proxy.CambioProxy;
import com.schulzmarcos.bookservice.api.response.Cambio;
import com.schulzmarcos.bookservice.domain.models.Book;
import com.schulzmarcos.bookservice.domain.repositories.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book endpoint")//define o nome na documentação
@RestController
@RequestMapping("book-service")
public class BookResource {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository repository;

    @Autowired
    private CambioProxy proxy;

    @Operation(summary = "Find a specific book by your ID")//define o que a endpoint em questão faz nesta classe
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
