package com.example.jiyin.home.Activity.sonview.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.common.widget.MLImageView;
import com.example.jiyin.home.Activity.homeview.base.CircleListBean;
import com.example.jiyin.home.Activity.homeview.base.CodeBase;
import com.example.jiyin.home.Activity.homeview.base.ImageArr;
import com.example.jiyin.home.Activity.sonview.base.MineAplyDosBean;
import com.example.jiyin.home.Activity.sonview.base.UserInfoBean;
import com.example.jiyin.home.Activity.sonview.base.UserReplyBean;
import com.example.jiyin.home.presenter.Impl.MypageImpl;
import com.example.jiyin.home.presenter.view.MypageView;
import com.example.jiyin.utils.GlideImageLoader;
import com.example.rootlib.utils.CollectionUtil;
import com.google.gson.Gson;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * 个人中心
 * 头像修改
 */

public class MyPhotoActivity extends JiYingActivity<MypageView, MypageImpl> implements MypageView {

    @BindView(R.id.goback)
    ImageView goback;
    @BindView(R.id.textView23)
    TextView textView23;
    @BindView(R.id.select_picture)
    ImageView selectPicture;
    @BindView(R.id.photo)
    MLImageView photo;
    @BindView(R.id.okimages)
    Button okimages;

    private List<String> paths = new ArrayList<>();
    private boolean isupdow=false;

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_my_photo;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new MypageImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlideImageLoader.loadLogh(activity,getIntent().getStringExtra("img"),photo);

        showDialog();

    }

    @Override
    public void retUserInfo(UserInfoBean bean) {
    }//废弃

    @Override
    public void err(String str) {
    }//废弃

    @Override
    public void retUserAvatarEdit(UserReplyBean bean) {
        if (bean.getCode()==-1) {
            toast(bean.getMsg());
        }
        toast(bean.getMsg());
        finish();
    }

    @Override
    public void retNameSetName(UserReplyBean bean) { } //废弃

    @Override
    public void Code(CodeBase bean) { } //废弃

    @Override
    public void retUserTelEdit(UserReplyBean bean) { }//废弃

    @Override
    public void retUserPassEdit(UserReplyBean bean) { }//废弃

    @Override
    public void retMineApplyDos(MineAplyDosBean bean) {//废弃

    }

    @Override
    public void retMinemyUp(CircleListBean bean) { }//废弃

    @OnClick({R.id.goback, R.id.select_picture,R.id.okimages})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.goback:
                finish();
                break;
            case R.id.select_picture:
                if (dialog != null) {
                    dialog.show();
                }
                break;
            case R.id.okimages:
                if (CollectionUtil.isEmpty(paths)) {
                    showProgress();
                    presenter.Upimages(selectList).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) { }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if(response.isSuccessful()) {
                                ImageArr imageArr = new Gson().fromJson(response.body().string(), ImageArr.class);
                                setImageUrl(imageArr);
                            }
                        }
                    });
                }
                break;
        }
    }

    private void setImageUrl(ImageArr imageArr) {
        if (imageArr.getCode()==-1) {
            toast(imageArr.getMsg());
            finish();
        }
        presenter.getUserAvatarEdit(imageArr.getData().get(0));

    }

    private Dialog dialog;
    private void showDialog(){
        if(dialog==null){
            dialog = new Dialog(this,R.style.ActionSheetDialogStyle);
            View view = LayoutInflater.from(this).inflate(R.layout.dialog_selectpicture,null);
            view.findViewById(R.id.select).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    select();
                }
            });
            view.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            dialog.setContentView(view);
            //获取当前Activity所在的窗体
            Window dialogwindow = dialog.getWindow();
            if (dialogwindow == null) {
                return;
            }
            dialogwindow.setGravity(Gravity.BOTTOM);
            WindowManager.LayoutParams lp = dialogwindow.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialogwindow.setAttributes(lp);
            dialog.setCanceledOnTouchOutside(true);

        }
    }

    private List<LocalMedia> selectList = new ArrayList<>();
    //选择相册 裁剪 图片
    private void select(){
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .theme(R.style.picture_default_style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(9)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .enablePreviewAudio(true) // 是否可播放音频 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(false)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .enableCrop(true)// 是否裁剪 true or false
                .compress(true)// 是否压缩 true or false
                .glideOverride(160, 160)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .withAspectRatio(4, 3)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示 true or false
                .isGif(true)// 是否显示gif图片 true or false
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(false)// 是否圆形裁剪 true or false
                .showCropFrame(true)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .selectionMedia(selectList)
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .forResult(0x188);//结果回调onActivityResult code
    }

    //返回图片地址
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 0x188:
                    // 图片/视屏选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    GlideImageLoader.loadLogh(activity,selectList.get(0).getCutPath(),photo);
                    isupdow=true;
                    okimages.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

}
