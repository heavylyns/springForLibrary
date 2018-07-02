package kolas3.user.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kolas3.common.Kolas3Exception;
import kolas3.common.login.SessionManager;
import kolas3.work.BookSearch.Model.InsertLoan;

@Controller
@RequestMapping(value="/kolas3")
public class UserProcessController {

	@RequestMapping(value="/member/register")
	public ModelAndView registerUser(HttpServletRequest request, HttpServletResponse response){
		return null;
	}
	
}
