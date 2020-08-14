package com.izere.droidcaffeappv2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class StoresAdapter extends RecyclerView.Adapter<StoresAdapter.ViewHolder>
{
    private ArrayList<Stores> storesData;
    private Context storesContext;

    StoresAdapter(ArrayList<Stores> mStoresData,Context context)
    {
        this.storesData = mStoresData;
        this.storesContext = context;
    }


    @NonNull
    @Override
    public StoresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(storesContext).inflate(R.layout.stores_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoresAdapter.ViewHolder holder, int position) {
        Stores currentStores = storesData.get(position);
        holder.bindTo(currentStores);

    }

    @Override
    public int getItemCount() {
        return storesData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myStoresImage;
        private TextView myStoresTitle;
        private TextView myStoresOpenTime;
        private TextView myStoresDescription;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myStoresImage= itemView.findViewById(R.id.stores_image);
            myStoresTitle= itemView.findViewById(R.id.stores_name);
            myStoresOpenTime= itemView.findViewById(R.id.store_open_time);
            myStoresDescription= itemView.findViewById(R.id.store_description);
        }

        public void bindTo(Stores currentStores) {
            Glide.with(storesContext).load(currentStores.getStoresImage()).into(myStoresImage);
            myStoresTitle.setText(currentStores.getStoresTitle());
            myStoresOpenTime.setText(currentStores.getStoresOpenTime());
            myStoresDescription.setText(currentStores.getStoresDescription());
        }
    }
}
