package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Person;
import com.example.demo.Repo.PersonRepository;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllUsers() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}