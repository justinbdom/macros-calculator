package edu.cnm.deepdive.macroscalculator.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

public class Trainee {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "trainee_id")
  private long id;

  @ColumnInfo(index = true)
  @NonNull
  private Date created = new Date();

  @ColumnInfo(name = "trainee_id", index = true)
  private Long trainee_id;

  public long getId() { return id; }

  public void setId(long id) {
    this.id = id;

  }

  @NonNull Date getCreated() { return created; }

}
