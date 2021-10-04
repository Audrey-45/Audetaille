package com.example.project.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.controller.Control;
import com.example.project.model.CartArticles;
import com.example.project.model.Tshirt;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    //proprieties
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    TabLayout tabLayout;
    TabItem tab1,tab2,tab3,tab4;
    ViewPager viewPager;
    fragmentmanager fragmentmanager;
    private Control control;

    /**
     * Creation activity
     * Item clickable in menu
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        control = Control.getInstance(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("");
        Toolbar toolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        setSupportActionBar(toolbar);


        //creation of the slide menu
        tabLayout = (TabLayout) findViewById(R.id.ctablayout);
        tab1 = (TabItem) findViewById(R.id.ctab1);
        tab2 = (TabItem) findViewById(R.id.ctab2);
        tab3 = (TabItem) findViewById(R.id.ctab3);
        tab4 = (TabItem) findViewById(R.id.ctab4);
        viewPager = (ViewPager) findViewById(R.id.pageholder);
        drawerLayout = (DrawerLayout) findViewById(R.id.mydrawer);
        navigationView = (NavigationView) findViewById(R.id.cnav);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        fragmentmanager = new fragmentmanager(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, tabLayout.getTabCount());
        viewPager.setAdapter(fragmentmanager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            /**
             * see which fragment is selected
             * @param tab
             */
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            /**
             * see which fragment is not selected
             * @param tab
             */
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            /**
             * see which fragment is reselected
             * @param tab
             */
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            /**
             * Menu item clikable
             * @param item
             * @return
             */
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                ArrayList<CartArticles> listCartArticles = control.getAllArticles();
                ArrayList<Tshirt> listTs = control.getAllTshirt();

                //All item in menu

                if (item.getItemId() == R.id.home)
                {
                    Toast.makeText(getApplicationContext(), "Home is clicked", Toast.LENGTH_SHORT).show();
                    Intent gameActivtyIntent=new Intent(MainActivity.this, MainActivity.class);

                    startActivity(gameActivtyIntent);
                }

                if (item.getItemId() == R.id.cart)
                {
                    Toast.makeText(getApplicationContext(), "Cart is clicked", Toast.LENGTH_SHORT).show();
                    if(listCartArticles.size()==0 && listTs.size()==0)
                    {
                        Intent gameActivtyIntent=new Intent(MainActivity.this, CartEmpty.class);
                        startActivity(gameActivtyIntent);
                    }
                    else if (listCartArticles.size()!=0 || listTs.size()!=0)
                    {
                        Intent gameActivtyIntent=new Intent(MainActivity.this, Cart.class);
                        startActivity(gameActivtyIntent);
                    }

                }

                if (item.getItemId() == R.id.saved_items)
                {
                    Toast.makeText(getApplicationContext(), "Saved items is clicked", Toast.LENGTH_SHORT).show();
                    Intent gameActivtyIntent=new Intent(MainActivity.this, FavoriteProducts.class);
                    startActivity(gameActivtyIntent);
                }

                if (item.getItemId() == R.id.my_account)
                {
                    Toast.makeText(getApplicationContext(), "My account is clicked", Toast.LENGTH_SHORT).show();
                    Intent gameActivtyIntent=new Intent(MainActivity.this, AccountMain.class);
                    startActivity(gameActivtyIntent);
                }

                if (item.getItemId() == R.id.our_vinted)
                {
                    //click on the item to open an http link
                    String url = "https://www.vinted.fr/member/53526365-audetaille";
                    Intent gameActivtyIntent = new Intent(Intent.ACTION_VIEW);
                    gameActivtyIntent.setData(Uri.parse(url));
                    startActivity(gameActivtyIntent);
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });


    }


}


