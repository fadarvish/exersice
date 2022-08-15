package com.aroosha.exersice.controller;

import com.aroosha.exersice.model.entity.Document;
import com.aroosha.exersice.model.entity.Person;
import com.aroosha.exersice.model.entity.PersonInfo;
import com.aroosha.exersice.model.repository.DocumentRepository;
import com.aroosha.exersice.model.repository.PersonInfoRepository;
import com.aroosha.exersice.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/document")
public class DocumentController {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonInfoRepository personInfoRepository;
    @PostMapping("/insert")
    public @ResponseBody String insert(@RequestParam String name,@RequestParam String content){
        List<Person> personList;
        Document document;
        PersonInfo personInfo;
        int personId,listSize;

        personList=(List<Person>)personRepository.findAll();
        listSize=personList.size();

        switch (listSize){
            case 0:
                return "no person to connect to this document";
            case  1:
                personId=personList.get(0).getId();
                break;
            default:
                personId=personList.get(new Random().nextInt(listSize-1)).getId();
        }
        document=new Document()
                .setName(name)
                .setContent(content);
        documentRepository.save(document);
        personInfo=new PersonInfo().setPersonId(personId).setDocumentId(document.getId());
        personInfoRepository.save(personInfo);
        return "succeeded";
    }

    @GetMapping("/selectAll")
    public @ResponseBody Iterable<Document> selectAll(){
        return documentRepository.findAll();
    }
    @GetMapping("/selectById")
    public @ResponseBody Document selectById(@RequestParam int id){
        return documentRepository.findById(id).get();
    }
    @PutMapping("update")
    public @ResponseBody String updateById(@RequestParam int id,@RequestParam String name,@RequestParam String content){
        Document document =documentRepository.findById(id).get();
        document.setName(name).setContent(content);
        documentRepository.save(document);
        return "succeeded";
    }
}
