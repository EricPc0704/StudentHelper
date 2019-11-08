package com.example.studentpi.model.Bean;

public class User {
    private String name;
    private String type;
    private String createAt;
    private String homeDirId;
    private String custId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getHomeDirId() {
        return homeDirId;
    }

    public void setHomeDirId(String homeDirId) {
        this.homeDirId = homeDirId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
