package com.example.studentpi.model.api;

import com.example.studentpi.model.Bean.User;
import com.example.studentpi.utils.RetrofitUtils;


import io.reactivex.Observable;

public class ApiWrapper extends RetrofitUtils {

    public Observable<User> testPost(String id) {
        return getService().testPost(id)
                .compose(this.<User>applySchedulers());
    }

}
