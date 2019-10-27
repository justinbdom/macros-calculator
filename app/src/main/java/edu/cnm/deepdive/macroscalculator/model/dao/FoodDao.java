package edu.cnm.deepdive.macroscalculator.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.macroscalculator.model.entity.Food;
import edu.cnm.deepdive.macroscalculator.model.entity.*;
import java.util.List;

@Dao
public interface FoodDao {

  @Insert
  long insert(Food food);

  @Query("SELECT * FROM Food ORDER BY name ASC")
  LiveData<List<Food>> getAll();

  @Query("SELECT * FROM Food WHERE food_id = :foodId")
  LiveData<Food> getById(long foodId);

  @Query("SELECT * FROM Food WHERE food_type_id = :foodTypeId ORDER BY name ASC")
  LiveData<List<Food>> getAllByType(long foodTypeId);

  @Query("SELECT * FROM Food WHERE trainee_id = :traineeId ORDER BY name ASC")
  LiveData<List<Food>> getAllByTrainee(long traineeId);


}
