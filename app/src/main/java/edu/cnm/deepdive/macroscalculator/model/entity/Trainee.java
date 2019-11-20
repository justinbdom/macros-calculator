package edu.cnm.deepdive.macroscalculator.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * The type Trainee.
 */
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

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() { return id; }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
    this.id = id;

  }

  /**
   * Gets created.
   *
   * @return the created
   */
  @NonNull
  public Date getCreated() { return created; }

  /**
   * Sets created date.
   *
   * @param created the created
   */
  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  /**
   * Gets name of Trainee.
   *
   * @return the name
   */
  @NonNull
  public String getName() {
    return name;
  }

  /**
   * Sets name of Trainee.
   *
   * @param name the name
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }

  /**
   * Gets email of Trainee.
   *
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets email of Trainee.
   *
   * @param email the email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets lbs Trainee wants to lose.
   *
   * @return the lbs to lose
   */
  public int getLbsToLose() {
    return lbsToLose;
  }

  /**
   * Sets lbs Trainee wants to lose.
   *
   * @param lbsToLose the lbs to lose.
   */
  public void setLbsToLose(int lbsToLose) {
    this.lbsToLose = lbsToLose;
  }

  /**
   * Gets food preference Trainee chooses.
   *
   * @return the food preference
   */
  public FoodPreference getFoodPreference() {
    return foodPreference;
  }

  /**
   * Sets food preference.
   *
   * @param foodPreference the food preference
   */
  public void setFoodPreference(
      FoodPreference foodPreference) {
    this.foodPreference = foodPreference;
  }

  /**
   * The enum Food preference.
   */
  public enum FoodPreference {
    /**
     * Vegan food preference.
     */
    VEGAN,
    /**
     * Vegetarian food preference.
     */
    VEGETARIAN,
    /**
     * None food preference.
     */
    NONE ;
  }
}
