package board.vo;

import javax.servlet.http.HttpServletRequest;

public class pageVO {
	private int totalRecord = 0; // 전체 글의갯수를 가져옴
	private final int numPerpage = 5;// 한페이지당 뿌려질 글의 갯수
	private final int pagePerBlock = 5; // 페이지 이동(블럭단위 : 이전 10페이지, 다음 10페이지 이런식으로)
	// 여기서는 3페이지를 하나로
	private int totalPage = 0; // 전체 몇 페이지냐
	private int totalBlock = 0;
	private int nowPage = 0;// 현재 페이지의 위치
	private int nowBlock = 0;
	private int beginPerPage = 0; // 페이지의 시작번호(1부터5, 6부터10...
	private int endPage=0;
	
	
	public pageVO(int totalRecord, int totalPage, int totalBlock, int nowPage,
			int nowBlock, int beginPerPage,int endPage) {
		super();
		this.totalRecord = totalRecord;	
		this.totalPage = totalPage;
		this.totalBlock = totalBlock;
		this.nowPage = nowPage;
		this.nowBlock = nowBlock;
		this.beginPerPage = beginPerPage;
		this.endPage=endPage;
	}
	
	public pageVO() {
		// TODO Auto-generated constructor stub
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getNumPerpage() {
		return numPerpage;
	}



	public int getPagePerBlock() {
		return pagePerBlock;
	}


	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getNowBlock() {
		return nowBlock;
	}

	public void setNowBlock(int nowBlock) {
		this.nowBlock = nowBlock;
	}

	public int getBeginPerPage() {
		return beginPerPage;
	}

	public void setBeginPerPage(int beginPerPage) {
		this.beginPerPage = beginPerPage;
	}
	
	@Override
	public String toString() {
		return "pageVO [totalRecord=" + totalRecord + ", numPerpage=" + numPerpage + ", pagePerBlock=" + pagePerBlock
				+ ", totalPage=" + totalPage + ", totalBlock=" + totalBlock + ", nowPage=" + nowPage + ", nowBlock="
				+ nowBlock + ", beginPerPage=" + beginPerPage + ", endPage=" + endPage + "]";
	}

	public void setPage(int size,int nowPage,int nowBlock){
				
		beginPerPage = (nowPage - 1) * numPerpage;


		this.nowBlock = nowBlock;
		
		this.nowPage=nowPage;
		
		beginPerPage=(nowPage-1)*numPerpage;

		totalRecord = size;

		endPage=beginPerPage + numPerpage;
		
		totalPage = ((int) Math.ceil((double) totalRecord / numPerpage));

		totalBlock = ((int) Math.ceil((double) totalPage / 5));
	}
}
