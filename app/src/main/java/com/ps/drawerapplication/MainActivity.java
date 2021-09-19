package com.ps.drawerapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.ps.drawerapplication.databinding.ActivityMainBinding;
import com.ps.drawerapplication.fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity {
    Context mContext;
    private String TAG ="MainActivity";
    ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
            binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
            initValues();
            clickEvents();
    }

    private void clickEvents() {
    binding.layoutDE.tvProfile.setOnClickListener(new View.OnClickListener() {
        @SuppressLint("WrongConstant")
        @Override
        public void onClick(View v) {
            setprofile();
            binding.drawer.closeDrawer(Gravity.START);

        }
    });
    }

    private void initValues() {
        mContext = this;
    }

    public void loadFragment(Fragment fragment) {
        try {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameFragcat, fragment);
            transaction.addToBackStack(null);
            transaction.commit();

        } catch (Exception e) {
            Log.d(TAG, "\tloadFragment\t" + e);
        }
    }

    void setprofile(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            binding.layoutDE.tvProfile.setTextColor(getColor(R.color.red));
            binding.layoutDE.tvActivity.setTextColor(getColor(R.color.black));
            binding.layoutDE.tvHelp.setTextColor(getColor(R.color.black));
            binding.layoutDE.tvMessage.setTextColor(getColor(R.color.black));
            binding.layoutDE.tvReports.setTextColor(getColor(R.color.black));
            binding.layoutDE.tvShare.setTextColor(getColor(R.color.black));
            binding.layoutDE.tvStats.setTextColor(getColor(R.color.black));
            binding.layoutDE.tvLists.setTextColor(getColor(R.color.black));
            binding.layoutDE.tvLogout.setTextColor(getColor(R.color.black));

        }
        loadFragment(new ProfileFragment());
    }
    public void onBackPressed () {

        if (binding.drawer.isDrawerOpen(GravityCompat. START )) {
            binding.drawer.closeDrawer(GravityCompat. START ) ;
        } else {
            super .onBackPressed() ;
        }
    }
}