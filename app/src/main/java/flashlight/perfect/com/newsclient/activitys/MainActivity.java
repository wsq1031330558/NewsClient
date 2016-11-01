package flashlight.perfect.com.newsclient.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import flashlight.perfect.com.newsclient.R;
import flashlight.perfect.com.newsclient.fragments.CreaterFragment;

public class MainActivity extends AppCompatActivity {
    //主页面
    CreaterFragment mCreaterFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        mCreaterFragment= (CreaterFragment) getSupportFragmentManager().findFragmentById(R.id.center_layout);

    }
}
