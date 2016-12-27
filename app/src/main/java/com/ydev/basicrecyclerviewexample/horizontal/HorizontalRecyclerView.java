package com.ydev.basicrecyclerviewexample.horizontal;

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

public class HorizontalRecyclerView extends AppCompatActivity {

    private RecyclerView mHorizontalView;
    private HorizontalAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;

    private int MAX_ITEM_COUNT = 50;

    // TestCode for Github
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        // RecyclerView binding
        mHorizontalView = (RecyclerView) findViewById(R.id.recyclerView);

        // init LayoutManager
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // 기본값이 VERTICAL

        // setLayoutManager
        mHorizontalView.setLayoutManager(mLayoutManager);

        // init Adapter
        mAdapter = new HorizontalAdapter();

        // init Data
        ArrayList<HorizontalData> data = new ArrayList<>();

        int i = 0;
        while (i < MAX_ITEM_COUNT) {
            data.add(new HorizontalData(R.mipmap.ic_launcher, i+"번째 데이터"));
            i++;
        }
 
        // set Data
        mAdapter.setData(data);

        // set Adapter
        mHorizontalView.setAdapter(mAdapter);

    }

}

class HorizontalAdapter extends RecyclerView.Adapter<HorizontalViewHolder> {

    private ArrayList<HorizontalData> HorizontalDatas;

    public void setData(ArrayList<HorizontalData> list){
        HorizontalDatas = list;
    }

    @Override
    public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 사용할 아이템의 뷰를 생성해준다.
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.horizon_recycler_items, parent, false);

        HorizontalViewHolder holder = new HorizontalViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(HorizontalViewHolder holder, int position) {
        HorizontalData data = HorizontalDatas.get(position);

        holder.description.setText(data.getText());
        holder.icon.setImageResource(data.getImg());

    }

    @Override
    public int getItemCount() {
        return HorizontalDatas.size();
    }
}

class HorizontalViewHolder extends RecyclerView.ViewHolder {

    public ImageView icon;
    public TextView description;

    public HorizontalViewHolder(View itemView) {
        super(itemView);

        icon = (ImageView) itemView.findViewById(R.id.horizon_icon);
        description = (TextView) itemView.findViewById(R.id.horizon_description);

    }
}

class HorizontalData {

    private int img;
    private String text;

    public HorizontalData(int img, String text){
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