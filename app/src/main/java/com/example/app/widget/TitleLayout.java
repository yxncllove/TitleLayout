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
import android.widget.TextView;

import com.example.app.R;

/**
 * Created by NCL on 2017/6/25
 * titleLayout
 */

public class TitleLayout extends LinearLayoutCompat
{
  private int textColor;
  private int textSize;
  private int themeResId;
  private Drawable backIcon;
  private String mTitle;
  private Toolbar mToolbar;
  private Context mContext;
  private TextView mTextView;

  public TitleLayout(Context context)
  {
    super(context);
  }

  public TitleLayout(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    this.mContext = context;
    init(context);
    initTypedArray(context, attrs);
    initLayout();
    initToolbar();
  }

  private void initTypedArray(Context context, AttributeSet attrs)
  {
    TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TitleLayout);
    int mDefaultSize = this.sp2px(context, 14.0F);
    int mDefaultColor = Color.BLACK;
    mTitle = ta.getString(R.styleable.TitleLayout_tTitleLayoutTitle);
    textColor = ta.getColor(R.styleable.TitleLayout_tTitleLayoutTextColor, mDefaultColor);
    textSize = ta.getDimensionPixelSize(R.styleable.TitleLayout_tTitleLayoutTextSize, mDefaultSize);
    backIcon = ta.getDrawable(R.styleable.TitleLayout_tTitleLayoutBackIcon);
    themeResId = ta.getResourceId(R.styleable.TitleLayout_tTitleLayoutTheme, 0);
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
  }

  private void initLayout()
  {
    if (this.mTitle != null)
    {
      this.initTitle();
    }
  }

  private void initTitle()
  {
    mTextView = new TextView(mContext);
    mTextView.setText(mTitle);
    mTextView.setTextColor(textColor);
    mTextView.setTextSize(0,textSize);
    mTextView.setGravity(Gravity.CENTER);

    Toolbar.LayoutParams params = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT,
        Toolbar.LayoutParams.MATCH_PARENT);
    params.gravity = Gravity.CENTER;
    mTextView.setLayoutParams(params);
    mToolbar.addView(mTextView, 0);
  }

  private void initToolbar()
  {
    mToolbar.setNavigationIcon(backIcon);
    mToolbar.setPopupTheme(themeResId);
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

  public TitleLayout setTtileText(String title)
  {
    this.mTitle = title;
    if (mTextView == null)
      initTitle();
    else
      mTextView.setText(title);
    return this;
  }


  public TitleLayout setTitleTextColor(int textColorResId)
  {
    this.textColor = textColorResId;
    if (mTextView == null)
      initTitle();
    else
      mTextView.setTextColor(textColorResId);

    return this;
  }

  public TitleLayout setTitleTextSize(float textSize)
  {
    this.textSize = this.sp2px(mContext, textSize);
    if (mTextView == null)
      initTitle();
    else
      mTextView.setTextSize(0,textSize);
    return this;
  }


  private int sp2px(Context context, float spValue)
  {
    float scale = context.getResources().getDisplayMetrics().scaledDensity;
    return (int) (spValue * scale + 0.5F);
  }
}
