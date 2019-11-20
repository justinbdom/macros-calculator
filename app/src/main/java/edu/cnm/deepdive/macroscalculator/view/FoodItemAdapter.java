package edu.cnm.deepdive.macroscalculator.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.macroscalculator.R;
import edu.cnm.deepdive.macroscalculator.model.entity.Food;
import java.util.LinkedList;
import java.util.List;

public class FoodItemAdapter extends ArrayAdapter<Food> {

  private List<Food> foods;

  public FoodItemAdapter(@NonNull Context context, @NonNull List<Food> foods) {
    super(context, R.layout.item_food, foods);
    this.foods = foods;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View view = (convertView != null) ? convertView :
        LayoutInflater.from(getContext()).inflate(R.layout.item_food, parent, false);
    Food food = getItem(position);
    CheckBox selected = view.findViewById(R.id.selected);
    selected.setChecked(food.isSelected());
    selected.setOnCheckedChangeListener((buttonView, isChecked) -> {
      food.setSelected(isChecked);
    });
    TextView name = view.findViewById(R.id.name);
    name.setText(food.getName());
    return view;
  }

  public List<Food> getSelected () {
    List<Food> selected = new LinkedList<>();
    for (Food food : foods){
      if (food.isSelected()) {
        selected.add(food);
      }
    }
    return selected;
  }
}
