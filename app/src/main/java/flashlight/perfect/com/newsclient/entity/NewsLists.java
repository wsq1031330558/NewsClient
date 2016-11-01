package flashlight.perfect.com.newsclient.entity;

/**
 * 新闻列表中的Data中的数据
 */

public class NewsLists {
    String summary;
    String icon;
    String stamp;
    String title;
    int nid;
    String link;

    @Override
    public String toString() {
        return "NewsLists{" +
                "summary='" + summary + '\'' +
                ", icon='" + icon + '\'' +
                ", stamp='" + stamp + '\'' +
                ", title='" + title + '\'' +
                ", nid=" + nid +
                ", link='" + link + '\'' +
                ", type=" + type +
                '}';
    }

    int type;

    public NewsLists(String summary, String title, String stamp, String icon, String link, int nid, int type) {
        this.summary = summary;
        this.title = title;
        this.stamp = stamp;
        this.icon = icon;
        this.link = link;
        this.nid = nid;
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;

    }

    public String getStamp() {
        return stamp;
    }

    public String getTitle() {
        return title;
    }

    public int getNid() {
        return nid;
    }

    public String getLink() {
        return link;
    }

    public int getType() {
        return type;
    }
}
