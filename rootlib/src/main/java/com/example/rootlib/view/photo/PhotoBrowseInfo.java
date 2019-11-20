package com.example.rootlib.view.photo;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于图片浏览的实体类
 */

public class PhotoBrowseInfo implements Parcelable {

    private List<String> photoUrls;
    private List<Rect> viewLocalRects;
    private int currentPhotoPosition = -1;

    private PhotoBrowseInfo(List<String> photoUrls, List<Rect> viewLocalRects, int currentPhotoPosition) {
        this.photoUrls = new ArrayList<>(photoUrls);
        this.viewLocalRects = new ArrayList<>(viewLocalRects);
        this.currentPhotoPosition = currentPhotoPosition;

    }

    public static PhotoBrowseInfo create(List<String> photoUrls, List<Rect> viewLocalRects, int currentPhotoPosition) {
        return new PhotoBrowseInfo(photoUrls, viewLocalRects, currentPhotoPosition);
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Rect> getViewLocalRects() {
        return viewLocalRects;
    }

    public void setViewLocalRects(List<Rect> viewLocalRects) {
        this.viewLocalRects = viewLocalRects;
    }

    public int getCurrentPhotoPosition() {
        return currentPhotoPosition;
    }

    public void setCurrentPhotoPosition(int currentPhotoPosition) {
        this.currentPhotoPosition = currentPhotoPosition;
    }

    public int getPhotosCount() {
        if (isListEmpty(photoUrls)) return 0;
        return photoUrls.size();
    }

    public boolean isValided() {
        return !(isListEmpty(photoUrls) || isListEmpty(viewLocalRects) || currentPhotoPosition == -1) && photoUrls.size() == viewLocalRects.size();
    }

    public static boolean isListEmpty(List<?> datas) {
        return datas == null || datas.size() <= 0;
    }

    //=============================================================Parcelable

    protected PhotoBrowseInfo(Parcel in) {
        photoUrls = in.createStringArrayList();
        viewLocalRects = in.createTypedArrayList(Rect.CREATOR);
        currentPhotoPosition = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(photoUrls);
        dest.writeTypedList(viewLocalRects);
        dest.writeInt(currentPhotoPosition);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PhotoBrowseInfo> CREATOR = new Creator<PhotoBrowseInfo>() {
        @Override
        public PhotoBrowseInfo createFromParcel(Parcel in) {
            return new PhotoBrowseInfo(in);
        }

        @Override
        public PhotoBrowseInfo[] newArray(int size) {
            return new PhotoBrowseInfo[size];
        }
    };
}
