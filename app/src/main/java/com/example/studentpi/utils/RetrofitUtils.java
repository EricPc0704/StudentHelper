package com.example.studentpi.utils;

import android.util.Log;

import com.example.studentpi.model.Bean.Response;
import com.example.studentpi.model.api.APIService;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    private static APIService service;
    private static Retrofit retrofit;
    private static final String API_HOST = Constant.API_HOST;

    public static APIService getService() {
        if (service == null) {
            service = getRetrofit().create(APIService.class);
        }
        return service;
    }

    private static Retrofit getRetrofit() {
        if (retrofit == null) {


            OkHttpClient client = new OkHttpClient.Builder()
                    //log请求参数
//                    .addInterceptor(interceptor)
                    .build();
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(API_HOST)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }


    protected <T> ObservableTransformer<Response<T>, T> applySchedulers() {
        return (ObservableTransformer<Response<T>, T>) transformer;
    }

    final ObservableTransformer transformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(Observable upstream) {
            return upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .flatMap(new Function() {
                        @Override
                        public Object apply(Object o) throws Exception {
                            return flatResponse((Response<Object>) o);

                        }
                    })
                    ;
        }

    };

    public <T> Observable<T> flatResponse(final Response<T> response) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) {
                if (response.isSuccess()) {
                    if (!emitter.isDisposed()) {
                        emitter.onNext(response.response);
                    }
                } else {
                    if (!emitter.isDisposed()) {
                        emitter.onError(new APIException(response.status, response.message));
                    }
                    return;
                }

                if (!emitter.isDisposed()) {
                    emitter.onComplete();
                }
            }
        });
    }


    public static class APIException extends Exception {
        public String code;
        public String message;

        public APIException(String code, String message) {
            this.code = code;
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }


}
