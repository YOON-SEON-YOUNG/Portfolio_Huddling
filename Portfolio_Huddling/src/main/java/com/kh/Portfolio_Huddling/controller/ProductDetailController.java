package com.kh.Portfolio_Huddling.controller;


import javax.inject.Inject;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.Portfolio_Huddling.maker.TempMakerRewordDto;
import com.kh.Portfolio_Huddling.project.BoardService;
import com.kh.Portfolio_Huddling.project.BoardVo;

import com.kh.Portfolio_Huddling.member.MemberVo;
import com.kh.Portfolio_Huddling.member.PaymentVo;
import com.kh.Portfolio_Huddling.member.PointService;

@Controller
@RequestMapping("/detail/*")
public class ProductDetailController {
	
	@Inject
	private BoardService boardService;

	
	// 펀딩 상세보기 페이지 
	@RequestMapping(value="/detailMain/{num}", method=RequestMethod.GET)
	public String page(@PathVariable("num") int project_num,
			HttpServletRequest request, Model model) throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("project_num", project_num);
		List<TempMakerRewordDto> list = boardService.getReowrd(project_num);
		model.addAttribute("reword",list);
		System.out.println("detailMain 실행중");
		return "detail/productDetail";
	}
	
	// 펀딩 상품 소개
	@RequestMapping(value= "/tapInfo", method = RequestMethod.GET)
	public String tapInfo() {
		System.out.println("tapInfo 실행중");
		return "detail/include/tapInfo";
		
	}
	
	// 펀딩 참여 내역
	@RequestMapping(value= "/tapComment", method = RequestMethod.GET)
	public String tapComment() {
		System.out.println("tapComment 실행중");
		return "detail/include/tapComment";
		
	}
	
	// 펀딩 후기
	@RequestMapping(value= "/tapReview", method = RequestMethod.GET)
	public String tapReview() {
		System.out.println("tapReview 실행중");
		return "detail/include/tapReview";
	}
	
	// 펀딩 리워드 옵션
	@RequestMapping(value= "/orderOption")
	public String orderOption() {
		return "detail/orderOption";
		
	}
	
	// 결제 페이지 포인트 사용(새창)
	@RequestMapping(value="/orderPage", method = RequestMethod.GET)
	public String orderPage() {
		return "detail/orderPage";
	}
		

	// 디테일 페이지 데이터 가져오기
	@RequestMapping(value="/getDetail/{num}", method= RequestMethod.GET)
	@ResponseBody
	public BoardVo getDetail(@PathVariable("num")int project_num,
			HttpServletRequest request) throws Exception {
		System.out.println("디테일 데이터 가져옴...");
		project_num = (int) request.getSession().getAttribute("project_num"); 
		BoardVo vo = boardService.getDetail(project_num);
		return vo;
	}
	// 총 결제 금액 가져오기
	@RequestMapping(value="/totalPayment/{num}", method=RequestMethod.GET)
	@ResponseBody
	public int totalPayment(@PathVariable("num")int project_num) throws Exception{
		int num = boardService.totalPayment(project_num);
		System.out.println("num :" + num);
		if(num == 0) {
			return 0;
		}
		return num;
	}
	
	//남은 날짜 구하기
	@RequestMapping(value="/endDate/{num}", method = RequestMethod.GET)
	@ResponseBody
	public String endDate(@PathVariable("num")int project_num) throws Exception{
		String date = boardService.endDate(project_num);
		System.out.println("datedata : " + date);
		return date;
	}
	
	//후원자 구하기
	@RequestMapping(value="/totalSponser/{num}",method =RequestMethod.GET)
	@ResponseBody
	public int totalSponser(@PathVariable("num")int project_num) throws Exception{
		int sponser = boardService.totalSponser(project_num);
		if(sponser == 0) {
			return 0;
		}
		return sponser;
	}
	
	//후원 진행상태 구하기
	@RequestMapping(value="/totalPrice/{num}",method= RequestMethod.GET)
	@ResponseBody
	public int totalPrice(@PathVariable("num")int project_num) throws Exception{
		int price = boardService.totalPrice(project_num);
		if(price == 0) {
			return 0;
		}
		return price;
	}
	
}
