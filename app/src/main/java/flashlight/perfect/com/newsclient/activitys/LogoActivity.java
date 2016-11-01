package flashlight.perfect.com.newsclient.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import flashlight.perfect.com.newsclient.R;

/***
 * 进入页面
 ***/

public class LogoActivity extends AppCompatActivity {
    public static final String FILE_NAME = "config";
    public static final String IS_FIRST = "first";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //判断是否为第一次进入
        SharedPreferences shar=this.getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        //默认第一次进入，所有得到默认值
        boolean flag = shar.getBoolean(IS_FIRST, true);
        if (flag) {
            //若第一次进入，进入滑动界面
            startActivity(new Intent(LogoActivity.this,GuidActivity.class));
            //启动编辑器 对象
            SharedPreferences.Editor edit = shar.edit();
            //修改数据，表示不再是第一次进入
            edit.putBoolean(IS_FIRST,false);
            //提交数据
            edit.commit();
            //结束 当前页面
            LogoActivity.this.finish();
            overridePendingTransition(R.anim.enter,R.anim.exits);
        }
        else {
            overridePendingTransition(R.anim.enter,R.anim.exits);
            setContentView(R.layout.activity_logo);
            new Thread(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 子线程睡眠5秒后通知主线程发生跳转
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(LogoActivity.this, MainActivity.class));
                            LogoActivity.this.finish();
                        }
                    });

                }
            }.start();
        }



    }
}
