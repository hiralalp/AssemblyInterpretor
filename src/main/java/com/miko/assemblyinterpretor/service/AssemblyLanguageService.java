package com.miko.assemblyinterpretor.service;

import java.util.List;

import com.miko.assemblyinterpretor.entity.AssemblyLanguage;

public interface AssemblyLanguageService {

	public String processQuery(String assemblyLanguage);

	public List<AssemblyLanguage> finAll();
	
	

}
