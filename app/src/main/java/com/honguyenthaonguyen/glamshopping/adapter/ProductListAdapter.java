package com.honguyenthaonguyen.glamshopping.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.honguyenthaonguyen.glamshopping.R;
import com.honguyenthaonguyen.glamshopping.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NGUYEN on 6/7/2016.
 */
public class ProductListAdapter extends RecyclerView.Adapter{

    List<Product> mDataset;
    public static int count;
    public static ArrayList<Integer> PRODUCT_ID_LIST;

    public  ProductListAdapter(List<Product> mDataset){
        this.mDataset = mDataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewTenSanPham;
        public TextView textViewNhaSanXuat;
        public TextView textViewGiaSanPham;
        public ImageView imageViewSanPham;
        public ImageButton imageButtonAdd;
        public CardView cardViewCellSanPham;
        public ViewHolder(View itemView)
        {
            super(itemView);
            textViewTenSanPham = (TextView) itemView.findViewById(R.id.textViewTenSanPham);
            textViewNhaSanXuat = (TextView) itemView.findViewById(R.id.textViewNhaSanXuat);
            textViewGiaSanPham = (TextView) itemView.findViewById(R.id.textViewGiaSanPham);
            imageViewSanPham = (ImageView) itemView.findViewById(R.id.imageViewSanPham);
            imageButtonAdd = (ImageButton) itemView.findViewById(R.id.imageButtonAdd);
            cardViewCellSanPham = (CardView) itemView.findViewById(R.id.card_viewCellSanPham);
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_product_list,parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        ((ViewHolder)holder).textViewTenSanPham.setText(mDataset.get(position).getTitle());
        final String title = mDataset.get(position).getTitle();
        ((ViewHolder)holder).textViewNhaSanXuat.setText(mDataset.get(position).getStatus());
        ((ViewHolder)holder).textViewGiaSanPham.setText("$ "+mDataset.get(position).getPrice());
//        Picasso.with(holder.itemView.getContext())
//                .load(mDataset.get(position).getImages().get(0).getSrc())
//                .into(((ViewHolder)holder).imageViewSanPham);
        Glide.with(holder.itemView.getContext())
                .load(mDataset.get(position).getImages().get(0).getSrc())
                .into(((ViewHolder)holder).imageViewSanPham);
        ((ViewHolder)holder).cardViewCellSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),title,Toast.LENGTH_LONG).show();
            }
        });
        PRODUCT_ID_LIST = new ArrayList<>();
        count = 0;
        ((ViewHolder)holder).imageButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                count++;
                PRODUCT_ID_LIST.add(mDataset.get(position).getId());
            }
        });


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
