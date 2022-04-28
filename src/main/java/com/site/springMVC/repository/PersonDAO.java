package com.site.springMVC.repository;

import com.site.springMVC.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> personList;

    {
        personList=new ArrayList<>();
        personList.add(new Person(1,"Paata"));
        personList.add(new Person(2,"Vera"));

    }

    public List<Person> index(){
        return personList;
    }

    public Person show(int id){
        return personList.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void save(Person person){
        personList.add(person);
    }
    public void update(int id,Person updatePerson){
        Person personToBeUpdated=show(id);
        personToBeUpdated.setName(updatePerson.getName());

    }

    public void delete(int id){
        personList.removeIf(p->p.getId()==id);
    }


}
