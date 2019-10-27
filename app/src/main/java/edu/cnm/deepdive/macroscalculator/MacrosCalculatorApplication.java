package edu.cnm.deepdive.macroscalculator;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.macroscalculator.service.MacrosCalculatorDatabase;

public class MacrosCalculatorApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    //GoogleSignInService.setApplicationContext(this);
    Stetho.initializeWithDefaults(this);
    Picasso.setSingletonInstance(
        new Picasso.Builder(this)
            .loggingEnabled(true) // Disable for production
            .build()
    );
    MacrosCalculatorDatabase.setApplicationContext(this);
    final MacrosCalculatorDatabase database = MacrosCalculatorDatabase.getInstance();
    new Thread(new Runnable() {
      @Override
      public void run() {
        database.getTraineeDao().delete();
      }
    }).start();
  }

}
