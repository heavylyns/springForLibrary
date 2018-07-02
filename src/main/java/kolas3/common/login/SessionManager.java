package kolas3.common.login;

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {
	private HttpSession Session;
	private HttpServletRequest request;

	public SessionManager(HttpServletRequest T_request) {
		this.request = T_request;
		this.Session = T_request.getSession();
	}

	public HttpServletRequest getRequest() {
		return this.request;
	}

	public HttpSession getSession() {
		return this.Session;
	}

	public Enumeration getAttributeNames() {
		return this.Session.getAttributeNames();
	}

	public Object getAttribute(String attributeName) {
		return this.Session.getAttribute(attributeName);
	}

	public long getCreationTime() {
		return this.Session.getCreationTime();
	}

	public long getLastRequest() {
		return this.Session.getLastAccessedTime();
	}

	public int getMaxInterval() {
		return this.Session.getMaxInactiveInterval();
	}

	public void setMaxInterval(int Seconds) {
		this.Session.setMaxInactiveInterval(Seconds);
	}

	public String getSessionID() {
		return this.Session.getId();
	}

	public boolean isSessionCheck() {
		if (this.Session.isNew()) {
			return true;
		}
		return false;
	}

	public void SessionExit() {
		this.Session.invalidate();
	}
}
