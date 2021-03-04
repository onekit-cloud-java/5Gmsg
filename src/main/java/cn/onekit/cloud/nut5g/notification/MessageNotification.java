package cn.onekit.cloud.nut5g.notification;


import cn.onekit.cloud.nut5g.notification.request.ReceivemessageNotification;

import cn.onekit.thekit.JSON;

import javax.servlet.http.HttpServletRequest;


@SuppressWarnings("unused")
public class MessageNotification extends Nut5GNotify{

    public static ReceivemessageNotification receivemessage(HttpServletRequest request,String accessToken) throws Exception{
        _checkSign(request,accessToken);
        return JSON.string2object(_receiveJson(request),ReceivemessageNotification.class);
    }






}
