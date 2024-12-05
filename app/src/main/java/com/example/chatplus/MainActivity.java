package com.example.chatplus;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.chatplus.Adapters.FragmentsAdapters;
import com.example.chatplus.Fragments.CallsFragment;
import com.example.chatplus.Fragments.ChatsFragment;
import com.example.chatplus.Fragments.GroupFragment;
import com.example.chatplus.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseDatabase database;

    TextView textView;
    TextView personOne;
    TextView personTwo;

    TabLayout tabLayout;
    FloatingActionButton fabAction;
    ViewPager viewPager;

    private void changeFabCon(final int index) {
        fabAction.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index) {
                    case 0:
                        fabAction.setImageDrawable(getDrawable(R.drawable.baseline_chat_24));
                        break;
                    case 1:
                        fabAction.setImageDrawable(getDrawable(R.drawable.baseline_add_24));
                        break;
                    case 2:
                        fabAction.setImageDrawable(getDrawable(R.drawable.baseline_call_24));
                        break;

                }
                fabAction.show();
            }

        }, 400);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fabAction = findViewById(R.id.fab_action);

        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewPager);

//        complete        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tabLayout.setupWithViewPager(viewPager);

        FragmentsAdapters fragmentsAdapters = new FragmentsAdapters(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragmentsAdapters.addFragment(new ChatsFragment(), "CHATS");
        fragmentsAdapters.addFragment(new GroupFragment(), "GROUPS");
        fragmentsAdapters.addFragment(new CallsFragment(), "CALLS");

        viewPager.setAdapter(fragmentsAdapters);

        binding.tvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatusClickActivity.class);
                startActivity(intent);

            }
        });
        textView = (TextView)findViewById(R.id.mySatus);
       textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatusClickActivity.class);
                startActivity(intent);

            }
        });

       personOne = (TextView)findViewById(R.id.satusPerson);
        personOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatusOne.class);
                startActivity(intent);

            }
        });

        personTwo = (TextView)findViewById(R.id.personSatus1);
        personTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StatusSce.class);
                startActivity(intent);

            }
        });



        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                changeFabCon(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


////        toalBar code update 2-11-24
////        this tool bar is create for the upper chat+ name and logo

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //        auth work only !!!!!
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();


        
        if (id == R.id.menu_search) {
            Toast.makeText(this, "search clicked", Toast.LENGTH_SHORT).show();
        }
//        if (id == R.id.menu_them) {
//            Toast.makeText(this, "them changed", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(MainActivity.this, ConstructionActivity.class);
//            startActivity(intent);
//        }
//
//         if (id == R.id.setings) {
//             Toast.makeText(this, "setting clicked", Toast.LENGTH_SHORT).show();
//
//             Intent intent = new Intent(MainActivity.this, SetingsActivity.class);
//             startActivity(intent);
//         }
//         if (id == R.id.logout) {
//             mAuth.signOut();
//             Toast.makeText(this, "Logout clicked", Toast.LENGTH_SHORT).show();
//             Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
//             startActivity(intent1);
//             finish();
//         }

        return true;
    }
}
