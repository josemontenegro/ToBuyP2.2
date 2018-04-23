package com.example.admin.tobuy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.tobuy.adapters.ToBuysAdapter;
import com.example.admin.tobuy.models.ToBuy;

/**
 * A placeholder fragment containing a simple view.
 */
public class ToBuyFragment extends Fragment implements ToBuyClickListener{

    private ToBuysAdapter adapter;

    public static final String TOBUYID = "com.example.admin.tobuy.view.main.KEY.TOBUY_ID";

    public ToBuyFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.toBuyRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ToBuysAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    public  void updateList(ToBuy toBuy){

        adapter.update(toBuy);
        Log.d("toBuy",toBuy.getProduct());

    }
    public void refreshList(){adapter.refresh();}

    @Override
    public void clickedID(long id) {

        Intent descripIntent = new Intent(getActivity(), DescriptionActivity.class);
        descripIntent.putExtra(TOBUYID, id);
        startActivity(descripIntent);

    }
}
