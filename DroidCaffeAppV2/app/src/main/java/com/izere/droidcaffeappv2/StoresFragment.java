package com.izere.droidcaffeappv2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.izere.droidcaffeappv2.R;

import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoresFragment extends Fragment {
    private RecyclerView storesRecyclerView;
    private ArrayList<Stores> storesData;
    private StoresAdapter storesAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StoresFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StoresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StoresFragment newInstance(String param1, String param2) {
        StoresFragment fragment = new StoresFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View storesView =  inflater.inflate(R.layout.fragment_stores, container, false);
        storesRecyclerView = storesView.findViewById(R.id.stores_recycler_view);
        storesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        storesData = new ArrayList<>();
        storesAdapter = new StoresAdapter(storesData,getContext());
        storesRecyclerView.setAdapter(storesAdapter);
        callData();
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT|ItemTouchHelper.DOWN|ItemTouchHelper.UP,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = viewHolder.getAdapterPosition();
                Collections.swap(storesData,from,to);
                storesAdapter.notifyItemMoved(from,to);
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                storesData.remove(viewHolder.getAdapterPosition());
                storesAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());

            }
        });
        helper.attachToRecyclerView(storesRecyclerView);
        return storesView;
    }

    private void callData() {

        String[] storesTitles = getResources().getStringArray(R.array.stores_title);
        String[] storesDescription = getResources().getStringArray(R.array.stores_description);
        String[] storesOpenTime = getResources().getStringArray(R.array.stores_open_time);
        TypedArray storesImages = getResources().obtainTypedArray(R.array.store_images);
        storesData.clear();
        for(int i = 0; i < storesTitles.length; i++) {
            storesData.add(new Stores(storesImages.getResourceId(i, 0), storesTitles[i], storesOpenTime[i],storesDescription[i]));
        }
        storesImages.recycle();
        storesAdapter.notifyDataSetChanged();
    }
}
