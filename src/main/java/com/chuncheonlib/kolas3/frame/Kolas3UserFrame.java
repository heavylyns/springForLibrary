package com.chuncheonlib.kolas3.frame;

import java.util.ArrayList;
import java.util.Date;

import com.chuncheonlib.kolas3.model.UserModel;

import java.io.UnsupportedEncodingException;

public class Kolas3UserFrame {

	private static String stx = "\002";
	private static String etx = "\003";

	/**
	 * Returns a register user frame and the corresponding quit frame.
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static ArrayList createRegisterFrameRequest(UserModel user) throws Exception{

		// create user frame
		String userFrame = createRegisterUserFrame(user);

		// create quit frame
		String quitFrame = Kolas3FrameCommon.setQuitFrame("AE114");

		ArrayList toReturn = new ArrayList();

		// add the user frame and the quit frame to the return object
		toReturn.add(userFrame);
		toReturn.add(quitFrame);

		return toReturn;
	}
	
	
	/**
	 * Creates an ArrayList of edit frame and the corresponding quit frame.
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public static ArrayList createEditFrameRequest(UserModel user) throws Exception{

		// create user frame
		String userFrame = createEditUserFrame(user);

		// create quit frame
		String quitFrame = Kolas3FrameCommon.setQuitFrame("AE115");

		ArrayList toReturn = new ArrayList();

		// add the user frame and the quit frame to the return object
		toReturn.add(userFrame);
		toReturn.add(quitFrame);

		return toReturn;
	}
	


	/**
	 * Creates a register user frame.
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String createRegisterUserFrame(UserModel user) throws UnsupportedEncodingException{

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
		int tagCount = 10;

		// tag 0: username
		String username = user.getUsername();
		int tag0Length = username.length();

		// tag 1: password
		String password = user.getPassword();
		int tag1Length = password.length();

		// tag 2: name
		String name = user.getName();
		int tag2Length = name.length();

		// tag 3: email address
		String emailAdd = user.getEmailAdd();
		int tag3Length = emailAdd.length();

		// tag 4: phone number
		String phoneNo = user.getPhoneNumber();
		int tag4Length = phoneNo.length();

		// tag 5: mobile number
		String mobileNo = user.getMobileNumber();
		int tag5Length = mobileNo.length();

		// tag 6: address
		String address = user.getAddressLine1() + " " + user.getAddressLine2();
		int tag6Length = address.length();

		// tag 7: CI flag
		String CiFlag = "";
		int tag7Length = 0;

		// tag 8: gender
		String gender = user.getGender();
		int genderInInt = gender.equals("M") ? 0 : 1;
		int tag8Length = 1;

		// tag 9: birthdate YYYYMMDD
		String birthdate = user.getBirthdate();
		String dateString = birthdate;
		int tag9Length = dateString.length();

		// tag 10: zip code
		String zipCode = user.getZipcode();
		String zipCodeString = "" + zipCode;
		int tag10Length = zipCodeString.length();

		// add tags 0 to 10 body frame
		body += String.format("%4d", new Object[] { Integer.valueOf(tagCount) });

		// --- tag 0
		body += String.format("%5d", new Object[] { Integer.valueOf(tag0Length) }); //tag 0 length
		body += String.format(username, new Object[0]);

		// -- tag 1
		body += String.format("%5d", new Object[] { Integer.valueOf(tag1Length)});
		body += String.format(password, new Object[0]);

		// -- tag 2
		body += String.format("%5d", new Object[] { Integer.valueOf(tag2Length)});
		body += String.format(new String(name.getBytes("UTF-8"), "UTF-8"), new Object[0]);

		// -- tag 3
		body += String.format("%5d", new Object[] { Integer.valueOf(tag3Length)});
		body += String.format(emailAdd, new Object[0]);

		// -- tag 4 
		body += String.format("%5d", new Object[] { Integer.valueOf(tag4Length)});
		body += String.format(phoneNo, new Object[0]);

		// -- tag 5
		body += String.format("%5d", new Object[] { Integer.valueOf(tag5Length)});
		body += String.format(mobileNo, new Object[0]);

		// -- tag 6
		body += String.format("%5d", new Object[] { Integer.valueOf(tag6Length)});
		body += String.format(new String(address.getBytes("UTF-8"), "UTF-8"), new Object[0]);

		// -- tag 7
		body += String.format("%5d", new Object[] { Integer.valueOf(tag7Length)});

		// -- tag 8
		body += String.format("%5d", new Object[] { Integer.valueOf(tag8Length)});
		body += String.format(Integer.toString(genderInInt), new Object[0]);

		// -- tag 9
		body += String.format("%5d", new Object[] { Integer.valueOf(tag9Length)});
		body += String.format(new String(dateString.getBytes("UTF-8"), "UTF-8"), new Object[0]);

		// -- tag 10
		body += String.format("%5d", new Object[] { Integer.valueOf(tag10Length)});
		body += String.format(zipCode, new Object[0]);


		/************** FOR HEAD part 2 ******************/
		// get length of body
		String bodyLength = String.format("%6d", new Object[] { Integer.valueOf(body.getBytes("UTF-8").length) });

