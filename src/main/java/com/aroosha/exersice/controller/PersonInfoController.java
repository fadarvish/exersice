package com.aroosha.exersice.controller;

import com.aroosha.exersice.model.entity.PersonInfo;
import com.aroosha.exersice.model.repository.PersonInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/personInfo")
public class PersonInfoController {
    @Autowired
    private PersonInfoRepository personInfoRepository;
    @PostMapping("/insert")
    public @ResponseBody String insert(@RequestParam int personId,@RequestParam int documentId)
    {
        PersonInfo personInfo=new PersonInfo()
                .setPersonId(personId)
                .setDocumentId(documentId);
        personInfoRepository.save(personInfo);
        return "succeeded";
    }

    @GetMapping("/selectAll")
    public @ResponseBody Iterable<PersonInfo> selectAll(){
        return personInfoRepository.findAll();
    }
}
