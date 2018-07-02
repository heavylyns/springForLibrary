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
public class MenuAction  {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

//	ECOLogManager Logger = new ECOLogManager();

//	public ActionForward guide(ActionMapping map, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) {
//		String menu_id = "";
//
//		menu_id = request.getParameter("menu_id");
//
//		System.out.println("menu_id:" + menu_id);
//		if (menu_id != null) {
//			if (menu_id.equals("")) {
//				mav.addObject("menu_id", menu_id);
//			}
//		}
//		return map.findForward("guide");
//	}
//
//	public ActionForward search(ActionMapping map, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) {
//		String menu_id = "";
//
//		menu_id = request.getParameter("menu_id");
//
//		System.out.println("menu_id:" + menu_id);
//		if (menu_id != null) {
//			mav.addObject("menu_id", menu_id);
//		}
//		return map.findForward("search");
//	}
//
//	public ActionForward info(ActionMapping map, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) {
//		int res = 0;
//		String view_type = "";
//		String board_table_name = "";
//		String mng_key = "";
//		String paging_str = "";
//
//		ArrayList info_list_arr = new ArrayList();
//
//		BookInfoList bookList = new BookInfoList();
//
//		String paging = "";
//		String totalCount = "";
//		String totalPage = "";
//		String curPage = "";
//		String menu_id = "";
//		String menu_num = "";
//		String page_num = "";
//
//		menu_id = request.getParameter("menu_id");
//		menu_num = request.getParameter("menu_num");
//		page_num = request.getParameter("page_num");
//
//		String keyword = "";
//		String chk_flag = "";
//		String orderby = "";
//		keyword = request.getParameter("keyword2");
//		chk_flag = request.getParameter("chk_flag");
//
//		System.out.println("menu_id=" + menu_id);
//
//		bookList.DBConnect();
//
//		BookInfoListForm bookInfoListForm = (BookInfoListForm) form;
//		if ((page_num == null) || (page_num.equals(""))) {
//			page_num = "1";
//		}
//		if ((menu_num == null) || (menu_num.equals(""))) {
//			menu_num = "9";
//		}
//		info_list_arr = bookList.ListEventBoard(menu_num, page_num, chk_flag, keyword, orderby);
//
//		paging_str = bookList.getPaging(menu_num, page_num, chk_flag, keyword);
//
//		StringTokenizer st = new StringTokenizer(paging_str, "*");
//		while (st.hasMoreTokens()) {
//			paging = st.nextToken();
//			totalCount = st.nextToken();
//			totalPage = st.nextToken();
//			curPage = st.nextToken();
//		}
//		mav.addObject("info_list_arr", info_list_arr);
//		mav.addObject("page_num", page_num);
//
//		mav.addObject("paging_str", paging);
//		if (menu_id != null) {
//			mav.addObject("menu_id", menu_id);
//			mav.addObject("menu_num", menu_num);
//		}
//		bookList.DBDisConnect();
//		return map.findForward("info");
//	}
//
//	public ActionForward event(ActionMapping map, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) {
//		int res = 0;
//		String view_type = "";
//		String board_table_name = "";
//		String mng_key = "";
//		String paging_str = "";
//
//		ArrayList event_list_arr = new ArrayList();
//		EventList eventList = new EventList();
//		BookInfoList bookList = new BookInfoList();
//
//		String paging = "";
//
//		String menu_id = "";
//		String menu_num = "";
//		String page_num = "";
//		menu_id = request.getParameter("menu_id");
//		menu_num = request.getParameter("menu_num");
//		page_num = request.getParameter("page_num");
//
//		String keyword = "";
//		String chk_flag = "";
//		String orderby = "";
//		keyword = request.getParameter("keyword2");
//		chk_flag = request.getParameter("chk_flag");
//
//		eventList.DBConnect();
//
//		EventListForm eventListForm = (EventListForm) form;
//		if ((page_num == null) || (page_num.equals(""))) {
//			page_num = "1";
//		}
//		if ((menu_num == null) || (menu_num.equals(""))) {
//			menu_num = "4";
//		}
//		System.out.println("메뉴넘버는?" + menu_num);
//		if (menu_num.equals("8")) {
//			event_list_arr = eventList.ListEventMovie(menu_num, page_num, chk_flag, keyword, orderby);
//		} else {
//			event_list_arr = eventList.ListEventBoard(menu_num, page_num, chk_flag, keyword, orderby);
//		}
//		paging_str = eventList.getPaging(menu_num, page_num, chk_flag, keyword);
//
//		StringTokenizer st = new StringTokenizer(paging_str, "*");
//		while (st.hasMoreTokens()) {
//			paging = st.nextToken();
//			String totalCount = st.nextToken();
//			String totalPage = st.nextToken();
//			String str1 = st.nextToken();
//		}
//		mav.addObject("event_list_arr", event_list_arr);
//		mav.addObject("page_num", page_num);
//
//		mav.addObject("paging_str", paging);
//		if (menu_num.equals("4")) {
//			mav.addObject("header_img", "<img src=/kolas3/images/LibraryEventImg/ti_04_1.gif>");
//		} else if (menu_num.equals("5")) {
//			mav.addObject("header_img", "<img src=/kolas3/images/LibraryEventImg/ti_04_2.gif>");
//		} else if (menu_num.equals("6")) {
//			mav.addObject("header_img", "<img src=/kolas3/images/LibraryEventImg/ti_04_3.gif>");
//		} else if (menu_num.equals("7")) {
//			mav.addObject("header_img", "<img src=/kolas3/images/LibraryEventImg/ti_04_4.gif>");
//		} else {
//			mav.addObject("header_img", "<img src=/kolas3/images/LibraryEventImg/ti_04_5.gif>");
//		}
//		eventList.DBDisConnect();
//		if (menu_id != null) {
//			mav.addObject("menu_id", menu_id);
//			mav.addObject("menu_num", menu_num);
//		}
//		return map.findForward("event");
//	}


/*
 *
  	<action   path="/menu_select"
  			      type="kolas3.work.WorkCommon.Action.MenuAction"
  			      parameter="method">

  	<forward name="guide"       path=".Layout_Guide"      />
  	<forward name="search"     path=".Layout_Search"    />
  	<forward name="info"           path=".Layout_Info"          />
  	<forward name="event"        path=".Layout_Event"       />
  	<forward name="service"     path="/iframe/UserService/ServiceLendCondition.jsp"   />
  	<forward name="member_join"     path="/iframe/UserService/ServiceMemberEntry.jsp"   />
  	<forward name="board"       path=".Layout_Board"     />
  	<forward name="request_search" path="/homepage/UserService/ServiceLendCondition.jsp"></forward>
  	</action>
 * */


