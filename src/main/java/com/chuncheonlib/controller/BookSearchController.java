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
public class BookSearchController {

	@RequestMapping(value="/mypage/mybooks")
	ModelAndView getListOfBorrowedBooks(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/mypage/mybooks");
		
		return toReturn;
	}
}
