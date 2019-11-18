package edu.cnm.deepdive.macroscalculator.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * The type Food.
 */
@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Trainee.class,
            parentColumns = {"trainee_id"},
            childColumns = {"trainee_id"},
            onDelete = ForeignKey.CASCADE
        )/**/
    }
)
public class Food {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "food_id")
  private long id;

  @NonNull
  @ColumnInfo(index = true)
  private Date created = new Date();

  @NonNull
  private String name;

  @NonNull
  @ColumnInfo(index = true)
  private Date updated = new Date();

  @ColumnInfo(name = "food_type_id", index = true)
  private Long foodTypeId;

  @ColumnInfo(name = "trainee_id", index = true)
  private Long traineeId;

  /**
   * Food name string.
   *
   * @return the string
   */
  @NonNull
  public String foodName() {
    return name;
  }

  /**
   * The Serving size.
   */
  public int servingSize;

  /**
   * The Protein.
   */
  public String protein;

  /**
   * The Carbs.
   */
  public String carbs;

  /**
   * The Veggies.
   */
  public String veggies;


  /**
   * Gets name.
   *
   * @return the name
   */
  @NonNull
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

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
  public Date getCreated() {
    return created;
  }

  /**
   * Sets created.
   *
   * @param created the created
   */
  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  /**
   * Gets updated.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Sets updated.
   *
   * @param updated the updated
   */
  public void setUpdated(@NonNull Date updated) {
    this.updated = updated;
  }

  /**
   * Gets food type id.
   *
   * @return the food type id
   */
  public Long getFoodTypeId() {
    return foodTypeId;
  }

  /**
   * Sets food type id.
   *
   * @param foodTypeId the food type id
   */
  public void setFoodTypeId(Long foodTypeId) {
    this.foodTypeId = foodTypeId;
  }

  /**
   * Returns the trainee of the {@link Trainee}
   *
   * @return the trainee id
   */
  public Long getTraineeId() {
    return traineeId;
  }

  /**
   * Sets trainee id.
   *
   * @param traineeId the trainee id
   */
  public void setTraineeId(Long traineeId) {
    this.traineeId = traineeId;
  }

  @NonNull
  @Override
  public String toString() {
    return name;
  }
}
