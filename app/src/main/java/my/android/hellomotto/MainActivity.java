package my.android.hellomotto;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottomNavigationView;
    private ClipboardManager myClipboard;
    Fragment selectedFragment = null;
    Fragment getSelectedFragment = null;
    DrawerLayout drawerLayout;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    Fragment fragment = null;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    ImageView imageBtn, location, shoping;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//      toolbar.setNavigationIcon(R.drawable.menu);
//        toolbar.setLogo(R.drawable.menu);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        imageBtn = findViewById(R.id.imagemenu);
        location = findViewById(R.id.placeholder);
        shoping = findViewById(R.id.shoping);

        shoping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MycartActivity.class);
                startActivity(intent);
            }
        });
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkPermission(Manifest.permission.ACCESS_COARSE_LOCATION, MY_PERMISSIONS_REQUEST_LOCATION);
            }
        });


        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);

        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(navigationView);
            }
        });

        getSelectedFragment = new Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag, getSelectedFragment).commit();

        selectedFragment = new Home();
        getSupportFragmentManager().beginTransaction().replace(R.id.frag, selectedFragment).commit();
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        bottomNavigationView.setSelectedItemId(R.id.action_profile);
                        getSelectedFragment = new Shopping();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        toolbar.setVisibility(View.GONE);
                        break;

                    case R.id.orders:
                        getSelectedFragment = new Order_nav();
                        bottomNavigationView.setSelectedItemId(R.id.action_shoppingbag);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        toolbar.setVisibility(View.GONE);
                        break;


                    case R.id.wallet:
                        Intent wallet = new Intent(getApplicationContext(), WalletActivity.class);
                        startActivity(wallet);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.help:
                        Intent help = new Intent(getApplicationContext(), HelpActivity.class);
                        startActivity(help);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.about:
                        Intent about = new Intent(getApplicationContext(), AboutActivity.class);
                        startActivity(about);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.delivery:
                        Intent delivery = new Intent(getApplicationContext(), DeliveryActivity.class);
                        startActivity(delivery);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.privacy:
                        Intent privacy = new Intent(getApplicationContext(), PrivacyActivity.class);
                        startActivity(privacy);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.termcondition:
                        Intent term = new Intent(getApplicationContext(), TermsActivity.class);
                        startActivity(term);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frag, getSelectedFragment).commit();

                return true;
            }
        });


        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.clearAnimation();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                toolbar.setVisibility(View.VISIBLE);
                switch (item.getItemId()) {
                    case R.id.action_home:
                        selectedFragment = new Home();
                        toolbar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.action_discount:
                        selectedFragment = new Offers();
                        toolbar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.action_shoppingbag:
                        selectedFragment = new Order_nav();
                        toolbar.setVisibility(View.GONE);
                        break;
                    case R.id.action_profile:
                        selectedFragment = new Profile();
                        toolbar.setVisibility(View.GONE);
                        break;
                    case R.id.action_dashboard:
                        selectedFragment = new Dashboard();
                        toolbar.setVisibility(View.VISIBLE);
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frag, selectedFragment).commit();
                return true;
            }
        });
    }


    public void checkPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission)
                == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{permission},
                    requestCode);
        } else {
            Toast.makeText(MainActivity.this,
                    "Permission already granted",
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super
                .onRequestPermissionsResult(requestCode,
                        permissions,
                        grantResults);


        if (requestCode == MY_PERMISSIONS_REQUEST_LOCATION) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,
                        "Location Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Location Permission Denied",
                        Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            onBackPressed();
        }
    return true;
    }


    @Override
    public void onBackPressed() {
        //this is only needed if you have specific things
        //that you want to do when the user presses the back button.
        /* your specific things...*/
        super.onBackPressed();
    }

}
