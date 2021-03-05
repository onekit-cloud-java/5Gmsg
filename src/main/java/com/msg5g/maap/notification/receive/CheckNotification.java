package com.msg5g.maap.notification.receive;
@SuppressWarnings("unused")
public class CheckNotification {
    public enum Type{
        chatbotInformation,
        media,
        message
    }
    private Type type;
    private String result;
    private String description;
    private String time;
    private String remark;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
