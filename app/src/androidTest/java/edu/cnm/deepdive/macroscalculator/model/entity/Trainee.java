package edu.cnm.deepdive.macroscalculator.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
public class Trainee {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "trainee_id")
  private long id;

  @ColumnInfo(index = true)
  @NonNull
  private Date created = new Date();

  @NonNull
  private String name;

  @ColumnInfo (name= "lbs_to_lose")
  private int lbsToLose;

  @ColumnInfo(name = "food_preference")
  private FoodPreference foodPreference;

  public long getId() { return id; }

  public void setId(long id) {
    this.id = id;

  }

  @NonNull Date getCreated() { return created; }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public enum FoodPreference {
    VEGAN, VEGETARIAN, NONE ;
  }

}
