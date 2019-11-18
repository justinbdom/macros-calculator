package edu.cnm.deepdive.macroscalculator.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.SearchView.OnQueryTextListener;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.macroscalculator.R;
import edu.cnm.deepdive.macroscalculator.model.entity.Food;
import edu.cnm.deepdive.macroscalculator.viewmodel.MainViewModel;


public class FoodSearchFragment extends Fragment {

  private MainViewModel viewModel;
  private SearchView foodSearch;
  private ListView foodList;

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
    foodSearch = view.findViewById(R.id.food_search);
    foodList = view.findViewById(R.id.food_list);
    foodSearch.setOnQueryTextListener(new OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        viewModel.searchFoods(query.trim());
        return true;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        return false;
      }
    });
    return view;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
    viewModel.getFoods().observe(this, (foods) -> {
      ArrayAdapter<Food> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, foods);
      foodList.setAdapter(adapter);
    });
  }
}
