package com.ydev.basicrecyclerviewexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ydev.basicrecyclerviewexample.horizontal.HorizontalRecyclerView;
import com.ydev.basicrecyclerviewexample.vertical.VerticalRecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnHorizontal;
    private Button btnVertical;
    private Button btnGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHorizontal = (Button) findViewById(R.id.btn_horizontal);
        btnVertical = (Button) findViewById(R.id.btn_vertical);
        btnGrid = (Button) findViewById(R.id.btn_grid);

        btnHorizontal.setOnClickListener(this);
        btnVertical.setOnClickListener(this);
        btnGrid.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_horizontal:
                Intent i1 = new Intent(MainActivity.this, HorizontalRecyclerView.class);
                startActivity(i1);
                break;
            case R.id.btn_vertical:
                Intent i2 = new Intent(MainActivity.this, VerticalRecyclerView.class);
                startActivity(i2);
                break;
            case R.id.btn_grid:

                break;
        }
    }
}
