package com.xiaoju.rxjava.first;

import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RxJavaTest {

    private static Logger logger = LoggerFactory.getLogger(RxJavaTest.class);

    public static void main(String[] args) {
        Observable mObservable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onComplete();
            }
        });

        Observer mObserver = new Observer<Integer>() {
            //这是新加入的方法，在订阅后发送数据之前，
            //回首先调用这个方法，而Disposable可用于取消订阅
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer value) {
                System.out.println("lucas onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        mObservable.subscribe(mObserver);


        Flowable.range(0, 10)
                .subscribe(new Subscriber<Integer>() {
                    Subscription sub;

                    //当订阅后，会首先调用这个方法，其实就相当于onStart()，
                    //传入的Subscription s参数可以用于请求数据或者取消订阅
                    @Override
                    public void onSubscribe(Subscription s) {
                        System.out.println("TAG onsubscribe start");
                        sub = s;
                        sub.request(1);
                        System.out.println("TAG onsubscribe end");
                    }

                    @Override
                    public void onNext(Integer o) {
                        logger.info("TAG onNext--->" + o);
                        sub.request(1);
                    }

                    @Override
                    public void onError(Throwable t) {
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("TAG onComplete");
                    }
                });


        Flowable.create(new FlowableOnSubscribe<Integer>() {
                            @Override
                            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                                e.onNext(1);
                                e.onNext(2);
                                e.onNext(3);
                                e.onNext(4);
                                e.onComplete();
                            }
                        }
                //需要指定背压策略
                , BackpressureStrategy.BUFFER);


    }
}
