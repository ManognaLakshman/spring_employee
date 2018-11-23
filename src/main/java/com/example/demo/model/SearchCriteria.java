package com.example.demo.model;

public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
    
//    String orPredicate;
//    this.orPredicate 
//    = orPredicate != null
//    && orPredicate.equals(SearchOperation.OR_PREDICATE_FLAG);
    
	public SearchCriteria(String key2, String operation2, Object value2) {
		// TODO Auto-generated constructor stub
		this.key=key2;
		this.operation=operation2;
		this.value=value2;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public boolean isOrPredicate() {
		//false will and. true will or. see what is operator and then implement
		// TODO Auto-generated method stub
		return true;
	}
}
