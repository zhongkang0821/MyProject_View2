package zhongkang.bawei.com.myproject_view2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhongkang on 2016/11/1.
 */
public class KangView extends View {
    private int circleColor;
    private int arcColor ;
    private int textColor ;
    private float textSize ;
    private String text ;
    private int startAngle;
    private int sweepAngle ;

    private int mCircleXY;
    private float mRadius ;
    private Paint mCirclePaint ;
    private RectF mRectF ;
    private Paint mArcPaint ;
    private Paint mTextPaint ;

    public KangView(Context context) {
        super(context);
    }

    public KangView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.circleView);
        if (ta != null) {
            circleColor = ta.getColor(R.styleable.circleView_circleColor, 0xffFF0000);
            arcColor = ta.getColor(R.styleable.circleView_arcColor, 0xff0000FF);
            textColor = ta.getColor(R.styleable.circleView_textColor, 0xff00FFFF);
            textSize = ta.getDimension(R.styleable.circleView_textSize, 50);
            text = ta.getString(R.styleable.circleView_text);
            startAngle = ta.getInt(R.styleable.circleView_startAngle, 0);
            sweepAngle = ta.getInt(R.styleable.circleView_sweepAngle, 190);
            ta.recycle();
        }
    }
    public KangView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        init();
    }
    private void init() {
        int length = Math.min(getMeasuredWidth(), getMeasuredHeight());
        mCircleXY = length / 2;
        mRadius = length * 0.5f / 2;
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setColor(circleColor);
        mRectF = new RectF(length * 0.1f, length * 0.1f, length * 0.9f,
                length * 0.9f);

        mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mArcPaint.setColor(arcColor);
        mArcPaint.setStyle(Paint.Style.STROKE);
        mArcPaint.setStrokeWidth((getWidth() * 0.1f));

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setColor(textColor);
        mTextPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSth(canvas);
    }
    private void drawSth(Canvas canvas){
        canvas.drawCircle(mCircleXY, mCircleXY, mRadius, mCirclePaint);
        canvas.drawArc(mRectF, startAngle, sweepAngle, false, mArcPaint);
        canvas.drawText("凤姐", mCircleXY, mCircleXY + textSize
                / 4, mTextPaint);
    }
}
