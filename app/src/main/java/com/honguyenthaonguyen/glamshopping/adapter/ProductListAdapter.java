package com.honguyenthaonguyen.glamshopping.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.honguyenthaonguyen.glamshopping.ProductDetailsActivity;
import com.honguyenthaonguyen.glamshopping.R;
import com.honguyenthaonguyen.glamshopping.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by NGUYEN on 6/7/2016.
 */
public class ProductListAdapter extends RecyclerView.Adapter{
    List<Product> mDataset;

    public static final String PRODUCT_ID = "";
    public  ProductListAdapter(List<Product> mDataset){
        this.mDataset = mDataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewProductName;
        public TextView textViewProductNumberOfComment;
        public TextView textViewProductDescription;
        public ImageView imageViewProductImage;
        public LinearLayout linearLayoutProductList;
        public ViewHolder(View itemView)
        {
            super(itemView);
            textViewProductName = (TextView) itemView.findViewById(R.id.text_product_name);
            textViewProductNumberOfComment = (TextView) itemView.findViewById(R.id.textViewProductCommentCount);
            textViewProductDescription = (TextView) itemView.findViewById(R.id.textViewProductDescription);
            imageViewProductImage = (ImageView) itemView.findViewById(R.id.image_view);
            linearLayoutProductList = (LinearLayout) itemView.findViewById(R.id.linear_product_cell);
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
        ((ViewHolder)holder).textViewProductName.setText(mDataset.get(position).getTitle());

        ((ViewHolder)holder).textViewProductNumberOfComment.setText(String.valueOf(mDataset.get(position).getRatingCount()));
        ((ViewHolder)holder).textViewProductDescription.setText(mDataset.get(position).getDescription());
        Picasso.with(holder.itemView.getContext())
                .load(mDataset.get(position).getImages().get(0).getSrc())
                .into(((ViewHolder)holder).imageViewProductImage);
        ((ViewHolder)holder).linearLayoutProductList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mh = new Intent(v.getContext(), ProductDetailsActivity.class);
                mh.putExtra(PRODUCT_ID,mDataset.get(position).getId()+"");
                v.getContext().startActivity(mh);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
