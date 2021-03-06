package gov.lct.util;

public class Pager {
	private int totalRows; //������
	private int pageSize; //ÿҳ��ʾ������
	private int currentPage; //��ǰҳ��
	private int totalPages; //��ҳ��
	private int startRow; //��ǰҳ����ݿ��е���ʼ��
	
	public Pager() {
		
	}
	
	public Pager(int _totalRows, int _pageSize) {
		pageSize = _pageSize;
		totalRows = _totalRows;
		totalPages=totalRows/pageSize;
		int mod=totalRows%pageSize;
		if(mod>0){
			totalPages++;
		}
		currentPage = 1;
		startRow = 0;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void first() {
		currentPage = 1;
		startRow = 0;
	}
	public void previous() {
		if (currentPage == 1) {
			return;
		}
		currentPage--;
		startRow = (currentPage - 1) * pageSize;
	}
	public void next() {
		if (currentPage < totalPages) {
			currentPage++;
		}
		startRow = (currentPage - 1) * pageSize;
	}
	public void last() {
		currentPage = totalPages;
		startRow = (currentPage - 1) * pageSize;
	}
	public void refresh(int _currentPage) {
		currentPage = _currentPage;
		if (currentPage > totalPages) {
			last();
		}
	}
}
