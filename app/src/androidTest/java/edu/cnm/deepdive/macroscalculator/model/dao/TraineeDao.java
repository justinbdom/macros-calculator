package edu.cnm.deepdive.macroscalculator.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import edu.cnm.deepdive.macroscalculator.model.entity.Trainee;
import java.util.Collection;
import java.util.List;

@Dao
public interface TraineeDao {

  @Insert
  long insert(Trainee trainee);

  @Insert
  long[] insert(Trainee... trainees);

  @Insert
  List<Long> insert(Collection<Trainee> trainees);

  @Query("SELECT * FROM Trainee ORDER BY name ASC")
  LiveData<List<Trainee>> getById(long traineeId);

  @Update
  int update(Trainee trainee);

  @Delete
  int delete(Trainee... trainees);

}
