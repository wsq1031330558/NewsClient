package flashlight.perfect.com.newsclient.entity;

import java.util.ArrayList;

/**
 * 新闻列表中的外层数据
 */

public class NewList {
    String message;
    String status;
    ArrayList<NewsLists> data;

    public NewList(String status, String message, ArrayList<NewsLists> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<NewsLists> getData() {
        return data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setData(ArrayList<NewsLists> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "NewList{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}
