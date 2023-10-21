package com.example.navigationdrawer.request;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdrawer.R;
import com.example.navigationdrawer.asset.AssetAdminActivity;
import com.example.navigationdrawer.assignment.AssignmentAdminActivity;
import com.example.navigationdrawer.assignment.AssignmentApdapter;
import com.example.navigationdrawer.assignment.new_request.NewRequestActivity;
import com.example.navigationdrawer.login.LoginActivity;
import com.example.navigationdrawer.main.MainAdminActivity;
import com.example.navigationdrawer.profile.ProfileAdminActivity;
import com.example.navigationdrawer.report.ReportActivity;
import com.example.navigationdrawer.user.UserAdminActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import Models.Assignment;

public class RequestAdminActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    RecyclerView recyclerView;
    RequestAdminAdapter requestAdminAdapter;
    ImageView imageMenu;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_admin);
        AnhXa();
        Handle_Component();
        setRecycleView();
    }
    private void setRecycleView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        requestAdminAdapter = new RequestAdminAdapter(this, getList());
        recyclerView.setAdapter(requestAdminAdapter);
    }

    private List<Assignment> getList() {
        List<Assignment> assignmentList = new ArrayList<>();
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        assignmentList.add(new Assignment("a","a","a","a","a","a","a","a"));
        return  assignmentList;
    }

    void AnhXa(){
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);
        recyclerView = findViewById(R.id.recycler_view);
    }

    void Handle_Component(){
        // Navigation Drawer------------------------------
        toggle = new ActionBarDrawerToggle(RequestAdminActivity.this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Drawer click event
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.mHome) {
                    Intent intent = new Intent(RequestAdminActivity.this, MainAdminActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }
                else if (itemId == R.id.mAsset) {
                    Intent intent = new Intent(RequestAdminActivity.this, AssetAdminActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }
                else if (itemId == R.id.mAssignment) {
                    Intent intent = new Intent(RequestAdminActivity.this, AssignmentAdminActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }
                else if (itemId == R.id.mRequest) {
                    drawerLayout.closeDrawers();
                }
                else if (itemId == R.id.mProfile) {
                    Intent intent = new Intent(RequestAdminActivity.this, ProfileAdminActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }
                else if (itemId == R.id.mStaff) {
                    Intent intent = new Intent(RequestAdminActivity.this, UserAdminActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }
                else if (itemId == R.id.mFeedback) {
                    Toast.makeText(RequestAdminActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                }
                else if (itemId == R.id.mReport) {
                    Intent intent = new Intent(RequestAdminActivity.this, ReportActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }
                else if (itemId == R.id.mLogout) {
                    Intent intent = new Intent(RequestAdminActivity.this, LoginActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                    finish();
                }
                return false;
            }
        });

        // App Bar Click Event
        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
}
