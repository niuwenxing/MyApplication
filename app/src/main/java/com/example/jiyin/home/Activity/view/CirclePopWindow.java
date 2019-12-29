package com.example.jiyin.home.Activity.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.example.jiyin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的发布 删除按钮
 */
public class CirclePopWindow extends PopupWindow {

    private Context context;
    private View view;
    private ListView listView;
    private List<String> list;

    public CirclePopWindow(Context context){
        this(context, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }


    public CirclePopWindow(Context context, int  width, int height) {
        this.context = context;
        setWidth(width);
        setHeight(height);
        //设置可以获得焦点
        setFocusable(true);
        //设置弹窗内可点击
        setTouchable(true);
        //设置弹窗外可点击
        setOutsideTouchable(true);
        setBackgroundDrawable(new BitmapDrawable());
        view = LayoutInflater.from(context).inflate(R.layout.popwin_menu,null);
        setContentView(view);
//        setAnimationStyle(R.style.popwin_anim_style);
        initData();
    }

    private void initData() {
        listView = (ListView) view.findViewById(R.id.title_list);
        list = new ArrayList<String>();
        list.add("删除");
        //设置列表的适配器
        listView.setAdapter(new BaseAdapter() {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = null;

                if (convertView == null) {
                    textView = new TextView(context);
                    textView.setTextColor(Color.rgb(255,255,255));
                    textView.setTextSize(14);
                    //设置文本居中
                    textView.setGravity(Gravity.CENTER);
                    //设置文本域的范围
                    textView.setPadding(0, 13, 0, 13);
                    //设置文本在一行内显示（不换行）
                    textView.setSingleLine(true);
                } else {
                    textView = (TextView) convertView;
                }
                //设置文本文字
                textView.setText(list.get(position));
                //设置文字与图标的间隔
                textView.setCompoundDrawablePadding(0);
                //设置在文字的左边放一个图标
//                textView.setCompoundDrawablesWithIntrinsicBounds(R.mipmap., null, null, null);

                return textView;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public Object getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                if (mItemClick != null) {
                    mItemClick.onclick();
                }
            }
        });

    }

    private  ItemClick mItemClick;
    public  interface ItemClick{ void onclick();}
    public  void setOnclick( ItemClick mItemClick){ this.mItemClick = mItemClick; }
}
