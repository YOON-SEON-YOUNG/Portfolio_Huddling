package com.kh.Portfolio_Huddling.controller;


import javax.inject.Inject;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.Portfolio_Huddling.maker.TempMakerMakersDto;
import com.kh.Portfolio_Huddling.maker.TempMakerRewordDto;
import com.kh.Portfolio_Huddling.member.MemberVo;
import com.kh.Portfolio_Huddling.member.PointService;
import com.kh.Portfolio_Huddling.member.PointVo;
import com.kh.Portfolio_Huddling.order.CartListDto;
import com.kh.Portfolio_Huddling.order.OrderDetailVo;
import com.kh.Portfolio_Huddling.order.OrderListDto;
import com.kh.Portfolio_Huddling.order.OrderService;
import com.kh.Portfolio_Huddling.order.OrderVo;
import com.kh.Portfolio_Huddling.order.RewordCartListDto;
import com.kh.Portfolio_Huddling.order.RewordCartVo;
import com.kh.Portfolio_Huddling.project.BoardService;
import com.kh.Portfolio_Huddling.project.BoardVo;


@Controller
@RequestMapping("/detail/*")
public class ProductDetailController {
	
	@Inject
	private BoardService boardService;
	
	@Inject
	private PointService pointService;
	
	@Inject
	private OrderService orderService;


	
	// 펀딩 상세보기 페이지 
	@RequestMapping(value="/detailMain/{num}", method=RequestMethod.GET)
	public String page(@PathVariable("num") int project_num, Model model, HttpSession session) throws Exception {
		session.setAttribute("project_num", project_num);
		MemberVo vo = (MemberVo)session.getAttribute("memberVo");
		System.out.println("vo:" + vo);
		List<TempMakerRewordDto> list = boardService.getReowrd(project_num);
		model.addAttribute("reword",list);
		System.out.println("detailMain 실행중");
		// 작성자 아이디 자바에 넣기위해 추가
		TempMakerMakersDto makersDto = boardService.makersInfo(project_num);
		model.addAttribute("makersDto",makersDto);
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



	// 디테일 페이지 데이터 가져오기
	@RequestMapping(value="/getDetail/{num}", method= RequestMethod.GET)
	@ResponseBody
	public BoardVo getDetail(@PathVariable("num")int project_num,
			HttpSession session) throws Exception {
		System.out.println("디테일 데이터 가져옴...");
		BoardVo vo = boardService.getDetail(project_num);
		return vo;
	}
	
	// 
	@RequestMapping(value="/endProject/{num}",method=RequestMethod.POST)
	@ResponseBody
	public void endProject(@PathVariable("num")int project_num) throws Exception{
		boardService.endProject(project_num);
	}
	// 총 결제 금액 가져오기
	@RequestMapping(value="/totalPayment/{num}", method=RequestMethod.GET)
	@ResponseBody
	public int totalPayment(@PathVariable("num")int project_num) throws Exception{
		int totalVal = boardService.totalPayment(project_num);
		return totalVal;
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
		return sponser;
	}
	
	//후원 진행상태 구하기
	@RequestMapping(value="/totalPrice/{num}",method= RequestMethod.GET)
	@ResponseBody
	public int totalPrice(@PathVariable("num")int project_num) throws Exception{
		int percent = boardService.percent(project_num);
		System.out.println("percent : " + percent);
		if(percent < 0) {
			System.out.println("this is null");
			return 0;
		} else {
		System.out.println("con :" + percent);
		return percent;
		}
	}
	
	//창작자 가져오기
	@RequestMapping(value="/makersInfo/{num}",method = RequestMethod.GET)
	@ResponseBody
	public TempMakerMakersDto makersInfo(@PathVariable("num")int project_num, HttpSession session) throws Exception{
		System.out.println("makersInfo : " + project_num);
		TempMakerMakersDto makersDto = boardService.makersInfo(project_num);
		return makersDto;
	}
	
	// 상품별 리워드 목록
			@RequestMapping(value="/detailMain/{num}/reword", method = RequestMethod.GET)
			public String getRewordList(@PathVariable("num") int project_num,
					HttpServletRequest request, Model model) throws Exception {
				HttpSession session = request.getSession();
				session.setAttribute("project_num", project_num);
				List<TempMakerRewordDto> list = boardService.getReowrd(project_num);
				model.addAttribute("reword",list);
				System.out.println("reword 실행중");
				return "detail/rewordList";
			}
	
			// 리워드 조회 
			@RequestMapping(value="/detailMain/{num}/option", method = RequestMethod.GET)
			public String getRewordView(@PathVariable("num") int project_num,
					@RequestParam("n") int temp_reword_num, Model model) throws Exception {
				TempMakerRewordDto rewordDto = orderService.rewordView(temp_reword_num);
				model.addAttribute("rewordDto", rewordDto);
				System.out.println("리워드 조회 실행중");
				return "detail/rewordView";
				
			}
		
		// 리워드 담기 
			@ResponseBody
			@RequestMapping(value="/detail/rewordcart", method = RequestMethod.POST)
			public int addCart(CartListDto cart, HttpSession session) throws Exception {
				int result = 0;
						
				MemberVo member = (MemberVo) session.getAttribute("memberVo");
				
				if(member != null) {
					cart.setMember_id(member.getMember_id());
					orderService.addCart(cart);
					System.out.println("리워드 카트 실행중");
					result = 1;
				}
				
				return result;
				
				
			}
			
			// 리워드 리스트 
			@RequestMapping(value="/detail/rewordCart", method = RequestMethod.GET)
			public String getCartList(HttpSession session, Model model) throws Exception {
				MemberVo member = (MemberVo)session.getAttribute("memberVo");
				String member_id = member.getMember_id();
				List<CartListDto> cartList = orderService.cartList(member_id);
				model.addAttribute("cartList", cartList);
				
				return "detail/rewordCart";
				
			}
			
			// 리워드 카트 삭제
			@ResponseBody
			@RequestMapping(value="/deleteCart", method = RequestMethod.POST)
			public int deleteCart(HttpSession session, @RequestParam(value="chbox[]") 
					List<String> chArr, RewordCartVo cart) throws Exception {
				
				MemberVo member = (MemberVo)session.getAttribute("memberVo");
				String member_id = member.getMember_id();
				
				int result = 0;
				int reword_cart_num = 0;
				
				if(member != null) {
					cart.setMember_id(member_id);
					
					for(String i : chArr) {
						reword_cart_num = Integer.parseInt(i);
						cart.setReword_cart_num(reword_cart_num);
						orderService.deleteCart(cart);
					}
					result = 1;
				}
				
				return result;
				
			} 
			
			// 주문
			@RequestMapping(value="/rewordCart", method=RequestMethod.POST)
			public String order(HttpSession session, OrderVo order, 
					OrderDetailVo orderDetail) throws Exception{
				
				
				MemberVo member = (MemberVo)session.getAttribute("memberVo");
				String member_id = member.getMember_id();
				
				Calendar cal = Calendar.getInstance();
				int year = cal.get(Calendar.YEAR);
				String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
				String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
				String subNum = "";
				
				for(int i = 1; i <= 6; i ++) {
					subNum += (int)(Math.random() * 10);
				}
				
				String order_id = ymd + "_" + subNum;
				
				order.setOrder_id(order_id);
				order.setMember_id(member_id);
				
				
				orderService.orderInfo(order);
				
				orderDetail.setOrder_id(order_id);
				orderService.orderInfo_Details(orderDetail);
				
				orderService.cartAllDelete(member_id);
				orderService.changePoint(member);
				
				return "redirect:/detail/orderList";
				
			}
			
			// 주문 목록
			@RequestMapping(value="/detail/orderList", method = RequestMethod.GET)
			public String getOrderList(HttpSession session, OrderVo order, Model model) 
					throws Exception{
				MemberVo member = (MemberVo)session.getAttribute("memberVo");
				String member_id = member.getMember_id();
				
				order.setMember_id(member_id);
				List<OrderVo> orderList = orderService.orderList(order);
				model.addAttribute("orderList", orderList);
				
				return "detail/orderList";
				
			}
			
			// 주문 상세 목록
			@RequestMapping(value="/detail/orderView", method = RequestMethod.GET)
			public String getOrderList(HttpSession session,
					@RequestParam("n") String order_id, 
					OrderVo order, Model model) throws Exception {
				
				MemberVo member = (MemberVo)session.getAttribute("memberVo");
				String member_id = member.getMember_id();
				
				order.setMember_id(member_id);
				order.setOrder_id(order_id);
				
				List<OrderListDto> orderView = orderService.orderView(order);
				model.addAttribute("orderView", orderView);
				
				return "detail/orderView";
				
			}
	
	
}
