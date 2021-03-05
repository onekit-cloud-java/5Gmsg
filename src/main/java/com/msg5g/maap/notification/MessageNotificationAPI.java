package com.msg5g.maap.notification;


import com.msg5g.maap.notification.receive.ReceivemessageNotification;


@SuppressWarnings("unused")
public interface MessageNotificationAPI  {


     ReceivemessageNotification receivemessage() throws Exception;


}





