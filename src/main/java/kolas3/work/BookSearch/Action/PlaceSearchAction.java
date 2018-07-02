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
import kolas3.work.BookSearch.Model.PlaceSearch;

@Controller
@RequestMapping(value = "/kolas3")
public class PlaceSearchAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (PlaceSearchAction.class);

	@RequestMapping(value="/book.searchNew.do")
	public ModelAndView  searchNew(HttpServletRequest request,HttpServletResponse response) throws Kolas3Exception {
		try {
		ModelAndView mav = new ModelAndView();
		ArrayList placesearchlist = null;

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
		mav.addObject("search_result", placesearchlist);

		mav.setViewName("kolas3/BookSearch/InfoNewData");
		return mav ; //mapping.findForward("search_result");
		} catch (Exception e) {
			logger.error("" + e);
			e.printStackTrace();
			throw new Kolas3Exception("");
		}
	}
}
