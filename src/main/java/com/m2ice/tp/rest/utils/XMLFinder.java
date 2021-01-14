package com.m2ice.tp.rest.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLFinder {

    public static String findAttribute(String xml, String attribute) {
//        Pattern pattern = Pattern.compile("*" + attribute + "=\"(.*)\"*");
//        Matcher matcher = pattern.matcher(xml);
//        if (matcher.matches()) {
//            return matcher.group(0);
//        }
//        return "";

        int pos1=xml.indexOf(attribute+"=\""); // On ne fait qu'avec "
        if (pos1<0) return null;
        int pos2=xml.indexOf("\"", pos1 + attribute.length()+2);
        return xml.substring(pos1 + attribute.length()+2, pos2);
    }
}
