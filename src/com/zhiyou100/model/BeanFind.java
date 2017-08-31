package com.zhiyou100.model;

public class BeanFind {
		private String keyword;
		private String findname;
		public String getKeyword() {
			return keyword;
		}
		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}
		public String getFindname() {
			return findname;
		}
		public void setFindname(String findname) {
			this.findname = findname;
		}
		@Override
		public String toString() {
			return "BeanFind [keyword=" + keyword + ", findname=" + findname + "]";
		}
		
		
		
}
