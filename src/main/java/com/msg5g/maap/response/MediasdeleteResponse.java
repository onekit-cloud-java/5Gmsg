package com.msg5g.maap.response;
@SuppressWarnings("unused")
public class MediasdeleteResponse {
    private String deleteMode;
    private int fileCount;
    private int totalCont;

    public String getDeleteMode() {
        return deleteMode;
    }

    public void setDeleteMode(String deleteMode) {
        this.deleteMode = deleteMode;
    }

    public int getFileCount() {
        return fileCount;
    }

    public void setFileCount(int fileCount) {
        this.fileCount = fileCount;
    }

    public int getTotalCont() {
        return totalCont;
    }

    public void setTotalCont(int totalCont) {
        this.totalCont = totalCont;
    }
}
