package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    private Paint mPaint;
    private float clickLeft = 100;
    private float radius = 200;
    private float clickTop = 20;
    private float blankAngle = 2;
    private float startAngle = -180;
    public Practice11PieChartView(Context context) {
        this(context,null);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(2);
        mPaint.setTextSize(20);
        //注：不要在onDraw方法中实例化对象
        float sweepAngle = 120;
        drawArc(canvas,true,true,"Lollipop",startAngle,sweepAngle);

        mPaint.setColor(Color.TRANSPARENT);
        drawArc(canvas,false,false,null,startAngle,blankAngle);

        mPaint.setColor(Color.parseColor("#FFC107"));
        drawArc(canvas,false,true,"Marshmallow",startAngle,55);

        mPaint.setColor(Color.TRANSPARENT);
        drawArc(canvas,false,true,"Froyo",startAngle,blankAngle);

        mPaint.setColor(Color.parseColor("#9C27B0"));
        drawArc(canvas,false,true,"Gingerbread",startAngle,10);
        mPaint.setColor(Color.TRANSPARENT);
        drawArc(canvas,false,false,null,startAngle,blankAngle);

        mPaint.setColor(Color.parseColor("#9E9E9E"));
        drawArc(canvas,false,true,"Ice Cream Sandwich",startAngle,10);
        mPaint.setColor(Color.TRANSPARENT);
        drawArc(canvas,false,false,null,startAngle,blankAngle);

        mPaint.setColor(Color.parseColor("#009688"));
        drawArc(canvas,false,true,"Jelly Bean",startAngle,40);
        mPaint.setColor(Color.TRANSPARENT);
        drawArc(canvas,false,false,null,startAngle,blankAngle);

        mPaint.setColor(Color.parseColor("#2196F3"));
        drawArc(canvas,false,true,"KitKat",startAngle,360-6*blankAngle-120-55-60);
        mPaint.setColor(Color.TRANSPARENT);
        drawArc(canvas,false,false,null,startAngle,blankAngle);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(30);
        canvas.drawText("饼图",clickLeft + 13 + radius - 30,getHeight()-20,mPaint);

    }
    private void drawArc(Canvas canvas,boolean isClickArc,boolean drawText,String text,float startAngle,float sweepAngle){
        float rectLeft,rectTop;
        if (isClickArc){    //如果是突出的那块扇形
            rectLeft = clickLeft;
            rectTop = clickTop;
        }else{
            rectLeft = clickLeft + 13;
            rectTop = clickTop + 15;
        }
        canvas.drawArc(new RectF(rectLeft,rectTop,rectLeft+2*radius,rectTop+2*radius),startAngle,sweepAngle,true,mPaint);
        float endAngle = startAngle + sweepAngle;
        float midAngle = (startAngle+endAngle)/2;
        if (midAngle > 180){
            midAngle-= 360;
        }
        if (drawText){  //如果要绘制文字
            mPaint.setColor(Color.WHITE);
            float startX = 0,startY = 0;
            if (midAngle>0&&midAngle<=90){
                startX = (float) (rectLeft+radius + radius*Math.cos(midAngle*Math.PI/180));
                startY = (float) (rectTop+radius + radius*Math.sin(midAngle*Math.PI/180));
                canvas.drawLine(startX,startY,startX+10,startY+10,mPaint);
                canvas.drawLine(startX+10,startY+10,startX+80,startY+10,mPaint);
                canvas.drawText(text,startX+80 +2,startY+10,mPaint);
            }else if (midAngle > 90 && midAngle<=180){
                startX = (float) (rectLeft+radius - radius*Math.cos((180-midAngle)*Math.PI/180));
                startY = (float) (rectTop+radius + radius*Math.sin((180-midAngle)*Math.PI/180));
                canvas.drawLine(startX,startY,startX-10,startY+10,mPaint);
                canvas.drawLine(startX-10,startY+10,startX-80,startY+10,mPaint);
                canvas.drawText(text,startX-80 - 20*text.length()/2,startY+10,mPaint);
            }else if (midAngle >=-180&&midAngle<=-90){
                startX = (float) (rectLeft+radius - radius*Math.cos((180+midAngle)*Math.PI/180));
                startY = (float) (rectTop+radius - radius*Math.sin((180+midAngle)*Math.PI/180));
                canvas.drawLine(startX,startY,startX-10,startY-10,mPaint);
                canvas.drawLine(startX-10,startY-10,startX-80,startY-10,mPaint);
                canvas.drawText(text,startX-80 - 20*text.length()/2,startY-10,mPaint);
            }else if (midAngle<=0&&midAngle>-90){
                startX = (float) (rectLeft+radius + radius*Math.cos((-midAngle)*Math.PI/180));
                startY = (float) (rectTop+radius - radius*Math.sin((-midAngle)*Math.PI/180));
                canvas.drawLine(startX,startY,startX+10,startY-10,mPaint);
                canvas.drawLine(startX+10,startY-10,startX+80,startY-10,mPaint);
                canvas.drawText(text,startX+80 +2,startY-10,mPaint);
            }
        }
        if (endAngle > 180){
            endAngle-= 360;
        }
        this.startAngle = endAngle;
    }
}
