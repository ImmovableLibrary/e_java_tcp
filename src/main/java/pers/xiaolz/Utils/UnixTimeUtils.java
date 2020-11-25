package pers.xiaolz.Utils;

import java.util.Calendar;


/**
 * File: UnixTimeUtils
 * Description:获取unix时间戳工具类
 * Date: 2020-05-14 15:40
 *
 * @Author: 毛豪峰
 */
public class UnixTimeUtils {

    /**
     * 获取昨天0点的unix时间戳
     * @param
     * @return
     * @author 毛豪峰
     * @date 2020-05-14 15:42
     **/
    public static Long getYesterdayBeginUnixTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,0,0,0);
        return calendar.getTime().getTime()/1000;
    }

    /**
     * 获取昨天23：59：59的Unix时间戳
     * @param
     * @return
     * @author 毛豪峰
     * @date 2020-05-14 15:42
     **/
    public static Long getYesterdayEndUnixTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,23,59,59);
        return calendar.getTime().getTime()/1000;
    }

    /**
     * 获取今天0点的unix时间戳
     * @param
     * @return
     * @author 毛豪峰
     * @date 2020-05-14 15:45
     **/
    public static Long getTodayBeginUnixTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),0,0,0);
        return calendar.getTime().getTime()/1000;
    }

    /**
     * 获取今天23：59：59的Unix时间戳
     * @param
     * @return
     * @author 毛豪峰
     * @date 2020-05-14 15:45
     **/
    public static Long getTodayEndUnixTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH),23,59,59);
        return calendar.getTime().getTime()/1000;
    }

    /**
     * 将unix时间戳转换为年月日时分秒
     * @param timeStamp
     * @return
     * @author 毛豪峰
     * @date 2020-05-14 16:24
     **/
    public static String getDateTimeFromUnixTime(String timeStamp){
        Long timestamp = Long.parseLong(timeStamp)*1000;
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date(timestamp));
    }

    /**
     * 将unix时间戳转换为年月日
     * @param timeStamp
     * @return
     * @author 毛豪峰
     * @date 2020-05-14 16:23
     **/
    public static String getDateFromUnixTime(String timeStamp){
        Long timestamp = Long.parseLong(timeStamp)*1000;
        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date(timestamp));
    }

    /**
     * 将unix时间戳转换为时分秒
     * @param timeStamp
     * @return
     * @author 毛豪峰
     * @date 2020-05-14 16:23
     **/
    public static String getTimeFromUnixTime(String timeStamp){
        Long timestamp = Long.parseLong(timeStamp)*1000;
        return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date(timestamp));
    }
}
