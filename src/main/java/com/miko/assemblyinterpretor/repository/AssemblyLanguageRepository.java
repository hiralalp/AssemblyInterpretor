package com.miko.assemblyinterpretor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miko.assemblyinterpretor.entity.AssemblyLanguage;

@Repository
public interface AssemblyLanguageRepository extends JpaRepository<AssemblyLanguage, Long>{

}
