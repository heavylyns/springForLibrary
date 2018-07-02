package kolas3.common;

import kolas3.common.utils.ECOLogManager;

public class ECOClass {
	public static ECOLogManager log;
	private String ProjectName = "";

	public ECOClass() {
		log = new ECOLogManager();
	}

	public String getProjectName() {
		return this.ProjectName;
	}

	void setProjectName(String f_ProjectName) {
		this.ProjectName = f_ProjectName;
	}
}
