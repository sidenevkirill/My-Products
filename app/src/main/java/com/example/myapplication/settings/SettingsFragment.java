package com.example.myapplication.settings;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.TaskStackBuilder;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.myapplication.LoginActivity;
import com.example.myapplication.MainAcivity;
import com.example.myapplication.R;

import java.util.Locale;

public class SettingsFragment extends PreferenceFragmentCompat
        implements Preference.OnPreferenceChangeListener, Preference.OnPreferenceClickListener {
    private static final String KEY_DARK_MODE = "dark_mode";
    private static final String KEY_DEVELOPER = "developer";
    private static final String KEY_CHANNEL = "channel";
    private static final String KEY_LOGOUT = "logout";

    private static final int REQUEST_CODE_PICK_DIR = 9999;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.prefs);

        findPreference(KEY_DARK_MODE).setOnPreferenceChangeListener(this);
        findPreference(KEY_DEVELOPER).setOnPreferenceClickListener(this);
        findPreference(KEY_CHANNEL).setOnPreferenceClickListener(this);
        findPreference(KEY_LOGOUT).setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        switch (preference.getKey()) {
            case KEY_DARK_MODE:
                if ((boolean) newValue) {
                }
                reloadTheme();
                break;
        }
        return true;
    }

    private void reloadTheme() {
        Activity activity = getActivity();

        TaskStackBuilder.create(activity)
                .addNextIntent(new Intent(activity, MainAcivity.class))
                .addNextIntent(activity.getIntent())
                .startActivities();

        activity.overridePendingTransition(R.anim.alpha_out, R.anim.alpha_in);
    }

    private void pickFolder() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
            i.addCategory(Intent.CATEGORY_DEFAULT);
            startActivityForResult(Intent.createChooser(i, "Choose directory"), REQUEST_CODE_PICK_DIR);
        }
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        switch (preference.getKey()) {
            case KEY_DEVELOPER:
               // AndroidUtil.browse(getActivity(), AUTHOR_LINK);
                break;
            case KEY_CHANNEL:
               // AndroidUtil.browse(getActivity(), AUTHOR_CHANNEL);
                break;
            case KEY_LOGOUT:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
        }
        return true;
    }

}
