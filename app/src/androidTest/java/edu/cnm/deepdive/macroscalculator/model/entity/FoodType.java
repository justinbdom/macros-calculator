package edu.cnm.deepdive.macroscalculator.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Food.class,
            childColumns = "food_id",
            parentColumns = "food_id"
        )
    }
)

public class FoodType {
  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "food_type_id")
  private long id;

  @NonNull
  private FoodPreference preference;


  @NonNull
  @ColumnInfo(index = true)
  private Date created = new Date();

  public long getId() { return id; }

  public void setId(long id) { this.id = id; }

  @NonNull
  public Date getCreated() { return created; }

  public enum FoodPreference {
    VEGAN, VEGETARIAN, NONE ;
  }

  @NonNull
  public FoodPreference getPreference() {
    return preference;
  }

  public void setPreference(
      @NonNull FoodPreference preference) {
    this.preference = preference;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }
}
