package com.jcalvopinam.service;

import org.springframework.stereotype.Service;

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

}
