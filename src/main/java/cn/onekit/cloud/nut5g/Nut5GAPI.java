package cn.onekit.cloud.nut5g;


import cn.onekit.cloud.nut5g.notification.ReceivemessageNotification;
import cn.onekit.cloud.nut5g.notification.StatusNotification;
import cn.onekit.cloud.nut5g.request.*;
import cn.onekit.cloud.nut5g.response.*;
import cn.onekit.thekit.SIGN;

import java.util.*;

public interface Nut5GAPI {

    AccessTokenResponse accessToken(AccessTokenRequest request) throws Nut5GError;

    void chatBotInfo(String accessToken,ChatBotInfoRequest request) throws Nut5GError;

    void chatBotInfomenu(String accessToken,ChatBotInfomenuRequest request) throws Nut5GError;

    FindchatBotInfoResponse findchatBotInfo(String accessToken) throws Nut5GError;

    MediasuploadResponse mediasupload(String accessToken,String uploadMode, Map<String,byte[]> files) throws Nut5GError;

    byte[] mediasdownload(String accessToken,String url) throws Nut5GError;

    MediasdeleteResponse mediasdelete(String accessToken,String url) throws Nut5GError;

    MessagesResponse messages(String accessToken,MessagesRequest request) throws Nut5GError;

    MessagesrevokeResponse messagesrevoke(String accessToken,MessagesrevokeRequest request) throws Nut5GError;






}
