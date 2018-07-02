package kolas3.work.UserService.Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kolas3.common.Kolas3Exception;
import kolas3.work.UserService.Form.UserZipcodeForm;
import kolas3.work.UserService.Model.UserMemberShipMgr;

@Controller
@RequestMapping(value = "/kolas3")
public class UserZipcodeFindAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/user.search_simple88.do")
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse reponse, UserZipcodeForm form) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		UserMemberShipMgr memberMgr = new UserMemberShipMgr();

		ArrayList ZipList = new ArrayList();
		String ZipcodeStr = "";
		String Mode = "";

		UserZipcodeForm Zipcodeform = (UserZipcodeForm) form;

		ZipcodeStr = Zipcodeform.getZipcodefind();
		Mode = Zipcodeform.getMode();

		ZipList = memberMgr.UserZipcodeFind(ZipcodeStr);

		mav.addObject("ZipcodeList", ZipList);

		// return map.findForward("ZipcodeFind");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
