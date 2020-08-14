package com.izere.droidcaffeappv2;
public class Stores {

        //Declare private member variables to be used to refer to the data stored in the arrays.
        private int storesImage;
        private String storesDescription;
        private String  storesTitle;
        private String  storesOpenTime;
        //Create a recipe for the recipe data model and pass the parameters: recipeImage, recipeTitle, recipeDescription

        Stores(int storesImage,String storesTitle,String storesOpenTime,String storesDescription){
            this.storesImage=storesImage;
            this.storesTitle=storesTitle;
            this.storesTitle=storesTitle;
            this.storesDescription=storesDescription;
            this.storesOpenTime=storesOpenTime;
        }
        //Create getters to return the specific objects
        public int getStoresImage()
        {
            return storesImage;
        }
        public String getStoresTitle()
        {
            return storesTitle;
        }
        public String getStoresOpenTime() { return storesOpenTime; }
        public String getStoresDescription()
        {
            return storesDescription;
        }

    }



