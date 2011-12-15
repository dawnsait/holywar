package com.fasheng.map.utils;

import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpCilentUtils {

    @SuppressWarnings("finally")
    public static String httpRequestByGet(String url, String charset) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;
        String responseContent = StringUtils.EMPTY;
        HttpEntity entity = null;

        try {
            HttpGet httpget = new HttpGet(url);

            long start = System.currentTimeMillis();
            response = httpclient.execute(httpget);
            long end = System.currentTimeMillis();
            System.out.println("http request time used: " + (end - start) + " ms");

            int status = response.getStatusLine().getStatusCode();
            if (status != 200) {
                throw new Exception("resopnse status is: " + status);
            }

            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpclient.getConnectionManager().shutdown();
            return responseContent;
        }

    }

    public static void main(String[] args) throws Exception {

        String charset = "UTF-8";

        String domain = "http://ditu.google.cn";
        String api = "/maps/api/geocode/json?";
        String[] paramKey = { "address", "sensor" };
        String[] paramValue = { "网商路699号", "true" };

        String params = "";
        for (int i = 0; i < paramKey.length; i++) {
            params += paramKey[i] + "=" + URLEncoder.encode(paramValue[i], charset) + "&";
        }
        String url = domain + api + params.substring(0, params.length() - 1);

        System.out.println(url);

        String response = httpRequestByGet(url, charset);
        System.out.println("----------------------------------------");
        System.out.println(response);
        System.out.println("----------------------------------------");

    }

}
