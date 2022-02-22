package com.schulzmarcos.api.resources;

import com.schulzmarcos.domain.models.Person;
import com.schulzmarcos.domain.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @RequestMapping(method=RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @RequestMapping(method=RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @RequestMapping(value="/{id}",
            method=RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
