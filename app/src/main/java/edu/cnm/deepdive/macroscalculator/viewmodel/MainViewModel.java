package edu.cnm.deepdive.macroscalculator.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;
import com.fatsecret.platform.services.android.Request;
import com.fatsecret.platform.services.android.ResponseListener;
import edu.cnm.deepdive.macroscalculator.BuildConfig;
import edu.cnm.deepdive.macroscalculator.model.entity.Food;
import edu.cnm.deepdive.macroscalculator.model.entity.Trainee;
import edu.cnm.deepdive.macroscalculator.service.MacrosCalculatorDatabase;
import java.util.LinkedList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

  private MacrosCalculatorDatabase database;

  private MutableLiveData<List<Food>> foods = new MutableLiveData<>();

  public MainViewModel(@NonNull Application application) {
    super(application);
    database = MacrosCalculatorDatabase.getInstance();
  }

  public LiveData<List<Trainee>> getTrainees() {
    return database.getTraineeDao().getAll();
  }

  public void searchFoods(String term) {
    new Thread(() -> {
      FatsecretService service = new FatsecretService(BuildConfig.CONSUMER_KEY,
          BuildConfig.CONSUMER_SECRET);
      Response<CompactFood> response = service.searchFoods(term, 0);
      List<Food> foods = new LinkedList<>();
      for (CompactFood compactFood : response.getResults()) {
        Food food = new Food();
        food.setName(compactFood.getName());
        foods.add(food);
      }
      this.foods.postValue(foods);
    }).start();
  }

  public LiveData<List<Food>> getFoods() {
    return foods;
  }

  public void saveFoods(List<Food> foods) {
    new Thread(() -> database.getFoodDao().insert(foods)).start();
  }
}
