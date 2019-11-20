package edu.cnm.deepdive.macroscalculator.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * This entity sorts foods with attributes of protein, carbs and veggies etc.
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

  @Ignore
  private boolean selected;


  /**
   * Food name string.
   * Food name is required in order for trainee to search food.
   * @return the string
   */
  @NonNull
  public String foodName() {
    return name;
  }

  /**
   * Serving size is required to display the total daily caloric intake.
   */
  public int servingSize;

  /**
   * Protein choice is required to display protein choices by type.
   */
  public String protein;

  /**
   * Carb choice is required to display carbs by type.
   */
  public String carbs;

  /**
   * Veggies are required to display veggie's by type.
   */
  public String veggies;


  /**
   * Gets name of foods.
   *
   * @return the name
   */
  @NonNull
  public String getName() {
    return name;
  }

  /**
   * Sets name of food.
   *
   * @param name the name
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }

  /**
   * Gets id associated with food.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id. associated with food.
   *
   * @param id the id
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Gets date created.
   *
   * @return the created
   */
  @NonNull
  public Date getCreated() {
    return created;
  }

  /**
   * Sets date created.
   *
   * @param created the created
   */
  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  /**
   * Gets updated date.
   *
   * @return the updated
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Sets updated date.
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
   * Returns trainee id. {@link Trainee}
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

  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }

  @NonNull
  @Override
  public String toString() {
    return name;
  }
}
