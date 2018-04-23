package com.example.admin.tobuy.adapters;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.admin.tobuy.R;
import com.example.admin.tobuy.ToBuyClickListener;
import com.example.admin.tobuy.data.Queries;
import com.example.admin.tobuy.models.ToBuy;

import java.util.List;

public class ToBuysAdapter extends RecyclerView.Adapter<ToBuysAdapter.ViewHolder> {

    private List<ToBuy> toBuys = new Queries().toBuys();

     private ToBuyClickListener listener;

     public ToBuysAdapter(ToBuyClickListener listener){
         this.listener = listener;
     }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tobuy,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

         final ToBuy toBuy = toBuys.get(position);


        holder.toBuyTv.setText(toBuy.getProduct());
        holder.quantityTv.setText(String.valueOf(toBuy.getQuantity()));
        holder.toBuyCb.setChecked(toBuy.isDone());


        holder.toBuyCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            int auxPosition = holder.getAdapterPosition();
                            ToBuy auxToBuy = toBuys.get(auxPosition);
                            auxToBuy.setDone(true);
                            auxToBuy.save();
                            toBuys.remove(auxToBuy);
                            notifyItemRemoved(auxPosition);
                        }
                        },400);

                }




            }
        });

        holder.toBuyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToBuy auxToBus = toBuys.get(holder.getAdapterPosition());
                listener.clickedID(auxToBus.getId());

            }
        });

    }

    @Override
    public int getItemCount() {

        return toBuys.size();
    }


    public  void update(ToBuy toBuy){
        toBuys.add(toBuy);
        notifyDataSetChanged();
    }

    public  void refresh(){
         toBuys.clear();
         toBuys = new Queries().toBuys();
         notifyDataSetChanged();
    }




    static class ViewHolder extends RecyclerView.ViewHolder{

        private CheckBox toBuyCb;
        private TextView toBuyTv;
        private TextView quantityTv;

        public ViewHolder(View itemView){
            super(itemView);

            toBuyCb = itemView.findViewById(R.id.toBuyCb);
            toBuyTv = itemView.findViewById(R.id.toBuyTv);
            quantityTv = itemView.findViewById(R.id.quantityTv);

        }
    }

}
