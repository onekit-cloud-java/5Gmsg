package cn.onekit.
        cloud.nut5g.notification;


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
public class NotifyInfoNotification extends Nut5GNotify{



    public static void informationChange(HttpServletRequest request,String accessToken) throws Exception{
        //_checkSign(request,accessToken);

    }

    public static RcsspamNotification rcsspam(HttpServletRequest request,String accessToken) throws Exception{
        //_checkSign(request,accessToken);
        return JSON.string2object(_receiveJson(request),RcsspamNotification.class);
    }

    public static CheckNotification check(HttpServletRequest request,String accessToken) throws Exception {
        //_checkSign(request,accessToken);
        return JSON.string2object(_receiveJson(request),CheckNotification.class);
    }


}
