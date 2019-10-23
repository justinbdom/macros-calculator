package edu.cnm.deepdive.macroscalculator.model.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.macroscalculator.model.entity.Activity;
import edu.cnm.deepdive.macroscalculator.model.entity.Trainee;


public interface ActivityDao {


  @Insert
  long[] insert(Activity activities);

  @Query("SELECT * FROM Activity WHERE activity_id = :activityId")



}
