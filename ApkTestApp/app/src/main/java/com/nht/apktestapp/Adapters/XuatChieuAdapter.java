package com.nht.apktestapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nht.apktestapp.Model.XuatChieu;
import com.nht.apktestapp.R;

import java.util.List;

public class XuatChieuAdapter extends BaseAdapter {
    private List<XuatChieu> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public XuatChieuAdapter(Context context, List<XuatChieu> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_item_xuatchieu, null);
            holder = new ViewHolder();
            holder.XuatChieuCode = (TextView) convertView.findViewById(R.id.XuatChieuCodeTextView);
            holder.startTime = (TextView) convertView.findViewById(R.id.startTimeTextView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.XuatChieuCode.setText(Integer.toString(listData.get(position).getMaXuatChieu()));
        holder.startTime.setText(listData.get(position).getTimeXuatChieu().toString());

        return convertView;
    }

    static class ViewHolder {
        TextView XuatChieuCode;
        TextView startTime;
    }
}
