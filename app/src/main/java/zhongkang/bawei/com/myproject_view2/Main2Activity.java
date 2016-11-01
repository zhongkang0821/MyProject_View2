package zhongkang.bawei.com.myproject_view2;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iv = (ImageView) findViewById(R.id.iv);
        initEvent();
    }

    private void initEvent() {
        iv.setOnTouchListener(new View.OnTouchListener() {

            private float x;
            private float y;
            private Matrix oldMatrix = new Matrix();  //用来操作图片模型
            private Matrix newMatrix = new Matrix();


            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        x = event.getX();
                        y = event.getY();
                        oldMatrix.set(iv.getImageMatrix());
                        break;
                    case MotionEvent.ACTION_MOVE:

                        //用另一个模型记录按下的位置
                        newMatrix.set(oldMatrix);
                        //移动模型
                        newMatrix.setTranslate(event.getX() - x, event.getY() - y);
                        break;
                    case MotionEvent.ACTION_UP:

                        break;

                }
                iv.setImageMatrix(newMatrix);
                return true;
            }
        });
    }
}
