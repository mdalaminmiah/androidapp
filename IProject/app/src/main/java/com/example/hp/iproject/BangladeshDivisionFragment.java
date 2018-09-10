package com.example.hp.iproject;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.Toast;

/**
 * Created by আলামিন
 *
 */
public class BangladeshDivisionFragment extends Fragment {
    GridLayout gridLayout;
    FragmentManager myFragmentManager;
    FragmentTransaction myFragmentTransaction;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.bangladesh_division_layout,null);
        gridLayout=(GridLayout)rootView.findViewById(R.id.mainGrid);

        setSingleEvent(gridLayout);


        return rootView;
    }

    private void setSingleEvent(GridLayout gridLayout) {
        for(int i = 0; i<gridLayout.getChildCount();i++){
            CardView cardView=(CardView)gridLayout.getChildAt(i);
            final int finalI= i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /*Toast.makeText(getActivity(), "Clicked at index"+ finalI, Toast.LENGTH_SHORT).show();*/
                    if (0 == finalI){
                        /*FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit();*/
                        Toast.makeText(getActivity(), "Clicked at index"+ finalI, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}