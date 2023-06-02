package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	
	@Setter(onMethod_ =  @Autowired)
	private BoardService service;
	
//	@Test
//	public void testExist() {
//		
//		log.info(service);
//		assertNotNull(service);
//	}

	
//	@Test
//	public void testRegister() {
//		
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");
//		
//		
//		service.register(board);
//		
//		log.info("생성된 게시물의 번호 : " + board.getBno());
//	}

//	@Test
//	public void testGetList() {
//		
//		service.getList().forEach(board -> log.info(board));
//	}
	
	
//	@Test
//	public void testGet() {
//		
//		log.info(service.get(1L));
//	}
	
	
	@Test
	public void testDelete() {
		
		// 게시물 번호의 존재 여부를 확인하고 테스트할 것
		// 해당 게시물이 존재할 때 true를 반환하는 것을 확인할 수 있음.
		log.info("REMOVE RESULT : " + service.remove(2L));
	}
	
	@Test
	public void testUpdate() {
		
		// board 테이블 리스트에 1번 테이블을 지정함.
		BoardVO board = service.get(1L);
		
		
		// 만약 지정한 값이 null 즉 테이블이 없다면 호출한 곳으로 다시 리턴함.
		if( board == null) {
			return;
		}
		
		// 특정한 테이블이 있다면 그 제목을 수정하고 업데이트 함.
		board.setTitle(" 제목 수정합니다." );
		log.info("MODIFY RESULT : " + service.modify(board));
	}

}
