package flashlight.perfect.com.newsclient.task;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import flashlight.perfect.com.newsclient.inter.onLoadInfoListener;

/**
 * 对新闻列表中的内容进行解析
 */

public class NewsCenterTask extends AsyncTask<String, Void, String> {
    {
        Log.e("——————————", "---------");
    }
    //static final String url = "http://118.244.212.82:9092/newsClient/path/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";

    onLoadInfoListener mLoadInfoListener;

    public void setOnloadInfoLitenter(onLoadInfoListener loadInfoListener){
        this.mLoadInfoListener = loadInfoListener;
    }

    @Override
    protected String doInBackground(String... params) {
        //路径地址
        String path = params[0];
        Log.e("-------","------path="+path.toString());
      //  path=url;
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        try {
            URL url= new URL(path);
            Log.e("-------","------url="+url.toString());
            httpURLConnection = (HttpURLConnection) url.openConnection();
            Log.e("-------","------httpURLConnection="+httpURLConnection.toString());
            Log.e("------","___________________"+httpURLConnection.getResponseCode());
            if (httpURLConnection.getResponseCode() ==HttpURLConnection.HTTP_OK) {
                Log.e("-------","------");
                inputStream = httpURLConnection.getInputStream();
                byte[] bytes=new byte[1024];
                Log.e("------","------bytes=="+bytes.length);

                int length = 0;
                StringBuffer buffer = new StringBuffer();
                while ((length = inputStream.read(bytes)) != -1) {
                    buffer.append(new String(bytes, 0, length));
                    //Log.e("====",""+ buffer.toString());
                }
                Log.e("====","222222222222222222"+ buffer.toString());
                return buffer.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //进行关闭各种流的操作
            if (null != httpURLConnection) {
                httpURLConnection.disconnect();
            }
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s != null && mLoadInfoListener != null) {
            mLoadInfoListener.getInfo(s);
        }
    }

}
