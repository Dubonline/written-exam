package com.example.writtenexam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @projectName: written-exam
 * @package: com.example.writtenexam
 * @className: Region
 * @author: dubo
 * @description: TODO
 * @date: 2022/12/7 12:15
 * @version: 1.0
 */
public class Region {
    private String id;
    private String name;
    private String code;
    private String parent;
    private List<Region> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parent='" + parent + '\'' +
                ", children=" + children +
                '}';
    }

    public List<Region> getChildren() {
        return children;
    }

    public void setChildren(List<Region> children) {
        this.children = children;
    }
}