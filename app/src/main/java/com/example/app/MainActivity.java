package com.example.app;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.app.widget.TitleLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Toolbar.OnMenuItemClickListener
{
  TitleLayout mLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mLayout = (TitleLayout) findViewById(R.id.title_layout);
    mLayout.inflateMenu(R.menu.title_menu);
    mLayout.setOnItemMenuListener(this);
    mLayout.setOverflowIcon(R.drawable.ic_zoom_out_map_black_24dp);
    mLayout.setNavigationOnClickListener(this);
    mLayout.setTitleTextColor(Color.BLACK);
  }

  @Override
  public void onClick(View v)
  {
    Toast.makeText(this, "返回", Toast.LENGTH_SHORT).show();
  }

  @Override
  public boolean onMenuItemClick(MenuItem item)
  {
    switch (item.getItemId())
    {
      case R.id.title_add:
        Toast.makeText(this, "添加", Toast.LENGTH_SHORT).show();
        break;
      case R.id.title_remove:
        Toast.makeText(this, "移除", Toast.LENGTH_SHORT).show();
        break;
    }
    return false;
  }

}
