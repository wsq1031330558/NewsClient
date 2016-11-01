package flashlight.perfect.com.newsclient.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import flashlight.perfect.com.newsclient.R;
import flashlight.perfect.com.newsclient.entity.NewsLists;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public class CenterAdapter extends MyAdapter<NewsLists> {
    public CenterAdapter(Context context) {
        super(context);
    }

    @Override
    public View setView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (null==convertView) {
            holder= new Holder();
            convertView=mInflater.inflate(R.layout.centeradapter,parent,false);
            holder.mImg= (ImageView) convertView.findViewById(R.id.img_centeradapter);
            holder.mTxt_Title= (TextView) convertView.findViewById(R.id.txt_centeradapter_titly);
            holder.mTxt_content= (TextView) convertView.findViewById(R.id.txt_centeradapter_content);
            holder.mTxt_Time= (TextView) convertView.findViewById(R.id.txt_centeradapter_time);
            convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
        Picasso.with(convertView.getContext()).load(mList.get(position).getIcon()).into(holder.mImg);
        holder.mTxt_Title.setText(mList.get(position).getSummary());
        holder.mTxt_content.setText(mList.get(position).getTitle());
        holder.mTxt_Time.setText(mList.get(position).getStamp());


        return convertView;
    }

    static class Holder {
        ImageView mImg;
        TextView mTxt_Title;
        TextView mTxt_content;
        TextView mTxt_Time;

    }
}
