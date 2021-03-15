package com.mari.shop.model;

import lombok.Data;

@Data
public class PageObject {
	/*
	 * SELECT * FROM 
	 * (select T.*,
	 * ROWNUM RN from tbl_product T ORDER BY PRODUCT_ID DESC) 
	 * WHERE 
	 * RN<=30 AND RN >20;
	 * 	  3*10 2*10
	 *    2*10 1*10
	 *    1*10 0*10 
	 *    (currPage)*criCnt ,(currPage-1)*criCnt
	 * n* 10( 기준- 게시글 몇개. 상품 몇개 )
	 * totalCnt = 501 개 가정
	 * 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
	 * endPage = 10, 20, 30, 40, 50 51
	 *         = 1*10 / 2*10 / 3*10..
	 *         n*10 / 5.xxx.. = totalCnt/criCnt*10
	 */
	private int criCnt =10; //기준이 되는 게시글 카운트 수. 1페이지당 10개 보여주기 (초기값)
	private int currPage =1; //현재 페이지. 초기값 1 설정
	private int startPage;
	private int endPage;
	private int totalCnt; //전체 게시글 수
	private boolean prevPage;
	private boolean nextPage;
	private int realEndPage;
	
	private Criteria cri;
	
	public PageObject(int totalCnt, int currPage, Criteria cri){
		this.totalCnt = totalCnt;
		this.currPage = currPage;
		this.cri = cri;
		realEndPage = (int)Math.ceil(totalCnt/(criCnt*1.0));
		endPage = (int)Math.ceil(currPage/10.0)*10;
		endPage = endPage>realEndPage? realEndPage : endPage;
		startPage = endPage - 9;
		startPage = startPage<1 ? 1:startPage;
		prevPage = startPage == 1? false : true;
		nextPage = endPage==realEndPage? false : true;
	}
}
