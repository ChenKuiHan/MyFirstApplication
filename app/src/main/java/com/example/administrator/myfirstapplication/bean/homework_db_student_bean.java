package com.example.administrator.myfirstapplication.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/3 0003.
 */
public class homework_db_student_bean implements Serializable {
    private int _id;
    private int pic;
    private String name;
    private int age;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

