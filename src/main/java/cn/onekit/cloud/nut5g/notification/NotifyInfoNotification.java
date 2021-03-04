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


    public  NotifyInfoNotification(HttpServletRequest request, String signKey) throws Exception {
        super(request, signKey);
    }

    public   void informationChange() throws Exception{


    }

    public  RcsspamNotification rcsspam() throws Exception{
        return JSON.string2object(_receiveJson(request),RcsspamNotification.class);
    }

    public  CheckNotification check() throws Exception {
        return JSON.string2object(_receiveJson(request),CheckNotification.class);
    }


}
