package com.simple.basic.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.simple.basic.command.BuilderVO;
import com.simple.basic.command.BuilderVO2;
import com.simple.basic.command.SimpleVO;

@Controller
@RequestMapping("/view")
public class ThymeleafController {

	//ex01화면 출력
	@GetMapping("/ex01")
	public String ex01() {
		return "view/ex01";
	}
	
	//ex02화면 출력
	@GetMapping("/ex02")
	public String ex02(Model model) {
		
		ArrayList<BuilderVO2> list = new ArrayList<>();

		//데이터(list)를 가지고 화면으로
		for(int i = 1; i <= 10; i++) {
			
			BuilderVO2 vo= BuilderVO2
						  .builder()
						  .name("홍길동" + i)
						  .age(i)
					      .build();
			list.add(vo); //리스트에 추가
		}
		//list ex02화면으로 가지고 나가보세요.
		model.addAttribute("bbb", "홍길동");
		model.addAttribute("aaa", list);
		
		return "view/ex02";
	}
	
	
	//quiz01화면으로 simpleVO를 반복문을 통해서 20개를 리스트에 담아 가져나갑니다.
	//quiz01화면에 sno값이 3의 배수일때만 출력.
	//LocalDateTime -> LocalDateTime.now()
	@GetMapping("/quiz01")
	public String quiz01(Model model) {
		
		ArrayList<SimpleVO> list = new ArrayList<>();
		
		for(int i = 1; i <= 20; i++) {
			 SimpleVO vo = SimpleVO.builder()
					 				.sno(i)
					 				.first("홍")
					 				.last("길동")
					 				.regdate(LocalDateTime.now())
					 				.build();
			
			 list.add(vo);
		}
		model.addAttribute("list", list); //리스트를 모델에추가
		
		return "view/quiz01";
	}
	
	
	@GetMapping("/ex03")
	public String ex03(Model model) {

		ArrayList<SimpleVO> list = new ArrayList<>();
		
		for(int i = 1; i <= 20; i++) {
			 SimpleVO vo = SimpleVO.builder()
					 				.sno(i)
					 				.first("홍")
					 				.last("길동")
					 				.regdate(LocalDateTime.now())
					 				.build();
			
			 list.add(vo);
		}
		model.addAttribute("list", list); //리스트를 모델에추가
		
		return "view/ex03";
	}
	
	
	
	
	
	
	
	
}
