package com.example.vincent.minaandroidservice.bean;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name MinaAndroidService
 * @page com.example.vincent.minaandroidservice.bean
 * @class describe
 * @date 2018/3/29 10:17
 */
public class MsgBean {

    // 0 客户端 1 服务器
    private int type;
    private String content;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
