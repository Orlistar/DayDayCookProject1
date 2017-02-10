package com.example.orlistarlib.util;

import android.os.Handler;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/12/26 0026.
 */

public class DownloadUtil {
    private static Handler handler = new Handler();

    public interface OnDownloadFinishedListener {
        void onDownloadFinished(String jsonData);
    }

    public static void download(final String url, final OnDownloadFinishedListener listener) {
        new Thread() {
            @Override
            public void run() {
                final String json = requestJson(url);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null) {
                            listener.onDownloadFinished(json);
                        }
                    }
                });
            }
        }.start();
    }

    private static String requestJson(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setConnectTimeout(3000);
            InputStream is = conn.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024 * 8];
            int len;
            while ((len = is.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            byte[] buffers = out.toByteArray();
            is.close();
            out.close();
            conn.disconnect();
            return new String(buffers);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
