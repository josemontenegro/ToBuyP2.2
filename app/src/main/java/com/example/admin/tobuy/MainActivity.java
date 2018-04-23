package com.example.admin.tobuy;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.admin.tobuy.models.ToBuy;

import static com.example.admin.tobuy.R.id.qToBuyEt;
import static com.example.admin.tobuy.R.id.toBuysfragment;

public class MainActivity extends AppCompatActivity {

    private ToBuyFragment toBuyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toBuyFragment = (ToBuyFragment) getSupportFragmentManager().findFragmentById(R.id.toBuysfragment);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_tobuy);

                //guardar la data

                ImageButton imageButton = dialog.findViewById(R.id.saveToBuyBtn);
                imageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        EditText input = dialog.findViewById(R.id.toBuyEt);
                        String product = input.getText().toString();

                        EditText input2 = dialog.findViewById(qToBuyEt);
                        String quantity = input2.getText().toString();


                        if (product.trim().length() == 0 || quantity.trim().length() == 0 ) {
                            Toast.makeText(MainActivity.this, "Debes completar todos los campos", Toast.LENGTH_SHORT).show();
                        } else {


                          
                                ToBuy toBuy = new ToBuy();
                                toBuy.setProduct(product);
                                toBuy.setQuantity(Integer.parseInt(quantity));
                                toBuy.setDone(false);
                                toBuy.save();

                                toBuyFragment.updateList(toBuy);



                            dialog.dismiss();
                            Toast.makeText(MainActivity.this, "Guardado Exitoso!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });




                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
