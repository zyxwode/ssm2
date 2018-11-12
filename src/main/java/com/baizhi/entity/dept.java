package com.baizhi.entity;

public class dept {
    private String id;
    private String dept_name;

    public dept() {
    }

    public dept(String id, String dept_name) {
        this.id = id;
        this.dept_name = dept_name;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getId() {
        return id;
    }

    public String getDept_name() {
        return dept_name;
    }

    @Override
    public String toString() {
        return "dept{" +
                "id='" + id + '\'' +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
