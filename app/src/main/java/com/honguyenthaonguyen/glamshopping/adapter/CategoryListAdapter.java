package com.honguyenthaonguyen.glamshopping.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.honguyenthaonguyen.glamshopping.ProductListActivity;
import com.honguyenthaonguyen.glamshopping.R;
import com.honguyenthaonguyen.glamshopping.model.ProductCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by NGUYEN on 6/7/2016.
 */
public class CategoryListAdapter extends RecyclerView.Adapter {
    List<ProductCategory> mDataset;
    public static String CAT_ID="";

    public CategoryListAdapter(List<ProductCategory> mDataset){
        this.mDataset = mDataset;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textViewCategoryName, textViewProductCategoryQuantity, textViewProductCategoryDescription;
        public ImageView imageViewProductCategoryImage;
        public LinearLayout linearLayoutProductCategory;

        public ViewHolder(final View itemView)
        {
            super(itemView);
            textViewCategoryName = (TextView) itemView.findViewById(R.id.text_category_name);
            textViewProductCategoryQuantity = (TextView) itemView.findViewById(R.id.textViewProductCategoryQuantity);
            textViewProductCategoryDescription = (TextView) itemView.findViewById(R.id.textViewProductCategoryDescription);
            imageViewProductCategoryImage = (ImageView) itemView.findViewById(R.id.imageViewProductCategoryImage);
            linearLayoutProductCategory = (LinearLayout) itemView.findViewById(R.id.linear_layout_product_category);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_category_list,parent,false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolder)holder).textViewCategoryName.setText(mDataset.get(position).getName());
        ((ViewHolder)holder).textViewProductCategoryQuantity.setText(mDataset.get(position).getCount() + "");
        ((ViewHolder)holder).textViewProductCategoryDescription.setText(mDataset.get(position).getDescription());
        Picasso.with(((ViewHolder) holder).imageViewProductCategoryImage.getContext())
                .load(mDataset.get(position).getImage()).into(((ViewHolder) holder).imageViewProductCategoryImage);
        ((ViewHolder)holder).linearLayoutProductCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productScreen =  new Intent(v.getContext(),ProductListActivity.class);
                productScreen.putExtra(CAT_ID, mDataset.get(position).getId()+"");
                v.getContext().startActivity(productScreen);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
