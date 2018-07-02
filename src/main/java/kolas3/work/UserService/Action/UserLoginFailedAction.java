package kolas3.work.UserService.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kolas3.common.Kolas3Exception;
import kolas3.work.UserService.Form.UserLoginForm;

@Controller
@RequestMapping(value = "/kolas3")
public class UserLoginFailedAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (UserLoginFailedAction.class);

	@RequestMapping(value = "/user.loginFailed.do")
	public ModelAndView loginFailed(HttpServletRequest request, HttpServletResponse response,UserLoginForm form) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		mav.addObject("menu_id", "LoginFailed");

		mav.addObject("LoginForm", form);



		mav.setViewName("kolas3/UserService/ServiceLoginFailed");

		// return map.findForward("LoginFailed");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
