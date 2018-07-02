package com.chuncheonlib.kolas3.frame;

public class Kolas3FrameCommon {
	
	private static String stx = "\002";
	private static String etx = "\003";
	
	/**
	 * Creates a quit frame for any kind of frame.
	 * @param command
	 * @return
	 * @throws Exception
	 */
	public static String setQuitFrame(String command) throws Exception {
		
		
		
		String SendBuffer = "";
		String tmpframe = "";
		String strTmp = "";
		String ctmp = "";
		String Msg = "QUIT";
		ctmp = String.format("%5s", new Object[] { command });
		SendBuffer = SendBuffer + ctmp;

		ctmp = String.format("%05d", new Object[] { Integer.valueOf(1) });
		SendBuffer = SendBuffer + ctmp;

		ctmp = String.format("%04d", new Object[] { Integer.valueOf(1) });
		strTmp = strTmp + ctmp;

		ctmp = String.format("%05d", new Object[] { Integer.valueOf(Msg.getBytes("UTF-8").length) });
		strTmp = strTmp + ctmp + Msg;

		ctmp = String.format("%06d", new Object[] { Integer.valueOf(strTmp.getBytes("UTF-8").length) });
		SendBuffer = SendBuffer + ctmp + strTmp;

		tmpframe = stx + SendBuffer + etx;
		String frame = new String(tmpframe.getBytes("UTF-8"), "UTF-8");
		return frame;
		
	}

}
