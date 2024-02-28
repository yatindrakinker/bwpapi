package pojo;

import java.util.List;

public class GetRefineProductsPojoData {

	private int totalPageRead;
	private int current_count;
	private String next;
	private String prev;
	private List<GetRefineProductsPojoDataRows> rows;
	private List<GetRefineProductsPojoDataQuery> query;

	public int getTotalPageRead() {
		return totalPageRead;
	}

	public void setTotalPageRead(int totalPageRead) {
		this.totalPageRead = totalPageRead;
	}

	public int getCurrent_count() {
		return current_count;
	}

	public void setCurrent_count(int current_count) {
		this.current_count = current_count;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getPrev() {
		return prev;
	}

	public void setPrev(String prev) {
		this.prev = prev;
	}

	public List<GetRefineProductsPojoDataRows> getRows() {
		return rows;
	}

	public void setRows(List<GetRefineProductsPojoDataRows> rows) {
		this.rows = rows;
	}

	public List<GetRefineProductsPojoDataQuery> getQuery() {
		return query;
	}

	public void setQuery(List<GetRefineProductsPojoDataQuery> query) {
		this.query = query;
	}

}
