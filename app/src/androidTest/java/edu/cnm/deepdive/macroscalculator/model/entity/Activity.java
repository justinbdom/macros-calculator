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
            childColumns = "trainee_id",
            parentColumns = "trainee_id",
            onDelete = ForeignKey.CASCADE

        )
    }
)
public class Activity {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "activity_id")
  private long id;

  private int duration;

  public String name;

  public String type;

  public long getId() {
    return id;
  }

  public int getDuration() {
    return duration;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  @ColumnInfo(index = true)
  @NonNull
  private Date created = new Date();

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }
}
