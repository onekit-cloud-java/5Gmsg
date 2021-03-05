package com.msg5g.maap.notification;


import cn.onekit.thekit.SIGN;
import com.msg5g.maap.BadSignException;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


@SuppressWarnings("unused")
public interface  NotificationAPI {


    default void _checkSign(HttpServletRequest request,String token) throws Exception {
        String signature = request.getHeader("signature");
        String timestamp = request.getHeader("timestamp");
        String nonce = request.getHeader("nonce");
        StringBuilder sb = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            Enumeration<String> headerValues = request.getHeaders(headerName);
            while(headerValues.hasMoreElements()) {
                String headerValue = headerValues.nextElement();
                sb.append(String.format("%s=%s;",headerName,headerValue));
            }
        }
        //FileDB.set("Headers", new Date().toString(), sb.toString());
        List<String> list = Arrays.asList(token, timestamp, nonce);
        Collections.sort(list);
        String str = String.join("", list);


        if (!new SIGN(SIGN.Method.HMACSHA256).sign(str).equals(signature)) {
            throw new BadSignException();
        }
    }


}
