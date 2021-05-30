package com.accountProServer.AccountProServer.adapter.controller;

import com.accountProServer.AccountProServer.adapter.ResponseModel;
import com.accountProServer.AccountProServer.adapter.ResponseModelImp;
import com.accountProServer.AccountProServer.domain.company.Company;
import com.accountProServer.AccountProServer.domain.company.CompanyRepository;
import com.accountProServer.AccountProServer.domain.company.enums.CompanyOriginEnum;
import com.accountProServer.AccountProServer.domain.company.enums.CompanyStatusEnum;
import com.accountProServer.AccountProServer.domain.company.enums.CompanyTypeEnum;
import com.accountProServer.AccountProServer.infrastructure.utitly.EnumParser;
import com.accountProServer.AccountProServer.service.CompanyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {
    private List<Company> tempDb = new ArrayList<>();
    private String path;
    @Autowired
    private CompanyRepository documentRepository;
    @Autowired
    private CompanyService companyService ;

//    @PostMapping("/company")
//    public ResponseEntity<String> createCompany(@RequestBody String inputJson) throws IOException {
//        CompanyRequestModel companyRequestModel = new ObjectMapper().readValue(inputJson, CompanyRequestModel.class);
//        ResponseModel responseModel = new ResponseModelImp();
//        try {
//            Company company = new Company(companyRequestModel.registerNumber,
//                    companyRequestModel.secretaryFirmRegisterNumberId,
//                    companyRequestModel.contactPersonId,
//                    companyRequestModel.formerlyKnownAs,
//                    companyRequestModel.name,
//                    companyRequestModel.oldRegisterNo,
//                    new EnumParser<CompanyOriginEnum>().parse(CompanyOriginEnum.class, companyRequestModel.companyOrigin),
//                    new EnumParser<CompanyStatusEnum>().parse(CompanyStatusEnum.class, companyRequestModel.companyStatus),
//                    new EnumParser<CompanyTypeEnum>().parse(CompanyTypeEnum.class, companyRequestModel.companyStatus),
//                    "123123");
//            tempDb.add(company);
//            responseModel.setIsSucceed(true);
//        } catch (Exception e) {
//            new ResponseEntity<>("Fail", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//        return new ResponseEntity<>("Success", HttpStatus.CREATED);
//    }
//
//    @GetMapping("/company/{registerNumber}")
//    public String getCompany(@PathVariable("registerNumber") String registerNumber) throws JsonProcessingException {
//        ResponseModel result = this.tempDb.stream().filter(company -> company.getRegisterNumber().equals(registerNumber))
//                .findFirst()
//                .map(this::createSuccessResponse)
//                .orElseGet(this::createFailResponse);
//        return new ObjectMapper().writeValueAsString(result);
//    }
//
//    private ResponseModel createFailResponse() {
//        ResponseModel responseModel = new ResponseModelImp();
//        responseModel.setIsSucceed(false);
//        responseModel.setErrorMessage("not found");
//        responseModel.setErrorCode("400");
//        return responseModel;
//    }
//
//    private ResponseModel createSuccessResponse(Company company) {
//        ResponseModel responseModel = new ResponseModelImp();
//        responseModel.setIsSucceed(true);
//        responseModel.setResponseData(new CompanyResponseModel(company));
//        return responseModel;
//    }
//
//    @RequestMapping("/greet")
//    private String greet() {
//        return "gret";
//    }
}
