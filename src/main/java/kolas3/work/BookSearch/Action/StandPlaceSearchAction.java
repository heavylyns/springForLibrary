package kolas3.work.BookSearch.Action;

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
import kolas3.work.BookSearch.Form.BuhoSearchForm;
import kolas3.work.BookSearch.Model.BuhoSearch;
import kolas3.work.BookSearch.Model.PlaceSearch;


@Controller
@RequestMapping(value="/kolas3")
public class StandPlaceSearchAction  {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (StandPlaceSearchAction.class);


	/* 자료 검색*/
	@RequestMapping(value="/book.searchSimple.do")
	public ModelAndView searchSimple(HttpServletRequest request,	HttpServletResponse response) throws Kolas3Exception {
		try {
			System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::들어오니");
			ModelAndView mav = new ModelAndView();
	
			response.setHeader("P3P", "CP=\"NOI CURa ADMa DEVa TAIa OUR DELa BUS IND PHY ONL UNI COM NAV INT DEM PRE\"");
			ArrayList placesearchlist = null;

			String type = "";
			if(request.getParameter("p_type") != "" && request.getParameter("p_type") != null){
				type = request.getParameter("p_type");
			}
			
			PlaceSearch place = new PlaceSearch();
			placesearchlist = place.placesearch();
			String menu_id = request.getParameter("menu_id");
			if ((menu_id != null) && (!menu_id.equals("")) && (menu_id != null)) {
				if (request.getParameter("menu_id").equals("detail")) {
					mav.addObject("menu_id", "search_detail");
				} else if (request.getParameter("menu_id").equals("new")) {
					mav.addObject("menu_id", "search_new");
				} else if (request.getParameter("menu_id").equals("simple")) {
					mav.addObject("menu_id", "search_simple");
				} else if (request.getParameter("menu_id").equals("junpa")) {
					mav.addObject("menu_id", "junpa");
				}
			}
			SessionManager Session = new SessionManager(request);
			Session.getSession().setAttribute("stand", "stand");
			Session.setMaxInterval(60000000);
			mav.addObject("search_result", placesearchlist);
	//
	

			if(!type.equals("pop")){
				mav.setViewName("kolas3/BookSearch/SearchDetailed"); // homepage  에서 iframe include 함.
				//mav.setViewName("kolas3/homepage/book/SearchDetailed");
				return mav;
			}else{
				mav.setViewName("kolas3/BookSearch/SearchDetailed_pop"); // homepage  에서 iframe include 함.
				//mav.setViewName("kolas3/homepage/book/SearchDetailed");
				return mav;
			}
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}

	}



	/* 대학부호검색*/
	@RequestMapping(value="/book.openuniv.do")
	public ModelAndView openuniv(HttpServletRequest request,	HttpServletResponse response) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("kolas3/BookSearch/openuniv");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}


	/* 대학부호검색*/
	@RequestMapping(value="/book.openunivsearch.do")
	public ModelAndView openunivsearch(HttpServletRequest request,	HttpServletResponse response , BuhoSearchForm form) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		ArrayList buhosearchlist = null;
		BuhoSearchForm buhosearchform = (BuhoSearchForm) form;
		BuhoSearch buho = new BuhoSearch();
		buhosearchlist = buho.buhosearch(buhosearchform);
		mav.addObject("search_result", buhosearchlist);
		//return mapping.findForward("search_result");
		mav.setViewName("kolas3/BookSearch/openuniv");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}

	}





	/* 기관부호검색*/
	@RequestMapping(value="/book.opengov.do")
	public ModelAndView opengov(HttpServletRequest request,	HttpServletResponse response) throws Kolas3Exception {
		try {
	ModelAndView mav = new ModelAndView();
		mav.setViewName("kolas3/BookSearch/opengov");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}

	/* 기관부호검색*/
	@RequestMapping(value="/book.opengovsearch.do")
	public ModelAndView opengovsearch(HttpServletRequest request,	HttpServletResponse response , BuhoSearchForm form) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		ArrayList buhosearchlist = null;
		BuhoSearchForm buhosearchform = (BuhoSearchForm) form;
		BuhoSearch buho = new BuhoSearch();
		buhosearchlist = buho.buhosearch(buhosearchform);
		mav.addObject("search_result", buhosearchlist);
		//return mapping.findForward("search_result");
		mav.setViewName("kolas3/BookSearch/opengov");
		return mav;
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}

	}

}
