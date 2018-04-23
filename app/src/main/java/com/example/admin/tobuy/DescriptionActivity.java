package com.example.admin.tobuy;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.tobuy.models.ToBuy;

public class DescriptionActivity extends AppCompatActivity {


    public static final String TOBUY_ID = "com.example.admin.tobuy.KEY.TOBUY_ID";

    private ToBuy toBuy;
    TextView prodSelectTv;
    TextView quanSelectTv;


    private ToBuyFragment toBuyFragment;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


            toBuyFragment = (ToBuyFragment) getSupportFragmentManager().findFragmentById(R.id.toBuysfragment);

        long id = getIntent().getLongExtra(TOBUY_ID, 0);

           if(id > 0) {

            toBuy = toBuy.findById(ToBuy.class, id);
            getSupportActionBar().setTitle(toBuy.getProduct());

            prodSelectTv = findViewById(R.id.proDescriptionTv);
            quanSelectTv = findViewById(R.id.quaDescriptionTv);


            prodSelectTv.setText("Producto: " + toBuy.getProduct());
            quanSelectTv.setText("Cantidad:: " );

        }
    }

}
