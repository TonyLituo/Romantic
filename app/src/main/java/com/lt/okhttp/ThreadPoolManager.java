package com.lt.okhttp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create by Lituo on 2019/6/10  22:39
 */

public class ThreadPoolManager {

    public static ThreadPoolManager sThreadPoolManager = new ThreadPoolManager();


    public static ThreadPoolManager getInstance(){
        if (null==sThreadPoolManager){
            synchronized (ThreadPoolManager.class){
                if (null==sThreadPoolManager){
                    sThreadPoolManager=new ThreadPoolManager();
                }
            }
        }
        return sThreadPoolManager;
    }
    //排序模式：先进先出
    private LinkedBlockingQueue<Runnable> mQueue =new LinkedBlockingQueue<>();
    //将异步任务添加到队列中
    public void addTask(Runnable runnable){
        try {
            mQueue.put(runnable);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //创建线程池
    private ThreadPoolExecutor mThreadPoolExecutor;

    private ThreadPoolManager() {
        mThreadPoolExecutor=new ThreadPoolExecutor(3, 10, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4), new RejectedExecutionHandler() {//线程异常
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        addTask(r);
    }
});
        //线程池需要处理核心线程
        mThreadPoolExecutor.execute(coreThread);
    }

    //创建核心线程，不停地去队列中获取请求，并提交给线程池处理
    private Runnable coreThread=new Runnable() {
        Runnable runnable=null;
        @Override
        public void run() {
            while (true){
                try {
                    runnable=mQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
}
