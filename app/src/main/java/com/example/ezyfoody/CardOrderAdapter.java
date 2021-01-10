package com.example.ezyfoody;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardOrderAdapter extends RecyclerView.Adapter<CardOrderAdapter.OrderViewHolder> {
    private ArrayList<Order> OrderList;


    public CardOrderAdapter(ArrayList<Order> orderList) {
        this.OrderList = orderList;
    }

    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        holder.txtName.setText("Name :"+OrderList.get(position).getName());
        holder.txtqty.setText("Quantity :"+String.valueOf(OrderList.get(position).getQuantity()));
        holder.txttotal.setText("Total Price: "+String.valueOf(OrderList.get(position).getTotalprice()));
    }

    @Override
    public int getItemCount() {
        return (OrderList != null) ? OrderList.size() : 0;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder{
        private TextView txtName, txtqty, txttotal;

        public OrderViewHolder(View itemView) {
            super(itemView);
                txtName = (TextView) itemView.findViewById(R.id.txt_name);
                txtqty = (TextView) itemView.findViewById(R.id.txt_qty);
                txttotal = (TextView) itemView.findViewById(R.id.txt_total);


        }
    }
}
