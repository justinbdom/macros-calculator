package edu.cnm.deepdive.macroscalculator.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.Index;
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

  private String email;

  @ColumnInfo (name= "lbs_to_lose")
  private int lbsToLose;

  @ColumnInfo(name = "food_preference")
  private FoodPreference foodPreference;

  public long getId() { return id; }

  public void setId(long id) {
    this.id = id;

  }

  @NonNull
  public Date getCreated() { return created; }

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getLbsToLose() {
    return lbsToLose;
  }

  public void setLbsToLose(int lbsToLose) {
    this.lbsToLose = lbsToLose;
  }

  public FoodPreference getFoodPreference() {
    return foodPreference;
  }

  public void setFoodPreference(
      FoodPreference foodPreference) {
    this.foodPreference = foodPreference;
  }

  public enum FoodPreference {
    VEGAN, VEGETARIAN, NONE ;
  }
}
