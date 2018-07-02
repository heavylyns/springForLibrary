package kolas3.work.UserService.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kolas3.common.Kolas3Exception;
import kolas3.common.login.SessionManager;

@Controller
@RequestMapping(value = "/kolas3")
public class UserServiceMenuAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (UserServiceMenuAction.class);

	@RequestMapping(value = "/user.service_move.do")
	public ModelAndView service_move(HttpServletRequest request, HttpServletResponse response) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		SessionManager Session = new SessionManager(request);
		if ((Session.getAttribute("USER_NO") != null) && (!Session.getAttribute("USER_NO").equals(""))) {
			String User_id = (String) Session.getAttribute("USER_NO");

			// return new ActionForward("/LoanStatus.do", true);
			mav.setViewName("redirect:/kolas3/user.LoanStatus.do");
			return mav;

		}
		mav.addObject("path", "/service_move.do");
		mav.addObject("menu_id", "Login");

		//return map.findForward("LoginRun");
		mav.setViewName("kolas3/UserService/ServiceLendCondition");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}

	}
}
