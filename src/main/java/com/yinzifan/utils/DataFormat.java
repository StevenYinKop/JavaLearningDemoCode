package com.yinzifan.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * 格式化数据工具类
 * 
 * @author CinCommon 2017/09/25 13:46:52
 */
public class DataFormat {
    /**
     * 时间值为 : 2100-01-01 00:00:00
     */
    public static final long DEFAULTENDDATE = 4102416000000L;
    /**
     * 一天的毫秒值: <b>如:</b><br>
     * 2000年1月1日 00:00:00 + <code>ONEDAYMILLIS</code> = 2000年1月2日 00:00:00
     */
    public static final long ONEDAYMILLIS = 86400000L;
    /**
     * 私有构造
     */
    private DataFormat() {
    }
    
    /**
     * Title: TimeStamp2Date
     * description:
     * @param date
     * @return
     */
    public static String TimeStamp2Date(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String str = sdf.format(date);
        return str;
    }
    
    /**
     * @param date
     *            允許通過的格式只有(hh:mm),(:mm),(x.y),(.y)
     * 
     * @return
     */
    public static BigDecimal String2BigDecimal(String date) {
        if (date.contains(":")) {
            // 如果輸入的時間格式為: (hh:mm)
            String[] time = date.split(":");
            String hourStr = time[0];
            String minuteStr = "";
            if (time.length == 1) {
                minuteStr = "0";
            } else {
                minuteStr = time[1];
            }
            BigDecimal minute = new BigDecimal(minuteStr);
            if ("".equals(hourStr)) {
                // 如果输入的时间是(:mm)
                return minute.divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP);
                // SimpleDateFormat sdf = new SimpleDateFormat()
            } else {
                // 輸入的時間格式是(hh:mm)
                BigDecimal hour = new BigDecimal(hourStr);
                return hour.add(minute.divide(new BigDecimal("60"), 2, BigDecimal.ROUND_HALF_UP));
            }
        } else {
            // 如果輸入的時間格式為: (x.y)
            return new BigDecimal(date);
        }
    }
    
    /**
     * 
     * <p>
     * Title: bigDecimal2String
     * </p>
     * <p>
     * description: 将BigDecimal类型的小数转换为 00:00 的格式
     * </p>
     * 
     * @param bigDecimal
     * @return 返回 00:00 格式的数据
     */
    public static String bigDecimal2String(BigDecimal bigDecimal) {
        BigDecimal[] divideAndRemainder = bigDecimal.divideAndRemainder(new BigDecimal("1"));
        String divide = divideAndRemainder[0].toBigInteger().toString();
        String remainer = divideAndRemainder[1].multiply(new BigDecimal("60")).toBigInteger().toString();
        if (remainer.length() == 1) {
            remainer = "0" + remainer;
        }
        return divide + ":" + remainer;
    }
    
    /**
     * 
     * <p>
     * Title: formatFloatStr
     * </p>
     * <p>
     * description:
     * </p>
     * 
     * @param bigDecimal
     * @return
     */
    public static String formatFloatStr(BigDecimal bigDecimal) {
        BigDecimal[] divideAndRemainder = bigDecimal.divideAndRemainder(new BigDecimal("1"));
        String divide = divideAndRemainder[0].toBigInteger().toString();
        String remainer = divideAndRemainder[1].multiply(new BigDecimal("100")).toBigInteger().toString();
        // String remainer = divideAndRemainder[1].multiply(new
        // BigDecimal("60")).toBigInteger().toString();
        if (remainer.length() == 1) {
            remainer = remainer + "0";
        }
        return divide + "." + remainer;
    }
    
    // public static void main(String[] args) {
    // System.out.println(formatFloatStr(new BigDecimal("2.0")));
    // }
    /**
     * 传入的Date带有时分秒参数, 这样查询数据库获取不到正确的输入,所以将时分秒参数值为零
     * 
     * @param date
     *            传入带有时分秒参数的Date数据
     * @return
     * @throws Exception
     */
    public static Date reduceAccuracyToDate(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String format = sdf.format(date);
            return sdf.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Title: parse
     * description:
     * @param format
     * @param dateStr
     * @return
     */
    public static Date parseStr2Date(String format, String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Title: parseDate2Str
     * description:
     * @param date
     * @param formatStr
     * @return
     */
    public static String parseDate2Str(String formatStr,Date date) {
        return new SimpleDateFormat(formatStr).format(date);
    }
    
    
    /**
     * 去除毫秒值
     * 
     * @param updTime
     */
    public static Long reduceAccuracyToDateTime(Long updTime) {
        BigDecimal bigDecimal = new BigDecimal(updTime);
        BigDecimal result = bigDecimal.divide(new BigDecimal("1000"), 0, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("1000"));
        return result.longValue();
    }
    
    /**
     * 直接使用set集合重写Comparator即可,不必使用list集合走弯路
     * 
     * @param <T>
     * @param list
     * @return
     */
    @Deprecated
    public static <T> List<T> removeDuplicateParam(List<T> list) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (result.contains(t)) {
                continue;
            } else {
                result.add(t);
            }
        }
        return result;
    }
    
    /**
     * 按照offset截取字符串,将多余的部分用...表示并将结果返回
     * 
     * @param rawStr
     *            待截取的字符串
     * @param offset
     *            需要的字符数
     * @return 截取完成的结果
     */
    @Deprecated
    public static String subString(String rawStr, int offset) {
        if (StringUtils.isBlank(rawStr)) {
            return null;
        } else {
            if (rawStr.length() < offset) {
                // System.out.println(rawStr);
                return rawStr;
            } else {
                String subString = rawStr.substring(0, offset);
                // System.out.println(subString);
                return subString.concat("...");
            }
        }
    }
    
    /**
     * Title: IterableToList
     * description: 将iterable集合转换为list, 为了用于JPA查询后返回的值的类型转换
     * @param iterable
     * @return 转换好的List<T>集合
     */
    public static <T> List<T> IterableToList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }
    
}
