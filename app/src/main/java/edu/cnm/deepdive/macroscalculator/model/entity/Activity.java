package edu.cnm.deepdive.macroscalculator.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * The type Activity.
 */
@Entity(
    foreignKeys = {
        @ForeignKey(
            entity = Trainee.class,
            childColumns = "trainee_id",
            parentColumns = "trainee_id",
            onDelete = ForeignKey.CASCADE

        )
    }
)
public class Activity {

  /**
   * Sets user id.
   *
   * @param id the id
   */
  public void setId(long id) {
    this.id = id;
  }

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "activity_id")
  private long id;

  @ColumnInfo(name = "trainee_id", index = true)
  private long traineeId;

  /**
   * Sets duration.
   *
   * @param duration the duration
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }

  private int duration;

  /**
   * Name of user.
   */
  public String name;

  /**
   * Workout of choice.
   */
  public String type;

  /**
   * User id.
   *
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * Gets duration.
   *
   * @return the duration
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Workout name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public String getType() {
    return type;
  }

  @ColumnInfo(index = true)
  @NonNull
  private Date created = new Date();

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
   * Sets trainee id.
   *
   * @param traineeId the trainee id
   */
  public void setTraineeId(long traineeId) {
    this.traineeId = traineeId;
  }

  /**
   * Gets trainee id.
   *
   * @return the trainee id
   */
  public long getTraineeId() {
    return traineeId;
  }
}
