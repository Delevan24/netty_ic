package com.xiaoju.rxjava.first;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class RxJavaCreate {
    private static Logger log = LoggerFactory.getLogger("RxJavaCreate");

    public static void main(String[] args) {

        String[] arr = {"a", "b", "c"};
        Observable.fromArray(arr);
        Observable.fromArray("arr", "sss", "ddd");
        Observable.fromArray(1, 2, 3, 4);

        List<String> strings = Arrays.asList(arr);
        Observable.fromIterable(strings);

        Observable.just(1, 2, 3, 4, 5).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Throwable {
                log.info("test" + integer);
            }
        });

    }
}
