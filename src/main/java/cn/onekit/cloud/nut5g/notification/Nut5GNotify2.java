package cn.onekit.cloud.nut5g.notification;


import cn.onekit.cloud.nut5g.BadSignException;
import cn.onekit.cloud.nut5g.notification.request.CheckNotification;
import cn.onekit.cloud.nut5g.notification.request.RcsspamNotification;
import cn.onekit.cloud.nut5g.notification.request.ReceivemessageNotification;
import cn.onekit.cloud.nut5g.notification.request.StatusNotification;
import cn.onekit.thekit.JSON;
import cn.onekit.thekit.SIGN;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public class Nut5GNotify2 {

    private static void _checkSign(HttpServletRequest request, String accessToken) throws Exception {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        List<String> list = Arrays.asList(accessToken, timestamp, nonce);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o1);
            }
        });
        String str = String.join("", list);


        if (!new SIGN(SIGN.Method.HMACSHA256).sign(str).equals(signature)) {
            throw new BadSignException();
        }
    }
    private static String _receiveJson(HttpServletRequest request) throws IOException {
        BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }
        return  responseStrBuilder.toString();
    }
    public static ReceivemessageNotification receivemessage(HttpServletRequest request,String accessToken) throws Exception{
        _checkSign(request,accessToken);

        return JSON.string2object(_receiveJson(request),ReceivemessageNotification.class);
    }

    public static StatusNotification status(HttpServletRequest request,String accessToken) throws Exception{
        _checkSign(request,accessToken);
        return JSON.string2object(_receiveJson(request),StatusNotification.class);
    }

    public static void informationChange(HttpServletRequest request,String accessToken) throws Exception{
        _checkSign(request,accessToken);

    }

    public static RcsspamNotification rcsspam(HttpServletRequest request,String accessToken) throws Exception{
        _checkSign(request,accessToken);
        return JSON.string2object(_receiveJson(request),RcsspamNotification.class);
    }

    public static CheckNotification check(HttpServletRequest request,String accessToken) throws Exception {
        _checkSign(request,accessToken);
        return JSON.string2object(_receiveJson(request),CheckNotification.class);
    }


}
