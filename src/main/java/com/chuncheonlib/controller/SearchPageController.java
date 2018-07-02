package com.chuncheonlib.controller;

import java.util.ArrayList;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kolas3.work.BookSearch.Model.AnalizeCommand;
import kolas3.work.BookSearch.Model.SockProcess;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.chuncheonlib.kolas3.frame.Kolas3BookFrame;
import com.chuncheonlib.kolas3.frame.Kolas3UserFrame;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class SearchPageController {

	@RequestMapping(value="search")
	public String search(){
		return "pages/search/search";
	}

	@RequestMapping(value="search/original")
	public String origTextSearch(){
		return "pages/search/original";
	}

	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="search/newarrivals")
	public ModelAndView getNewArrivals() throws Exception{

		ModelAndView toReturn = new ModelAndView();

		// create socket for communicating with KOLAS server
		SockProcess sockprocess = new SockProcess();

		// create object for "analizing" frame responses
		AnalizeCommand anlizecommand = new AnalizeCommand();

		// create an array list frame to send to KOLAS server
		// ArrayList frame = Kolas3UserFrame.createRegisterFrameForSocket(user);
		ArrayList frame = Kolas3BookFrame.createGetNewArrivalsRequest();

		// send to KOLAS server and receive data from server
		String frameResponse = sockprocess.pro3sock((String) frame.get(0), (String) frame.get(1));

		// decipher returned data
		Vector responseVector = anlizecommand.analize(frameResponse);

		// DEV: temporarily put the returned object and see what is the result from the server
		toReturn.addObject("returnObject", responseVector);

		toReturn.setViewName("pages/search/newarrivals");
		return toReturn;
	}

	/**
	 * This is 대출베스
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="search/topten")
	public ModelAndView topLending() throws Exception{

		ModelAndView toReturn = new ModelAndView();


		// create socket for communicating with KOLAS server
		SockProcess sockprocess = new SockProcess();

		// create object for "analizing" frame responses
		AnalizeCommand anlizecommand = new AnalizeCommand();

		// create an array list frame to send to KOLAS server
		// ArrayList frame = Kolas3UserFrame.createRegisterFrameForSocket(user);
		ArrayList frame = Kolas3BookFrame.createGetBestLendingRequest();

		// send to KOLAS server and receive data from server
		String frameResponse = sockprocess.pro3sock((String) frame.get(0), (String) frame.get(1));

		// decipher returned data
		Vector responseVector = anlizecommand.analize(frameResponse);

		// DEV: temporarily put the returned object and see what is the result from the server
		toReturn.addObject("returnObject", responseVector);




		toReturn.setViewName("pages/search/lending");

		return toReturn;
	}



}
