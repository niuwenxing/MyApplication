package com.example.rootfilelibs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rootfilelibs.adapter.AbsRecycleAdapter;
import com.example.rootfilelibs.adapter.RecyAdapter;
import com.example.rootfilelibs.entity.FileItem;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> 文件选择器</p>
 *
 */

public class DocumentViewActivity extends AppCompatActivity implements View.OnClickListener {
    private  ProgressDialog mProgressDialog;
    private  List<FileItem> mDocuments = new ArrayList<>();
    private final static int SCAN_OK = 1;
    private final static int SCAN_ERROR = 0;
    private final MyHandler myHandler = new MyHandler(this);
    private RecyclerView recyclerview;
    private RecyAdapter recyAdapter;
    private String filePath="";
    private TextView pathStr;
    private ImageView iv_image_btn;
    private TextView ok_filebtn;
    private int CODE=0x25326;
    private Intent retIntent;

    public static void startsActivitys(@NonNull Activity context, int code){
        context.startActivityForResult(new Intent(context, DocumentViewActivity.class)
                , code);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_view);

        recyAdapter = new RecyAdapter();
        recyAdapter.setChoiceMode(AbsRecycleAdapter.CHOICE_MODE_SINGLE);
        recyclerview = findViewById(R.id.file_list_view);
        pathStr = findViewById(R.id.pathStr);
        iv_image_btn = findViewById(R.id.iv_image_btn);
        ok_filebtn = findViewById(R.id.ok_filebtn);
        iv_image_btn.setOnClickListener(this);
        ok_filebtn.setOnClickListener(this);
        getDocuments();
        retIntent = new Intent();

        recyAdapter.setOnItemClickListener(new AbsRecycleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (!isEmpty(mDocuments)) {
                    filePath = mDocuments.get(position).getFilePath();
                    pathStr.setText(filePath+"");
                    retIntent.putExtra("KeyPathstr",filePath);
                }
            }
        });
    }
    public static boolean isEmpty(List data) {
        return data == null || data.isEmpty();
    }


    private void getDocuments() {
        //显示进度条
        mProgressDialog = ProgressDialog.show(DocumentViewActivity.this, null,
                this.getString(R.string.jmui_loading));

        new Thread(new Runnable() {
            @Override
            public void run() {
                ContentResolver contentResolver = getContentResolver();
                String[] projection = new String[] {MediaStore.Files.FileColumns.DATA,
                        MediaStore.Files.FileColumns.TITLE, MediaStore.Files.FileColumns.SIZE,
                        MediaStore.Files.FileColumns.DATE_MODIFIED};

                //分别对应 txt doc pdf ppt xls wps docx pptx xlsx 类型的文档
                String selection = MediaStore.Files.FileColumns.MIME_TYPE + "= ? "
                        + " or " + MediaStore.Files.FileColumns.MIME_TYPE + " = ? "
                        + " or " + MediaStore.Files.FileColumns.MIME_TYPE + " = ? "
                        + " or " + MediaStore.Files.FileColumns.MIME_TYPE + " = ? "
                        + " or " + MediaStore.Files.FileColumns.MIME_TYPE + " = ? "
                        + " or " + MediaStore.Files.FileColumns.MIME_TYPE + " = ? "
                        + " or " + MediaStore.Files.FileColumns.MIME_TYPE + " = ? "
                        + " or " + MediaStore.Files.FileColumns.MIME_TYPE + " = ? "
                        + " or " + MediaStore.Files.FileColumns.MIME_TYPE + " = ? ";

                String[] selectionArgs = new String[] {"application/msword",
                        "application/vnd.ms-powerpoint",
                        "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                        "application/vnd.openxmlformats-officedocument.presentationml.presentation"};
//                String[] selectionArgs = new String[] {"text/plain", "application/msword", "application/pdf",
//                        "application/vnd.ms-powerpoint", "application/vnd.ms-excel", "application/vnd.ms-works",
//                        "application/vnd.openxmlformats-officedocument.presentationml.presentation",
//                        "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"};

                Cursor cursor = contentResolver.query(MediaStore.Files.getContentUri("external"), projection,
                        selection, selectionArgs, MediaStore.Files.FileColumns.DATE_MODIFIED + " desc");

                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        String filePath = cursor.getString(cursor.getColumnIndex(MediaStore.Files.FileColumns.DATA));
                        String size = cursor.getString(cursor.getColumnIndex(MediaStore.Files.FileColumns.SIZE));
                        String date = cursor.getString(cursor.getColumnIndex(MediaStore.Files.FileColumns.DATE_MODIFIED));
                        if (scannerFile(filePath)) {
                            FileItem fileItem = new FileItem(filePath, null, size, date,0);
                            mDocuments.add(fileItem);
                        }
                    }
                    cursor.close();
                    cursor = null;
                    myHandler.sendEmptyMessage(SCAN_OK);
                } else {
                    myHandler.sendEmptyMessage(SCAN_ERROR);
                }
            }
        }).start();
    }

    private File file;
    private boolean scannerFile(String path) {
        file = new File(path);
        if (file.exists() && file.length() > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_image_btn) {
            finish();
        }
        if (v.getId() == R.id.ok_filebtn){
            if (isStringEmpty(filePath)) {
                setResult(CODE,retIntent);
                finish();
            }else{
                setResult(CODE,retIntent);
                finish();
            }
        }
    }

    public static boolean isStringEmpty(String str) {
        if (TextUtils.isEmpty(str) || "null".equals(str) || "".equals(str)) {
            return true;
        } else {
            return false;
        }
    }


    private static class MyHandler extends Handler {
        private final DocumentViewActivity contextWeakReference;
        public MyHandler(DocumentViewActivity  context) {
            contextWeakReference = context;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case SCAN_OK:
                    contextWeakReference.mProgressDialog.dismiss();
                    contextWeakReference.recyAdapter.setData(contextWeakReference.mDocuments);
                    contextWeakReference.recyclerview.setAdapter(contextWeakReference.recyAdapter);
                    break;
                case SCAN_ERROR:
                    if (contextWeakReference.mProgressDialog.isShowing()) {
                        contextWeakReference.mProgressDialog.dismiss();
                    }
                    break;

            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != mProgressDialog) {
            mProgressDialog.dismiss();
        }
    }

}
