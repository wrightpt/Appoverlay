package com.example.c.appoverlay;

import android.annotation.*;
import android.content.*;
import android.graphics.*;
import android.net.*;
import android.os.*;
import android.provider.*;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;

import com.google.android.youtube.player.*;

import java.security.*;

public class MainActivity extends YouTubeBaseActivity {

    public static final String KEY
            = "AIzaSyBtR6Rc_m_9AUXHa9UY9UURbPAuUxlVfZc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addOverlay();




            }
        });



        FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //assert playerView != null;





              //  WindowManager wm = (WindowManager) getApplicationContext().getSystemService(WINDOW_SERVICE);


              //  mButton.setOnTouchListener();

              //  Button mButton = findViewById(R.id.);
               // mButton.setText("Overlay button");

                 WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                      WindowManager.LayoutParams.TYPE_PHONE,
                       WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                         WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,

                         WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,PixelFormat.UNKNOWN);

                         //| WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL |
                         //       WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,

                //| WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,

                        // | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        // | WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
                        //PixelFormat.TRANSLUCENT);
                      //   PixelFormat.TRANSPARENT);

              //  params.gravity = Gravity.TOP | Gravity.LEFT;
              //  params.x = 0;
              //  params.y = 100;

               // params.gravity = Gravity.RIGHT | Gravity.TOP;
              //  params.setTitle("Load Average");
                WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);


               // final WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);

                final View myView = inflater.inflate(R.layout.my_view, null);

                wm.addView(myView, params);
                init();

              //  wm.addView(mButton, params);


            }
        });
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == OVERLAY_PERMISSION_CODE) {
            if (!Settings.canDrawOverlays(this)) {
                // SYSTEM_ALERT_WINDOW permission not granted...
            }
        }
    }

    public static int OVERLAY_PERMISSION_CODE = 2525;
    public static int OVERLAY_PERMISSION_REQ_CODE = 2526;

    @TargetApi(Build.VERSION_CODES.M)
    public void addOverlay() {
        if (!Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void init(){

      // YoutubeFragment fragment1 = new YoutubeFragment();
      YouTubePlayerFragment fragment = new YoutubeFragment();
      //  YoutubeFragment ytfragment = (YoutubeFragment) YoutubeFragment.newInstance();
        android.app.FragmentManager manager = getFragmentManager();
        manager.beginTransaction()
               .add(fragment,"hey1")
              //  .add(R.id.youTubePlayerFragment1,fragment)
               // .replace(R.id.youTubePlayerFragment1,fragment1)
              //  .replace(R.id.youTubePlayerFragment,ytfragment)
             //   .replace(R.id.youTubePlayerFragment, fragment)

                .addToBackStack(null)
                .commit();

     //   YouTubePlayerFragment youTubePlayerFragment = new YouTubePlayerFragment();
        //youTubePlayerFragment.initialize("YOUR_YOUTUBE_API_KEY", (YouTubePlayer.OnInitializedListener) this);
        //YouTubePlayerView playerView = (YouTubePlayerView)findViewById(R.id.player_view);

     // youTubePlayerFragment.initialize(KEY, new YouTubePlayer.OnInitializedListener() {
       //     @Override
        //    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
          //      if(!b){
               //     youTubePlayer.cueVideo("83yInyY1KLs");

              //  }}

           // @Override
          //  public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

          //  }
      //  });
}
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
