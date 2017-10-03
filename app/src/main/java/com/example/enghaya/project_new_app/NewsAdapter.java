package com.example.enghaya.project_new_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ENG.HAYA on 10/2/2017 AD.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View list = convertView;
        if (list == null) {
            list = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView title = (TextView) list.findViewById(R.id.title);
        TextView sectionname = (TextView) list.findViewById(R.id.sectionname);
        TextView data = (TextView) list.findViewById(R.id.date);
        TextView athor = (TextView) list.findViewById(R.id.athor);
        News News = getItem(position);
        title.setText(News.getTitle());
        sectionname.setText(News.getSection());
        data.setText(News.getDate());
        athor.setText(News.getAthors());


        return list;
    }
}
