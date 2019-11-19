package com.example.goflash;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;
import com.example.goflash.fragment.HomeFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedOnce = false;
    @Bind(R.id.content)
    LinearLayout content;
    @Bind(R.id.bottom_navigation) AHBottomNavigation navigation;

    String a,b,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = "Mungkin";
        b = "inilah";
        c = "saatnya";
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
//            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

//        sess = new SessionUser(this);


//        sess.setString("tooltip_event_daily","");
//        sess.setString("tooltip_main","");
//        sess.commitSess();

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        // Sets the Toolbar to act as the ActionBar for this Activity window.
//        // Make sure the toolbar exists in the activity and is not null
//        setSupportActionBar(toolbar);
////        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        toolbar.setTitle("BRISPOT");
////        toolbar.setSubtitle("");


//        if (savedInstanceState == null) {
//            mDrawerLayout.openDrawer(mDrawerList);
//        }
//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        if (sess.getString("level_user").equalsIgnoreCase("60")){
            transaction.replace(R.id.content, HomeFragment.newInstance(0));

//        }else {
//            transaction.replace(R.id.content, HomeSmeFragment.newInstance(0));
//
//        }
        transaction.commit();
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Home", R.drawable.bt_home_home_off, R.color.main_color_50);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("My Organizer", R.drawable.bt_home_dailyact_off, R.color.main_color_50);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Profile", R.drawable.bt_home_profile_off, R.color.main_color_50);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Pesan", R.drawable.bt_home_pesan_off, R.color.main_color_50);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem("Bantuan", R.drawable.bt_home_bantuan_off, R.color.main_color_50);
        navigation.addItem(item1);
        navigation.addItem(item2);
        navigation.addItem(item3);
        navigation.addItem(item4);
        navigation.addItem(item5);
        navigation.setDefaultBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.main_color_500));
        navigation.setBehaviorTranslationEnabled(true);
//        navigation.manageFloatingActionButtonBehavior(floatingActionButton);
        navigation.setAccentColor(ContextCompat.getColor(MainActivity.this, R.color.main_color_400));
        navigation.setInactiveColor(ContextCompat.getColor(MainActivity.this, R.color.white));
        navigation.setForceTint(true);
        navigation.setTranslucentNavigationEnabled(true);
//        navigation.setTitleState(AHBottomNavigation.TitleState.SHOW_WHEN_ACTIVE);
        navigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
//        navigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_HIDE);
        navigation.setColored(false);
//        navigation.setColoredModeColors(ContextCompat.getColor(MainActivity.this, R.color.main_color_400),ContextCompat.getColor(MainActivity.this, R.color.main_color_grey_400));
        navigation.setCurrentItem(0);
//        navigation.setNotificationBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.main_color_A400));
//        navigation.setNotification("1", 2);
        AHNotification notification = new AHNotification.Builder()
                .setText("0")
                .setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.material_orange_500))
                .setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white))
                .build();
        navigation.setNotification(notification, 3);
//        navigation.enableItemAtPosition(2);
//        navigation.disableItemAtPosition(2);
        navigation.setItemDisableColor(ContextCompat.getColor(MainActivity.this, R.color.main_color_grey_600));
        navigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here...
                Fragment selectedFragment = null;
//                mDrawerLayout.closeDrawer(mDrawerList);
                switch (position) {
                    case 0:
//                        if (sess.getString("level_user").equalsIgnoreCase("60")){
                            selectedFragment = HomeFragment.newInstance(1);

//                        }else {
//                            selectedFragment = HomeSmeFragment.newInstance(1);
//
//                        }
                        break;
                    case 1:
//                        selectedFragment = EventFragment.newInstance(2);
                        break;
                    case 2:
//                        startNotif();
//                        startReminder();
//                        selectedFragment = ProfileFragment.newInstance(3);
                        break;
                    case 3:
//                        startAlarm();
//                        selectedFragment = NotifFragment.newInstance(4);
                        break;
                    case 4:
//                        cancelAlarm();
//                        cancleReminder(ServiceReminder.class);
//                        cancelReminder();
//                        cancelNotif();
//                        selectedFragment = HelpFragment.newInstance(5);
                        break;
                    case 5:
//                        if (sess.getString("level_user").equalsIgnoreCase("60")){
                            selectedFragment = HomeFragment.newInstance(6);

//                        }else {
//                            selectedFragment = HomeSmeFragment.newInstance(6);
//
//                        }
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content, selectedFragment);
                transaction.commit();
                return true;
            }
        });
        navigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                // Manage the new y position
            }
        });

