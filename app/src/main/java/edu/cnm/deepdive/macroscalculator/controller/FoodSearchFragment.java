package edu.cnm.deepdive.macroscalculator.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.macroscalculator.R;


/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link FoodSearchFragment.OnFragmentInteractionListener} interface to handle interaction events.
 * Use the {@link FoodSearchFragment#newInstance} factory method to create an instance of this
 * fragment.
 */
public class FoodSearchFragment extends Fragment {
 // TODO Add fields for viewmodel, searchview and recyclerview

  public static FoodSearchFragment newInstance() {
    FoodSearchFragment fragment = new FoodSearchFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view =  inflater.inflate(R.layout.fragment_food_search, container, false);
    //TODO get refrences to your searchview and recylerview
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //TODO Setup viewmodel and setup observers.
  }
}
