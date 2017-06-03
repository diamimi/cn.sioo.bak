package cn.sioo.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by morrigan on 2017/6/3.
 */
public abstract class BaseThread<T> {

    public static Logger LOGGER = LoggerFactory.getLogger(BaseThread.class);

    public T t;

    public BaseThread(T t) {
        this.t=t;
    }
}
