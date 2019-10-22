package edu.cnm.deepdive.macroscalculator.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Query;
import edu.cnm.deepdive.macroscalculator.model.entity.FoodType;
import java.util.List;

public interface FoodTypeDao {


  @Query("SELECT * FROM Foodtype ORDER BY created ASC")
  LiveData<List<FoodType>> getAll();


}

