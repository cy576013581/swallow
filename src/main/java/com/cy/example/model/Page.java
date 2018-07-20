package com.cy.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Page {
	
	private int page=1;

	private int rows=10;
	
	private int index=0;

	public Page(int page, int rows) {
		this.page = page;
		this.rows = rows;
	}
}
