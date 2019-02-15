/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fineworkimg.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.LocalDate;

/**
 *
 * @author s.aekasit
 */
public class DateTimeUtil {

    public final static String pattern = "dd-MMM-yyyy";
    public final static String PATTERN_DB = "yyyy-MM-dd";
    public final static String PATTERN_DT_DB = "yyyy-MM-dd HH:mm:ss";
    public final static String SELECT_FROM_TIME = " 00:00:00";
    public final static String SELECT_TO_TIME = " 23:59:59";

    protected static final String[] MTH_TH = {"มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม"};
    protected static final String[] SMTH_TH = {"ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.", "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.", "ก.ย.", "ต.ค.", "พ.ย.", "ธ.ค."};
    protected static final String[] MTH_EN = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    protected static final String[] SMTH_EN = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    public static String dateToString(Date date, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = "dd-MM-yyyy";
        }
        return date != null ? (new SimpleDateFormat(pattern, Locale.US)).format(date) : null;
    }

    public static Date stringToDate(String date, String pattern) {
        try {
            if (StringUtils.isBlank(pattern)) {
                pattern = "dd-MM-yyyy";
            }
            return date != null ? (new SimpleDateFormat(pattern, Locale.US)).parse(date.trim()) : null;
        } catch (ParseException ex) {
        }
        return null;
    }

    public static String convertLongToDateStr(long l) {
        DateTime dt = new DateTime(l, DateTimeZone.UTC);
        String h = dt.getHourOfDay() == 0 ? "" : String.valueOf(dt.getHourOfDay() + "h ");
        String m = dt.getMinuteOfHour() == 0 ? "" : String.valueOf(dt.getMinuteOfHour() + "m ");
        String s = dt.getSecondOfMinute() == 0 ? "" : String.valueOf(dt.getSecondOfMinute() + "s ");
        return h + m + s + dt.getMillisOfSecond() + "ms";
    }

    public static Date getSystemDate() {
        Calendar c = new GregorianCalendar(Locale.US);
        return c.getTime();
    }

    public static String strCurrentDateOnPatternDate(String patternDate) {
        Calendar c = new GregorianCalendar(Locale.US);
        c.setTimeInMillis(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat(patternDate, Locale.US);
        return sdf.format(c.getTime());
    }

    public static Date getDateLong(String l) {
        if (l == null) {
            return null;
        }
        return new Date(Long.parseLong(l));
    }

    public static Date getDateLong(long l) {
        if (l == 0 || l < 0) {
            return null;
        }

        return new Date(l);
    }

    /**
     * Convert date string to date BuddhistEra using given pattern and language. Example. if you assigned language ="T" 
     * 1.SHORT = 25/1/2545 
     * 2.MEDIUM = 25 ม.ค. 2545 
     * 3.LONG = 25 มกราคม 2545 
     * 4.FULL = วันศุกร์ที่ 25 มกราคม พ.ศ. 2545 
     * 5.FULLMEDIUM = วันศุกร์ที่ 25 ม.ค. 2545
     *
     * if you assigned language ="E" 
     * 1.SHORT = 25/1/2002 
     * 2.MEDIUM = 25 ม.ค. 2002 
     * 3.LONG = 25 มกราคม 2002 
     * 4.FULL = วันศุกร์ที่ 25 มกราคม ค.ศ. 2002 
     * 5.FULLMEDIUM = วันศุกร์ที่ 25 ม.ค. 2002
     *
     * @param strDate the date string Example. 05/02/2002
     * @param format the target format such as SHORT,MEDIUM,LONG,FULL,FULLMEDIUM.
     * @param language the language such as E or T.
     * @return the formatted date string.
     */
    public static String cnvStringDateToBuddhistEra(
            String strDate,
            String format,
            String language)
            throws Exception {
        String dateThai = "";
        if (strDate.equals("00/00/0000")) {
            strDate = "";
            return strDate;
        }
        try {
            if (!validateDate(strDate)) {
                return "InValid Date ";
            }

            String[] monthThai = {"มกราคม", "กุมภาพันธ์", "มีนาคม", "เมษายน", "พฤษภาคม", "มิถุนายน", "กรกฎาคม", "สิงหาคม", "กันยายน", "ตุลาคม", "พฤศจิกายน", "ธันวาคม"};
            String[] shortMonthThai = {"ม.ค.", "ก.พ.", "มี.ค.", "เม.ย.", "พ.ค.", "มิ.ย.", "ก.ค.", "ส.ค.", "ก.ย.", "ต.ค.", "พ.ย.", "ธ.ค."};
            String[] dayThai = {"อาทิตย์", "จันทร์", "อังคาร", "พุธ", "พฤหัสบดี", "ศุกร์", "เสาร์"};
            String[] monthEnglish = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            String[] shortMonthEng = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
            String[] dayEng = {"Sunday", "Monday", "Tueday", "Wednesday", "Thursday", "Friday", "Saturday"};

            java.util.Date newDate = cnvStringToDate(strDate);
            Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
            calendar.setTime(newDate);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH);
            int yearAD = calendar.get(Calendar.YEAR);
            int yearBC = yearAD + 543;
            //System.out.println("  dayOfWeek ="+dayOfWeek+" day ="+day+" month= "+month+" yearAD="+yearAD);
            //String dateStr = (new SimpleDateFormat("dd/MM/yyyy")).format(newDate);
            //System.out.println(" DateStr = "+dateStr);
            String monthStr = "";
            if (language.equalsIgnoreCase("T")) {
                if (format.equalsIgnoreCase("SHORT")) {
                    if (month < 9) {
                        dateThai = cnvByteToString(Integer.toString(day) + "/0" + Integer.toString(month + 1) + "/" + Integer.toString(yearBC));
                    } else {
                        dateThai = cnvByteToString(Integer.toString(day) + "/" + Integer.toString(month + 1) + "/" + Integer.toString(yearBC));
                    }
                    System.out.println("DateThai =  " + dateThai);
                    return dateThai;
                }
                if (format.equalsIgnoreCase("MEDIUM")) {
                    monthStr = shortMonthThai[month];
                    dateThai = cnvByteToString(Integer.toString(day) + " " + monthStr + " " + Integer.toString(yearBC));
                    return dateThai;
                }
                if (format.equalsIgnoreCase("LONG")) {
                    monthStr = monthThai[month];
                    dateThai = cnvByteToString(Integer.toString(day) + " " + monthStr + " " + Integer.toString(yearBC));
                    return dateThai;
                }
                if (format.equalsIgnoreCase("FULL")) {
                    monthStr = monthThai[month];
                    dateThai = cnvByteToString("วัน" + dayThai[dayOfWeek - 1] + "ที่ " + Integer.toString(day) + " " + monthStr + "  พ.ศ. " + Integer.toString(yearBC));
                    return dateThai;
                }
                if (format.equalsIgnoreCase("FULLMEDIUM")) {
                    monthStr = shortMonthThai[month];
                    dateThai = cnvByteToString("วัน" + dayThai[dayOfWeek - 1] + "ที่ " + Integer.toString(day) + " " + monthStr + " " + Integer.toString(yearBC));
                    return dateThai;
                }
            } else {
                if (format.equalsIgnoreCase("SHORT")) {
                    dateThai = Integer.toString(day) + "/" + Integer.toString(month + 1) + "/" + Integer.toString(yearAD);
                    return dateThai;
                }
                if (format.equalsIgnoreCase("MEDIUM")) {
                    monthStr = shortMonthEng[month];
                    dateThai = Integer.toString(day) + " " + monthStr + " " + Integer.toString(yearAD);
                    return dateThai;
                }
                if (format.equalsIgnoreCase("LONG")) {
                    monthStr = monthEnglish[month];
                    dateThai = Integer.toString(day) + " " + monthStr + " " + Integer.toString(yearAD);
                    return dateThai;
                }
                if (format.equalsIgnoreCase("FULL")) {
                    monthStr = monthEnglish[month];
                    dateThai = dayEng[dayOfWeek - 1] + "  " + Integer.toString(day) + " " + monthStr + " " + Integer.toString(yearAD);
                    return dateThai;
                }
                if (format.equalsIgnoreCase("FULLMEDIUM")) {
                    monthStr = shortMonthEng[month];
                    dateThai = dayEng[dayOfWeek - 1] + "  " + Integer.toString(day) + " " + monthStr + " " + Integer.toString(yearAD);
                    return dateThai;
                }
            }
        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
        return null;
    }

    /**
     * Convert byte to string
     *
     * @param inputstr the String value
     */
    public static String cnvByteToString(String inputstr) throws Exception {
        String code = checkOs();
        String outputstr = null;
        String osName = System.getProperty("os.name");
        try {
            if (osName.equals("Solaris")) {
                byte[] b = inputstr.getBytes(code);
                outputstr = new String(b);
            } else {
                outputstr = inputstr;
            }
        } catch (java.io.UnsupportedEncodingException e) {
            //log.debug("Unsupported Encoding");
            e.printStackTrace();;
        }
        return outputstr;
    }

    /**
     * Convert java.util.Date to date string using given pattern.
     *
     * 1. DD/MM/YYYY = 25/01/2002 2. YYYY/MM/DD = 2002/01/25 3. DD/MM/YYYY HH24:MI:SS	= 25/01/2002 16:36:45 4. DD/MM/YYYY HH:MM:SS = 25/01/2002 16:36:45
     *
     * @param inputDate the date value.
     * @param targetFormat the targetFormat : Example : DD/MM/YYYY .
     */
    public static String cnvDateToString(
            java.util.Date inputDate,
            String targetFormat)
            throws Exception {
        targetFormat = targetFormat.toUpperCase();
        String retDate = "";
        String hh = "";
        String mm = "";
        String ss = "";
        if (inputDate != null) {
            java.util.Calendar calendarObj = java.util.Calendar.getInstance(Locale.ENGLISH);
            calendarObj.setTime(inputDate);

            int day = calendarObj.get(java.util.Calendar.DAY_OF_MONTH);
            int month = calendarObj.get(java.util.Calendar.MONTH) + 1;
            int year = calendarObj.get(java.util.Calendar.YEAR);
            int hours = calendarObj.get(java.util.Calendar.HOUR_OF_DAY);
            int minutes = calendarObj.get(java.util.Calendar.MINUTE);
            int seconds = calendarObj.get(java.util.Calendar.SECOND);

            /*			Debug.println(" day = " + day + " month = " + month + " year = " + year +  "\n"
							+ " hours = " + hours + " minutes = " + minutes + " seconds = "+ seconds);*/
            if (day < 10) {
                retDate = "0" + day;
            } else {
                retDate = (new Integer(day)).toString();
            }

            if (month < 10) {
                if (targetFormat.equals("DD/MM/YYYY")) {
                    retDate = retDate + "/0" + month + "/" + year;
                }
                if (targetFormat.equals("YYYY/MM/DD")) {
                    retDate = year + "/0" + month + "/" + retDate;
                }
                if (targetFormat.equals("MM/DD/YYYY")) {
                    retDate = "/0" + month + "/" + retDate + year;
                }
                if (targetFormat.equals("DD/MM/YYYY HH24:MI:SS")
                        || targetFormat.equals("DD/MM/YYYY HH:MM:SS")) {
                    if (hours < 10) {
                        hh = "0" + Integer.toString(hours);
                    } else {
                        hh = Integer.toString(hours);
                    }
                    if (minutes < 10) {
                        mm = "0" + Integer.toString(minutes);
                    } else {
                        mm = Integer.toString(minutes);
                    }
                    if (seconds < 10) {
                        ss = "0" + Integer.toString(seconds);
                    } else {
                        ss = Integer.toString(seconds);
                    }

                    retDate = retDate + "/0" + month + "/" + year + " " + hh + ":" + mm + ":" + ss;
                }
            } else {
                if (targetFormat.equals("DD/MM/YYYY")) {
                    retDate = retDate + "/" + month + "/" + year;
                }

                if (targetFormat.equals("YYYY/MM/DD")) {
                    retDate = year + "/" + month + "/" + retDate;
                }
                if (targetFormat.equals("MM/DD/YYYY")) {
                    retDate = month + "/" + retDate + year;
                }
                if (targetFormat.equals("DD/MM/YYYY HH24:MI:SS")
                        || targetFormat.equals("DD/MM/YYYY HH:MM:SS")) {
                    if (hours < 10) {
                        hh = "0" + Integer.toString(hours);
                    } else {
                        hh = Integer.toString(hours);
                    }
                    if (minutes < 10) {
                        mm = "0" + Integer.toString(minutes);
                    } else {
                        mm = Integer.toString(minutes);
                    }
                    if (seconds < 10) {
                        ss = "0" + Integer.toString(seconds);
                    } else {
                        ss = Integer.toString(seconds);
                    }

                    retDate = retDate + "/" + month + "/" + year + " " + hh + ":" + mm + ":" + ss;
                }
            }
        } else {
            if (targetFormat.equals("DD/MM/YYYY")) {
                retDate = "00/00/0000";
            }
            if (targetFormat.equals("YYYY/MM/DD")) {
                retDate = "0000/00/00";
            }
            if (targetFormat.equals("DD/MM/YYYY HH24:MI:SS")
                    || targetFormat.equals("DD/MM/YYYY HH:MM:SS")) {
                retDate = "00/00/0000 00:00:00";
            }
        }
        return retDate;
    }

    /**
     * Convert date string to date value.
     *
     * @return date value.
     * @param inpDate the date string in the format of "dd/mm/yyyy". Example. "15/01/2002".
     */
    public static java.util.Date cnvStringToDate(String inpDate) {
        java.util.Date date = null;
        boolean convert = false;
        if (inpDate == null || inpDate.length() == 0 || inpDate.equals("null")) {
            return date;
        }
        if ((inpDate != null) || (inpDate.length() >= 10)) {
            int ind1 = inpDate.indexOf('/');
            int ind2 = inpDate.lastIndexOf('/');
            if ((ind1 == 2) && (ind2 == 5)) {
                convert = true;
            }
        }
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        if (convert) {
            int day = Integer.parseInt(inpDate.substring(0, 2));
            int month = Integer.parseInt(inpDate.substring(3, 5));
            int year = Integer.parseInt(inpDate.substring(6, 10));

            if (inpDate.length() > 10) {
                int hh = Integer.parseInt(inpDate.substring(11, 13));
                int mm = Integer.parseInt(inpDate.substring(14, 16));
                if (inpDate.length() > 16) {
                    int ss = Integer.parseInt(inpDate.substring(17, 19));
                    calendar.set(year, month - 1, day, hh, mm, ss);
                } else {
                    calendar.set(year, month - 1, day, hh, mm);
                }
            } else {
                calendar.set(year, month - 1, day);
            }
        }
        return calendar.getTime();
    }

    /**
     * Check OS
     */
    public static String checkOs() throws Exception {
        String code = null;
        String osName = System.getProperty("os.name");
        if (osName.equals("Windows NT")) {
            code = "TIS620";
        } else {
            if (osName.equals("Solaris")) {
                code = "TIS620";
            } else {
                code = "TIS620";
            }
        }
        return code;
    }

    /**
     * Validate the date string is corrected date value. Example. 1. 33/04/2002 is false 2. 28/02/2002 is true 3. 28/13/2002 is false 4. 29/02/2002 is false
     *
     * @return boolean true if corrected date.
     * @param dateStr the date string.
     */
    public static boolean validateDate(String inputDate) {
        if (inputDate.indexOf("/") < 0) {
            return false;
        }

        java.util.Calendar calendarObj = java.util.Calendar.getInstance(Locale.ENGLISH);

        int dayInt = Integer.parseInt(inputDate.substring(0, inputDate.indexOf("/")));
        inputDate = inputDate.substring(inputDate.indexOf("/") + 1);
        int monthInt = Integer.parseInt(inputDate.substring(0, inputDate.indexOf("/")));
        int yearInt = Integer.parseInt(inputDate.substring(inputDate.indexOf("/") + 1));

        calendarObj.set(yearInt, monthInt - 1, dayInt);
        int day = calendarObj.get(java.util.Calendar.DAY_OF_MONTH);
        int month = calendarObj.get(java.util.Calendar.MONTH) + 1;
        int year = calendarObj.get(java.util.Calendar.YEAR);

        //	Debug.println("<<source>> = " + dayInt + "/" + monthInt +"/" + yearInt  + " <<new>> = " + day + "/" + month +"/" + year);
        if (dayInt == day && monthInt == month && yearInt == year) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        
        try {
            System.out.println("1.>>>>>>>>>>>>>>>>>>" + DateTimeUtil.cnvStringDateToBuddhistEra(DateTimeUtil.dateToString(DateTimeUtil.getSystemDate(), "dd/MM/yyyy"),"FULL","T"));
        } catch (Exception ex) {
           ex.printStackTrace();
        }
        
       // DateTimeUtil.cnvStringDateToBuddhistEra(DateTimeUtil.dateToString(DateTimeUtil.getSystemDate(), "dd/MM/yyyy"),"LONG","T");
        long l = 1442854203 * 1000;

    }

    public static LocalDate convertUtilDateToLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        DateTime dt = new DateTime(date);
        return dt.toLocalDate();
    }
    
    
    public static String fill2(int value) {
        String ret = String.valueOf(value);

        if (ret.length() < 2) {
            ret = "0" + ret;
        }
        return ret;
    }

    public static String durationTime(Date date1, Date date2) {
        TimeUnit timeUnit = TimeUnit.SECONDS;

        long diffInMilli = date2.getTime() - date1.getTime();
        long s = timeUnit.convert(diffInMilli, TimeUnit.MILLISECONDS);

        long days = s / (24 * 60 * 60);
        long rest = s - (days * 24 * 60 * 60);
        long hrs = rest / (60 * 60);
        long rest1 = rest - (hrs * 60 * 60);
        long min = rest1 / 60;
        long sec = s % 60;

        String dates = "";
      /*  if (days > 0) {
            dates = days + " Days ";
        }
*/

        dates += fill2((int) hrs) + ": ";
        dates += fill2((int) min) + ": ";
        dates += fill2((int) sec) + "";
        
        return dates;
    }
}
