package com.chuncheonlib.kolas3.frame;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Kolas3BookFrame {

	private static String stx = "\002";
	private static String etx = "\003";


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList createGetNewArrivalsRequest() throws Exception{

		// create GetNewArrivals request frame
		String requestFrame = createGetNewArrivalsFrame();

		String quitFrame = Kolas3FrameCommon.setQuitFrame("AE116");

		ArrayList toReturn = new ArrayList();
		toReturn.add(requestFrame);
		toReturn.add(quitFrame);

		return toReturn;

	}

	public static String createGetNewArrivalsFrame() throws UnsupportedEncodingException{


		String returnFrame = "";

		// declaration of frame elements
		String head = "";
		String body = "";


		/************** FOR HEAD part 1 ******************/
		String command = "AE114";


		// head: command name
		head = head + String.format("%5s", new Object[] { command });

		// head: record count
		head = head + String.format("%5d", new Object[] { Integer.valueOf(1) });

		/************** FOR BODY *************************/
		// body: tag count
		int tagCount = 4;

		// tag 0: new book arrival start date
		String arrivalStartDate = "20160101";
		int tag0Length = arrivalStartDate.length();

		// tag 1: new book arrival end date
		String arrivalEndDate = "20161231";
		int tag1Length = arrivalEndDate.length();

		// tag 2: management classification
		String mngmntClass = "0";
		int tag2Length = mngmntClass.length();

		// tag 3: max number of search result items
		String maxItemCount = "10";
		int tag3Length = maxItemCount.length();

		// add tag count
		body += String.format("%4d", new Object[] { Integer.valueOf(tagCount) });

		// --- tag 0
		body += String.format("%5d", new Object[] { Integer.valueOf(tag0Length) }); //tag 0 length
		body += String.format(arrivalStartDate, new Object[0]);

		// -- tag 1
		body += String.format("%5d", new Object[] { Integer.valueOf(tag1Length)});
		body += String.format(arrivalEndDate, new Object[0]);

		// -- tag 2
		body += String.format("%5d", new Object[] { Integer.valueOf(tag2Length)});
		body += String.format(new String(mngmntClass.getBytes("UTF-8"), "UTF-8"), new Object[0]);

		// -- tag 3
		body += String.format("%5d", new Object[] { Integer.valueOf(tag3Length)});
		body += String.format(maxItemCount, new Object[0]);

		/************** FOR HEAD part 2 ******************/
		// get length of body
		String bodyLength = String.format("%6d", new Object[] { Integer.valueOf(body.getBytes("UTF-8").length) });

		head += bodyLength;

		/*************** ADDING UP ************************/
		String tempFrame = stx + head + body + etx;

		returnFrame = new String(tempFrame.getBytes("UTF-8"), "UTF-8");

		return returnFrame;
	}

	public static ArrayList createGetBestLendingRequest() throws Exception{
		ArrayList toReturn = new ArrayList();
		
		String requestFrame = createGetBestLendingFrame();
		String quitFrame = Kolas3FrameCommon.setQuitFrame("AE111");
		
		toReturn.add(requestFrame);
		toReturn.add(quitFrame);


		return toReturn;
	}

	public static String createGetBestLendingFrame() throws UnsupportedEncodingException{

		String returnFrame = "";

		// declaration of frame elements
		String head = "";
		String body = "";


		/************** FOR HEAD part 1 ******************/
		String command = "AE111";

		// head: command name
		head = head + String.format("%5s", new Object[] { command });

		// head: record count
		head = head + String.format("%5d", new Object[] { Integer.valueOf(1) });

		/************** FOR BODY *************************/
		// body: tag count
		int tagCount = 4;

		// tag 0: new book arrival start date
		String arrivalStartDate = "20160101";
		int tag0Length = arrivalStartDate.length();

		// tag 1: new book arrival end date
		String arrivalEndDate = "20161231";
		int tag1Length = arrivalEndDate.length();

		// tag 2: management classification
		String mngmntClass = "0";
		int tag2Length = mngmntClass.length();

		// tag 3: max number of search result items
		String maxItemCount = "10";
		int tag3Length = maxItemCount.length();

		// add tag count
		body += String.format("%4d", new Object[] { Integer.valueOf(tagCount) });

		// --- tag 0
		body += String.format("%5d", new Object[] { Integer.valueOf(tag0Length) }); //tag 0 length
		body += String.format(arrivalStartDate, new Object[0]);

		// -- tag 1
		body += String.format("%5d", new Object[] { Integer.valueOf(tag1Length)});
		body += String.format(arrivalEndDate, new Object[0]);

		// -- tag 2
		body += String.format("%5d", new Object[] { Integer.valueOf(tag2Length)});
		body += String.format(new String(mngmntClass.getBytes("UTF-8"), "UTF-8"), new Object[0]);

		// -- tag 3
		body += String.format("%5d", new Object[] { Integer.valueOf(tag3Length)});
		body += String.format(maxItemCount, new Object[0]);

		/************** FOR HEAD part 2 ******************/
		// get length of body
		String bodyLength = String.format("%6d", new Object[] { Integer.valueOf(body.getBytes("UTF-8").length) });

		head += bodyLength;

		/*************** ADDING UP ************************/
		String tempFrame = stx + head + body + etx;

		returnFrame = new String(tempFrame.getBytes("UTF-8"), "UTF-8");

		return returnFrame;

	}
	
	public static ArrayList createGetListOfBorrowedBooksRequest() throws Exception{
		ArrayList toReturn = new ArrayList();
		
		String requestFrame = createGetListOfBorrowedBooksFrame();
		String quitFrame = Kolas3FrameCommon.setQuitFrame("AE120");
		
		return toReturn;
	}
	
	public static String createGetListOfBorrowedBooksFrame() throws UnsupportedEncodingException{
		
		String returnFrame = "";

		// declaration of frame elements
		String head = "";
		String body = "";


		/************** FOR HEAD part 1 ******************/
		String command = "AE120";

		// head: command name
		head = head + String.format("%5s", new Object[] { command });

		// head: record count
		head = head + String.format("%5d", new Object[] { Integer.valueOf(1) });

		/************** FOR BODY *************************/
		// body: tag count
		int tagCount = 4;

		// tag 0: borrow period start date
		String borrowStartDate = "20160101";
		int tag0Length = borrowStartDate.length();

		// tag 1: borrow period end date
		String borrowEndDate = "20161231";
		int tag1Length = borrowEndDate.length();

		// tag 2: management classification
		String mngmntClass = "0";
		int tag2Length = mngmntClass.length();

		// tag 3: username
		String username = "10";
		int tag3Length = username.length();

		// add tag count
		body += String.format("%4d", new Object[] { Integer.valueOf(tagCount) });

		// --- tag 0
		body += String.format("%5d", new Object[] { Integer.valueOf(tag0Length) }); //tag 0 length
		body += String.format(borrowStartDate, new Object[0]);

		// -- tag 1
		body += String.format("%5d", new Object[] { Integer.valueOf(tag1Length)});
		body += String.format(borrowEndDate, new Object[0]);

		// -- tag 2
		body += String.format("%5d", new Object[] { Integer.valueOf(tag2Length)});
		body += String.format(new String(mngmntClass.getBytes("UTF-8"), "UTF-8"), new Object[0]);

		// -- tag 3
		body += String.format("%5d", new Object[] { Integer.valueOf(tag3Length)});
		body += String.format(username, new Object[0]);

		/************** FOR HEAD part 2 ******************/
		// get length of body
		String bodyLength = String.format("%6d", new Object[] { Integer.valueOf(body.getBytes("UTF-8").length) });

		head += bodyLength;

		/*************** ADDING UP ************************/
		String tempFrame = stx + head + body + etx;

		returnFrame = new String(tempFrame.getBytes("UTF-8"), "UTF-8");

		return returnFrame;
		
	}
	

}
