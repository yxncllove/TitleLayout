package com.example.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.app.R;

/**
 * Created by NCL on 2017/6/25
 * titleLayout
 */

public class TitleLayout extends LinearLayoutCompat
{
  private Toolbar mToolbar;
//  private TextView mTextView;

  public TitleLayout(Context context)
  {
    super(context);
  }

  public TitleLayout(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    init(context);

    int defaultSize = this.sp2px(context, 14.0F);
    int defaultColor = Color.BLACK;

    TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleLayout);
    String title = ta.getString(R.styleable.TitleLayout_tTitleLayoutTitle);
    int textColor = ta.getColor(R.styleable.TitleLayout_tTitleLayoutTextColor, defaultColor);
    float textSize = ta.getDimensionPixelSize(R.styleable.TitleLayout_tTitleLayoutTextSize, defaultSize);
    Drawable backIcon = ta.getDrawable(R.styleable.TitleLayout_tTitleLayoutBackIcon);
    int themeResId = ta.getResourceId(R.styleable.TitleLayout_tTitleLayoutTheme, 0);

//    mTextView.setText(title);
//    mTextView.setTextColor(textColor);
//    mTextView.setTextSize(0, textSize);
    mToolbar.setNavigationIcon(backIcon);
    mToolbar.setPopupTheme(themeResId);

    ta.recycle();
  }

  public TitleLayout(Context context, AttributeSet attrs, int defStyleAttr)
  {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  private void init(Context context)
  {
    View view = LayoutInflater.from(context).inflate(R.layout.title_layout, this);
    mToolbar = (Toolbar) view.findViewById(R.id.title_toolbar);
//    mTextView = (TextView) view.findViewById(R.id.title_text_view);
  }


  public void inflateMenu(int resId)
  {
    mToolbar.inflateMenu(resId);
  }

  public void setOnItemMenuListener(Toolbar.OnMenuItemClickListener listener)
  {
    mToolbar.setOnMenuItemClickListener(listener);
  }

  public void setNavigationOnClickListener(OnClickListener listener)
  {
    mToolbar.setNavigationOnClickListener(listener);
  }

  public void setOverflowIcon(int resId)
  {
    mToolbar.setOverflowIcon(getResources().getDrawable(resId));
  }

  public void addView(View child)
  {
    View centerView = mToolbar.getChildAt(0);

    Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT,
        Toolbar.LayoutParams.MATCH_PARENT);
    params.gravity = Gravity.CENTER;
    child.setLayoutParams(params);
    mToolbar.addView(child, 0);
  }

  private int sp2px(Context context, float spValue)
  {
    float scale = context.getResources().getDisplayMetrics().scaledDensity;
    return (int) (spValue * scale + 0.5F);
  }
}
