package net.foxcom.android.trackmybeer;

import android.app.Application;

import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import net.foxcom.android.trackmybeer.utils.logging.CrashReportingTree;
import timber.log.Timber;

public class TrackerApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Timber.d("Build type is " + BuildConfig.BUILD_TYPE);

        Iconify.with(new FontAwesomeModule());

        if (!ApplicationConfig.DEBUG) {
            Timber.plant(new CrashReportingTree());
        } else {
            Timber.plant(new Timber.DebugTree());
        }
        Timber.d("application start");

    }
}
