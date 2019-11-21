package com.example.jiyin.home.Activity.homeview;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jiyin.R;
import com.example.jiyin.common.activity.JiYingActivity;
import com.example.jiyin.home.Activity.adapter.FullyGridLayoutManager;
import com.example.jiyin.home.Activity.adapter.GridImageAdapter;
import com.example.jiyin.home.Activity.homeview.base.ReleaseBean;
import com.example.jiyin.home.Activity.presenter.impl.ReleaseCirclesImpl;
import com.example.jiyin.home.Activity.presenter.view.ReleaseCirclesView;
import com.example.jiyin.home.Activity.view.CircleActivity;
import com.example.jiyin.utils.ConstantUtil;
import com.example.rootlib.permission.RequestPermissionListener;
import com.example.rootlib.utils.StringUtil;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发布圈子 / 发布视频
 */

public class ReleaseCirclesActivity extends JiYingActivity<ReleaseCirclesView, ReleaseCirclesImpl> implements ReleaseCirclesView {

    @BindView(R.id.ed_content)
    EditText edContent;
    @BindView(R.id.status_counter)
    TextView statusCounter;
    @BindView(R.id.tv_releaseTitle)
    TextView tvReleaseTitle;
    @BindView(R.id.gv_photo)
    RecyclerView gvPhoto;
    @BindView(R.id.Circlelabel_btn)
    TextView mCirclelabel_btn;
    @BindView(R.id.iv_goback)
    ImageView ivGoback;
    @BindView(R.id.tv_ReleaseBtn)
    TextView tvReleaseBtn;
    //    @BindView(R.id.tv_releaseTitle)
//    TextView tvReleaseTitle;
    private String type;
    private GridImageAdapter adapter;
    /**
     * 相册选取
     */
    private List<LocalMedia> selectList = new ArrayList<>();
    private CharSequence str;
    private int ification_id=0;
    private String title=null;

