package edu.cnm.deepdive.macroscalculator.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.macroscalculator.model.dao.ActivityDao;
import edu.cnm.deepdive.macroscalculator.model.dao.FoodDao;
import edu.cnm.deepdive.macroscalculator.model.dao.TraineeDao;
import edu.cnm.deepdive.macroscalculator.model.entity.Activity;
import edu.cnm.deepdive.macroscalculator.model.entity.Food;
import edu.cnm.deepdive.macroscalculator.model.entity.Trainee;
import edu.cnm.deepdive.macroscalculator.model.entity.Trainee.FoodPreference;
import java.util.Date;

@Database(
    entities = {Trainee.class, Food.class, Activity.class},
    version = 1, exportSchema = true
)
@TypeConverters(MacrosCalculatorDatabase.Converters.class)
public abstract class MacrosCalculatorDatabase extends RoomDatabase {


  private static Application applicationContext;

  public static void setApplicationContext(Application applicationContext) {
    MacrosCalculatorDatabase.applicationContext = applicationContext;
  }

  public static MacrosCalculatorDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract TraineeDao getTraineeDao();

public abstract FoodDao getFoodDao();

public abstract ActivityDao getActivityDao();

  private static class InstanceHolder {

    private static final MacrosCalculatorDatabase INSTANCE;

    static {
      INSTANCE =
          Room.databaseBuilder(applicationContext, MacrosCalculatorDatabase.class, "macros_db")
              .build();
    }

  }

  public static class Converters {

    @TypeConverter
    public Long dateToLong(Date date) {
      return (date != null) ? date.getTime() : null;
    }

    @TypeConverter
    public Date longToDate(Long milliseconds) {
      return (milliseconds != null) ? new Date(milliseconds) : null;
    }

    @TypeConverter
    public String enumToString(Enum value) {
      return (value != null) ? value.toString() : null;
    }

    @TypeConverter
    public FoodPreference stringToFoodPreference(String value) {
      return (value != null) ? FoodPreference.valueOf(value) : null;
    }
  }
}
