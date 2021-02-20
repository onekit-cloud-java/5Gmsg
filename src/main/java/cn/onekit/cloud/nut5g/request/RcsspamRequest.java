package cn.onekit.cloud.nut5g.request;

import java.util.ArrayList;

public class RcsspamRequest {
    private ArrayList<String> messageId;
    private String spamType;
    private String freeText;

    public ArrayList<String> getMessageId() {
        return messageId;
    }

    public void setMessageId(ArrayList<String> messageId) {
        this.messageId = messageId;
    }

    public String getSpamType() {
        return spamType;
    }

    public void setSpamType(String spamType) {
        this.spamType = spamType;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }
}
