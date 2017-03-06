package com.jcalvopinam.controller;

import com.jcalvopinam.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author juanca <juan.calvopina+dev@gmail.com>
 */
@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String hello() {
        personService.setName("Juanca");
        return String.format("Hello, {}", personService.getName());
    }

}
