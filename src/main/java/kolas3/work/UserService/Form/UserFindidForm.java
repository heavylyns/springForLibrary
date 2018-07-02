package kolas3.work.UserService.Form;



public class UserFindidForm
  
{
  private String user_name = "";
  private String civil_no1 = "";
  private String civil_no2 = "";
  private String result_id = "";
  private String find_flag = "";
  
  public String getCivil_no1()
  {
    return this.civil_no1;
  }
  
  public void setCivil_no1(String civil_no1)
  {
    this.civil_no1 = civil_no1;
  }
  
  public String getCivil_no2()
  {
    return this.civil_no2;
  }
  
  public void setCivil_no2(String civil_no2)
  {
    this.civil_no2 = civil_no2;
  }
  
  public String getUser_name()
  {
    return this.user_name;
  }
  
  public void setUser_name(String user_name)
  {
    this.user_name = user_name;
  }
  
  public void reset()
  {
    this.user_name = null;
    this.civil_no1 = null;
    this.civil_no2 = null;
  }
  
  public String getFind_flag()
  {
    return this.find_flag;
  }
  
  public void setFind_flag(String find_flag)
  {
    this.find_flag = find_flag;
  }
  
  public String getResult_id()
  {
    return this.result_id;
  }
  
  public void setResult_id(String result_id)
  {
    this.result_id = result_id;
  }
}
