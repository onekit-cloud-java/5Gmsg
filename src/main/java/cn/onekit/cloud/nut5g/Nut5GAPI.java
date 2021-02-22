package cn.onekit.cloud.nut5g;


import cn.onekit.cloud.nut5g.request.*;
import cn.onekit.cloud.nut5g.response.*;
import cn.onekit.thekit.SIGN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public interface Nut5GAPI {

    default boolean _checkSign( String signature,String token,String timestamp,String nonce) throws Exception {
        List<String> list = Arrays.asList(token, timestamp, nonce);
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o1);
            }
        });
        String str = String.join("", list);

        return new SIGN(SIGN.Method.HMACSHA256).sign(str).equals(signature);
    }

    AccessTokenResponse accessToken(AccessTokenRequest request) throws Nut5GError;

    Nut5GResponse chatBotInfo(ChatBotInfoRequest request) throws Nut5GError;

    Nut5GResponse chatBotInfomenu(ChatBotInfomenuRequest request) throws Nut5GError;

    FindchatBotInfoResponse findchatBotInfo() throws Nut5GError;

    MediasuploadResponse mediasupload(byte[] request) throws Nut5GError;

    byte[] mediasdownload(String url) throws Nut5GError;

    MediasdeleteResponse mediasdelete(String url) throws Nut5GError;

    MessagesResponse messages(MessagesRequest request) throws Nut5GError;

    MessagesrevokeResponse messagesrevoke(MessagesrevokeRequest request) throws Nut5GError;

    void receivemessage(ReceivemessageRequest request) throws Nut5GError;

    void status(StatusRequest request) throws Nut5GError;

    void informationChange() throws Nut5GError;

    void rcsspam(RcsspamRequest request) throws Nut5GError;

    void check(CheckRequest request) throws Nut5GError;




}
