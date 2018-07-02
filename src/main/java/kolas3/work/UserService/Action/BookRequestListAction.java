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
import kolas3.common.login.SessionManager;
import kolas3.common.utils.ECOLogManager;
import kolas3.work.UserService.Form.BookRequestListForm;
import kolas3.work.UserService.Model.BookRequestMgr;

@Controller
@RequestMapping(value = "/kolas3")
public class BookRequestListAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (BookRequestListAction.class);

	private ECOLogManager LogMgr = new ECOLogManager();


	/*
 		<action path="/RequestListBook"
 					name="BookRequestListForm"
 					scope="request"
 					type="work.UserService.Action.BookRequestListAction">

 					<forward name="Request_search" path="/iframe/UserService/ServiceBookRequestList.jsp"></forward>
 					<forward name="ListView"       path="/iframe/UserService/ServiceBookRequestList.jsp" ></forward></action>

	 * */

	@RequestMapping(value="/user.RequestListBook.do")
	public ModelAndView RequestListBook( HttpServletRequest request, HttpServletResponse reponse , BookRequestListForm form) throws Kolas3Exception {
		try {
	ModelAndView mav = new ModelAndView();

		reponse.setHeader("P3P", "CP=\"NOI CURa ADMa DEVa TAIa OUR DELa BUS IND PHY ONL UNI COM NAV INT DEM PRE\"");

		ArrayList<BookRequestListForm> RequestBookArray = new ArrayList<BookRequestListForm>();

		BookRequestListForm RequestListForm = (BookRequestListForm) form;
		BookRequestMgr RequestMgr = new BookRequestMgr();
		SessionManager Session = new SessionManager(request);
		String Error_code = "";
		String keyword = "";
		String chk_name = "";
		String chk_title = "";
		int page = 0;
		try {
			Error_code = request.getParameter("error");
			if ((request.getAttribute("UPDATE") != null) || (request.getAttribute("DELETE") != null)) {
				keyword = request.getParameter("keyword");
				chk_name = request.getParameter("chk_name");
				chk_title = request.getParameter("chk_title");
				page = Integer.parseInt(request.getParameter("page"));
			}
			if ((keyword != null) && (chk_name != null) && (chk_title != null) && (page != 0)) {
				RequestListForm.setKeyword(keyword);
				RequestListForm.setChk_name(chk_name);
				RequestListForm.setChk_title(chk_title);
				RequestListForm.setCurrent_pagecount(String.valueOf(page));
			}
			if (Error_code == null) {
				Error_code = "";
			}
			String book_manage = (String) Session.getAttribute("BOOK_MANAGE");
			if (book_manage == null) {
				book_manage = "";
			}
			RequestBookArray = RequestMgr.RequestBookListMgr(RequestListForm, book_manage);
			if (RequestMgr.getTempAraay().size() != 0) {
				RequestListForm = (BookRequestListForm) RequestMgr.getTempAraay().get(0);
			}
			if ((!Error_code.equals("")) && (Error_code != null)) {
				mav.addObject("error", Error_code);
			}
		} catch (Exception e) {
			this.LogMgr.error(e.getMessage());
		}
		mav.addObject("total_pagecount", String.valueOf(RequestListForm.getTotal_pagecount()));
		mav.addObject("current_pagecount", String.valueOf(RequestListForm.getCurrent_pagecount()));
		mav.addObject("pageGroupStart", String.valueOf(RequestListForm.getPageGroupStart()));
		mav.addObject("pageGroupEnd", String.valueOf(RequestListForm.getPageGroupEnd()));
		mav.addObject("width_page", String.valueOf(RequestListForm.getWidth_page()));
		mav.addObject("prev_page", String.valueOf(RequestListForm.getPrev_page()));
		mav.addObject("next_page", String.valueOf(RequestListForm.getNext_page()));
		mav.addObject("chk_name", RequestListForm.getChk_name());
		mav.addObject("chk_title", RequestListForm.getChk_title());
		mav.addObject("BookRequestListForm", RequestListForm);


		mav.addObject("RequestBookArray", RequestBookArray);
		mav.addObject("menu_id", "RequestTotalList");
		if (Session.getSession().getAttribute("MODE") != null) {
			if (Session.getSession().getAttribute("MODE").equals("search")) {
				//return map.findForward("Request_search");
				mav.setViewName("kolas3/UserService/ServiceBookRequestList");
				return mav;
			}
		}
		//return map.findForward("ListView");
		mav.setViewName("kolas3/UserService/ServiceBookRequestList");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
