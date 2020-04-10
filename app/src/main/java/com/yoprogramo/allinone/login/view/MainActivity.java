package com.yoprogramo.allinone.login.view;

import android.app.Activity;
import android.os.Bundle;

import com.yoprogramo.allinone.App;
import com.yoprogramo.allinone.networkservices.TwitchAPI;
import com.yoprogramo.allinone.networkservices.model.Top;
import com.yoprogramo.allinone.networkservices.model.Twitch;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends Activity {
    @Inject
    TwitchAPI twitchAPI;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getComponent().inject(this);

        twitchAPI.getTopGamesObservable()
                .flatMap((Function<Twitch, ObservableSource<Top>>) twitch -> Observable.fromIterable(twitch.getTop()))
                .flatMap((Function<Top, ObservableSource<String>>) top -> Observable.just(top.getGame().getName()))
                .filter(s -> s.startsWith("C"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                        System.out.println("Photo: " + s);

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        twitchAPI.getTopGamesObservable()
                .flatMap((Function<Twitch, ObservableSource<Top>>) twitch -> Observable.fromIterable(twitch.getTop()))
                .flatMap((Function<Top, ObservableSource<Integer>>) top -> Observable.just(top.getViewers()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer s) {

                        if(s == null){
                            System.out.println("Photo: item null");
                            return;
                        }

                        System.out.println("Photo: " + s.toString());

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("completes: " );
                    }
                });
    }


}
