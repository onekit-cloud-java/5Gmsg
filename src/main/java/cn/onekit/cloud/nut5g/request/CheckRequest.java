package cn.onekit.cloud.nut5g.request;

public class CheckRequest {
    public enum type{
        chatbotInformation,
        media,
        message
    }
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
}
