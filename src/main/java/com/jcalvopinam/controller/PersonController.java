package com.jcalvopinam.controller;

import com.jcalvopinam.model.Person;
import com.jcalvopinam.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @author juanca <juan.calvopina+dev@gmail.com>
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String add() {
        personService.setName("Juanca");
        Person person = personService.add(personService.getName());
        try {
            personService.numberPersons(Arrays.asList(person));
        } catch (EmptyStackException ese) {
            System.out.println("EmptyStackException: " + ese.getMessage());
        }
        return String.format("Welcome!, %s", person.getName());
    }

}
