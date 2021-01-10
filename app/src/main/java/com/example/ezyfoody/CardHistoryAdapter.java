package com.example.ezyfoody;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CardHistoryAdapter extends RecyclerView.Adapter<CardHistoryAdapter.CardViewHolder> {
    private ArrayList<History> OrderList;


    public CardHistoryAdapter(ArrayList<History> orderList) {
        this.OrderList = orderList;
    }

    @Override
    public CardHistoryAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_history, parent, false);
        return new CardHistoryAdapter.CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardHistoryAdapter.CardViewHolder holder, int position) {
        holder.txtName.setText(OrderList.get(position).getFood());
        holder.txtqty.setText("Quantity :"+String.valueOf(OrderList.get(position).getQty()));
        holder.txttotal.setText("Total Price: "+String.valueOf(OrderList.get(position).getTotalprice()));
        holder.txtdate.setText("Time: "+String.valueOf(OrderList.get(position).getDate()));
    }

    @Override
    public int getItemCount() {
        return (OrderList != null) ? OrderList.size() : 0;
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName, txtqty, txttotal,txtdate;

        public CardViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtqty = (TextView) itemView.findViewById(R.id.txt_qty);
            txttotal = (TextView) itemView.findViewById(R.id.txt_total);
            txtdate = (TextView) itemView.findViewById(R.id.txt_date);

        }
    }
}
