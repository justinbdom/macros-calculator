package edu.cnm.deepdive.macroscalculator;

import android.app.Application;
import android.util.Log;
import com.android.volley.VolleyLog;
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
    VolleyLog.setTag("Volley");
    Log.isLoggable("Volley", Log.VERBOSE);
    VolleyLog.DEBUG = true;
    MacrosCalculatorDatabase.setApplicationContext(this);
    MacrosCalculatorDatabase database = MacrosCalculatorDatabase.getInstance();
    new Thread(new Runnable() {
      @Override
      public void run() {
        database.getTraineeDao().delete();
      }
    }).start();
  }

}
