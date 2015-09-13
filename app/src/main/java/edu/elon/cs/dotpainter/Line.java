package edu.elon.cs.dotpainter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * @author J. Hollingsworth and CSC 303 - Fall 2015
 * Modified by Michael Winkler and Rachel McGovern
 * 9/11/15
 */

public class Line {
    private float x0, y0, x1, y1;
    private Paint paint;

    public Line(float x0, float y0, float x1, float y1, int penWidth, int alpha, int red, int green, int blue) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        paint = new Paint();
        paint.setARGB(alpha, red, green, blue);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(penWidth);
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(x0, y0, x1, y1, paint);
    }

}
