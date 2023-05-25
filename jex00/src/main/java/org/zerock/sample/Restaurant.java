package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Data
@Component	// 스프링에게 관리를 해야하는 대상임을 표시하는 어노테이션임.
public class Restaurant {

	
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
}
