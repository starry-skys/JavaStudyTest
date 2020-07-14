package com.designMode.protype;

import java.io.Serializable;

/**
 * @Author Stephen
 * @DATE 2020/1/15 11:28
 */
public class Subject implements Serializable {
    private String name;
    private String content;

    public String getName() {
        return name;
    }

    public Subject setName(String name) {
        this.name = name;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Subject setContent(String content) {
        this.content = content;
        return this;
    }

    public Subject(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Subject() {
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

}
