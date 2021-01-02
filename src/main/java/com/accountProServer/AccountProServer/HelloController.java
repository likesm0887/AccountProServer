package com.accountProServer.AccountProServer;

import com.accountProServer.AccountProServer.adapter.InputModel;
import com.accountProServer.AccountProServer.repository.DocumentRepository;
import com.accountProServer.AccountProServer.service.DocumentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {
    private String path;
    private DocumentRepository documentRepository = new DocumentRepository("./template/SSM_FS-MPERS_128 879-A_20180331.xml");
    private DocumentService documentService = new DocumentService(documentRepository);

    @PostMapping("/InputModel")

    public  String addElement(@RequestBody String inputModel) {
        InputModel user2=null;
        try {
             user2 = new ObjectMapper().readValue(inputModel, InputModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        documentService.modify(user2);
        return "add" + user2.getTagName();

    }

    @PostMapping("/InputModels")
    public String addElement(List<InputModel> inputModel) {
        inputModel.forEach(input -> documentService.modify(input));
        return "add" + inputModel.get(0).getTagName();
    }

    @RequestMapping("/greet")
    private String greet() {
        return "gret";
    }
}
