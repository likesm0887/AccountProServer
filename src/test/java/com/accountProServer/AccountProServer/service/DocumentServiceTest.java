package com.accountProServer.AccountProServer.service;

import com.accountProServer.AccountProServer.adapter.InputModel;
import com.accountProServer.AccountProServer.repository.DocumentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class DocumentServiceTest {

    @Test
    public void when_give_signal_attribute_to_ModifyDocumentService_then_the_value_should_be_modify() {
        String path = "./src/test/java/com/accountProServer/AccountProServer/testData/SSM_FS-MPERS_128879-A_20180331_test_data.xml";
        DocumentRepository documentRepository = new DocumentRepository(path);
        DocumentService service = new DocumentService(documentRepository);
        String modifyValue = String.valueOf(new Date().getTime());
        InputModel inputModel = new InputModel("ssmt-dei:CompanyRegistrationNumber", modifyValue);
        service.modify(inputModel);
        assertXmlPath(path, "//" + "ssmt-dei:CompanyRegistrationNumber", modifyValue);

    }
    @Test
    public void test(){
        create();
    }

    private void assertXmlPath(String path, String xpath, String expectedValue) {
        DocumentRepository documentRepository = new DocumentRepository(path);
        DocumentService service = new DocumentService(documentRepository);
        String assertValue = service.select(xpath).getStringValue();
        Assert.assertEquals(expectedValue, assertValue);
    }

    private void create() {
        ObjectMapper objectMapper = new ObjectMapper();
        String modifyValue = String.valueOf(new Date().getTime());
        String json = "";
        InputModel inputModel = new InputModel("ssmt-dei:CompanyRegistrationNumber", modifyValue);
        try {
            json = objectMapper.writeValueAsString(inputModel);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.print(json);
    }
}