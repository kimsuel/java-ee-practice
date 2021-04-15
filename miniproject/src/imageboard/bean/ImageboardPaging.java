package imageboard.bean;

import lombok.Data;

@Data
public class ImageboardPaging {
	private int currentPage; // 현재페이지
	private int pageBlock; // [이전][1][2][3][다음] - 3블럭
	private int pageSize; // 1페이지당 3개씩
	private int totalA;   // 총글수
	private StringBuffer pagingHTML;
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		// 총 페이지 수 ( 총 글 수 필요 )
		int totalP = (totalA+pageSize-1) / pageSize;
		
		int startPage = (currentPage - 1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		if(endPage > totalP) endPage = totalP;
		
		if(startPage > pageBlock) // startPage가 3 보다 크면
			pagingHTML.append("[<span id=paging onclick=imageboardPaging("+(startPage-1)+")>이전</span>]");
		
		for(int i=startPage; i<=endPage; i++) {
			if(i==currentPage) {
				pagingHTML.append("[<span id=currentPaging onclick=imageboardPaging("+i+")>"+i+"</span>]");
			}else {
				pagingHTML.append("[<span id=paging onclick=imageboardPaging("+i+")>"+i+"</span>]");
			}
		}
		
		if(endPage < totalP) {
			pagingHTML.append("[<span id=paging onclick=imageboardPaging("+(endPage+1)+")>다음</span>]");
		}
	}
	
	
}