	@RequestMapping(value="/user.menu_select.do")
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws Kolas3Exception {
		try {
	ModelAndView mav = new ModelAndView();
		SessionManager Session = new SessionManager(request);

		String menu_mode = "";
		String menu_id = "";
		if (request.getParameter("mode") != null) {
			menu_mode = request.getParameter("mode");
		}
		if (request.getParameter("menu_id") != null) {
			menu_id = request.getParameter("menu_id");
		}
		if (menu_id.equals("service_menu1")) {
			if ((Session.getAttribute("USER_NO") != null) && (!Session.getAttribute("USER_NO").equals(""))) {
				String user_no = (String) Session.getSession().getAttribute("USER_NO");

				//return new ActionForward("/LoanStatus.do", true);
				mav.setViewName("forward:kolas3/UserService/LoanStatus.do");
				return mav;
			}
			mav.addObject("path", "/menu_select.do?method=service&menu_id=service_menu1");
			mav.addObject("menu_id", "Login");

			//return map.findForward("service");
			mav.setViewName("kolas3/UserService/ServiceLendCondition");
			return mav;

		}
		System.out.println("!!!!!!!!!!!!!!!!!!" + menu_id);
		if (menu_id.equals("service_menu3")) {
			if ((Session.getAttribute("USER_NO") != null) && (!Session.getAttribute("USER_NO").equals(""))) {
				System.out.println("!!!!!!!!!!!!!!!!!!");
				//return new ActionForward("/RequestDataView.do", true);
				mav.setViewName("forward:/kolas3/user.RequestDataView.do");
				return mav;
			}
			mav.addObject("path", "/menu_select.do?method=service&menu_id=service_menu3");
			mav.addObject("menu_id", "Login");
			if (menu_mode.equals("search")) {
				Session.getSession().setAttribute("MODE", "search");
				//return map.findForward("request_search");
				mav.setViewName("kolas3/UserService/ServiceLendCondition");
				return mav;
			}
			//return map.findForward("service");
			mav.setViewName("kolas3/UserService/ServiceLendCondition");
			return mav;
		}
		if (menu_id.equals("service_menu2")) {
			mav.addObject("menu_id", "service_menu2");
			//return map.findForward("member_join");
			mav.setViewName("kolas3/UserService/ServiceMemberEntry");
			return mav;
		}
		if (menu_id != null) {
			mav.addObject("menu_id", menu_id);
		}
		//return map.findForward("service");
		mav.setViewName("kolas3/UserService/ServiceLendCondition");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}

//	public ActionForward board(ActionMapping map, ActionForm form, HttpServletRequest request,
//			HttpServletResponse response) {
//		String menu_id = "";
//
//		menu_id = request.getParameter("menu_id");
//
//		System.out.println("menu_id:" + menu_id);
//		if (menu_id != null) {
//			mav.addObject("menu_id", menu_id);
//		}
//		return map.findForward("board");
//	}
}
