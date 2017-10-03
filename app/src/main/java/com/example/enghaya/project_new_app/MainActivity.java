package com.example.enghaya.project_new_app;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<News>> {

    private static final String mUrl = "https://content.guardianapis.com/search";
    private NewsAdapter Adapter;
    private TextView EmptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EmptyTextView = (TextView) findViewById(R.id.textview);

        Adapter = new NewsAdapter(this, new ArrayList<News>());
        ListView List = (ListView) findViewById(R.id.listview);
        List.setAdapter(Adapter);
        List.setEmptyView(EmptyTextView);

        populateList();

        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News current = Adapter.getItem(position);
                Uri mUri = Uri.parse(current.getUrl());
                Intent intent = new Intent(Intent.ACTION_VIEW, mUri);
                startActivity(intent);
            }
        });
    }

    public void populateList() {
        Adapter.clear();
        final ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        LoaderManager loaderManager = getLoaderManager();
        if (networkInfo != null && networkInfo.isConnected()) {
            loaderManager.initLoader(2, null, this);
        } else {
            EmptyTextView.setText(R.string.checkinternet);
        }
    }

    @Override
    public Loader<List<News>> onCreateLoader(int id, Bundle args) {
        Uri UUri = Uri.parse(mUrl);
        Uri.Builder builder = UUri.buildUpon();
        builder.appendQueryParameter("q", "car");
        builder.appendQueryParameter("api-key", "test");
        return new NewsLoader(this, builder.toString());
    }

    @Override
    public void onLoadFinished(Loader<List<News>> loader, List<News> news) {
        Adapter.clear();
        if (news != null && !news.isEmpty()) {
            Adapter.addAll(news);
        }
    }

    @Override
    public void onLoaderReset(Loader loader) {
        Adapter.clear();
    }
}
