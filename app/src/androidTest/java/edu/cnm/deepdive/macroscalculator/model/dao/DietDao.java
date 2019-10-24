package edu.cnm.deepdive.macroscalculator.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.macroscalculator.model.entity.FoodType;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public interface DietDao {

@Insert
LiveData<Long> insert(Collection<FoodType> FoodTypes);

  @Query("SELECT * FROM Foodtype ORDER BY created ASC")
  LiveData<List<FoodType>> getAll();


}

