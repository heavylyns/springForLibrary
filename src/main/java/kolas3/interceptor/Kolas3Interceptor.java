package kolas3.interceptor;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class Kolas3Interceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = Logger.getLogger(Kolas3Interceptor.class);
	// @Autowired
	// private CommonDAO dao;
	// public static final String RETURN_URL = "common/return";

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean flag = true;

		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		String mapData = getParameterMap(request);

		logger.info("");
		logger.info("");
		logger.info("======================================================================");
		logger.info("request.getContextPath(): " + request.getContextPath());
		logger.info("request.getRequestURI() : " + request.getRequestURI());
		logger.info("request.getParameterMap : " + mapData);
		logger.info("request.getRemoteAddr() : " + ipAddress);
		logger.info("======================================================================");
//		if ((request.getRequestURI().equals("/login/login.do")) || (request.getRequestURI().equals("/common/error.do"))
//				|| (request.getRequestURI().equals("/login/logOut.do"))) {
//			return true;
//		}
//		String userId = SessionUtil.getSesson(request, "USER_ID");
//		if (userId.equals("")) {
//			response.sendRedirect("/login/login.do");
//			flag = false;
//		} else {
//			// boolean b = SessionUtil.getFormOwnerChk(request,
//			// request.getRequestURI());
//			boolean b = true;
//			if (!b) {
//				response.sendRedirect("/common/error.do");
//				flag = false;
//			}
//		}
		return flag;
	}

	public String getParameterMap(HttpServletRequest request) {
		Map parameterMap = new HashMap();
		Enumeration enums = request.getParameterNames();
		while (enums.hasMoreElements()) {
			String paramName = (String) enums.nextElement();
			String[] parameters = request.getParameterValues(paramName);
			if (parameters.length > 1) {
				parameterMap.put(paramName, parameters);
			} else {
				parameterMap.put(paramName, parameters[0]);
			}
		}
		String str = parameterMap.toString();

		return str;
	}
}
