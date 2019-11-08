package com.example.studentpi.model.Bean;


import com.example.studentpi.utils.Constant;

/**
 * Created by Sunflower on 2016/1/11.
 */
public class Response<T> {

    public String status;
    public String message;
    public T response;


    public boolean isSuccess() {
        return status.equals(Constant.OK);
    }
}
