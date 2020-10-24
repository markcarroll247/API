package com.example.demo.service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//business logic needed for the business would be in this part of the code.


@Service  // this is an annotate
public class PersonService {

    private final PersonDao personDao;

    @Autowired // autowired into the interface. Dependency inejction
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) { // injecting into the constructor here. the text in the quotes says whcich DB i am using. I could say Mongo to change it to a Mongo DB
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id, newPerson);
    }

}
