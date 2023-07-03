package com.miko.assemblyinterpretor.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class AssemblyLanguage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long queryId;
	private String query;
	private String queryResult;
	private String finalResult;
	
	
	
	
	public AssemblyLanguage() {
		super();
	}


	public AssemblyLanguage(long queryId, String query, String queryResult, String finalResult) {
		super();
		this.queryId = queryId;
		this.query = query;
		this.queryResult = queryResult;
		this.finalResult = finalResult;
	}
	
	
	public long getQueryId() {
		return queryId;
	}
	public void setQueryId(long queryId) {
		this.queryId = queryId;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getQueryResult() {
		return queryResult;
	}
	public void setQueryResult(String queryResult) {
		this.queryResult = queryResult;
	}
	public String getFinalResult() {
		return finalResult;
	}
	public void setFinalResult(String finalResult) {
		this.finalResult = finalResult;
	}


	@Override
	public String toString() {
		return "AssemblyLanguage [queryId=" + queryId + ", query=" + query + ", queryResult=" + queryResult
				+ ", finalResult=" + finalResult + "]";
	}
	
	
	

}
