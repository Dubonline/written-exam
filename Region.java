package com.example.writtenexam;

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
    private String name;

    @Override
    public String toString() {
        return "Region{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(name, region.name) && Objects.equals(code, region.code) && Objects.equals(parent, region.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, parent);
    }

    public Region() {
    }

    public Region(String name, String code, String parent) {
        this.name = name;
        this.code = code;
        this.parent = parent;
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

    private String code;
    private String parent;
}