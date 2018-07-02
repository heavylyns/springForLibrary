package kolas3.work.UserService.Form;



public class UserLoginForm

{
  private String user_card = "";
  private String pass_card = "";
  private String idcheck = "";
  private String user_id = "";
  private String user_pwd = "";
  private String user_no = "";
  private String user_manage = "";
  private String name = "";
  private String login_flag = "";
  private String url = "";
  private String[] rec_key;
  private int page = 1;
  private String s_year = "";
  private String s_month = "";
  private String s_day = "";
  private String e_year = "";
  private String e_month = "";
  private String e_day = "";
  private String select_field = "";
  private String civil_no = "";
  private String gpin_hash ="";
  private String ipin_hash ="";

  public String getUrl()
  {
    return this.url;
  }

  public void setUrl(String url)
  {
    this.url = url;
  }

  public String getUser_id()
  {
    return this.user_id;
  }

  public void setUser_id(String user_id)
  {
    this.user_id = user_id;
  }

  public String getUser_pwd()
  {
    return this.user_pwd;
  }

  public void setUser_pwd(String user_pwd)
  {
    this.user_pwd = user_pwd;
  }

  public String[] getRec_key()
  {
    return this.rec_key;
  }

  public void setRec_key(String[] rec_key)
  {
    this.rec_key = rec_key;
  }

  public String getE_day()
  {
    return this.e_day;
  }

  public void setE_day(String e_day)
  {
    this.e_day = e_day;
  }

  public String getE_month()
  {
    return this.e_month;
  }

  public void setE_month(String e_month)
  {
    this.e_month = e_month;
  }

  public String getE_year()
  {
    return this.e_year;
  }

  public void setE_year(String e_year)
  {
    this.e_year = e_year;
  }

  public int getPage()
  {
    return this.page;
  }

  public void setPage(int page)
  {
    this.page = page;
  }

  public String getS_day()
  {
    return this.s_day;
  }

  public void setS_day(String s_day)
  {
    this.s_day = s_day;
  }

  public String getS_month()
  {
    return this.s_month;
  }

  public void setS_month(String s_month)
  {
    this.s_month = s_month;
  }

  public String getS_year()
  {
    return this.s_year;
  }

  public void setS_year(String s_year)
  {
    this.s_year = s_year;
  }

  public String getSelect_field()
  {
    return this.select_field;
  }

  public void setSelect_field(String select_field)
  {
    this.select_field = select_field;
  }

  public String getIdcheck()
  {
    return this.idcheck;
  }

  public void setIdcheck(String idcheck)
  {
    this.idcheck = idcheck;
  }

  public String getUser_no()
  {
    return this.user_no;
  }

  public void setUser_no(String user_no)
  {
    this.user_no = user_no;
  }

  public String getLogin_flag()
  {
    return this.login_flag;
  }

  public void setLogin_flag(String login_flag)
  {
    this.login_flag = login_flag;
  }

  public String getUser_manage()
  {
    return this.user_manage;
  }

  public void setUser_manage(String user_manage)
  {
    this.user_manage = user_manage;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getPass_card()
  {
    return this.pass_card;
  }

  public void setPass_card(String pass_card)
  {
    this.pass_card = pass_card;
  }

  public String getUser_card()
  {
    return this.user_card;
  }

  public void setUser_card(String user_card)
  {
    this.user_card = user_card;
  }

  public String getCivil_no() {
	return civil_no;
  }

  public void setCivil_no(String civil_no) {
	this.civil_no = civil_no;
  }

public String getGpin_hash() {
	return gpin_hash;
}

public void setGpin_hash(String gpin_hash) {
	this.gpin_hash = gpin_hash;
}

public String getIpin_hash() {
	return ipin_hash;
}

public void setIpin_hash(String ipin_hash) {
	this.ipin_hash = ipin_hash;
}
  
  
}
