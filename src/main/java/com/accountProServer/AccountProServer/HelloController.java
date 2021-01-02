package com.accountProServer.AccountProServer;

import com.accountProServer.AccountProServer.adapter.InputModel;
import com.accountProServer.AccountProServer.repository.DocumentRepository;
import com.accountProServer.AccountProServer.service.DocumentService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {
    private String path;
    private DocumentRepository documentRepository = new DocumentRepository("./template/SSM_FS-MPERS_128 879-A_20180331.xml");
    private DocumentService documentService = new DocumentService(documentRepository);

    @PostMapping("/InputModel")
    private String addElement(InputModel inputModel) {
        documentService.modify(inputModel);
        return "add" + inputModel.getTagName();
    }

    @PostMapping("/InputModels")
    private String addElement(List<InputModel> inputModel) {
        inputModel.forEach(input -> documentService.modify(input));
        return "add" + inputModel.get(0).getTagName();
    }

    @RequestMapping("/greet")
    private String greet() {
        return "gret";
    }
}
