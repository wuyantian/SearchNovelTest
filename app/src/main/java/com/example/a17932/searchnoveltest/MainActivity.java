package com.example.a17932.searchnoveltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private List<Novels>novelsList=new ArrayList<>();
    Novels novels=new Novels();
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
         LinearLayoutManager manager=new LinearLayoutManager(this);
         sendRequestWithOkHttp();
         novels.setData(data);
         novelsList.add(novels);
        NovelAddapter adapter=new NovelAddapter(novelsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);


    }
    public void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client=new OkHttpClient();
                    Request request=new Request.Builder().url("https://www.apiopen.top/novelSearchApi?name=盗墓笔记").build();
                    Response response=client.newCall(request).execute();
                    String responseData=response.body().string();
                    parseJSONWithJSONObject(responseData);
                }catch (Exception e){

                }
            }
        }).start();
    }
    public void parseJSONWithJSONObject(String jsonData){
        try {
            JSONArray jsonArray=new JSONArray(jsonData);
            for (int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                data=jsonObject.getString("data");
                Log.d("main","成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
