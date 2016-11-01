package flashlight.perfect.com.newsclient.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Administrator on 2016/10/27 0027.
 */

public class GuidAdapter extends PagerAdapter {
    //三张图片
    ImageView[] mRed;

    public GuidAdapter(ImageView[] mRed) {
        this.mRed = mRed;
    }

    @Override
    public int getCount() {
        return mRed==null?0:mRed.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //向container中添加数据
        ImageView imageView= mRed[position];
        container.addView(imageView);
        return imageView;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //移除看不到的图片
        container.removeView(mRed[position]);
    }
}
