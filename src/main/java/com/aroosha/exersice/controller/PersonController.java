package com.aroosha.exersice.controller;

import com.aroosha.exersice.model.entity.Document;
import com.aroosha.exersice.model.entity.Person;
import com.aroosha.exersice.model.repository.DocumentRepository;
import com.aroosha.exersice.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @PostMapping("/insert")
    public @ResponseBody String insert(@RequestParam String name){
        Person person=new Person();
        person.setName(name);
        personRepository.save(person);
        return "succeeded";
    }

    @GetMapping("/selectAll")
    public @ResponseBody Iterable<Person> selectAll(){
        return personRepository.findAll();
    }

    @GetMapping("/selectById")
    public @ResponseBody Person selectById(@RequestParam int id){
        return personRepository.findById(id).get();
    }

    @PutMapping("update")
    public @ResponseBody String updateById(@RequestParam int id,@RequestParam String name){
        Person person=personRepository.findById(id).get();
        person.setName(name);
        personRepository.save(person);
        return "succeeded";
    }
}
