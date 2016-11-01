package flashlight.perfect.com.newsclient.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import flashlight.perfect.com.newsclient.R;
import flashlight.perfect.com.newsclient.adapter.GuidAdapter;

/****
 * 引导页面
 ****/

public class GuidActivity extends AppCompatActivity {
    ViewPager mVp;
    //三个点
    ImageView[] mImg;
    //三张图片
    ImageView[] mRed;
    //三张图片ID
    int[] mId = {R.drawable.bd, R.drawable.welcome, R.drawable.wy,R.drawable.small};
    //最上方文本
    TextView mTxt;
    //适配器
    GuidAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guid);
        mVp = (ViewPager) findViewById(R.id.vp_activity_guid);
        mTxt = (TextView) findViewById(R.id.txt_activity_guid);
        //将文本设置为隐藏
        mTxt.setVisibility(View.INVISIBLE);
        mImg = new ImageView[4];
        mRed = new ImageView[4];
        //三个小点
        mImg [0]= (ImageView) findViewById(R.id.img_guid_activity_0);
        mImg [1]= (ImageView) findViewById(R.id.img_guid_activity_1);
        mImg [2]= (ImageView) findViewById(R.id.img_guid_activity_2);
        mImg [3]= (ImageView) findViewById(R.id.img_guid_activity_3);
        //将第一个点点设置为绿色
        mImg[0].setImageResource(R.drawable.adware_style_selected);
        //加载数据源
        for (int i = 0; i <4 ; i++) {
            mRed[i]=new ImageView(this);
            mRed[i].setImageResource(mId[i]);
        }
        //适配器
        mAdapter=  new GuidAdapter(mRed);
        mVp.setAdapter(mAdapter);
        //刷新适配器
        mAdapter.notifyDataSetChanged();
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==3) {
                    mTxt.setVisibility(View.VISIBLE);
                    mRed[3].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            new Thread(){
                                @Override
                                public void run() {
                                    try {
                                        Thread.sleep(3000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    startActivity(new Intent(GuidActivity.this,MainActivity.class));
                                    GuidActivity.this.finish();
                                }
                            }.start();
                        }
                    });
                }else
                {
                    mTxt.setVisibility(View.INVISIBLE);
                }
                for (int i = 0; i < mImg.length; i++) {
                    mImg[i].setImageResource(R.drawable.adware_style_default);
                }
                mImg[position].setImageResource(R.drawable.adware_style_selected);

            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intnet = new Intent(GuidActivity.this
                , MainActivity.class);
                startActivity(intnet);
                GuidActivity.this.finish();
            }
        });








    }
}
