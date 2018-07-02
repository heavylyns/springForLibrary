package kolas3.work.BookSearch.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Http {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String EndLine = "\n";
	private String SockIP;
	private int SockPort;
	private String SockSendURL;
	private String Method = "POST";
	private String Parameter = "";
	private String CookieInfo = "";
	private boolean CookieYN = false;
	private Socket Sock = null;
	private OutputStream out = null;
	private InputStream in = null;
	private PrintWriter pw = null;
	private BufferedReader br = null;
	private InputStreamReader isr = null;
	private OutputStreamWriter osw = null;
	public String Result = "";
	public String HeaderCookieInfo = "";
	private String CharSet = "EUC-KR";

	private void setURLInfo(String URLInfo, String Parameter, String Method, String CharSet, String CookieInfo,
			boolean CookieYN) {
		try {
			URL url = new URL(URLInfo);

			this.SockIP = url.getHost();

			this.SockPort = 80;
			if (url.getPort() != -1) {
				this.SockPort = url.getPort();
			}
			this.SockSendURL = url.getPath();

			this.Parameter = Parameter;

			this.Method = Method;

			this.CharSet = CharSet;

			this.CookieYN = CookieYN;
			if (this.CookieYN) {
				this.SockSendURL = "/";
				this.Parameter = "";
				this.Method = "GET";

				int ids = 0;
				ids = SockProcess();
				this.Result = "";
				if (ids == 0) {
					this.CookieInfo = this.HeaderCookieInfo;
				}
				logger.debug("[변경된 SockSEndURL]" + this.SockSendURL);
				logger.debug("[변경된 Parameter]" + this.Parameter);
				logger.debug("[변경된 Method]" + this.Method);
				logger.debug("[변경된 Cookie]" + this.CookieInfo);

				this.SockSendURL = url.getPath();
				this.Parameter = Parameter;
				this.Method = Method;

				ids = SockProcess();

				this.Result = "";
			} else {
				this.CookieInfo = CookieInfo;
			}
		} catch (Exception localException) {
		}
	}

	private Socket SocketInit() throws IOException {
		this.Sock = new Socket(this.SockIP, this.SockPort);

		this.Sock.setSoTimeout(30000);

		return this.Sock;
	}

	private OutputStream OutStream() throws IOException {
		this.out = this.Sock.getOutputStream();
		return this.out;
	}

	private InputStream InStream() throws IOException {
		this.in = this.Sock.getInputStream();
		return this.in;
	}

	private PrintWriter PrWriter() throws UnsupportedEncodingException {
		this.pw = new PrintWriter(OutputStmWriter());
		return this.pw;
	}

	private BufferedReader BufReader() throws UnsupportedEncodingException {
		this.br = new BufferedReader(InputStmReader());
		return this.br;
	}

	private InputStreamReader InputStmReader() throws UnsupportedEncodingException {
		this.isr = new InputStreamReader(this.in, this.CharSet);
		return this.isr;
	}

	private OutputStreamWriter OutputStmWriter() throws UnsupportedEncodingException {
		this.osw = new OutputStreamWriter(this.out, this.CharSet);
		return this.osw;
	}

	private void sPuts(String Msg) {
		this.pw.println(Msg);
	}

	private void sFlush() {
		this.pw.flush();
	}

	private String sRead() throws IOException {
		return String.valueOf(this.br.read());
	}

	private String sReadLine() throws IOException {
		return this.br.readLine();
	}

	private void setClose() throws IOException {
		if (this.pw != null) {
			this.pw.close();
		}
		if (this.br != null) {
			this.br.close();
		}
		if (this.Sock != null) {
			this.Sock.close();
		}
	}

	private String HttpHeaderInfo() {
		String Header = "";
		if (this.Method.equals("POST")) {
			try {
				Header = "POST " + this.SockSendURL + " HTTP/1.0" + this.EndLine;
				Header = Header + "Accept-Language: ko" + this.EndLine;
				Header = Header + "Content-Type: application/x-www-form-urlencoded" + this.EndLine;
				Header = Header + "Accept-Encoding: gzip, deflate" + this.EndLine;
				Header = Header + "User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727)"
						+ this.EndLine;
				Header = Header + "Host: " + this.SockIP + ":" + this.SockPort + this.EndLine;
				Header = Header + "Content-Length: " + this.Parameter.getBytes("EUC-KR").length + this.EndLine;
				Header = Header + "Connection: Close" + this.EndLine;
				Header = Header + "Cache-Control: no-cache" + this.EndLine;
				if (this.CookieInfo.length() > 1) {
					Header = Header + "Cookie: " + this.CookieInfo + this.EndLine;
				}
				Header = Header + this.EndLine;
				Header = Header + this.Parameter;
				Header = Header + this.EndLine + this.EndLine;
			} catch (UnsupportedEncodingException localUnsupportedEncodingException) {
			}
		} else {
			Header = "GET " + this.SockSendURL + " HTTP/1.1" + this.EndLine;
			Header = Header + "Accept: */*" + this.EndLine;
			Header = Header + "Accept-Language: ko" + this.EndLine;
			Header = Header + "Accept-Encoding: gzip, deflate" + this.EndLine;
			Header = Header + "User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727)"
					+ this.EndLine;
			Header = Header + "Host: " + this.SockIP + ":" + this.SockPort + this.EndLine;
			Header = Header + "Connection: Close" + this.EndLine;
			if (this.CookieInfo.length() > 1) {
				Header = Header + "Cookie: " + this.CookieInfo + this.EndLine;
			}
			Header = Header + this.EndLine + this.EndLine;
		}
		return Header;
	}

	private int SockProcess() {
		String line = null;
		boolean cookie_flag = false;
		try {
			SocketInit();

			OutStream();

			InStream();

			PrWriter();

			sPuts(HttpHeaderInfo());

			logger.debug(HttpHeaderInfo());

			sFlush();

			BufReader();

			boolean flag = false;
			while ((line = sReadLine()) != null) {
				if (this.CookieYN) {
					if (cookie_flag) {
						break;
					}
					cookie_flag = HttpCookieInfo(line);
					// break label79;

				}
				if (line.length() == 0) {
					flag = true;
				}
				if (flag) {
					this.Result = (this.Result + line + "\n");
				}
			}
			setClose();
		} catch (ConnectException e) {
			return -31;
		} catch (UnknownHostException e) {
			return -32;
		} catch (IOException e) {
			return -33;
		}
		return 0;
	}

	public String HttpRequest(String URLInfo, String Parameter, String Method, String CharSet, String CookieInfo,
			boolean CookieYN) {
		int ids = 0;

		setURLInfo(URLInfo, Parameter, Method, CharSet, CookieInfo, CookieYN);

		logger.debug("\n--------------------------------\n");
		logger.debug("아이피 : " + this.SockIP);
		logger.debug("포트 : " + this.SockPort);
		logger.debug("파라미트 : " + this.Parameter);
		logger.debug("메소드 : " + this.Method);
		logger.debug("언어:" + this.CharSet);
		logger.debug("쿠기:" + this.CookieInfo);
		logger.debug("\n--------------------------------\n");
		logger.debug(HttpHeaderInfo());

		ids = SockProcess();

		return this.Result;
	}

	public boolean HttpCookieInfo(String tmpData) {
		boolean flag = false;
		try {
			String[] CookieInfoH1 = tmpData.split("Set-Cookie: ");
			if ((CookieInfoH1[1] != null) && (!CookieInfoH1[1].equals("")) && (CookieInfoH1[1].length() > 1)) {
				flag = true;

				this.HeaderCookieInfo = CookieInfoH1[1];
			}
		} catch (Exception localException) {
		}
		return flag;
	}
}
