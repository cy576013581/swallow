package com.cy.example.carrier;

public class PageCa {
	
	private int page=1;
	
	private int rows=10;
	
	private int index=0;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getIndex() {
		return (page-1)*rows;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "PageVo [page=" + page + ", rows=" + rows + ", index=" + index
				+ "]";
	}
	
}
