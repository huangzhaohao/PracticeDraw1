package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        RectF rectF = new RectF(widthPixels / 4, widthPixels / 4 + 60, widthPixels * 3 / 4 - 60, widthPixels / 2);
        canvas.drawArc(rectF,-180,70,false,paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF,-20,-80,true,paint);
        canvas.drawArc(rectF,20,140,false,paint);
    }
}
