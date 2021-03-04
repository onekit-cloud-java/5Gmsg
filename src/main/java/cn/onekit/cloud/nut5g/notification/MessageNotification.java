package cn.onekit.cloud.nut5g.notification;


import cn.onekit.cloud.nut5g.notification.request.ReceivemessageNotification;

import cn.onekit.thekit.JSON;

import javax.servlet.http.HttpServletRequest;


@SuppressWarnings("unused")
public class MessageNotification extends Nut5GNotify{


    public   MessageNotification(HttpServletRequest request, String signKey) throws Exception {
        super(request, signKey);
    }

    public ReceivemessageNotification receivemessage() throws Exception{
        return JSON.string2object(_receiveJson(request),ReceivemessageNotification.class);
    }






}
