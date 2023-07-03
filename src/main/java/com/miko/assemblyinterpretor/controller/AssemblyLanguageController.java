package com.miko.assemblyinterpretor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miko.assemblyinterpretor.entity.AssemblyLanguage;
import com.miko.assemblyinterpretor.service.AssemblyLanguageService;



@RestController
@RequestMapping("/interpretor")
public class AssemblyLanguageController {
	
	@Autowired
	AssemblyLanguageService assemblyLanguageService;
	
	
	
	@PostMapping("/query")
    public String processQuery(@RequestBody String requestBody) {
        
		return assemblyLanguageService.processQuery(requestBody);
		
        
    }
	
	@GetMapping("/getallqueries")
	public List<AssemblyLanguage> getAllQueries() {
		
		return assemblyLanguageService.finAll();
	}
}
