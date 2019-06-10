package com.lt.okhttp;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Create by Lituo on 2019/6/10  23:31
 */

public class JOSNHttpRequest implements IHttpRequest{

    private String url;
    private byte[] data;
    private CallbackListener callbackListener;
    private HttpURLConnection mURLConnection;
    @Override
    public void setUrl(String url) {
        this.url=url;
    }

    @Override
    public void setData(byte[] data) {
        this.data=data;
    }

    @Override
    public void setListener(CallbackListener listener) {
        this.callbackListener=callbackListener;
    }

    @Override
    public void excute() {
        //执行网络访问
        URL url=null;
        try {
            url=new URL(this.url);
            mURLConnection= (HttpURLConnection) url.openConnection();//打开http连接
            mURLConnection.setConnectTimeout(6000);//连接的超时时间
            mURLConnection.setUseCaches(false);//是否适用缓存
            mURLConnection.setInstanceFollowRedirects(true);//是成员函数，仅用与当前函数，设置这个链接是否可以被重定向
            mURLConnection.setReadTimeout(3000);//响应超时时间
            mURLConnection.setDoInput(true);//设置这个连接是否可以写入数据
            mURLConnection.setDoOutput(true);//设置这个连接是否可以输出数据
            mURLConnection.setRequestMethod("POST");//
            mURLConnection.setRequestProperty("Content-Type","application/json;charset=UTF-8");//设置消息的类型
            mURLConnection.connect();//连接，从上述至此的配置要在connect之前完成，实际上它只是建立了一个与服务器的TCP连接

            //使用字节流发送数据
            OutputStream out=mURLConnection.getOutputStream();
            BufferedOutputStream bos=new BufferedOutputStream(out);//缓冲字节流包装字节流
            bos.write(data);//把字节数组的数据写进缓冲区
            bos.flush();//刷新缓冲区，发送数据
            out.close();
            bos.close();
            //使用字符流写入数据
            if(mURLConnection.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream in=mURLConnection.getInputStream();
                callbackListener.onSuccess(in);
                //数据返回到我们的框架中
            }else{
                 throw new RuntimeException("请求失败");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            mURLConnection.disconnect();
        }
    }
}
