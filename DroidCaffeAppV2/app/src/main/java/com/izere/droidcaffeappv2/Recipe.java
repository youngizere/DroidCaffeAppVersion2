package com.izere.droidcaffeappv2;

public class Recipe {
    private final int recipeImage;
    private String recipeTitle;
    private  String recipeDescription;

    //constructor for recipe data model
    Recipe(int recipeImage, String recipeTitle, String recipeDescription){
        this.recipeImage = recipeImage;
        this.recipeTitle = recipeTitle;
        this.recipeDescription = recipeDescription;
    }
    public int getRecipeImage(){
        return recipeImage;
    }
    public String getRecipeTitle(){
        return recipeTitle;
    }
    public String getRecipeDescription(){
        return recipeDescription;
    }
}
