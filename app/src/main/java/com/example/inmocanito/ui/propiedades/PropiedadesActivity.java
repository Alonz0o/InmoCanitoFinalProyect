package com.example.inmocanito.ui.propiedades;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.inmocanito.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesActivity extends AppCompatActivity implements PropiedadesFragment.OnFragmentInteractionListener {

    private PropiedadesViewModel PVM;
    private ViewPager VPP;
    private TabLayout tbPropiedades;
    private AppBarLayout ablPropiedades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propiedades);

        PVM = ViewModelProviders.of(this).get(PropiedadesViewModel.class);

        VPP=findViewById(R.id.viewPage);
        ablPropiedades=findViewById(R.id.abPropietarios);
        tbPropiedades = new  TabLayout(this);
        ablPropiedades.addView(tbPropiedades);
        ViewPageAdapter VPA = new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        VPA.addFragment(new PropiedadesFragment(),"Propiedad1");
        VPA.addFragment(new PropiedadesFragment(),"Propiedad2");
        VPA.addFragment(new PropiedadesFragment(),"Propiedad3");
        VPA.addFragment(new PropiedadesFragment(),"Propiedad4");
        VPA.addFragment(new PropiedadesFragment(),"Propiedad5");

        VPP.setAdapter(VPA);
        tbPropiedades.setupWithViewPager(VPP);
        tbPropiedades.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getApplicationContext(),tab.getText(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void OnFragmentInteraction(Uri uri) {

    }
    public class ViewPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titulosFragments = new ArrayList<>();
        public  ViewPageAdapter(@NonNull FragmentManager fm, int behavior){
            super(fm, behavior);
    }

    public Fragment getItem (int position)
    {
        return fragmentList.get(position);
    }
    public int getCount ()
    {
        return fragmentList.size();
    }

    public CharSequence getPageTitle (int posicion) {
        return titulosFragments.get(posicion);
    }
    public void addFragment (Fragment fragment, String titulo) {
        fragmentList.add(fragment);
        titulosFragments.add(titulo);
        }
    }
}
