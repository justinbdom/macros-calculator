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
            entity = Trainee.class,
            parentColumns = {"trainee_id"},
            childColumns = {"trainee_id"},
            onDelete = ForeignKey.CASCADE
        )
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

  @NonNull
  public String foodName() {
    return name;
  }

  public int servingSize;

  public String protein;

  public String carbs;

  public String veggies;



  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  public Date getUpdated() {
    return updated;
  }

  public void setUpdated(@NonNull Date updated) {
    this.updated = updated;
  }

  public Long getFoodTypeId() {
    return foodTypeId;
  }

  public void setFoodTypeId(Long foodTypeId) {
    this.foodTypeId = foodTypeId;
  }

  public Long getTraineeId() {
    return traineeId;
  }

  public void setTraineeId(Long traineeId) {
    this.traineeId = traineeId;
  }

}
