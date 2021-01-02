package com.accountProServer.AccountProServer.service;

import com.accountProServer.AccountProServer.adapter.InputModel;
import com.accountProServer.AccountProServer.repository.DocumentRepository;
import org.dom4j.Element;


public class DocumentService {
    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }


    public void modify(InputModel inputModel) {
        if (inputModel.getAttributes().isEmpty())
            documentRepository.modifyElement(inputModel.getTagName(), inputModel.getValue());
        else
            inputModel.getAttributes()
                    .forEach(attribute -> documentRepository.modifyElement(
                            inputModel.getTagName(),
                            attribute.getName(),
                            attribute.getData())
                    );
        documentRepository.save();
    }

    public Element select(String xpath) {
        return documentRepository.select(xpath);
    }
}
