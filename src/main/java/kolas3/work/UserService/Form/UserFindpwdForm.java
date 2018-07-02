package kolas3.work.UserService.Form;



public class UserFindpwdForm
  
{
  private String user_id = "";
  private String user_name = "";
  private String civil_no1 = "";
  private String civil_no2 = "";
  private String result_pass = "";
  private String find_flag = "";
  
  public String getFind_flag()
  {
    return this.find_flag;
  }
  
  public void setFind_flag(String find_flag)
  {
    this.find_flag = find_flag;
  }
  
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
  
  public String getUser_id()
  {
    return this.user_id;
  }
  
  public void setUser_id(String user_id)
  {
    this.user_id = user_id;
  }
  
  public String getUser_name()
  {
    return this.user_name;
  }
  
  public void setUser_name(String user_name)
  {
    this.user_name = user_name;
  }
  
  public String getResult_pass()
  {
    return this.result_pass;
  }
  
  public void setResult_pass(String result_pass)
  {
    this.result_pass = result_pass;
  }
}
