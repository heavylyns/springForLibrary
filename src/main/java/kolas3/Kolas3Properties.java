package kolas3;

import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kolas3Properties {
	private static final Logger logger = LoggerFactory.getLogger(Kolas3Properties.class);
	private static volatile Kolas3Properties uniqueInstance;
	private Properties properties = null;

	private Properties getProperties() {
		return this.properties;
	}

	private static String xml_socket_path = "";
	private static String xml_nosearch_path = "";
	private static String xml_makequery_path = "";
	private static String xml_hanja_path = "";





	public static String getXml_socket_path() {
		getInstance();
		return xml_socket_path;
	}

	public static void setXml_socket_path(String xml_socket_path) {
		Kolas3Properties.xml_socket_path = xml_socket_path;
	}

	public static String getXml_nosearch_path() {
		getInstance();
		return xml_nosearch_path;
	}

	public static void setXml_nosearch_path(String xml_nosearch_path) {
		Kolas3Properties.xml_nosearch_path = xml_nosearch_path;
	}

	public static String getXml_makequery_path() {
		getInstance();
		return xml_makequery_path;
	}

	public static void setXml_makequery_path(String xml_makequery_path) {
		Kolas3Properties.xml_makequery_path = xml_makequery_path;
	}

	public static String getXml_hanja_path() {
		getInstance();
		return xml_hanja_path;
	}

	public static void setXml_hanja_path(String xml_hanja_path) {
		Kolas3Properties.xml_hanja_path = xml_hanja_path;
	}

//	public static String getCkUploadFilePath() {
//		getInstance();
//		return ckUploadFilePath;
//	}
//
//	public static void setCkUploadFilePath(String ckUploadFilePath) {
//
//		Kolas3Properties.ckUploadFilePath = ckUploadFilePath;
//	}

	private Kolas3Properties() {
		reloadConfiguration();
	}

	public static Kolas3Properties getInstance() {
		if (uniqueInstance == null) {
			synchronized (Kolas3Properties.class) {
				if (uniqueInstance == null) {
					uniqueInstance = new Kolas3Properties();
				}
			}
		}
		return uniqueInstance;
	}

	public void reloadConfiguration() {
		try {
			this.properties = new Properties();
			ClassLoader loader = getClass().getClassLoader();
			String prop = "/kolas3/kolas3.properties";
			InputStream is = loader.getResourceAsStream(prop);
			this.properties.load(is);
			is.close();

			setProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void setProperties() {
		//ckUploadFilePath = get("ckUploadFilePath");
		xml_socket_path    = get("xml_socket_path"   );
		xml_nosearch_path  = get("xml_nosearch_path" );
		xml_makequery_path = get("xml_makequery_path");
		xml_hanja_path     = get("xml_hanja_path"    );

	}

	private String get(String key) {
		String str = "";
		try {
			if (this.properties.get(key) != null) {
				str = this.properties.get(key).toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = "";
		}
		//str = MyUtil.nvl(str);

		logger.info("###" + key + "=" + str);

		return str;
	}

	public boolean reload() {
		reloadConfiguration();
		return true;
	}

	public Properties getGlobalProperties() {
		return this.properties;
	}
}
