package com.jcalvopinam.service;


import com.jcalvopinam.model.Person;

import java.util.EmptyStackException;
import java.util.List;

/**
 * @author juanca <juan.calvopina+dev@gmail.com>
 */
public interface PersonService {

    String getName();

    void setName(String name);

    Person add(String name);

    int numberPersons(List<Person> persons) throws EmptyStackException;

}
