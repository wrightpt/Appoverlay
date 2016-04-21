package com.example.c.appoverlay;

import android.content.*;
import android.graphics.*;
import android.util.*;
import android.view.*;
import android.widget.*;

/**
 * Created by c on 4/19/16.
 */
public class MyRelativeLayout extends FrameLayout{


    public MyRelativeLayout(Context context) {
        this(context, null, 0);

        //super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

       // super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    final WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_PHONE,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT);

float mLastX;
    float mLastY;
    float mStartY;
    boolean mIsBeingDragged;
    int mTouchSlop;


    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastX = event.getX();
                mLastY = event.getY();
                mStartY = mLastY;
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                mIsBeingDragged = false;
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();
                float xDelta = Math.abs(x - mLastX);
                float yDelta = Math.abs(y - mLastY);

                float yDeltaTotal = y - mStartY;
                if (yDelta > xDelta && Math.abs(yDeltaTotal) > mTouchSlop) {
                    mIsBeingDragged = true;
                    mStartY = y;
                    return true;
                }
                break;
        }

        return false;
    }
    private WindowManager.LayoutParams paramsF = params;
    private int initialX;
    private int initialY;
    private float initialTouchX;
    private float initialTouchY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_DOWN:
                initialX = paramsF.x;
                initialY = paramsF.y;
                initialTouchX = event.getRawX();
                initialTouchY = event.getRawY();
            case MotionEvent.ACTION_UP:
                mIsBeingDragged = false;
                break;
            case MotionEvent.ACTION_MOVE:
                float x = event.getX();
                float y = event.getY();

                float xDelta = Math.abs(x - mLastX);
                float yDelta = Math.abs(y - mLastY);

                float yDeltaTotal = y - mStartY;

              //  paramsF.x = initialX + (int) (event.getRawX() - initialTouchX);
             //   paramsF.y = initialY + (int) (event.getRawY() - initialTouchY);
             //   windowManager.updateViewLayout(chatHead, paramsF);


                //  paramsF.y = initialY + (int) (event.getRawY()
                // if (!mIsBeingDragged && yDelta > xDelta && Math.abs(yDeltaTotal) > mTouchSlop) {
                //     mIsBeingDragged = true;
                //     mStartY = y;
                //      yDeltaTotal = 0;
                //  }
                //   if (yDeltaTotal < 0)
                //       yDeltaTotal = 0;

                //    if (mIsBeingDragged) {
                //        scrollTo(0, (int) yDeltaTotal);
                //  }

                //    mLastX = x;
                //     mLastY = y;
                //       break;
                // }
        }
                return true;
        }
    }
