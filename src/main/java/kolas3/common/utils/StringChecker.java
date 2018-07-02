package kolas3.common.utils;

public class StringChecker
{
  public static boolean isNull(String str)
  {
    if ((str == null) || (str.trim().length() == 0)) {
      return true;
    }
    return false;
  }
  
  public static boolean isNumber(String str)
  {
    if (isNull(str)) {
      return false;
    }
    str = str.trim();
    int n = str.length();
    for (int i = 0; i < n; i++)
    {
      char c = str.charAt(i);
      if (('0' > c) || (c > '9')) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean isSame(String str, String n)
  {
    if ((isNull(str)) || (isNull(n))) {
      return false;
    }
    str = str.trim();
    n = n.trim();
    if (str.equals(n)) {
      return true;
    }
    return false;
  }
  
  public static boolean isID(String str)
  {
    if (isNull(str)) {
      return false;
    }
    str = str.trim().toUpperCase();
    char c = str.charAt(0);
    if (('A' > c) || (c > 'Z')) {
      return false;
    }
    int n = str.length();
    for (int i = 1; i < n; i++)
    {
      c = str.charAt(i);
      if ((('A' > c) || (c > 'Z')) && (('0' > c) || (c > '9')) && (c != '_')) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean isCardNumber(String str)
  {
    if (isNull(str)) {
      return false;
    }
    if (isNumber(str))
    {
      str = str.trim();
      if (str.length() != 16) {
        return false;
      }
    }
    return true;
  }
  
  public static int isByteSize(String str)
  {
    int StrSize = 0;
    if (isNull(str)) {
      return -1;
    }
    byte[] Strbyte = str.getBytes();
    StrSize = Strbyte.length;
    
    return StrSize;
  }
  
  public static boolean isEmail(String str)
  {
    if (isNull(str)) {
      return false;
    }
    int n = str.indexOf("@");
    if (n < 0) {
      return false;
    }
    n = str.indexOf(".");
    if (n < 0) {
      return false;
    }
    return true;
  }
  
  public static boolean isAlpha(String str)
  {
    if (isNull(str)) {
      return false;
    }
    for (int idx = 0; idx < str.length(); idx++)
    {
      char TestAlpha = '\000';
      
      TestAlpha = str.charAt(idx);
      if (((TestAlpha > '@') && (TestAlpha < '[')) || ((TestAlpha > '`') && (TestAlpha < '{'))) {
        return true;
      }
    }
    return false;
  }
  
  public String RemoveWord(String srcstr)
  {
    String data = "";
    int[] start = { 32, 58, 91, 123, 554, 697, 706, 741, 768, 8192, 8592, 10240, 12288, 
      12800, 40960, 61440, 65056, 65140, 65280, 65306, 65339, 65371, 65504 };
    
    int[] end = { 47, 64, 96, 191, 545, 703, 735, 750, 879, 8447, 10191, 10495, 12351, 
      13055, 42191, 61695, 65103, 65135, 65295, 65312, 65344, 65381, 65535 };
    if ((srcstr == null) || (srcstr.equals("")) || (srcstr.trim().length() == 0))
    {
      data = "String error";
      
      return data;
    }
    data = srcstr;
    

    data = data.trim();
    for (int i = 0; i < 23; i++) {
      for (int j = start[i]; j <= end[i]; j++) {
        if (data.indexOf((char)j) != -1) {
          data = data.replaceAll("\\" + (char)j, "");
        }
      }
    }
    return data;
  }
  
  public String ConvertHtmlWord(String srcstr)
  {
    String data = "";
    if ((srcstr == null) || (srcstr.equals("")) || (srcstr.trim().length() == 0))
    {
      data = "String error";
      
      return data;
    }
    data = srcstr;
    

    data = data.replaceAll("\\;", "△▲59;");
    data = data.replaceAll("\\#", "△#35;");
    data = data.replaceAll("\\&", "&#38;");
    data = data.replaceAll("\\▲", "#");
    data = data.replaceAll("\\△", "&");
    data = data.replaceAll("\\!", "&#33;");
    data = data.replaceAll("\\“", "&#34;");
    data = data.replaceAll("\\$", "&#36;");
    data = data.replaceAll("\\%", "&#37;");
    data = data.replaceAll("\\'", "&#39;");
    data = data.replaceAll("\\(", "&#40;");
    data = data.replaceAll("\\)", "&#41;");
    data = data.replaceAll("\\*", "&#42;");
    data = data.replaceAll("\\+", "&#43;");
    data = data.replaceAll("\\,", "&#44;");
    data = data.replaceAll("\\-", "&#45;");
    data = data.replaceAll("\\.", "&#46;");
    data = data.replaceAll("\\/", "&#47;");
    data = data.replaceAll("\\:", "&#58;");
    data = data.replaceAll("\\<", "&#60;");
    data = data.replaceAll("\\=", "&#61;");
    data = data.replaceAll("\\>", "&#62;");
    data = data.replaceAll("\\?", "&#63;");
    data = data.replaceAll("\\@", "&#64;");
    data = data.replaceAll("\\[", "&#91;");
    data = data.replaceAll("\\]", "&#93;");
    data = data.replaceAll("\\^", "&#94;");
    data = data.replaceAll("\\_", "&#95;");
    data = data.replaceAll("\\`", "&#96;");
    data = data.replaceAll("\\{", "&#123;");
    data = data.replaceAll("\\}", "&#124;");
    data = data.replaceAll("\\|", "&#125;");
    data = data.replaceAll("\\~", "&#126;");
    

    return data;
  }
  
  public String BrToCRLF(String srcstr)
  {
    String data = "";
    if ((srcstr == null) || (srcstr.equals("")) || (srcstr.trim().length() == 0))
    {
      data = "String error";
      
      return data;
    }
    data = srcstr;
    

    data = data.replaceAll("<br>", "\r\n");
    


    return data;
  }
  
  public String CRLFToBr(String srcstr)
  {
    String data = "";
    if ((srcstr == null) || (srcstr.equals("")) || (srcstr.trim().length() == 0))
    {
      data = "String error";
      
      return data;
    }
    data = srcstr;
    

    data = data.replaceAll("\r\n", "<br>");
    

    return data;
  }
  
  public String NVL(String srcstr, String changeword)
  {
    if (srcstr == null) {
      return changeword;
    }
    return srcstr;
  }
}
