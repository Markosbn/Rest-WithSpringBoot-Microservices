package com.schulzmarcos.api.resources;

import com.schulzmarcos.domain.models.Person;
import com.schulzmarcos.domain.services.ConverterService;
import com.schulzmarcos.domain.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService service;

    @GetMapping
    public List<Person> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") String id){
        return service.findById(id);
    }
}
