package com.example.marketplace.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;



import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.marketplace.Domain.SliderItems;
import com.example.marketplace.R;

import java.util.ArrayList;

public class SlinderAdapter extends RecyclerView.Adapter<SlinderAdapter.SliderViewholder> {
    private ArrayList<SliderItems> sliderItems; // Changed type
    private ViewPager2 viewPager2;
    private Context context;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            sliderItems.addAll(sliderItems);
            notifyDataSetChanged();
        }
    };

    public SlinderAdapter(ArrayList<SliderItems> sliderItems, ViewPager2 viewPager2) { // Updated constructor
        this.sliderItems = sliderItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SlinderAdapter.SliderViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new SliderViewholder(LayoutInflater.from(context).inflate(R.layout.slider_item_container, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SlinderAdapter.SliderViewholder holder, int position) {
        holder.setImage(sliderItems.get(position)); // Updated to pass SliderItems
        if (position == sliderItems.size() - 2) {
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliderItems.size();
    }

    public class SliderViewholder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public SliderViewholder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
        }

        void setImage(SliderItems sliderItem) { // Updated type
            RequestOptions requestOptions = new RequestOptions();
            requestOptions = requestOptions.transform(new CenterCrop());
            Glide.with(context)
                    .load(sliderItem.getUrl()) // Uses getUrl() from SliderItems
                    .apply(requestOptions)
                    .into(imageView);
        }
    }
}
