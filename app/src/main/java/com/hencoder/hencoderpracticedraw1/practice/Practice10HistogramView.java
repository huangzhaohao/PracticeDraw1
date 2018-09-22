package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    private Paint mPaint;

    public Practice10HistogramView(Context context) {
        this(context,null);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.WHITE);
        canvas.drawLine(100,50,100,400, mPaint);
        canvas.drawLine(100,400,680,400, mPaint);
        mPaint.setTextSize(20);
        canvas.drawText(" Froyo",120,420, mPaint);
        canvas.drawText("  GB  ",200,420, mPaint);
        canvas.drawText(" ICS ",260,420, mPaint);
        canvas.drawText("  JB  ",320,420, mPaint);
        canvas.drawText("KitKat",380,420, mPaint);
        canvas.drawText("   L  ",440,420, mPaint);
        canvas.drawText("   M  ",500,420, mPaint);
        mPaint.setTextSize(34);
        canvas.drawText("直方图",getResources().getDisplayMetrics().widthPixels/2-34,480,mPaint);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(200,370,250,400, mPaint);
        canvas.drawRect(260,370,310,400, mPaint);
        canvas.drawRect(320,300,370,400, mPaint);
        canvas.drawRect(380,270,430,400, mPaint);
        canvas.drawRect(440,200,490,400, mPaint);
        canvas.drawRect(500,320,550,400, mPaint);
    }
}
