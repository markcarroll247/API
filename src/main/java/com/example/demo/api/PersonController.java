package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;


@RequestMapping ("api/v1/person")  // this is the endpoint to send the json request on postman to
// controller class has methods that exposes end points that the client can consume
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) { // spring boots injects the service into the constructor.
        this.personService = personService;
    }

    //post request
    @PostMapping // this makes this a post request
    public void addPerson(@Valid @NotNull @RequestBody Person person){ //takes the request body in json postman request and put it inside person. The json object will be turned into a person
        personService.addPerson(person);
    }

    @GetMapping // this makes this a get request
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}") // id in the url path
    public Person getPersonById(@PathVariable("id") UUID id){  // path variable in the http request url in postman
        return personService.getPersonById(id)
                .orElse(null); // could put another expception in here
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id")UUID id, @Valid @NotNull @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }

}

