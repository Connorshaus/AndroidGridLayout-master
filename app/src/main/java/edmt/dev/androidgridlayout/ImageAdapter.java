package edmt.dev.androidgridlayout;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ImageAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mImageIds = new int[]  {R.drawable.imga, R.drawable.imgb, R.drawable.imgc, R.drawable.imgd, R.drawable.imagee};

    ImageAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount(){
        return mImageIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageview = new ImageView(mContext);
        imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageview.setImageResource(mImageIds[position]);
        container.addView(imageview, 0);
        return imageview;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}
