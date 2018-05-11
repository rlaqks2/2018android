package com.example.rlaqk.lab4_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;

public class TouchEventView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    Context context;

    GestureDetector gestureDetector;

    public TouchEventView(Context c, AttributeSet a) {
        super(c, a);
        gestureDetector = new GestureDetector(context, new GestureListener());

        paint.setAntiAlias(true);
        paint.setStrokeWidth(6f);//글씨 크기
        paint.setColor(Color.BLUE);//색상

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    public void setColor(int r, int g, int b) {
        int rgb = Color.rgb(r, g, b);
        paint.setColor(rgb);
    }

    private class GestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            float x = e.getX();
            float y = e.getY();

            // 도면 영역을 깨끗히 한다.
            path.reset();
            Log.d("Double Tap", "Tapped at: (" + x + "," + y + ")");

            return true;
        }

    }
    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float X = event.getX();
        float Y = event.getY();

        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(X, Y);
                return true;
            case MotionEvent.ACTION_MOVE:

                path.lineTo(X, Y);
                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                return false;
        }

       //gestureDetector 저장
        gestureDetector.onTouchEvent(event);
        //다시 그리기
        invalidate();
        return true;
    }
}