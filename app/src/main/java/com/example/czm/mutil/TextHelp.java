package com.example.czm.mutil;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author czm
 * Desc:
 * @date 2019/6/3 0003
 **/
public class TextHelp {

    //人民币符号
    public static final String RMB = "" + Html.fromHtml("&yen");


    /**
     * 转千位符 无小数位去除小数
     *
     * @param num
     * @return
     */
    public static String num2thousand(String num) {
        String numStr = "";
        if (TextUtils.isEmpty(num)) {
            return numStr;
        }

        NumberFormat nf = NumberFormat.getInstance();
        try {
            BigDecimal bigDecimal = new BigDecimal(num);
            if ((bigDecimal.doubleValue() % 1) > 0) {
                DecimalFormat df = new DecimalFormat("#,##0.00");
                numStr = df.format(nf.parse(num));
            } else {
                DecimalFormat df = new DecimalFormat("#,##0");
                numStr = df.format(nf.parse(num));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return numStr;

    }

    /**
     * 转千位符 无小数位去除小数
     *
     * @param bdNum
     * @return
     */
    public static String num2thousand(BigDecimal bdNum) {
        String numStr = "";
        String num = getNum(bdNum);
        NumberFormat nf = NumberFormat.getInstance();
        try {
            BigDecimal bigDecimal = new BigDecimal(num);
            if ((bigDecimal.doubleValue() % 1) > 0) {
                DecimalFormat df = new DecimalFormat("#,##0.00");
                numStr = df.format(nf.parse(num));
            } else {
                DecimalFormat df = new DecimalFormat("#,##0");
                numStr = df.format(nf.parse(num));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return numStr;

    }

    /**
     * 转千位符 保留两位小数
     *
     * @param num
     * @return
     */
    public static String num2thousand20(String num) {
        String numStr = "";
        if (TextUtils.isEmpty(num)) {
            return numStr;
        }
        NumberFormat nf = NumberFormat.getInstance();
        try {
            DecimalFormat df = new DecimalFormat("#,##0.00");
            numStr = df.format(nf.parse(num));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return numStr;
    }


    /**
     * BigDecimal转String
     *
     * @param bd
     * @return
     */
    public static String getNum(BigDecimal bd) {
        if (bd == null) {
            return new BigDecimal(BigInteger.ZERO).toString();
        }
        return bd.toString();
    }

    /**
     * BigDecimal转Float
     *
     * @param bd
     * @return
     */
    public static Float getNumByFloat(BigDecimal bd) {
        if (bd == null) {
            return new BigDecimal(BigInteger.ZERO).floatValue();
        }
        return bd.floatValue();
    }

    /**
     * BigDecimal转String 保留小数
     *
     * @param bd
     * @param v
     * @return
     */
    public static String getNum(BigDecimal bd, int v) {
        if (bd == null) {
            return new BigDecimal(BigInteger.ZERO).setScale(v, RoundingMode.HALF_UP).toString();
        }
        return bd.setScale(v, RoundingMode.HALF_UP).toString();
    }

    /**
     * 字符串空组合
     *
     * @param string
     * @return
     */
    public static String getStrings(String... string) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : string) {
            if (!TextUtils.isEmpty(str)) {
                stringBuffer.append(str);
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 字符串空过滤
     *
     * @param string
     * @return
     */
    public static String getString(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    /**
     * 字符串空过滤
     *
     * @param string
     * @param str    空替代字符串
     * @return
     */
    public static String getString(String string, String str) {
        if (TextUtils.isEmpty(string)) {
            return str;
        }
        return string;
    }


    /**
     * 字符串空判断
     *
     * @param str
     * @return
     */
    public static boolean isNull(String... str) {
        for (String s : str) {
            if (TextUtils.isEmpty(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符空判断pro
     *
     * @param str
     * @return
     */
    public static boolean isNullAndText(String... str) {
        for (String s : str) {
            if (TextUtils.isEmpty(s)) {
                return true;
            } else {
                return "null".equals(s) || "NULL".equals(s);
            }
        }
        return false;
    }

    /**
     * 集合空判断
     *
     * @param obj
     * @return
     */
    public static boolean isNull(final Collection<?> obj) {
        return (obj == null) || (obj.size() <= 0);
    }


}
