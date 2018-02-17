package malik1989.areeb.mydeviceinfo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import malik1989.areeb.mydeviceinfo.AppObjects.MyFragmentManager;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle toggle;
    private MyFragmentManager myFragementManager;
    private Fragment specFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigationDrawer();

        myFragementManager = new MyFragmentManager(this, R.id.content_frame);
        myFragementManager.updateFragment(myFragementManager.specFragment);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        if(toggle != null){
            toggle.syncState();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        if(toggle != null){
            toggle.onConfigurationChanged(newConfig);
        }
    }

    @Override
    public void onBackPressed(){
        View currentView = getCurrentFocus();
        if(currentView != null){
            currentView.clearFocus();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);

        Intent intent;

        switch (item.getItemId()){
            case R.id.info:
                intent = new Intent(getBaseContext(), InfoActivity.class);
                startActivity(intent);
                break;
        }

        return toggle != null && toggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void setupNavigationDrawer(){

        final String[] menu;
        final DrawerLayout drawerLayout;
        final ListView listView;
        final ArrayAdapter<String> adapter;

        menu = getResources().getStringArray(R.array.activities);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.left_drawer);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                drawerLayout.closeDrawers();

                myFragementManager.switchFragments(menu[position], getSupportFragmentManager());
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(toggle);
    }

}
