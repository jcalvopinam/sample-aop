package com.jcalvopinam.aspect;

import com.jcalvopinam.model.Person;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.EmptyStackException;

/**
 * @author juanca <juan.calvopina+dev@gmail.com>
 */
@Aspect
@Component
public class PersonMonitor {

    @Before("getNamePointcut()")
    public void firstAdvice() {
        System.out.println("Executing firstAdvice on getName() method");
    }

    @Before("getNamePointcut()")
    public void secondAdvice() {
        System.out.println("Executing secondAdvice on getName() method");
    }

    @Pointcut("execution(public String getName())")
    public void getNamePointcut() {
    }

    @Before("execution(* com.jcalvopinam.service.PersonService.setName (java.lang.String)) && args(name)")
    public void beforeSetName(String name) {
        System.out.println(String.format("Executing before to set the name: %s", name));
    }

    @Around("execution(* com.jcalvopinam.service.PersonService.add (java.lang.String)) && args(name)")
    public Object aroundAddingPerson(ProceedingJoinPoint proceedingJoinPoint, String name) throws Throwable {
        name = name + "!";
        Person person = (Person) proceedingJoinPoint.proceed(new Object[]{name});
        person.setName(person.getName().toUpperCase());
        System.out.println(String.format("Executing aroundAddingPerson for modify the attribute from: %s to: %s)",
                name, person.getName()));
        return person;
    }

    @AfterReturning(pointcut = "execution(* getName())", returning = "returnString")
    public void getNameReturningAdvice(String returnString) {
        System.out.println(String.format("Executing getNameReturningAdvice. Returned String: %s ", returnString));
    }

    @AfterThrowing("execution(* com.jcalvopinam.service.PersonService.*(..))")
    public void logExceptions(JoinPoint joinPoint) throws EmptyStackException {
        System.out.println(String.format("Exception thrown in Person method: %s", joinPoint.toString()));
    }

}
