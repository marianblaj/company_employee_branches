package com.example.company_employee.company_employee.controller;

import com.example.company_employee.company_employee.service.Company;
import com.example.company_employee.company_employee.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/company")
public class CompanyController {
    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public List<CompanyDto> getAllCompany(){
        return companyService
                .getAllCompanies()
                .stream()
                .map(Company::toDto)
                .collect(Collectors.toList());
    }
    @PostMapping("/")
    public String addCompany(@RequestBody Company company){
        companyService.addCompany(company);
        return "Added company name " + company.getName();
    }

}
