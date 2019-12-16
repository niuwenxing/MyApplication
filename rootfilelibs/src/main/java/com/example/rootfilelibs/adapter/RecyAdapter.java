package com.example.rootfilelibs.adapter;

import android.widget.CheckBox;

import com.example.rootfilelibs.R;
import com.example.rootfilelibs.entity.FileItem;

public class RecyAdapter extends AbsRecycleAdapter<FileItem> {
    @Override
    public int getLayoutId(int viewType) {
        return R.layout.item_document;
    }
    @Override
    public void convert(VH holder, FileItem data, int position) {

        String filePath = data.getFilePath();
        holder.setText(R.id.document_title,filePath.substring(filePath.lastIndexOf('/') + 1));
        holder.setText(R.id.document_size,data.getFileSize());
        holder.setText(R.id.document_date,data.getDate());
        CheckBox view = holder.getView(R.id.document_cb);
        view.setClickable(false);
        view.setChecked(data.isChecked());

    }
}
