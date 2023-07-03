package com.miko.assemblyinterpretor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miko.assemblyinterpretor.entity.AssemblyLanguage;
import com.miko.assemblyinterpretor.logic.AssemblyInterpreter;
import com.miko.assemblyinterpretor.repository.AssemblyLanguageRepository;

@Service
public class AssemblyLanguageServiceImpl implements AssemblyLanguageService{
	
	@Autowired
	private AssemblyLanguageRepository assemblyLanguageRepository;
	
	@Autowired
	AssemblyInterpreter assemblyInterpreter;
	
	

	@Override
	public String processQuery(String requestBody) {
		// TODO Auto-generated method stub
		
		try {
			
			int res=assemblyInterpreter.executeProgram(requestBody);
			AssemblyLanguage assemblyLanguage= new AssemblyLanguage();
			if(res>-1) 
				assemblyLanguage.setFinalResult("sucess");
			else
				assemblyLanguage.setFinalResult("failure");
			
			assemblyLanguage.setQueryResult(Integer.toString(res));
			assemblyLanguage.setQuery(requestBody);
			
			assemblyLanguageRepository.save(assemblyLanguage);
			
			return Integer.toString(res);
			
		}catch(Exception e){
			
			return "Some Error!!!";
		}
		
		
	}



	@Override
	public List<AssemblyLanguage> finAll() {
		// TODO Auto-generated method stub
		return assemblyLanguageRepository.findAll();
	}
	
	
}
