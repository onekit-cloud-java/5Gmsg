package cn.onekit.cloud.nut5g.notification;

import java.util.List;
@SuppressWarnings("unused")
public class StatusNotification {
    private List<DeliveryInfo> deliveryInfoList;

    public static class DeliveryInfo{
        private String messageId;
        private String dateTime;
        public enum status{
            sent,
            failed,
            delivered,
            displayed,
            deliveredToNetwork,
            revokeOk,
            revokeFail,
        }
        private String errorCode;
        private String errorMessage;
        private String destinationAddress;
        private String senderAddress;

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getDestinationAddress() {
            return destinationAddress;
        }

        public void setDestinationAddress(String destinationAddress) {
            this.destinationAddress = destinationAddress;
        }

        public String getSenderAddress() {
            return senderAddress;
        }

        public void setSenderAddress(String senderAddress) {
            this.senderAddress = senderAddress;
        }
    }

    public List<DeliveryInfo> getDeliveryInfoList() {
        return deliveryInfoList;
    }

    public void setDeliveryInfoList(List<DeliveryInfo> deliveryInfoList) {
        this.deliveryInfoList = deliveryInfoList;
    }
}
