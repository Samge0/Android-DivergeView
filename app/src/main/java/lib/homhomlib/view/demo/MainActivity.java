package lib.homhomlib.view.demo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import lib.homhomlib.view.DivergeView;

public class MainActivity extends AppCompatActivity {
    private DivergeView mDivergeView;
    private Button mBtnStart;
    private ArrayList<Bitmap> mList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnStart = (Button)findViewById(R.id.btnStart);
        mList = new ArrayList<>();
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm1, null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(),R.drawable.ic_praise_sm2,null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(),R.drawable.ic_praise_sm3,null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(),R.drawable.ic_praise_sm4,null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(),R.drawable.ic_praise_sm5,null)).getBitmap());
        mList.add(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.ic_praise_sm6, null)).getBitmap());
        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDivergeView.setDiverges(new Object[]{0,1,2,3,4,5,0,1,2,3,4});
                mDivergeView.start();
//                if (mDivergeView.isRunning()) {
//                    mDivergeView.stop();
//                } else {
//
//                }
            }
        });
        mDivergeView = (DivergeView) findViewById(R.id.divergeView);
        mDivergeView.setDivergeViewProvider(new Provider());
//        mDivergeView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mList != null){
            for(Bitmap bitmap : mList){
                if(!bitmap.isRecycled()){
                    bitmap.recycle();
                }
            }
            mList.clear();
            mList = null;
        }

    }

    class Provider implements DivergeView.DivergeViewProvider{

        @Override
        public Bitmap getBitmap(Object obj) {
            return mList.get((int)obj);
        }
    }
}
