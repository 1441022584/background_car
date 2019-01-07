/**
 * Copyright (C),2018
 * FileName: 段国强
 * Author:   admin
 * Date:     2019/1/1 17:25
 * Description: 实体
 * History:
 */
package com.jk.car.model;

import java.io.Serializable;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈实体〉
 *
 * @author admin
 * @create 2019/1/1
 * @since 1.0.0
 */
public class TreeBean implements Serializable {


    private static final long serialVersionUID = 7347863424235391297L;


    private Integer id;

    private String text;

    private String href;

    private Integer pid;

    private Boolean selectable;  //节点能否被点击 选中  叶子节点才能被选中

    private List<TreeBean> nodes;   // 不能叫children 只能叫nodes


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public List<TreeBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeBean> nodes) {
        this.nodes = nodes;
    }


    @Override
    public String toString() {
        return "TreeBean{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", href='" + href + '\'' +
                ", pid=" + pid +
                ", selectable=" + selectable +
                ", nodes=" + nodes +
                '}';
    }
}
