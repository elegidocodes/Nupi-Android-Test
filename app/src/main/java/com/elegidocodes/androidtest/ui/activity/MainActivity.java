package com.elegidocodes.androidtest.ui.activity;

import static com.elegidocodes.androidtest.utility.SharedPreferencesUtil.get;
import static com.elegidocodes.androidtest.utility.SharedPreferencesUtil.remove;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.elegidocodes.androidtest.R;
import com.elegidocodes.androidtest.databinding.ActivityMainBinding;
import com.elegidocodes.androidtest.model.Token;
import com.elegidocodes.androidtest.model.User;
import com.elegidocodes.androidtest.utility.CircleTransform;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;

    private NavController navController;
    private AppBarConfiguration appBarConfiguration;
    private DrawerLayout drawerLayout;

    private User user;
    private Token token;

    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        user = get(this, "MyPrefs", "user", User.class);
        token = get(this, "MyPrefs", "token", Token.class);

        context = this;

        // Initialize Navigation Drawer
        drawerLayout = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Set up navigation
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.navHostFragment);

        if (navHostFragment != null) {
            navController = navHostFragment.getNavController();

            // Set up AppBarConfiguration with the drawer
            appBarConfiguration = new AppBarConfiguration.Builder(R.id.loginFragment, R.id.fragmentHome, R.id.userProfileFragment)
                    .setOpenableLayout(drawerLayout)
                    .build();

            // Set up ActionBar with NavController and Drawer
            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

            // Connect NavigationView with NavController
            NavigationUI.setupWithNavController(navigationView, navController);

            // Set up destination changed listener for toolbar visibility
            navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
                if (destination.getId() == R.id.splashFragment || destination.getId() == R.id.loginFragment) {
                    hideToolbar();
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                } else {
                    showToolbar();
                    drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                }
            });


            navigationView.setNavigationItemSelectedListener(item -> {

                if (item.getItemId() == R.id.menu_logout) {
                    if (token != null) {
                        logOut(token);
                    }
                }

                return true;
            });

        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        // Handle both drawer and back button navigation
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem profileItem = menu.findItem(R.id.menu_user_information);
        if (profileItem != null && profileItem.getIcon() != null) {
            profileItem.getIcon().setTint(ContextCompat.getColor(this, R.color.white));
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_user_information) {
            navigateToUserProfile();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        Picasso.get()
                .load(user.getProfilePicture())
                .placeholder(R.drawable.icon_person_24px)
                .error(R.drawable.icon_person_24px)
                .transform(new CircleTransform())
                .into(new Target() {
                    @Override
                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                        menu.findItem(R.id.menu_user_information).setIcon(new BitmapDrawable(getResources(), bitmap));
                    }

                    @Override
                    public void onBitmapFailed(Exception e, Drawable errorDrawable) {
                        Log.e(TAG, e.getMessage(), e);
                        menu.findItem(R.id.menu_user_information).setIcon(errorDrawable);
                    }

                    @Override
                    public void onPrepareLoad(Drawable placeHolderDrawable) {
                        menu.findItem(R.id.menu_user_information).setIcon(placeHolderDrawable);
                    }
                });

        return super.onPrepareOptionsMenu(menu);
    }

    public void hideToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public void showToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.show();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
        }
    }

    private void navigateToUserProfile() {
        try {
            NavOptions options = new NavOptions.Builder()
                    .setLaunchSingleTop(true)
                    .build();

            navController.navigate(R.id.userProfileFragment, null, options);
        } catch (Exception e) {
            Toast.makeText(this, "Navigation error", Toast.LENGTH_SHORT).show();
        }
    }

    private void logOut(Token token) {
        viewModel.logout(token.getAccessToken())
                .thenAccept(serverResponse -> {
                    if (serverResponse != null && serverResponse.getCode() == 200) {

                        runOnUiThread(() -> {

                            Toast.makeText(context, serverResponse.getMessage(), Toast.LENGTH_SHORT).show();

                            navController.navigate(R.id.loginFragment);
                            remove(context, "MyPrefs", "user");
                            remove(context, "MyPrefs", "token");

                        });

                    }
                })
                .exceptionally(throwable -> {
                    Log.e(TAG, "Error logging out", throwable);
                    return null;
                });
    }

}