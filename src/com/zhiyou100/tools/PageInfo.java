package com.zhiyou100.tools;

public class PageInfo {

	private int currentPage;
	private int beginPage;
	private int endPage;
	private int totalPage;
	private int totalDataCount;
	private String servletPath;

	/*
	 * 设置当前页,总页数,总数据量,请求路径
	 */
	public PageInfo(int currentPage, int totalPage, int totalDataCount,String servletPath) {
		super();
		this.totalDataCount = totalDataCount;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.servletPath = servletPath+"?page=";
		caculateBeginAndEnd();
	}

	/*
	 * 
	 * 通过当前页和总页数,计算起始页和终止页
	 * 
	 */
	public void caculateBeginAndEnd(){
		if(currentPage - 5 >= 1  && currentPage + 5<= totalPage){
			beginPage = currentPage - 5;
			endPage = currentPage + 5;
		}else if (currentPage - 5 < 1 && currentPage + 5 > totalPage){
			beginPage = 1;
			endPage = totalPage;
		}else if (currentPage + 5 > totalPage) {
			
			endPage = totalPage;
			beginPage = endPage - 10 < 1? 1 : endPage - 10;
			
		}else if(currentPage - 5 < 1){
			beginPage = 1;
			endPage = beginPage + 10 >totalPage? totalPage: beginPage + 10;
		}	
	}
	
	public int getTotalDataCount() {
		return totalDataCount;
	}
	public void setTotalDataCount(int totalDataCount) {
		this.totalDataCount = totalDataCount;
	}
	public String getServletPath() {
		return servletPath;
	}
	public void setServletPath(String servletPath) {
		this.servletPath = servletPath;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
}
