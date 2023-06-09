package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

//	@Select("select * from sys.tbl_board where bno > 0")
	// tbl_board 리스트 목록
	public List<BoardVO> getList();
	// 페이징 처리
	public List<BoardVO> getListWithPaging(Criteria cri);
	// insert만 처리되고 생성된 PK값을 알 필요가 없는 경우
	public void insert(BoardVO board);
	// insert문이 실행되고 생성된 PK값을 알아야 하는 경우
	public void insertSelectKey(BoardVO board);
	// read 처리
	public BoardVO read(Long bno);
	// delete 삭제 처리
	public int delete(Long bno);
	// update 수정 처리
	public int update(BoardVO board);
	// 전체 페이지 갯수 불러오기
	public int getTotalCount(Criteria cri);
	
	
}
