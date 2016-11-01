package flashlight.perfect.com.newsclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * 自定义适配器
 */

public abstract class MyAdapter<T> extends BaseAdapter {
    ArrayList<T> mList;
    LayoutInflater mInflater;

    public MyAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<T> list) {
        if (null != this.mList) {
            this.mList.clear();
        }
        this.mList = list;

    }

    @Override
    public int getCount() {
        return null!=mList?0:mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return setView(position,convertView,parent);
    }

    public abstract View setView(int position, View convertView, ViewGroup parent);

}
