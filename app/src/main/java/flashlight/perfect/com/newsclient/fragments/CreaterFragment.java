package flashlight.perfect.com.newsclient.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import flashlight.perfect.com.newsclient.R;
import flashlight.perfect.com.newsclient.adapter.CenterAdapter;
import flashlight.perfect.com.newsclient.entity.NewList;
import flashlight.perfect.com.newsclient.entity.NewsLists;
import flashlight.perfect.com.newsclient.inter.onLoadInfoListener;
import flashlight.perfect.com.newsclient.task.NewsCenterTask;
import flashlight.perfect.com.newsclient.utlis.HttpUtlis;
import me.maxwin.view.XListView;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public class CreaterFragment extends Fragment implements XListView.IXListViewListener, onLoadInfoListener {
    XListView mXlst;
    Handler mHandler;
    Gson mGson;
    ArrayList<NewsLists> mData;
    CenterAdapter mAdapter;
    public static final String url = "http://118.244.212.82:9092/newsClient/path/news_list?ver=1&subid=1&dir=1&nid=1&stamp=20140321&cnt=20";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.creater_fragment, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mHandler = new Handler();
        //为注解框架进行初始化
        mXlst = (XListView) view.findViewById(R.id.lst_center_fargment);
        NewsCenterTask task = new NewsCenterTask();
        task.setOnloadInfoLitenter(this);
//        task.execute(HttpUtlis.PATH+HttpUtlis.LIST);
        Log.e("----------", "HttpUtlis.PATH+HttpUtlis.LIST" + HttpUtlis.PATH + HttpUtlis.LIST);
        task.execute(url);


    }

    @Override
    public void getInfo(String msg) {
        Log.e("----------------", "-----------------------");
        mGson = new Gson();
        NewList data = mGson.fromJson(msg, new TypeToken<NewList>() {
        }.getType());
        Log.e("----------", "====" + data.toString());
        mData = data.getData();
        mAdapter = new CenterAdapter(getContext());
        mAdapter.setData(mData);
        mXlst.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


        //上拉加载
        mXlst.setPullLoadEnable(true);
        //下拉刷新
        mXlst.setPullRefreshEnable(true);
        //对下拉上拉设置监听事件，否则无法加载信息
        mXlst.setXListViewListener(this);


    }


    @Override
    public void onRefresh() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                stop();
            }
        }, 2000);

    }

    @Override
    public void onLoadMore() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                stop();
            }
        }, 2000);

    }

    public void stop() {
        //停止刷新和加载
        mXlst.stopLoadMore();
        mXlst.stopRefresh();
        //设置时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mXlst.setRefreshTime(format.format(new Date(System.currentTimeMillis())));
    }


}