		head += bodyLength;

		/*************** ADDING UP ************************/
		String tempFrame = stx + head + body + etx;

		returnFrame = new String(tempFrame.getBytes("UTF-8"), "UTF-8");

		return returnFrame;
	}

	/**
	 * Creates an edit user frame.
	 * @param user
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String createEditUserFrame(UserModel user) throws UnsupportedEncodingException{

		String returnFrame = "";

		// declaration of frame elements
		String head = "";
		String body = "";


		/************** FOR HEAD part 1 ******************/
		String command = "AE115";


		// head: command name
		head = head + String.format("%5s", new Object[] { command });

		// head: record count
		head = head + String.format("%5d", new Object[] { Integer.valueOf(1) });

		/************** FOR BODY *************************/
		// body: tag count
		int tagCount = 10;

		// tag 0: username
		String username = user.getUsername();
		int tag0Length = username == null ? 0 : username.length();

		// tag 1: password
		String password = user.getPassword();
		int tag1Length = password == null ? 0 : password.length();

		// tag 2: name
		String name = user.getName();
		int tag2Length = name == null ? 0 : name.length();

		// tag 3: email address
		String emailAdd = user.getEmailAdd();
		int tag3Length = emailAdd == null ? 0 : emailAdd.length();

		// tag 4: phone number
		String phoneNo = user.getPhoneNumber();
		int tag4Length = phoneNo == null ? 0 : phoneNo.length();

		// tag 5: mobile number
		String mobileNo = user.getMobileNumber();
		int tag5Length = mobileNo == null ? 0 : mobileNo.length();

		// tag 6: address
		String address = user.getAddressLine1() + " " + user.getAddressLine2();
		int tag6Length = address == null ? 0 : address.length();

		// tag 7: CI flag
		String CiFlag = "";
		int tag7Length = 0;

		// tag 8: gender
		String gender = user.getGender();
		int genderInInt = gender.equals("M") ? 0 : 1;
		int tag8Length = 1;

		// tag 9: birthdate YYYYMMDD
		String birthdate = user.getBirthdate();
		String dateString = birthdate;
		int tag9Length = dateString.length();

		// tag 10: zip code
		String zipCode = user.getZipcode();
		String zipCodeString = "" + zipCode;
		int tag10Length = zipCodeString.length();

		// add tags 0 to 10 body frame
		body += String.format("%4d", new Object[] { Integer.valueOf(tagCount) });

		// --- tag 0
		body += String.format("%5d", new Object[] { Integer.valueOf(tag0Length) }); //tag 0 length
		body += String.format(username, new Object[0]);

		// -- tag 1
		body += String.format("%5d", new Object[] { Integer.valueOf(tag1Length)});
		body += String.format(password, new Object[0]);

		// -- tag 2
		body += String.format("%5d", new Object[] { Integer.valueOf(tag2Length)});
		body += String.format(new String(name.getBytes("UTF-8"), "UTF-8"), new Object[0]);

		// -- tag 3
		body += String.format("%5d", new Object[] { Integer.valueOf(tag3Length)});
		body += String.format(emailAdd, new Object[0]);

		// -- tag 4 
		body += String.format("%5d", new Object[] { Integer.valueOf(tag4Length)});
		body += String.format(phoneNo, new Object[0]);

		// -- tag 5
		body += String.format("%5d", new Object[] { Integer.valueOf(tag5Length)});
		body += String.format(mobileNo, new Object[0]);

		// -- tag 6
		body += String.format("%5d", new Object[] { Integer.valueOf(tag6Length)});
		body += String.format(new String(address.getBytes("UTF-8"), "UTF-8"), new Object[0]);

		// -- tag 7
		body += String.format("%5d", new Object[] { Integer.valueOf(tag7Length)});

		// -- tag 8
		body += String.format("%5d", new Object[] { Integer.valueOf(tag8Length)});
		body += String.format(Integer.toString(genderInInt), new Object[0]);

		// -- tag 9
		body += String.format("%5d", new Object[] { Integer.valueOf(tag9Length)});
		body += String.format(new String(dateString.getBytes("UTF-8"), "UTF-8"), new Object[0]);

		// -- tag 10
		body += String.format("%5d", new Object[] { Integer.valueOf(tag10Length)});
		body += String.format(zipCode, new Object[0]);


		/************** FOR HEAD part 2 ******************/
		// get length of body
		String bodyLength = String.format("%6d", new Object[] { Integer.valueOf(body.getBytes("UTF-8").length) });

		head += bodyLength;

		/*************** ADDING UP ************************/
		String tempFrame = stx + head + body + etx;

		returnFrame = new String(tempFrame.getBytes("UTF-8"), "UTF-8");

		return returnFrame;
	}
	
	public static ArrayList createIForgotUsernameRequest(UserModel user) throws Exception{
		ArrayList toReturn = new ArrayList();
		
		String requestFrame = createIForgotUsernameFrame(user);
		String quitFrame = Kolas3FrameCommon.setQuitFrame("AE113");
		
		toReturn.add(requestFrame);
		toReturn.add(quitFrame);
		
		return toReturn;
	}
	
	
	public static String createIForgotUsernameFrame(UserModel user) throws UnsupportedEncodingException{
		
		String returnFrame = "";

		// declaration of frame elements
		String head = "";
		String body = "";


		/************** FOR HEAD part 1 ******************/
		String command = "AE113";


		// head: command name
		head = head + String.format("%5s", new Object[] { command });

		// head: record count
		head = head + String.format("%5d", new Object[] { Integer.valueOf(1) });

		/************** FOR BODY *************************/
		// body: tag count
		int tagCount = 7;

		// tag 0: username
		String username = user.getUsername();
		int tag0Length = username.length();

		// tag 1: email address
		String emailAdd = user.getEmailAdd();
		int tag1Length = emailAdd.length();

		// tag 2: familyID
		String familyID = "";
		int tag2Length = familyID.length();

		// tag 3: family id rec_key
		String familyIdRecKey = "";
		int tag3Length = familyIdRecKey.length();

		// tag 4: national id no
		String nationalIdNo = "";
		int tag4Length = nationalIdNo.length();

		// tag 5: mobile number
		String mobileNo = user.getMobileNumber();
		int tag5Length = mobileNo.length();

		// tag 6: name
		String name = user.getName();
		int tag6Length = name.length();

		// add tags 0 to 10 body frame
		body += String.format("%4d", new Object[] { Integer.valueOf(tagCount) });

		// --- tag 0
		body += String.format("%5d", new Object[] { Integer.valueOf(tag0Length) }); //tag 0 length
		body += String.format(username, new Object[0]);

		// -- tag 1
		body += String.format("%5d", new Object[] { Integer.valueOf(tag1Length)});
		body += String.format(emailAdd, new Object[0]);

		// -- tag 2
		body += String.format("%5d", new Object[] { Integer.valueOf(tag2Length)});
		body += String.format(new String(familyID.getBytes("UTF-8"), "UTF-8"), new Object[0]);

		// -- tag 3
		body += String.format("%5d", new Object[] { Integer.valueOf(tag3Length)});
		body += String.format(familyIdRecKey, new Object[0]);

		// -- tag 4 
		body += String.format("%5d", new Object[] { Integer.valueOf(tag4Length)});
		body += String.format(nationalIdNo, new Object[0]);

		// -- tag 5
		body += String.format("%5d", new Object[] { Integer.valueOf(tag5Length)});
		body += String.format(mobileNo, new Object[0]);

		// -- tag 6
		body += String.format("%5d", new Object[] { Integer.valueOf(tag6Length)});
		body += String.format(new String(name.getBytes("UTF-8"), "UTF-8"), new Object[0]);



		/************** FOR HEAD part 2 ******************/
		// get length of body
		String bodyLength = String.format("%6d", new Object[] { Integer.valueOf(body.getBytes("UTF-8").length) });

		head += bodyLength;

		/*************** ADDING UP ************************/
		String tempFrame = stx + head + body + etx;

		returnFrame = new String(tempFrame.getBytes("UTF-8"), "UTF-8");

		return returnFrame;

	}
	
	public ArrayList createIForgotPasswordRequest(UserModel user) throws Exception{
		ArrayList toReturn = new ArrayList();
		
		String requestFrame = createIForgotPasswordFrame(user);
		String quitFrame = Kolas3FrameCommon.setQuitFrame("AE115");
		
		toReturn.add(requestFrame);
		toReturn.add(quitFrame);
		
		return toReturn;
	}
	
	
	public String createIForgotPasswordFrame(UserModel user) throws UnsupportedEncodingException{
		String returnFrame = "";

		// declaration of frame elements
		String head = "";
		String body = "";


		/************** FOR HEAD part 1 ******************/
		String command = "AE115";


		// head: command name
		head = head + String.format("%5s", new Object[] { command });

		// head: record count
		head = head + String.format("%5d", new Object[] { Integer.valueOf(1) });

		/************** FOR BODY *************************/
		// body: tag count
		int tagCount = 2;

		// tag 0: username
		String username = user.getUsername();
		int tag0Length = username == null ? 0 : username.length();

		// tag 1: password
		String password = user.getPassword();
		int tag1Length = password == null ? 0 : password.length();

		// add tags 0 to 1 body frame
		body += String.format("%4d", new Object[] { Integer.valueOf(tagCount) });

		// --- tag 0
		body += String.format("%5d", new Object[] { Integer.valueOf(tag0Length) }); //tag 0 length
		body += String.format(username, new Object[0]);

		// -- tag 1
		body += String.format("%5d", new Object[] { Integer.valueOf(tag1Length)});
		body += String.format(password, new Object[0]);

		/************** FOR HEAD part 2 ******************/
		// get length of body
		String bodyLength = String.format("%6d", new Object[] { Integer.valueOf(body.getBytes("UTF-8").length) });

		head += bodyLength;

		/*************** ADDING UP ************************/
		String tempFrame = stx + head + body + etx;

		returnFrame = new String(tempFrame.getBytes("UTF-8"), "UTF-8");

		return returnFrame;
	}
	
	
	

	public static void main (String args[]){
		String nothing = null;

		if (nothing == null){
			System.out.println("I am null");
		}
	}

}
