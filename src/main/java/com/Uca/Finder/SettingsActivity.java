package com.Uca.Finder;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.finder.service.Cache.ServiceCache;

public class SettingsActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        CheckBox box = (CheckBox) findViewById(R.id.checkBox);
        boolean cacheActivate = new ServiceCache(SettingsActivity.this).cacheIsActivate();
        box.setChecked(cacheActivate);
        box.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                   if(isChecked){
                       new ServiceCache(SettingsActivity.this).activateCache();
                   }else{
                       new ServiceCache(SettingsActivity.this).desactivateCache();
                   }
               }
           }
        );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
