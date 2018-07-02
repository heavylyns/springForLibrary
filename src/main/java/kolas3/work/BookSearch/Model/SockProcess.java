package kolas3.work.BookSearch.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kolas3.Kolas3Properties;
import kolas3.common.xml.Parser;
import kolas3.work.BookSearch.Action.SearchAction;

public class SockProcess {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());// (SockProcess.class);
	Socket sock;
	OutputStream out = null;
	InputStream in = null;
	PrintWriter pw = null;
	BufferedReader br = null;
	InputStreamReader isr = null;
	OutputStreamWriter osw = null;
	String CharSet = "UTF-8";
	long SetTimeOut = 1L;
	long SetStartTime = System.currentTimeMillis();

	public String searchsock(String frame, String quitframe) throws UnknownHostException, IOException {
		//Parser parser = new Parser(Kolas3Properties.getXml_socket_path());
		Parser parser = new Parser(Kolas3Properties.getXml_socket_path());

		parser.setValue("ip");
		String ip = parser.getValue();
		parser.setValue("port");
		int port = Integer.parseInt(parser.getValue());
		String AnalizeBeforeData = "";

		logger.info("PUT-DATA:" + frame);
		logger.info("PUT-DATA:" + quitframe);
		try {
			String AckNak = "";
			String temp = "";
			String str = "";
			this.sock = new Socket(ip, port);
			this.sock.setSoTimeout(10000000);
			this.out = this.sock.getOutputStream();
			this.osw = new OutputStreamWriter(this.out, this.CharSet);
			this.pw = new PrintWriter(this.osw);
			
			// send to kolas server
			this.pw.println(frame);
			this.pw.flush();
			
			// open input stream and wait for response
			this.in = this.sock.getInputStream();
			this.isr = new InputStreamReader(this.in, this.CharSet);
			this.br = new BufferedReader(this.isr);
			
			// read data from the input stream
			for (int i = 0; i < 5; i++) {
				AckNak = AckNak + (char) this.br.read();
			}
			
			// if server sent an acknowledgment
			// if compareTo results to zero, then it means they are equal
			// \002CW\025
			if (AckNak.compareTo("\002CW\025\003") == 0) {
				str = "\002W\006\003";
				
				// temp is empty string + AckNak
				temp = temp + AckNak;
				
				
				this.pw.println(temp);
				this.pw.flush();
			} else {
				
				str = "";
				this.pw.println(str);
				this.pw.flush();
			}
			
			
			String getData = "";
			int st = 0;
			int TimeOut = 0;
			
			while (this.br != null) {
				// read from input stream
				String tmp = "" + (char) this.br.read();
				st++;
				// \003 is ETX (or end of frame)
				if (tmp.compareTo("\003") == 0) {
					// if ended, send a W ACK frame (this means that all data has been received)
					getData = getData + tmp;
					temp = "\002W\006\003";
					this.pw.println(temp);
					this.pw.flush();
					break;
				}
				getData = getData + tmp;
			}
			AnalizeBeforeData = getData;
			if (!quitframe.equals("202")) {
				this.pw.println(quitframe);
				if (this.pw != null) {
					this.pw.close();
				}
				if (this.br != null) {
					this.br.close();
				}
				if (this.sock != null) {
					this.sock.close();
				}
			}
		} catch (ConnectException e) {
			e.printStackTrace();
			logger.error("", e);
			return "-31";
		} catch (UnknownHostException e) {
			e.printStackTrace();
			logger.error("", e);
			return "-32";
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("", e);
			return "-33";
		}
		logger.info("OUT-DATA:" + AnalizeBeforeData);
		return AnalizeBeforeData;
	}

	
	public ArrayList detailviewsock(String frame202, String quitframe) throws UnknownHostException, IOException {
		ArrayList AnalizeBeforeData = new ArrayList();
		try {
			String getData = searchsock(frame202, "202");
			AnalizeBeforeData.add(getData);
			logger.debug(getData);
			String temp = "";
			temp = "";

			getData = "";
			int st = 0;
			while (this.br != null) {
				String tmp = "" + (char) this.br.read();
				st++;
				if (tmp.compareTo("\003") == 0) {
					getData = getData + tmp;
					temp = "\002W\006\003";
					this.pw.println(temp);
					this.pw.flush();
					break;
				}
				getData = getData + tmp;
			}
			AnalizeBeforeData.add(getData);

			this.pw.println(quitframe);
			if (this.pw != null) {
				this.pw.close();
			}
			if (this.br != null) {
				this.br.close();
			}
			if (this.sock != null) {
				this.sock.close();
			}
		} catch (ConnectException e) {
			logger.error("-31");
		} catch (UnknownHostException e) {
			logger.error("-32");
		} catch (IOException e) {
			logger.error(e.getMessage());
			logger.error("-33");
		}
		return AnalizeBeforeData;
	}

	// for other kinds of socks
	public String pro3sock(String frame207, String quitframe) throws UnknownHostException, IOException {
		Parser parser = new Parser(Kolas3Properties.getXml_socket_path());
		parser.setValue("ip");
		String ip = parser.getValue();
		parser.setValue("port");
		int port = Integer.parseInt(parser.getValue());
		String AnalizeBeforeData = "";
		
		try {
			String AckNak = "";
			String temp = "";
			String str = "";
			Socket sock = new Socket(ip, port);
			sock.setSoTimeout(10000);
			
			// create an output stream
			this.out = sock.getOutputStream(); // output stream
			this.osw = new OutputStreamWriter(this.out, this.CharSet); // outputstream writer
			this.pw = new PrintWriter(this.osw); // print writer
			
			// frame 207 also includes other frame types, according to the documentation (single data frame response only!)
			this.pw.println(frame207);
			this.pw.flush();

			// create input stream for receiving packets from the server
			this.in = sock.getInputStream();     // input stream reader from a socket/port
			this.isr = new InputStreamReader(this.in, this.CharSet);  // input stream reader
			this.br = new BufferedReader(this.isr); // buffered reader for getting packets from the KOLAS server
			
			for (int i = 0; i < 5; i++) {
				AckNak = AckNak + (char) this.br.read();
			}
			
			// what is STX | C | W | \025 | ETX ??
			if (AckNak.compareTo("\002CW\025\003") == 0) {
				str = "\002W\006\003"; // ACK Frame
				temp = temp + AckNak; // temp is initially blank
				
				// send W ACK frame
				this.pw.println(temp);
				this.pw.flush();
			} else {
				str = "";
				
				// send an empty frame?
				this.pw.println(str);
				this.pw.flush();
			}
			
			// getData holds the "frame" returned from the KOLAS server
			String getData = "";
			int st = 0;
			int TimeOut = 0;
			
			
			while (this.br != null) {
				// read character by character the frame sent by KOLAS server
				String tmp = "" + (char) this.br.read();
				st++;
				
				// 003 is ETX (end of frame indicator)
				// if it is the end frame,
				if (tmp.compareTo("\003") == 0) {
					getData = getData + tmp;
					temp = "\002W\006\003";
					
					// if ended, send a W ACK frame (this means that all data has been received)
					this.pw.println(temp);
					break;
				}
				getData = getData + tmp;
			}
			
			// AnalizeBeforeData is the "frame" received from KOLAS server
			AnalizeBeforeData = getData;

			// send a quit frame
			this.pw.println(quitframe);
			
			// close the IO streams (print writers and buffered readers)
			if (this.pw != null) {
				this.pw.close();
			}
			if (this.br != null) {
				this.br.close();
			}
			if (sock != null) {
				sock.close();
			}
		} catch (ConnectException e) {
			return "-31";
		} catch (UnknownHostException e) {
			return "-32";
		} catch (IOException e) {
			return "-33";
		}
		return AnalizeBeforeData;
	}
}
