package com.cy.example.model;

import lombok.Data;

@Data
public class Page {
	
	private int page=1;
	
	private int rows=10;
	
	private int index=0;
}
