package com.ydev.basicrecyclerviewexample.vertical;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ydev.basicrecyclerviewexample.R;

import java.util.ArrayList;

public class VerticalRecyclerView extends AppCompatActivity {

    private RecyclerView mVerticalView;
    private VerticalAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private int MAX_ITEM_COUNT = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vertical_recycler_view);

        // RecyclerView binding
        mVerticalView = (RecyclerView) findViewById(R.id.vertical_list);

        // init LayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // 기본값이 VERTICAL

        // setLayoutManager
        mVerticalView.setLayoutManager(mLayoutManager);

        // init Adapter
        mAdapter = new VerticalAdapter();

        // init Data
        ArrayList<VerticalData> data = new ArrayList<>();

        int i = 0;
        while (i < MAX_ITEM_COUNT) {
            data.add(new VerticalData(R.mipmap.ic_launcher, i+"번째 데이터"));
            i++;
        }
 
        // set Data
        mAdapter.setData(data);

        // set Adapter
        mVerticalView.setAdapter(mAdapter);

    }

}

class VerticalAdapter extends RecyclerView.Adapter<VerticalViewHolder> {

    private ArrayList<VerticalData> verticalDatas;

    public void setData(ArrayList<VerticalData> list){
        verticalDatas = list;
    }

    @Override
    public VerticalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 사용할 아이템의 뷰를 생성해준다.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vertical_recycler_items, parent, false);

        VerticalViewHolder holder = new VerticalViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(VerticalViewHolder holder, int position) {
        VerticalData data = verticalDatas.get(position);

        holder.description.setText(data.getText());
        holder.icon.setImageResource(data.getImg());

    }

    @Override
    public int getItemCount() {
        return verticalDatas.size();
    }
}

class VerticalViewHolder extends RecyclerView.ViewHolder {

    public ImageView icon;
    public TextView description;

    public VerticalViewHolder(View itemView) {
        super(itemView);

        icon = (ImageView) itemView.findViewById(R.id.vertical_icon);
        description = (TextView) itemView.findViewById(R.id.vertical_description);

    }
}

class VerticalData {

    private int img;
    private String text;

    public VerticalData(int img, String text){
        this.img = img;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public int getImg() {
        return this.img;
    }
}