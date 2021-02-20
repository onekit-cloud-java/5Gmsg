package cn.onekit.cloud.nut5g;


import cn.onekit.cloud.nut5g.request.*;
import cn.onekit.cloud.nut5g.response.*;

public interface Nut5GAPI {

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
