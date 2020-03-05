package com.ttai.demo.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 防止字符串sql注入过滤方法
 */
public class SqlUtils {

    public static Object clearSqlCode(Object obj) {
        if (obj instanceof String) {
            String st = (String) obj;
            if (StringUtils.isNotEmpty(st)) {
                st = st.replaceAll("\'", "''");
                st = st.replaceAll("\"", "");
                st = st.replaceAll("--", "");
                return st;
            }
        }
        return obj;
    }


    public static Object clearWebCode(Object obj) {
        if (obj instanceof String) {
            String st = (String) obj;
            st = st.replaceAll("<", "-&lt;");
            st = st.replaceAll(">", "-&gt;");
            return st;
        }
        return obj;
    }


    public static void main(String[] arge) {

        String st = "fas''df--1231\"23";
        System.out.println(SqlUtils.clearSqlCode(st));

        String st2 = "<fasdf--123123>";
        System.out.println(SqlUtils.clearWebCode(st2));
        System.out.println(st2.replaceAll(">", "--11&gt;"));

    }


}
