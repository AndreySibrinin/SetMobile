package com.example.user10.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

class CardView extends View {


    Card card;



    public CardView(Context context, Card card) {
        super(context);
        this.card = card;
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(4);
        p.setColor(Color.rgb(250, 240, 180));
        canvas.drawRoundRect(10,10, canvas.getWidth()-10, canvas.getHeight()-10, 5,5,p);

       switch (card.getColor()){
           case 1: p.setColor(Color.RED);
           case 2: p.setColor(Color.BLUE);
           case 3: p.setColor(Color.YELLOW);
       }


        int r = (card.getFill() == 1) ? 1 : ((card.getFill()==2) ? 2 : 3);

        p.setStyle(Paint.Style.FILL);

        for (int i=0; i<card.getCount(); i++) {

            switch (card.getShape()){
                case 1: canvas.drawCircle(canvas.getWidth()/2, (i+1)*canvas.getHeight()/(card.getCount()+1), 10*r, p);

                case 2: canvas.drawRect(canvas.getWidth()/2-10*r,
                        (i+1)*canvas.getHeight()/(card.getCount()+1)-10*r, canvas.getWidth()/2+10*r,
                        (i+1)*canvas.getHeight()/(card.getCount()+1)+10*r, p);

                case 3: canvas.drawOval(canvas.getWidth()/2-15*r,
                        (i+1)*canvas.getHeight()/(card.getCount()+1)-10*r, canvas.getWidth()/2+15*r,
                        (i+1)*canvas.getHeight()/(card.getCount()+1)+10*r, p);
            }

        }

    }


}