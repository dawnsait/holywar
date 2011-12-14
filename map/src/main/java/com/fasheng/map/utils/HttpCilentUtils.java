package com.fasheng.map.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpCilentUtils {

    public static String httpRequestByGet(String url, String charset)
            throws ClientProtocolException, IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = null;
        String responseContent = "";
        InputStream in = null;
        try {
            HttpGet httpget = new HttpGet(url);

            long start = System.currentTimeMillis();
            response = httpclient.execute(httpget);
            long end = System.currentTimeMillis();
            System.out.println("http request time used: " + (end - start) + " ms");

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                in = entity.getContent();
                responseContent = readResponse(in, charset);
            }

            //			ResponseHandler<String> responseHandler = new BasicResponseHandler();
            //            responseContent = httpclient.execute(httpget, responseHandler);

        } finally {
            //记得关闭输入流  
            if (in != null)
                in.close();

            httpclient.getConnectionManager().shutdown();
        }
        return responseContent;
    }

    public static String readResponse(InputStream in, String charset) throws IOException {
        String responseContent = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
        String line = null;
        while ((line = reader.readLine()) != null) {
            responseContent += "\n";
            responseContent += line;
        }
        return responseContent;
    }

    public static void main(String[] args) {
        try {
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

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
