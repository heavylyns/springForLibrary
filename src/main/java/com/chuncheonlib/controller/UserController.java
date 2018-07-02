package com.chuncheonlib.controller;

import java.io.IOException;
import java.net.UnknownHostException;
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

import com.chuncheonlib.kolas3.frame.Kolas3UserFrame;
import com.chuncheonlib.kolas3.model.UserModel;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class UserController {

	@RequestMapping(value="/register/processRegistration")
	public ModelAndView createUser(HttpServletRequest request, HttpServletResponse response, UserModel user) throws Exception{
		
		ModelAndView createUserMAV = new ModelAndView();
		
		
		/****** FOR USE IN TESTING ONLY*******/
		UserModel testUser = new UserModel();
		testUser.setName("가나다");
		testUser.setPassword("qwaszx123");
		testUser.setUsername("springworkstest001");
		testUser.setEmailAdd("test@springworks.co.kr");
		testUser.setPhoneNumber("01088888888");
		testUser.setAddressLine1("서울시 마포구 백범로35 서강대학교");
		testUser.setAddressLine2("R관 R101호");
		testUser.setGender("M");
		testUser.setBirthdate("19880101");
		testUser.setZipcode("04096");
		
		
		// create socket for communicating with KOLAS server
		SockProcess sockprocess = new SockProcess();
		
		// create object for "analizing" frame responses
		AnalizeCommand anlizecommand = new AnalizeCommand();
		
		// create an array list frame to send to KOLAS server
		// ArrayList frame = Kolas3UserFrame.createRegisterFrameForSocket(user);
		ArrayList frame = Kolas3UserFrame.createRegisterFrameRequest(testUser); // for testing purposes
		
		// send to KOLAS server and receive data from server
		String frameResponse = sockprocess.pro3sock((String) frame.get(0), (String) frame.get(1));
		
		// decipher returned data
		Vector responseVector = anlizecommand.analize(frameResponse);
		
		// DEV: temporarily put the returned object and see what is the result from the server
		createUserMAV.addObject("returnObject", responseVector);
		
		return null;
	}
	
	
	@RequestMapping(value="/register/editProcess")
	public ModelAndView editUser(HttpServletRequest request, HttpServletResponse response, UserModel user) throws Exception{
		
		ModelAndView createUserMAV = new ModelAndView();
		
		/****** FOR USE IN TESTING ONLY*******/
		UserModel testUser = new UserModel();
		testUser.setName("가나다");
		testUser.setPassword("qwaszx123");
		testUser.setUsername("springworkstest001");
		testUser.setEmailAdd("test@springworks.co.kr");
		testUser.setPhoneNumber("01088888888");
		testUser.setAddressLine1("서울시 마포구 백범로35 서강대학교");
		testUser.setAddressLine2("R관 R101호");
		testUser.setGender("M");
		testUser.setBirthdate("19880101");
		testUser.setZipcode("04096");
		
		// create socket for communicating with KOLAS server
		SockProcess sockprocess = new SockProcess();
		
		// create object for "analizing" frame responses
		AnalizeCommand anlizecommand = new AnalizeCommand();
		
		// create an array list frame to send to KOLAS server
		// ArrayList frame = Kolas3UserFrame.createRegisterFrameForSocket(user);
		ArrayList frame = Kolas3UserFrame.createEditFrameRequest(testUser); // for testing purposes
		
		// send to KOLAS server and receive data from server
		String frameResponse = sockprocess.pro3sock((String) frame.get(0), (String) frame.get(1));
		
		// decipher returned data
		Vector responseVector = anlizecommand.analize(frameResponse);
		
		// DEV: temporarily put the returned object and see what is the result from the server
		createUserMAV.addObject("returnObject", responseVector);
		
		return null;
	}
	
	
	@RequestMapping(value="/iforgot")
	public ModelAndView iForgot(){
		
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/iforgot/main");
		
		return toReturn;
	}
	
	
	@RequestMapping(value="/iforgot/username")
	public ModelAndView iforgotUsername() throws Exception{
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/iforgot/username");
		
		return toReturn;
	}
	
	
	@RequestMapping(value="/iforgot/usernameProcess")
	public ModelAndView iforgotUsernameProcess() throws Exception{
		ModelAndView toReturn = new ModelAndView();
		
		/****** FOR USE IN TESTING ONLY*******/
		UserModel testUser = new UserModel();
		testUser.setName("가나다");
		testUser.setMobileNumber("01088888888");
		
		// create socket for communicating with KOLAS server
		SockProcess sockprocess = new SockProcess();
		
		// create object for "analizing" frame responses
		AnalizeCommand anlizecommand = new AnalizeCommand();
		
		// create an array list frame to send to KOLAS server
		// ArrayList frame = Kolas3UserFrame.createRegisterFrameForSocket(user);
		ArrayList frame = Kolas3UserFrame.createIForgotUsernameRequest(testUser); // for testing purposes
		
		// send to KOLAS server and receive data from server
		String frameResponse = sockprocess.pro3sock((String) frame.get(0), (String) frame.get(1));
		
		// decipher returned data
		Vector responseVector = anlizecommand.analize(frameResponse);
		
		// DEV: temporarily put the returned object and see what is the result from the server
		toReturn.addObject("returnObject", responseVector);
		
		return toReturn;
	}
	
	@RequestMapping(value="/iforgot/password")
	public ModelAndView iforgotPassword(){
		ModelAndView toReturn = new ModelAndView();
		
		toReturn.setViewName("pages/iforgot/password");
		
		return toReturn;
	}
	
	
	@RequestMapping(value="/iforgot/passwordProcess")
	public ModelAndView iforgotPasswordProcess() throws Exception{
		ModelAndView toReturn = new ModelAndView();
		
		/****** FOR USE IN TESTING ONLY*******/
		UserModel testUser = new UserModel();
		testUser.setName("가나다");
		testUser.setUsername("test123");
		testUser.setMobileNumber("01088888888");
		
		// create socket for communicating with KOLAS server
		SockProcess sockprocess = new SockProcess();
		
		// create object for "analizing" frame responses
		AnalizeCommand anlizecommand = new AnalizeCommand();
		
		// create an array list frame to send to KOLAS server
		// ArrayList frame = Kolas3UserFrame.createRegisterFrameForSocket(user);
		ArrayList frame = Kolas3UserFrame.createIForgotUsernameRequest(testUser); // for testing purposes
		
		// send to KOLAS server and receive data from server
		String frameResponse = sockprocess.pro3sock((String) frame.get(0), (String) frame.get(1));
		
		// decipher returned data
		Vector responseVector = anlizecommand.analize(frameResponse);
		
		// DEV: temporarily put the returned object and see what is the result from the server
		toReturn.addObject("returnObject", responseVector);
		
		return toReturn;
	}
	
}
