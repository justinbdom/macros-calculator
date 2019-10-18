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
        ),
        @ForeignKey(
            entity = FoodType.class,
            childColumns = "food_type_id",
            parentColumns = "food_type_id",
            onDelete = ForeignKey.CASCADE
        )
    }
)

public class Food {

}
