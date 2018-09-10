package com.example.hp.iproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
/**
 * Created by Md Al Amin

 */
public class MainActivity extends AppCompatActivity{
    DrawerLayout myDrawerLayout;
    NavigationView myNavigationView;
    FragmentManager myFragmentManager;
    FragmentTransaction myFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         *Setup the DrawerLayout and NavigationView
         */
        myDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        myNavigationView = (NavigationView) findViewById(R.id.nav_drawer) ;
        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the HomeFragment as the first Fragment
         */
        myFragmentManager = getSupportFragmentManager();
        myFragmentTransaction = myFragmentManager.beginTransaction();
        /*myFragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit();*/
        myFragmentTransaction.replace(R.id.containerView, new BangladeshDivisionFragment()).commit();

        /**
         * Setup click events on the Navigation View Items.
         */
        myNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem selectedMenuItem) {
                myDrawerLayout.closeDrawers();
                if (selectedMenuItem.getItemId() == R.id.nav_item_home) {
                    FragmentTransaction fragmentTransaction = myFragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new HomeFragment()).commit();
                }
                if (selectedMenuItem.getItemId() == R.id.nav_item_bookmark) {
                    FragmentTransaction xfragmentTransaction = myFragmentManager.beginTransaction();
                    xfragmentTransaction.replace(R.id.containerView, new BangladeshDivisionFragment()).commit();
                }
                return false;
            }
        });
        /**
         * Setup Drawer Toggle of the Toolbar
         */
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, myDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);
        myDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }
}