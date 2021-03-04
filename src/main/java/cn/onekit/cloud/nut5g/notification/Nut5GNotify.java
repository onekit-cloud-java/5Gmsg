package cn.onekit.cloud.nut5g.notification;


import cn.onekit.cloud.nut5g.BadSignException;
import cn.onekit.thekit.AJAX;
import cn.onekit.thekit.FileDB;
import cn.onekit.thekit.SIGN;


import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("unused")
public abstract class Nut5GNotify {
    protected final String signKey;
    protected  HttpServletRequest request;
    Nut5GNotify(HttpServletRequest request,String signKey) throws Exception {
        this.request=request;
        this.signKey=signKey;
        _checkSign(request);
    }

    protected  void _checkSign(HttpServletRequest request) throws Exception {
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
        FileDB.set("Headers", new Date().toString(), sb.toString());
        List<String> list = Arrays.asList(signKey, timestamp, nonce);
        Collections.sort(list);
        String str = String.join("", list);


        if (!new SIGN(SIGN.Method.HMACSHA256).sign(str).equals(signature)) {
            throw new BadSignException();
        }
    }

    public  String _receiveJson(HttpServletRequest request) throws IOException {
        String string  = AJAX.reveive(request);
        FileDB.set("notify",new Date().toString(),string);
        return  string;
    }
}
