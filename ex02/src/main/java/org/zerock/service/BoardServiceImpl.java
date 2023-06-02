package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		/*
		 * BoardServicec는 void 타입으로 설계되었으므로 mapper.insertSelectKey()의 반환 값인 int를 사용하지 않고
		 * 있지만, 필요하다면 예외 처리나 void 대신에 int 타입을 이용해서 사용할 수도 있다.
		 * 
		 * mapper의 insertSelectKey()를 이용해서 나중에 생성된 게시물의 번호를 확인할 수 있게 작성함.
		 */
		log.info("register........" + board);

		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {

		log.info("get().....");

		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify........." + board);
		// 정상적으로 수정이 이루어지면 1이라는 값을 반환하기 때문에 == 연산자를 이용해서 true/false 를 처리할 수 있다.
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		
		log.info("remove......" + bno);
		// 정상적으로 삭제가 이루어지면 1이라는 값을 반환하기 때문에 == 연산자를 이용해서 true/false 를 처리할 수 있다.
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {

		log.info("getList()..........");

		return mapper.getList();
	}


}
