package com.anymarvel.myapplication.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class LadderLayout extends RelativeLayout {
    Paint paint;
    Path path;

    public LadderLayout(Context context) {
        super(context);
    }

    public LadderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public LadderLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private PorterDuffXfermode porterDuffXfermodeIn;
    private PorterDuffXfermode porterDuffXfermodeOut;

    public void initViews() {
        porterDuffXfermodeIn = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        porterDuffXfermodeOut = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        setWillNotDraw(false);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);//设置STROKE才能设置成圆角

        path = new Path();

        path.moveTo(100, 100);
        path.lineTo(300, 0);
        path.lineTo(300, 300);
        path.lineTo(0, 300);
        path.close();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = 400;
        int measuredHeight = 400;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            // 为每一个子控件测量大小
            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            if (childView instanceof ImageView) {

                ViewGroup.LayoutParams layoutParams = childView.getLayoutParams();
                layoutParams.width = measuredWidth;
                layoutParams.height = measuredHeight;
            }

        }
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    public void draw(Canvas canvas) {
        int saved = canvas.saveLayer(null, null, Canvas.ALL_SAVE_FLAG);
        super.draw(canvas);

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.O_MR1) {
            paint.setXfermode(porterDuffXfermodeIn);
        } else {
            paint.setXfermode(porterDuffXfermodeOut);
            if (!path.isInverseFillType()) {
                path.toggleInverseFillType();
            }
        }
        canvas.drawPath(path, paint);
        canvas.restoreToCount(saved);
    }
}
