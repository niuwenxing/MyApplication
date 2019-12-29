package com.example.jiyin.common.net;

/**
 * Created by zhl on 2019/12/27.
 */
public interface UploadProgressListener {
    void onProgress(long totalLength, long CurrentLength);
}
