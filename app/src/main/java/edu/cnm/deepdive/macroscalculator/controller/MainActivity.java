package edu.cnm.deepdive.macroscalculator.controller;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import edu.cnm.deepdive.macroscalculator.R;
import edu.cnm.deepdive.macroscalculator.viewmodel.MainViewModel;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BottomNavigationView navView = (BottomNavigationView) findViewById(R.id.navigation);
    NavHostFragment hostFragment =
        (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
    NavController navController = hostFragment.getNavController();
    NavigationUI.setupWithNavController(navView, navController);
    MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
  }

}
