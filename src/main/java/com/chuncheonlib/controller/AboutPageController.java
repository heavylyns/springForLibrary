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
@RequestMapping(value="/")
public class AboutPageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (DetailViewAction.class);
	
	@RequestMapping(value="home")
	public String index(){
//		logger.info("I WAS HERE!!!");
		
		return "pages/home";
		
	}
	
	@RequestMapping(value="about")
	public ModelAndView aboutUsMain(){	
		ModelAndView mainAboutUs = new ModelAndView();
		
		mainAboutUs.setViewName("pages/about/main");
		mainAboutUs.addObject("title", "도서관안내");
		mainAboutUs.addObject("name", "aboutMain");
		
		return mainAboutUs;
	}
	
	@RequestMapping(value="about/info01")
	public ModelAndView aboutChuncheonLib(){
		
		ModelAndView toReturn = new ModelAndView();
		toReturn.setViewName("pages/about/info01");
		
		toReturn.addObject("title", "춘천시립도서관");
		toReturn.addObject("name", "chuncheonLibInfo");
		
		return toReturn;
	}
	
	@RequestMapping(value="about/info02")
	public ModelAndView aboutChuncheonChildrenLib(){
		ModelAndView childrenLib = new ModelAndView();
		
		childrenLib.addObject("title", "청소년도서관");
		childrenLib.addObject("name", "childrensLib");
		
		childrenLib.setViewName("pages/about/info02");
		
		return childrenLib;
	}
	
	@RequestMapping(value="about/info03")
	public ModelAndView aboutNeighborhoodLib(){
		ModelAndView neighborhoodLib = new ModelAndView();
		
		neighborhoodLib.addObject("name", "neighborhoodlib");
		
		neighborhoodLib.setViewName("pages/about/info03");
		
		return neighborhoodLib;
	}
	
	@RequestMapping(value="about/info04")
	public String info04(){
		return "pages/about/info04";
	}
	
	@RequestMapping(value="about/info05")
	public ModelAndView info05(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.addObject("name", "soyang");
		toReturn.setViewName("pages/about/info05");
		
		return toReturn;
	}
	
	@RequestMapping(value="about/info06")
	public ModelAndView info06(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.addObject("name", "namsan");
		
		toReturn.setViewName("pages/about/info06");
		
		return toReturn;
	}
	
	@RequestMapping(value="about/info07")
	public ModelAndView info07(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/about/info07");
		
		toReturn.addObject("name", "somyun");
		
		return toReturn;
	}
	
	@RequestMapping(value="about/greeting")
	public ModelAndView greeting(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/about/greeting");
		
		toReturn.addObject("name", "greeting");
		
		return toReturn;
	}
	
	@RequestMapping(value="about/regulations")
	public ModelAndView regulations(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.addObject("name", "regulations");
		
		toReturn.setViewName("pages/about/regulations");
		
		return toReturn;
	}
	
	@RequestMapping(value="about/charter")
	public ModelAndView charter(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.addObject("name", "charter");
		toReturn.setViewName("pages/about/charter");
		
		return toReturn;
	}
	
	@RequestMapping(value="about/history")
	public ModelAndView history(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/about/history");
		
		toReturn.addObject("name", "history");
		
		return toReturn;
	}
	
	@RequestMapping(value="about/join")
	public ModelAndView join(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/about/join");
		
		toReturn.addObject("name", "join_info");
		
		return toReturn;
	}
	
	
}
