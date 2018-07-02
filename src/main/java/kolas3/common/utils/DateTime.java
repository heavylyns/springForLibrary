package kolas3.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTime
{
  public static String dateSep = "-";
  public static String timeSep = ":";
  public static String dateSep_1 = ".";
  private static final String[] day = { "일", "월", "화", "수", "목", "금", "토" };

  public static int getNumberByPattern(String pattern)
  {
    SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.KOREA);

    String dateString = formatter.format(new Date());
    return Integer.parseInt(dateString);
  }

  public static String getYear()
  {
    return String.valueOf(getNumberByPattern("yyyy"));
  }

  public static String getMonth()
  {
    return String.valueOf(getNumberByPattern("MM"));
  }

  public static String getDay()
  {
    return String.valueOf(getNumberByPattern("dd"));
  }

  public static String getDayOfWeek()
  {
    Calendar c = Calendar.getInstance();
    return day[(c.get(7) - 1)];
  }

  public static String getHour()
  {
    Calendar c = Calendar.getInstance();
    return String.valueOf(c.get(11));
  }

  public static String getMinute()
  {
    Calendar c = Calendar.getInstance();
    return String.valueOf(c.get(12));
  }

  public static String getSecond()
  {
    Calendar c = Calendar.getInstance();
    return String.valueOf(c.get(13));
  }

  public String getDateString()
  {
    String Year = "";
    String Month = "";
    String Day = "";

    String DateResult = "";

    Year = getYear();
    Month = getMonth();
    Day = getDay();
    if (Month.length() == 1) {
      Month = "0" + Month;
    }
    if (Day.length() == 1) {
      Day = "0" + Day;
    }
    DateResult = Year + " " + "/" + " " + Month + " " + "/" + " " + Day;

    return DateResult;
  }

  public String getDateTrString()
  {
    String Year = "";
    String Month = "";

    String DateResult = "";

    Year = getYear();
    Month = getMonth();
    if (Month.length() == 1) {
      Month = "0" + Month;
    }
    DateResult = Year + "/" + Month;

    return DateResult;
  }

  public static String getDateString(String pattern)
  {
    return
      getYear() + pattern + getMonth() + pattern + getDay() + pattern + " " + getHour() + ":" + getMinute() + ":" + getSecond();
  }

  public static String getTimeString()
  {
    String hour = getHour();
    String min = getMinute();
    String sec = getSecond();
    if (hour.length() == 1) {
      hour = "0" + hour;
    }
    if (min.length() == 1) {
      min = "0" + min;
    }
    if (sec.length() == 1) {
      sec = "0" + sec;
    }
    return hour + timeSep + min + timeSep + sec;
  }

  public static String getTimeStampString()
  {
    return getDateString("-") + " " + getTimeString();
  }

  public static String getDateTimeMin()
  {
    String month = getMonth();
    String day = getDay();
    String hour = getHour();
    String min = getMinute();
    if (month.length() == 1) {
      month = "0" + month;
    }
    if (day.length() == 1) {
      day = "0" + day;
    }
    if (hour.length() == 1) {
      hour = "0" + hour;
    }
    if (min.length() == 1) {
      min = "0" + min;
    }
    return getYear() + month + day + hour + min;
  }

  public String getDateTimeString()
  {
    String month = getMonth();
    String day = getDay();
    String hour = getHour();
    String min = getMinute();
    String sec = getSecond();
    if (month.length() == 1) {
      month = "0" + month;
    }
    if (day.length() == 1) {
      day = "0" + day;
    }
    if (hour.length() == 1) {
      hour = "0" + hour;
    }
    if (min.length() == 1) {
      min = "0" + min;
    }
    if (sec.length() == 1) {
      sec = "0" + sec;
    }
    return getYear() + month + day + hour + min + sec;
  }

  public static String getParseDateString(String dateTime, String pattern)
  {
    if (dateTime != null)
    {
      String year = dateTime.substring(0, 4);
      String month = dateTime.substring(4, 6);
      String day = dateTime.substring(6, 8);

      return year + pattern + month + pattern + day;
    }
    return "";
  }

  public static boolean checkEmbolism(int year)
  {
    int remain = 0;
    int remain_1 = 0;
    int remain_2 = 0;

    remain = year % 4;
    remain_1 = year % 100;
    remain_2 = year % 400;
    if (remain == 0)
    {
      if (remain_1 == 0)
      {
        if (remain_2 == 0) {
          return true;
        }
        return false;
      }
      return true;
    }
    return false;
  }

  public static int getMonthDate(String year, String month)
  {
    int[] dateMonth = new int[12];

    dateMonth[0] = 31;
    dateMonth[1] = 28;
    dateMonth[2] = 31;
    dateMonth[3] = 30;
    dateMonth[4] = 31;
    dateMonth[5] = 30;
    dateMonth[6] = 31;
    dateMonth[7] = 31;
    dateMonth[8] = 30;
    dateMonth[9] = 31;
    dateMonth[10] = 30;
    dateMonth[11] = 31;
    if (checkEmbolism(Integer.parseInt(year))) {
      dateMonth[1] = 29;
    }
    int day = dateMonth[(Integer.parseInt(month) - 1)];

    return day;
  }
}
