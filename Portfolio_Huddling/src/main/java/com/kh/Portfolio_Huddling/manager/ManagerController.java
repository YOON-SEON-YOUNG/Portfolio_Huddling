package com.kh.Portfolio_Huddling.manager;

import java.lang.annotation.Repeatable;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.Portfolio_Huddling.member.MemberProfileVo;
import com.kh.Portfolio_Huddling.member.MemberService;
import com.kh.Portfolio_Huddling.member.MemberVo;
import com.kh.Portfolio_Huddling.message.MessageService;
import com.kh.Portfolio_Huddling.message.MessageVo;
import com.kh.Portfolio_Huddling.project.ProjectService;
import com.kh.Portfolio_Huddling.project.ProjectVo;

@Controller
@RequestMapping("/manager/*")
public class ManagerController {
	
	@Inject
	private MemberService memberService;

	@Inject
	private ManagerService menagerService;
	
	@Inject
	private ProjectService projectService;
	
	@Inject
	private MessageService messageService;
	
	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public String page() {
		
		return "manager/managerMainPage";
	}
	
	@Transactional
	@RequestMapping(value = "/inquiry", method = RequestMethod.GET)
	public String getInquiry() {
		
		return "manager/managerInquiry";
	}
	
	@RequestMapping(value = "/questionsControlInquiry", method = RequestMethod.GET)
	public String questionsControlInquiry(MessageVo messageVo, Model model) {
		model.addAttribute("message_sender", messageVo.getMessage_sender());
		model.addAttribute("message_receiver", messageVo.getMessage_receiver());
		return "manager/include/questionsControlMessage";
	}
	
	@Transactional
	@RequestMapping(value = "/userControl", method = RequestMethod.GET)
	public String userControl(Model model, MemberVo memberVo, String search) throws Exception {
		if (search == null || search.equals("")) {
			List<MemberVo> list = memberService.memberList(memberVo);
			model.addAttribute("memberList", list);
			model.addAttribute("search", search);
			return "manager/include/userControl";
		} else if (search != null && !(search.equals(""))) {
			List<MemberVo> list = memberService.memberSearch(search);
			model.addAttribute("memberList", list);
			model.addAttribute("search", search);
			System.out.println(list);
			return "manager/include/userControl";
		}
		
		return "manager/include/userControl";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/memberBan", method = RequestMethod.GET)
	public int userRating(@Param("member_id")String member_id) throws Exception {
		int banState = menagerService.memberRating(member_id);
		System.out.println("memberBan입니다:" + banState);
		if (banState == 1) {
			return 1;
		} else {
		return 0;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateMemberRating", method = RequestMethod.POST)
	public int userRating(MemberVo memberVo) throws Exception {
		return memberService.memberRating(memberVo);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/projectApp", method = RequestMethod.POST)
	public String projectApp(ProjectVo projectVo) throws Exception {
		if (projectVo.getProject_app() == 0) {
			projectService.projectApproval(projectVo);
			return "UnApp";
		} else if (projectVo.getProject_app() == 1) {
			projectService.projectApproval(projectVo);
			return "App";
		}
		return "0";
	}
	
	@RequestMapping(value = "/projectApprovalControl", method = RequestMethod.GET)
	public String projectAcceptanceControl(Model model, ProjectVo projectVo) throws Exception {
		List<ProjectVo> list = projectService.ProjectList(projectVo);
		model.addAttribute("projectList", list);
		return "manager/include/projectApprovalControl";
	}
	
	@RequestMapping(value = "/projectUnApprovalControl", method = RequestMethod.GET)
	public String projectControl(Model model, ProjectVo projectVo) throws Exception {
		List<ProjectVo> list = projectService.ProjectList(projectVo);
		model.addAttribute("projectList", list);
		return "manager/include/projectUnApprovalControl";
	}
	
	@RequestMapping(value = "/questionsControl", method = RequestMethod.GET)
	public String questionsControl() {
		
		return "manager/include/questionsControl";
	}
	
	
	@RequestMapping(value = "/memberShip", method = RequestMethod.GET)
	public String memberShip(Model model, @Param("member_id") String member_id)throws Exception {
		System.out.println("member_id:" + member_id);
		MemberVo mVo = menagerService.memberShip(member_id);
		System.out.println("mVo:" + mVo);
		model.addAttribute("mVo", mVo);
		return "manager/include/memberShip";
	}
	
	
	
}
