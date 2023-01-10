package com.example.demo.properties;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 创建业务类
 *
 * @author zaochun.zjw
 * @date 2023/1/9
 */
public class HttpClient {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //获取网页数据
    public String getHtml(){
        try{
            URL url = new URL(this.url);
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
            String line = null;
            StringBuilder sp = new StringBuilder();
            while ( (line = br.readLine()) !=null){
                sp.append(line).append("\n");
            }
            return sp.toString();
        }catch (Throwable e){
            e.printStackTrace();;
        }

        return "error";
    }
}
