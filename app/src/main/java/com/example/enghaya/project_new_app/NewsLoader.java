package com.example.enghaya.project_new_app;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by ENG.HAYA on 10/2/2017 AD.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String Url;

    public NewsLoader(Context context, String url) {
        super(context);
        Url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<News> loadInBackground() {
        if (Url == null) {
            return null;
        }

        return QueryUtils.fetch(Url);
    }
}
