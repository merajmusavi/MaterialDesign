package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.btm_nv);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.history:
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1.replace(R.id.fragment_main, new Fragment_History());
                        fragmentTransaction1.commit();
                        break;
                    case R.id.home:
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_main, new FragmentMain());
                        fragmentTransaction.commit();
                        break;
                    case R.id.nearby:
                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction2.replace(R.id.fragment_main,new Fragment_NearBy());
                        fragmentTransaction2.commit();
                }
                return true;
            }

        });
       bottomNavigationView.setSelectedItemId(R.id.home);
       bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
           @Override
           public void onNavigationItemReselected(@NonNull MenuItem item) {

           }
       });
    }
}