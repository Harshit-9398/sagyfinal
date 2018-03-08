import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.abhi.sagyfinal.R;

/**
 * Created by harsh on 3/8/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {
    Context ct;
    LayoutInflater li;
    Integer [] images = {R.drawable.boy,R.drawable.man,R.drawable.man2};

    public ViewPagerAdapter(Context ct) {
        this.ct = ct;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        li = (LayoutInflater)ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.custom_layout, null);
        ImageView imageView = view.findViewById(R.id.imageView2);
        imageView.setImageResource(images[position]);
        ViewPager vp = (ViewPager)container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp = (ViewPager)container;
        View view = (View)object;
        vp.removeView(view);
    }
}