    private int circle_type;//发布类型


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_release_circles;
    }

    @Override
    protected void createPresenter() {
        super.createPresenter();
        presenter = new ReleaseCirclesImpl();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getIntent().getStringExtra(ConstantUtil.KEY_CODE);
        if (type.equals(ConstantUtil.CIRCLES)) {
            tvReleaseTitle.setText("发布圈子");
            circle_type=0;
        } else {
            tvReleaseTitle.setText("发布视频");
            circle_type=1;
        }
        initView();

    }

    private void initView() {
        FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        gvPhoto.setLayoutManager(manager);
        adapter = new GridImageAdapter(this, onAddPicClickListener);
        adapter.setList(selectList);
        gvPhoto.setAdapter(adapter);


        edContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                statusCounter.setText("500/" + String.valueOf(500 - s.length()));
                str = s;
            }

            @Override
            public void afterTextChanged(Editable s) {
                int selectionStart = edContent.getSelectionStart();
                int selectionEnd = edContent.getSelectionEnd();
                //删除多余输入的字（不会显示出来）
                if (str.length() > 500) {
                    s.delete(selectionStart - 1, selectionEnd);
                    edContent.setText(s);
                    toast("最多输入500字");
                }
            }
        });

    }

    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
            initAuthority();
        }

    };

    //相册
    private void initPicture() {
        adapter.setSelectMax(9);
        PictureSelector.create(activity)
                .openGallery(PictureMimeType.ofImage())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .theme(R.style.picture_default_style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .maxSelectNum(9)// 最大图片选择数量 int
                .minSelectNum(1)// 最小选择数量 int
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
                .previewImage(true)// 是否可预览图片 true or false
                .enablePreviewAudio(true) // 是否可播放音频 true or false
                .isCamera(true)// 是否显示拍照按钮 true or false
                .imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                .isZoomAnim(false)// 图片列表点击 缩放效果 默认true
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .enableCrop(false)// 是否裁剪 true or false
                .compress(true)// 是否压缩 true or false
                .glideOverride(160, 160)// int glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .withAspectRatio(4, 3)// int 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示 true or false
                .isGif(true)// 是否显示gif图片 true or false
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                .circleDimmedLayer(false)// 是否圆形裁剪 true or false
                .showCropFrame(false)// 是否显示裁剪矩形边框 圆形裁剪时建议设为false   true or false
                .selectionMedia(selectList)// 是否传入已选图片 List<LocalMedia> list
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }

    //视频
    private void initVoide() {
        adapter.setSelectMax(1);
        PictureSelector.create(activity)
                .openGallery(PictureMimeType.ofVideo())//全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                .theme(R.style.picture_default_style)//主题样式(不设置为默认样式) 也可参考demo values/styles下 例如：R.style.picture.white.style
                .imageSpanCount(4)// 每行显示个数 int
                .selectionMode(PictureConfig.SINGLE)
                .previewVideo(true)
                .enablePreviewAudio(true)
                .isCamera(true)//
                .sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                .isZoomAnim(false)// 图片列表点击 缩放效果 默认true
                .selectionMedia(selectList)// 是否传入已选图片 List<LocalMedia> list
                .videoMaxSecond(16)// 显示多少秒以内的视频or音频也可适用 int
                .videoMinSecond(1)// 显示多少秒以内的视频or音频也可适用 int
                .recordVideoSecond(15)//默视频秒数录制 认60s int
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片/视屏选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    adapter.setList(selectList);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
        if(requestCode==123){
            if(resultCode==00056){
                title = data.getStringExtra("title");
                ification_id = data.getIntExtra("id", 0);
                if (title==null||ification_id==0) return;
                mCirclelabel_btn.setText(StringUtil.isEmpty(title)?"请选择": title);
            }
        }

        if (requestCode == 0x2222) {
            initAuthority();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


    private void initAuthority() {
        requestPermission(0x1301, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, new RequestPermissionListener() {
            @Override
            public void onPass(String[] pas) {
                if (type.equals(ConstantUtil.CIRCLES)) {
                    initPicture();
                } else {
                    initVoide();
                }
            }
            @Override
            public void onUnPass(String[] uPas) {
                if (null == uPas || uPas.length == 0) {// 等于0 没有要通过的权限

                }else{
                    dialogShowRemind(0, getString(R.string.common_prompt), getString(R.string.common_authority_warn)
                            , getString(R.string.common_open), getString(R.string.common_cancel), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    startActivityForResult(getAppDetailSettingIntent(), 0x2222); //直接进入手机中设置界面
                                }
                            }, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    finish();
                                }
                            }
                    );
                    toast("请开权限");
                }

            }
        });
    }


    @OnClick({R.id.Circlelabel_btn,R.id.tv_ReleaseBtn,R.id.iv_goback})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Circlelabel_btn:  //选择标签页
//                startActivity(new Intent(this, CircleActivity.class));
                startActivityForResult(new Intent(this, CircleActivity.class),123);
                break;
            case R.id.tv_ReleaseBtn:
                if (title==null||ification_id==0){toast("请选择 圈子标签");
                    return; }
                UpRelease();
                break;
            case R.id.iv_goback:
                finish();
                break;
        }
    }

    /**
     * 上传图片
     */
    private void UpRelease() {
        if (selectList != null && selectList.size() != 0)
        presenter.UpImages(selectList);
        else
        if (StringUtil.isEmpty(edContent.getText().toString().trim())) {
                toast("请填写圈子内容");
        }else{
            presenter.releaseCircles(edContent.getText().toString().trim(),ification_id,circle_type,"");
        }
        return;
    }
    //发布圈子
    @Override
    public void setImageUrl(String data) {
        if(StringUtil.isEmpty(edContent.getText().toString().trim())||StringUtil.isEmpty(data)){
            toast("请填写圈子内容");
            return;
        }
        if (ification_id==0) {
            toast("请选择圈子类型");
            return;
        }
        presenter.releaseCircles(edContent.getText().toString().trim(),ification_id,circle_type,data);
    }

    @Override
    public void releasedSuccessfully(ReleaseBean bean) {
        if (bean.getCode()==-1) {
            toastLong(bean.getMsg());
        }else{
            toastLong(bean.getMsg());
            finish();
        }

    }

    @Override
    public void releaseFail(String mge, String s) {
        toastLong(mge+s);
    }
}
