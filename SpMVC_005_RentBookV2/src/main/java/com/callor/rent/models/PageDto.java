package com.callor.rent.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDto {
	//Builder 패턴으로 객체를 생성할때 기본 변수값 설정하기
	@Builder.Default
	private int pageNum = 1; 		// 보려는 페이지 번호
	private int totalCount; 		// 데이터 전체 개수
	private int offsetNum = 0;		// 시작 페이지 번호
	
	@Builder.Default
	private int limitCount = 10;	// 보여질 데이터 개수
	private int pageNumCount;		// 하단 페이지 네이션에 보여질 번호 개수
	private int finalPageNum;		// 전페페이지의 마지막 페이지 번호

	private int firstPageNum;		// 현제페이지의 첫번째 페이지 번호 
	private int lastPageNum;		// 현제페이지의 마지막 페이지 번호
	
	
	public int getFinalPageNum() {
		if(this.totalCount < 1) return 0;
		this.finalPageNum = (this.totalCount + (this.limitCount - 1)) / this.limitCount;
		return this.finalPageNum;
	}
	public int getOffSetNum() {
		this.offsetNum = (pageNum - 1) * limitCount;
		return this.offsetNum;
	}
	public int getFirstPageNum() {
		this.firstPageNum = (int)(pageNum - 4);
//		this.firstPageNum = (int)(pageNum - (limitCount /2));
		this.firstPageNum = this.firstPageNum < 1 ? 1 : this.firstPageNum;
		return firstPageNum;
	}
	public int getLastPageNum() {
		this.firstPageNum = this.getFirstPageNum();
		this.finalPageNum = this.getFinalPageNum();
		this.lastPageNum = (int)(pageNum + 4);
//		this.lastPageNum = (int)(pageNum + (limitCount /2));
//		this.lastPageNum = this.firstPageNum + (this.limitCount - 1);
		this.lastPageNum = this.lastPageNum > this.finalPageNum ? this.finalPageNum : this.lastPageNum;
		return lastPageNum;
	}
	
}
