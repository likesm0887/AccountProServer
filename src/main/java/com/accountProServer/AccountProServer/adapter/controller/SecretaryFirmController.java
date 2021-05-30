package com.accountProServer.AccountProServer.adapter.controller;

import com.accountProServer.AccountProServer.adapter.responseModel.SecretaryFirmResponseModel;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SecretaryFirmController {
//    private List<SecretaryFirm> tempDb = new ArrayList<>();
//
//    @PostMapping("/secretaryFirm")
//    public ResponseEntity<String> createSecretaryFirm(@RequestBody String inputJson) throws IOException {
//        SecretaryFirmRequestModel secretaryFirmRequestModel = new ObjectMapper().readValue(inputJson, SecretaryFirmRequestModel.class);
//        ResponseModel responseModel = new ResponseModelImp();
//        SecretaryFirm secretaryFirm = new SecretaryFirm(secretaryFirmRequestModel.firmRegisterNumber,
//                secretaryFirmRequestModel.name,
//                secretaryFirmRequestModel.email,
//                secretaryFirmRequestModel.telephone,
//                secretaryFirmRequestModel.address);
//        try {
//            tempDb.add(secretaryFirm);
//            responseModel.setIsSucceed(true);
//        } catch (Exception e) {
//            new ResponseEntity<>("Fail", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>("Success", HttpStatus.CREATED);
//    }
//
//    @GetMapping("/secretaryFirm/getAll")
//    public String getAllSecretaryFirm() throws JsonProcessingException {
//        ResponseModel responseModel = new ResponseModelImp();
//        responseModel.setIsSucceed(true);
//        responseModel.setResponseData(this.tempDb.stream()
//                .map(this::createSecretaryFirmResponse)
//                .collect(toList()));
//        return new ObjectMapper().writeValueAsString(responseModel);
//    }

//    private SecretaryFirmResponseModel createSecretaryFirmResponse(SecretaryFirm secretaryFirm) {
//        SecretaryFirmResponseModel secretaryFirmResponseModel = new SecretaryFirmResponseModel();
//        secretaryFirmResponseModel.address = secretaryFirm.getAddress();
//        secretaryFirmResponseModel.email = secretaryFirm.getEmail();
//        secretaryFirmResponseModel.firmRegisterNumber = secretaryFirm.getFirmRegisterNumber();
//        secretaryFirmResponseModel.name = secretaryFirm.getName();
//        secretaryFirmResponseModel.telephone = secretaryFirm.getTelephone();
//        return secretaryFirmResponseModel;
//    }
}
