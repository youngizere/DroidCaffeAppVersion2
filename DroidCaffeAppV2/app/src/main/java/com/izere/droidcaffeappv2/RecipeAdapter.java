package com.izere.droidcaffeappv2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    //Declare the private member variables Recipe Data and the context
    private ArrayList<Recipe> recipeData;
    private Context myContext;
    RecipeAdapter(ArrayList<Recipe> mRecipeData, Context context){
        this.myContext = context;
        this.recipeData = mRecipeData;
    }
    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.recipe_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
        Recipe currentRecipe = recipeData.get(position);
        holder.bindTo(currentRecipe);

    }

    @Override
    public int getItemCount() {

        return recipeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView myRecipeImage;
        private TextView myRecipeTitle;
        private TextView myRecipeDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myRecipeImage = itemView.findViewById(R.id.recipe_image);
            myRecipeTitle = itemView.findViewById(R.id.recipe_title);
            myRecipeDescription = itemView.findViewById(R.id.recipe_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dessertPosition = getAdapterPosition();
                    Recipe currentDessert = recipeData.get(dessertPosition);
                    if (dessertPosition == 0){
                        Intent donutIntent = new Intent(myContext, DonutActivity.class);
                        donutIntent.putExtra("dTitle", currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage", currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription", currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);

                    }
                    else {
                        Toast.makeText(myContext,"Drop the previous recipes to view this item", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        public void bindTo(Recipe currentRecipe) {
            //Glide library is used to prevent the app from crushing as a result of loading different image resolutions
            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myRecipeImage);
            myRecipeTitle.setText(currentRecipe.getRecipeTitle());
            myRecipeDescription.setText(currentRecipe.getRecipeDescription());

        }
    }
}
