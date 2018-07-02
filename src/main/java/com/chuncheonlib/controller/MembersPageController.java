package com.chuncheonlib.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
@RequestMapping(value="/members")
public class MembersPageController {
	
	@RequestMapping(value="/faq")
	public ModelAndView faq(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/faq/faq_list");
		
		// the name object is used in the navbar
		toReturn.addObject("name", "faq");
		
		return toReturn;
	}
	

	@RequestMapping(value="/qna")
	public ModelAndView questionAndAnswer(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/qna/qna_list");
		
		// the name object is used in the navbar
		toReturn.addObject("name", "qna_list");
		
		return toReturn;
	}
	
	@RequestMapping(value="/qna/view")
	public ModelAndView viewQA(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/qna/view");
		
		toReturn.addObject("name", "qna_list");
		
		return toReturn;
	}
	
	@RequestMapping(value="/qna/create")
	public ModelAndView createQA(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/qna/create");
		
		toReturn.addObject("name", "qna_list");
		
		return toReturn;
	}
	
	@RequestMapping(value="/qna/reply")
	public ModelAndView replyQA(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/qna/reply");
		
		toReturn.addObject("name", "qna_list");
		
		return toReturn;
	}
	
	@RequestMapping(value="/noticeboard")
	public ModelAndView noticeboardList(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/noticeboard/noticeboard_list");
		
		toReturn.addObject("name", "noticeboard");
		
		return toReturn;
		
	}
	
	@RequestMapping(value="/noticeboard/view")
	public ModelAndView viewNotice(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/noticeboard/view");
		
		toReturn.addObject("name", "noticeboard");
		
		return toReturn;
		
	}
	
	@RequestMapping(value="/noticeboard/create")
	public ModelAndView createNotice(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/noticeboard/create");
		
		toReturn.addObject("name", "noticeboard");
		
		return toReturn;
		
	}
	
	
	@RequestMapping(value="/freeboard")
	public ModelAndView freeboard(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/freeboard/freeboard_list");
		
		toReturn.addObject("name", "freeboard");
		
		return toReturn;
		
	}
	
	@RequestMapping(value="/volunteering")
	public ModelAndView volunteering(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/volunteering/overview");
		
		toReturn.addObject("name", "volunteering");
		
		return toReturn;
		
	}
	
	@RequestMapping(value="/volunteering/apply")
	public ModelAndView chooseVolunteeringDate(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/volunteering/apply");
		
		toReturn.addObject("name", "volunteering");
		
		return toReturn;
		
	}
	
	@RequestMapping(value="/excursions")
	public ModelAndView excursions(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/excursions/overview");
		
		toReturn.addObject("name", "excursion");
		
		return toReturn;
		
	}
	
	@RequestMapping(value="/excursions/apply")
	public ModelAndView chooseExcursionDate(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/members/excursions/apply");
		
		toReturn.addObject("name", "excursions");
		
		return toReturn;
		
	}
	
	
	
	
}
