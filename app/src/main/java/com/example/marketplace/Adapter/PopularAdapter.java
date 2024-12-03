package com.example.marketplace.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.marketplace.Domain.ItemDomain;
import com.example.marketplace.databinding.ViewholderPopListBinding;

import java.util.ArrayList;

public class PopularAdapter  extends RecyclerView.Adapter<PopularAdapter.Viewholder> {
    ArrayList<ItemDomain> items;
    Context context;

    public PopularAdapter(ArrayList<ItemDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext()
;
        ViewholderPopListBinding binding = ViewholderPopListBinding.inflate(LayoutInflater.from(context),parent,false);

        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
holder.binding.title.setText(items.get(position).getTitle());
holder.binding.reviewTxt.setText(""+items.get(position).getReview());
holder.binding.priceTxt.setText("$"+items.get(position));
holder.binding.retireTxt.setText("("+items.get(position).getReview());
holder.binding.oldPriceTxt.setText("$"+items.get(position).getOldPrice());
holder.binding.oldPriceTxt.setPaintFlags(holder.binding.oldPriceTxt.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
holder.binding.ratingBar.setRating((float) items.get(position).getRating());

        RequestOptions requestOptions = new RequestOptions();
        requestOptions=requestOptions.transform(new CenterCrop());

        Glide.with(context)
                .load(items.get(position).getPicUrl().get(0))
                .apply(requestOptions)
                .into(holder.binding.pic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });{
        }



    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder{
        ViewholderPopListBinding binding;
        public Viewholder(ViewholderPopListBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}

