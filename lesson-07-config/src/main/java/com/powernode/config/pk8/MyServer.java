package com.powernode.config.pk8;

public class MyServer {
    String title;
    String ip;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "MyServer{" +
                "title='" + title + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
