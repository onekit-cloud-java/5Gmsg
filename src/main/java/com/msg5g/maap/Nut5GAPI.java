package com.msg5g.maap;

import com.msg5g.maap.request.*;
import com.msg5g.maap.response.*;


import java.util.*;
@SuppressWarnings("unused")
public interface Nut5GAPI {

    AccessTokenResponse accessToken(AccessTokenRequest request) throws Nut5GError;

    void chatBotInfo(String accessToken, ChatBotInfoRequest request) throws Nut5GError;

    void chatBotInfomenu(String accessToken, ChatBotInfomenuRequest request) throws Nut5GError;

    FindchatBotInfoResponse findchatBotInfo(String accessToken) throws Nut5GError;

    MediasuploadResponse mediasupload(String accessToken, String uploadMode, Map<String,byte[]> files) throws Nut5GError;

    byte[] mediasdownload(String accessToken,String url) throws Nut5GError;

    MediasdeleteResponse mediasdelete(String accessToken, String url) throws Nut5GError;

    MessagesResponse messages(String accessToken, MessagesRequest request) throws Nut5GError;

    MessagesrevokeResponse messagesrevoke(String accessToken, MessagesrevokeRequest request) throws Nut5GError;






}
