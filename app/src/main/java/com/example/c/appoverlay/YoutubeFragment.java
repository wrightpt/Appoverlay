package com.example.c.appoverlay;

/**
 * Created by c on 4/4/16.
 */

import android.annotation.*;
import android.content.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;

import com.google.android.youtube.player.*;
import com.google.android.youtube.player.YouTubePlayer.*;


public class YoutubeFragment extends YouTubePlayerFragment{ //} implements View.OnClickListener {
    // API キー
    private static final String API_KEY = "AIzaSyC1rMU-mkhoyTvBIdTnYU0dss0tU9vtK48";

    // YouTubeのビデオID
    private static String VIDEO_ID = "WhnDvvNS8zQ";

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = super.onCreateView(inflater, container, savedInstanceState);
      // View view = inflater.inflate(R.layout.my_view, container, false);

       FrameLayout wrapper = new FrameLayout(getContext()) {
           @Override
         public boolean onInterceptTouchEvent(MotionEvent ev) {
              return true;
          }
        };



       // FrameLayout wrapper1 = getFragmentManager().findFragmentById(R.id.youTubePlayerFragment);
                //.findViewById(R.id.youTubePlayerFragment1);
       // wrapper1.addView(view);

        // YouTubeフラグメントインスタンスを取得
        Log.d("initialize1", "initialize1");
       // YouTubePlayerFragment youTubePlayerFragment = YouTubePlayerFragment.newInstance();
        YouTubePlayerFragment youTubePlayerFragment = YoutubeFragment.newInstance();
       // YoutubeFragment youtubeFragment = (YoutubeFragment) YoutubeFragment.instantiate(getContext(),);


        // レイアウトにYouTubeフラグメントを追加
        android.app.FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
       //transaction.add(youTubePlayerFragment,"hey").commit();
        // transaction.add(R.id.youtube_layout1, youTubePlayerFragment).commit();
        //transaction.add(R.id.youTubePlayerFragment,youTubePlayerFragment,"fragment1").commit();
       transaction.add(youTubePlayerFragment,"fragment2").commit();
      //  transaction.add(youtubeFragment,"fragment3").commit();

        // YouTubeフラグメントのプレーヤーを初期化する
        Log.d("initialize", "initialize");
     //   youtubeFragment.initialize(API_KEY,new OnInitializedListener() {
        youTubePlayerFragment.initialize(API_KEY, new OnInitializedListener() {

            // YouTubeプレーヤーの初期化成功
            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    Log.d("initsuccess","initsuccess");
                    //player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(VIDEO_ID);
                    player.play();
                    Log.d("initsuccess3","initsuccess3");
                }
            }

            // YouTubeプレーヤーの初期化失敗
            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult error) {
                // YouTube error
                Log.d("initfailure", String.valueOf(error));
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                Log.d("errorMessage:", errorMessage);
            }
        });

        //return wrapper1;

        //return rootView;
        return view;
    }

   // @Override
   // public void onClick(View v) {

    //}
}