package homework.paging;

public class PageRequest implements Pageable {
	private Integer page;
	private Integer limit;
	public  PageRequest(Integer page,Integer limit) {
		this.page=page;
		this.limit=limit;
	}
	
	public Integer getPage() {
		// TODO Auto-generated method stub
		return this.page;
	}

	public Integer getOffset() {
		// TODO Auto-generated method stub
		if(this.page!=null&& this.limit!=null) {
			return (this.page-1)*this.limit;
		}
		return null;
	}

	public Integer getLimit() {
		// TODO Auto-generated method stub
		return this.limit;
	}
	
}
