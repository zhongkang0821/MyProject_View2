package zhongkang.bawei.com.myproject_view2;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhongkang on 2016/11/1.
 */
public class KangView2 extends View {

    private Paint mPaint;
    private int mCount;
    private int mWidth;
    private int mRectHeight;
    private int mRectWidth;
    private LinearGradient mLinearGradinent;
    private double mRandom;
    private float mcurrentHeight;

    public static final int OFFSET=5;


    public KangView2(Context context) {
        super(context);
    }

    public KangView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        //去掉锯齿
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        //设置颜色
        mPaint.setColor(Color.GREEN);
        //设置填满
        mPaint.setStyle(Paint.Style.FILL);
        //用typedArray放资源文件
        TypedArray ta=context.obtainStyledAttributes(attrs,R.styleable.volumneView);
        if(ta!=null){
            mCount=ta.getInt(R.styleable.volumneView_count,8);
            ta.recycle();
        }
    }

    public KangView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //宽度设置为屏幕宽度
        mWidth=getMeasuredWidth();
        //高度为屏幕高度
        mRectHeight=getMeasuredHeight();

        mRectWidth= (int) (mWidth*0.8/mCount);

        mLinearGradinent=new LinearGradient(0,0,mRectWidth,mRectHeight,Color.GREEN,Color.YELLOW
        , Shader.TileMode.CLAMP);
        mPaint.setShader(mLinearGradinent);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<mCount;i++){
            mRandom=Math.random();
            mcurrentHeight= (float) (mRectHeight * mRandom);
            float width= (float) (mWidth * 0.4 / 2 +OFFSET);
            canvas.drawRect(width+i*mRectWidth,mcurrentHeight,width+(i+1)*mRectWidth,mRectHeight,mPaint);
        }
        postInvalidateDelayed(300);
    }
}
