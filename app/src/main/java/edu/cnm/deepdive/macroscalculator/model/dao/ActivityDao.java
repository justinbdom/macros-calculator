package edu.cnm.deepdive.macroscalculator.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.macroscalculator.model.entity.Activity;
import edu.cnm.deepdive.macroscalculator.model.entity.Trainee;
import java.util.Collection;
import java.util.List;

@Dao
public interface ActivityDao {


  @Insert
  long insert(Activity activity);

  @Insert
  List<Long> insert(Collection<Activity> activities);

  @Query("SELECT * FROM Activity ORDER BY name ASC")
  LiveData<List<Activity>> getAll();

  @Update
  int update(Activity activities);

  @Delete
  int delete(Activity... activities);

}
