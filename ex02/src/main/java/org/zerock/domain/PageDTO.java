package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		// 마지막 페이지  Math.ceil 소수점 올림으로 함
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		// 시작 페이지
		this.startPage = this.endPage - 9;
		// 진짜 끝 번호
		int realEnd = (int) (Math.ceil(total * 1.0/ cri.getAmount()));
		
		// 끝 번호보다 마지막 페이지가 더 크다면
		if(realEnd < this.endPage) {
			// 끝 번호를 마지막 페이지에 대입
			this.endPage = realEnd;
		}
		// 1보다 크다면 이전 페이지가 있음
		this.prev = this.startPage > 1;
		// realEnd 진짜 끝 번호가 마지막 페이지보다 크다면 다음 페이지가 있음.
		this.next = this.endPage < realEnd;
	}
}
