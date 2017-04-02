package com.jcalvopinam.service;

import com.jcalvopinam.model.Person;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;

/**
 * @author juanca <juan.calvopina+dev@gmail.com>
 */
@Service
public class PersonServiceImpl implements PersonService {

    private String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Person add(String name) {
        Person person = new Person();
        person.setName(name);
        return person;
    }

    @Override
    public int numberPersons(List<Person> persons) throws EmptyStackException {
        if (persons.size() < 5) {
            throw new EmptyStackException();
        }
        return persons.size();
    }

}
