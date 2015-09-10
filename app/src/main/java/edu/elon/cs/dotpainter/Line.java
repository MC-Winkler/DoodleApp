package edu.elon.cs.dotpainter;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by mwinkler3 on 9/10/2015.
 */
public class Line {
    private float x0, y0, x1, y1;
    private float penWidth;
    private Paint paint;

    public Line(float x0, float y0, float x1, float y1, int penWidth, int ) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;

        this.penWidth = (float) penWidth;

        // random color
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        int alpha = (int) (Math.random() * 256);
        paint = new Paint();
        paint.setARGB(alpha, red, green, blue);
        paint.setStrokeWidth(penWidth);
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(x0, y0, x1, y1, paint);
    }

}
