package board.bean;

import lombok.Data;

@Data
public class BoardPaging {
	private int currentPage; // 현재페이지
	private int pageBlock; // [이전][1][2][3][다음]
	private int pageSize; // 1페이지당 5개씩
	private int totalA;   // 총글수
	private StringBuffer pagingHTML;
	// 계속 편집할 수 있도록 StringBuffer 설정
	// 어떤 거는 [1] 어떤 거는 [1][2] 이런식으로 설정하기 위함
	
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		// 총 페이지 수 ( 총 글 수 필요 )
		int totalP = (totalA+pageSize-1) / pageSize;
		
		int startPage = (currentPage - 1)/pageBlock*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		if(endPage > totalP) endPage = totalP;
		
		if(startPage > pageBlock) // startPage가 3 보다 크면
			pagingHTML.append("[<a id=paging href='boardList.jsp?pg="+(startPage-1)+"'>이전</a>]");
		
		for(int i=startPage; i<=endPage; i++) {
			if(i==currentPage) {
				pagingHTML.append("[<a id=currentPaging href='boardList.jsp?pg="+i+"'>"+i+"</a>]");
			}else {
				pagingHTML.append("[<a id=paging href='boardList.jsp?pg="+i+"'>"+i+"</a>]");
			}
		}
		
		if(endPage < totalP) {
			pagingHTML.append("[<a id=paging href='boardList.jsp?pg="+(endPage+1)+"'>다음</a>]");
		}
	}
	
	
}


/*
 * pagingHTML -> "[1][2][3][다음]"
 * pagingHTML -> "[이전][4][5]"
 * 
 * 총글수 : 7    [1][2]
 * 총글수 : 15   [1][2][3]
 *        startPage   endPage
 * 총글수 : 16   [1][2][3][다음]
 *        [이전][4][5]
 *        
 * currentPage : 2 -> startPage = 1 , endPage = 3
 * currentPage : 5 -> startPage = 4 , endPage = 6
 * */