//        /** ACTIVATE JOB PUSH REMINDER ***/
//        Intent i2 = new Intent(this, ServiceReminder.class);
//        if(!isMyServiceRunning(ServiceReminder.class)){
//            startService(i2);
//        }

//        Intent alarmIntent = new Intent(this, SyncShareLocation.class);
//        pendingIntent = PendingIntent.getBroadcast(this, 0, alarmIntent, 0);
//        Intent reminderIntent = new Intent(this, ServiceReminderNew.class);
//        pendingReminderIntent = PendingIntent.getBroadcast(this, 0, reminderIntent, 0);
//        Intent notifIntent = new Intent(this, ServiceNotifikasi.class);
//        pendingNotifIntent = PendingIntent.getBroadcast(this, 0, notifIntent, 0);
//        notifikasiReceiver = new NotifReceiver();
//
//        if(sess.has("serv_reminder_on")) {
//            if(sess.getString("serv_reminder_on").equalsIgnoreCase("on")) {
//                if(managerReminders == null) {
//                    startReminder();
//                }
//            }else if(sess.getString("serv_reminder_on").equalsIgnoreCase("off_sys")) {
//                cancelReminder();
//            }else if(sess.getString("serv_reminder_on").equalsIgnoreCase("on_sys")) {
//                startReminder();
//            }else if(sess.getString("serv_reminder_on").equalsIgnoreCase("off")) {
//                cancelReminder();
//            }else{
//                cancelReminder();
//            }
//        }else{
//            cancelReminder();
//        }
//        if(sess.has("serv_notif_on")) {
//            if(sess.getString("serv_notif_on").equalsIgnoreCase("on")) {
//                if(managerNotifs == null) {
//                    startNotif();
//                }
//            }else if(sess.getString("serv_notif_on").equalsIgnoreCase("off_sys")) {
//                cancelNotif();
//            }else if(sess.getString("serv_notif_on").equalsIgnoreCase("on_sys")) {
//                startNotif();
//            }else if(sess.getString("serv_notif_on").equalsIgnoreCase("off")) {
//                cancelNotif();
//            }else{
//                cancelNotif();
//            }
//        }else{
//            cancelNotif();
//        }
//        if(sess.has("serv_loc_on")) {
//            if(sess.getString("serv_loc_on").equalsIgnoreCase("on")) {
//                if(manager == null) {
//                    startShareLoc();
//                }
//            }else if(sess.getString("serv_loc_on").equalsIgnoreCase("off_sys")) {
//                cancelShareLoc();
//            }else if(sess.getString("serv_loc_on").equalsIgnoreCase("on_sys")) {
//                startShareLoc();
//            }else if(sess.getString("serv_loc_on").equalsIgnoreCase("off")) {
//                cancelShareLoc();
//            }else{
//                cancelShareLoc();
//            }
//        }else{
//            cancelShareLoc();
//        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if(sess.has("start_sess")) {
//            if(!sess.getString("start_sess").equalsIgnoreCase("") && sess.getString("start_sess") != null) {
//                try {
//                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    Date currentTime = Calendar.getInstance().getTime();
//                    Date rDate = dateFormat.parse(sess.getString("start_sess"));
//                    Calendar rTime = Calendar.getInstance();
//                    rTime.setTime(rDate);
//                    rTime.add(Calendar.DAY_OF_MONTH,1);
//                    if(currentTime.after(rTime.getTime())) {
//                        finish();
//                        Intent in = new Intent(MainActivity.this,SplashScreenActivity.class);
//                        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(in);
//                    }
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }

    @Override
    public void onBackPressed() {
//        ActivityCompat.finishAffinity(MainActivity.this);
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }else {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Tekan sekali lagi untuk keluar", Toast.LENGTH_SHORT).show();

//            new Handler().postDelayed(new Runnable() {
//
//                @Override
//                public void run() {
//                    doubleBackToExitPressedOnce=false;
//                    ActivityCompat.finishAffinity(MainActivity.this);
//                }
//            }, 2000);
        }
    }

    public void setNotifCounter(String count) {
        AHNotification notification = new AHNotification.Builder()
                .setText(count)
                .setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.material_orange_500))
                .setTextColor(ContextCompat.getColor(MainActivity.this, R.color.white))
                .build();
        navigation.setNotification(notification, 3);
    }

    public void startShareLoc() {
//        manager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
//        int interval = 1000;
//        sess.setString("serv_loc_on","on");
//        if(sess.getString("serv_loc_on").equalsIgnoreCase("on_sys")) {
//            sess.setString("serv_loc_on","on_sys");
//        }
//        sess.commitSess();
//        manager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
        Toast.makeText(this, "Share Loc Set", Toast.LENGTH_SHORT).show();
    }

    public void startReminder() {
//        managerReminders = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
//        int interval = 1000;
//        managerReminders.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingReminderIntent);
//        sess.setString("serv_reminder_on","on");
//        if(sess.getString("serv_reminder_on").equalsIgnoreCase("on_sys")) {
//            sess.setString("serv_reminder_on","on_sys");
//        }
//        sess.commitSess();
        Toast.makeText(this, "Reminder Set", Toast.LENGTH_SHORT).show();
    }

    public void startNotif() {
//        managerNotifs = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
//        int interval = 1000;
//        notifikasiReceiver.setActHandler(this);
//        registerReceiver(notifikasiReceiver,new IntentFilter("id.co.bri.brispotnew.NOTIFRECEIVER"));
//        managerNotifs.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingNotifIntent);
//        sess.setString("serv_notif_on","on");
//        if(sess.getString("serv__on").equalsIgnoreCase("on_sys")) {
//            sess.setString("serv_notif_on","on_sys");
//        }
//        sess.commitSess();
        Toast.makeText(this, "Notifikasi Set", Toast.LENGTH_SHORT).show();
    }

    public void cancelShareLoc() {
//        if (manager != null) {
//            manager.cancel(pendingIntent);
//            sess.setString("serv_loc_on","off");
//            if(sess.getString("serv_loc_on").equalsIgnoreCase("off_sys")) {
//                sess.setString("serv_loc_on","off_sys");
//            }
//            sess.commitSess();
            Toast.makeText(this, "Share Loc Canceled", Toast.LENGTH_SHORT).show();
//        }
    }

    public void cancelReminder() {
//        if (managerReminders != null) {
//            sess.setString("serv_reminder_on","off");
//            if(sess.getString("serv_reminder_on").equalsIgnoreCase("off_sys")) {
//                sess.setString("serv_reminder_on","off_sys");
//            }
//            sess.commitSess();
//            managerReminders.cancel(pendingReminderIntent);
            Toast.makeText(this, "Reminder Canceled", Toast.LENGTH_SHORT).show();
//        }
    }

    public void cancelNotif() {
//        if (managerNotifs != null) {
//            sess.setString("serv_notif_on","off");
//            if(sess.getString("serv_notif_on").equalsIgnoreCase("off_sys")) {
//                sess.setString("serv_notif_on","off_sys");
//            }
//            sess.commitSess();
//            managerNotifs.cancel(pendingReminderIntent);
//            unregisterReceiver(notifikasiReceiver);
            Toast.makeText(this, "Notifikasi Canceled", Toast.LENGTH_SHORT).show();
//        }
    }

    /*** CHECK SERVICE IS RUNNING ***/
    private boolean isMyServiceRunning(Class<?> serviceClass) {
//        managerReminder = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
//        for (ActivityManager.RunningServiceInfo service : managerReminder.getRunningServices(Integer.MAX_VALUE)) {
//            if (serviceClass.getName().equals(service.service.getClassName())) {
//                return true;
//            }
//        }
        return false;
    }

    private void cancleReminder(Class<?> serviceClass) {
//        if(managerReminder != null) {
////            for (ActivityManager.RunningServiceInfo service : managerReminder.getRunningServices(Integer.MAX_VALUE)) {
////                managerReminder.killBackgroundProcesses(service.service.getClassName());
////
////            }
//            processes = managerReminder.getRunningAppProcesses();
//            for (ActivityManager.RunningAppProcessInfo info : processes) {
//
//                if (info.processName.equalsIgnoreCase("id.co.bri.brispotnew")) {
//                    // kill selected process
////                    android.os.Process.killProcess(info.pid);
////                    android.os.Process.sendSignal(info.pid, android.os.Process.SIGNAL_KILL);
//                    managerReminder.killBackgroundProcesses(info.processName);
//                }
//            }
//
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        if (mDrawerToggle.onOptionsItemSelected(item)) {
//            if(!mDrawerLayout.isDrawerOpen(Gravity.RIGHT))
//                mDrawerLayout.openDrawer(Gravity.RIGHT);
//            else
//                mDrawerLayout.closeDrawer(Gravity.RIGHT);
//            return true;
//        }
        return super.onOptionsItemSelected(item);
    }



}
