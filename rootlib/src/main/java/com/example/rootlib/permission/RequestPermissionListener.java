package com.example.rootlib.permission;

public interface RequestPermissionListener {
    /**
     * 请求通过
     */
    void onPass(String[] pas);

    /**
     * 为请求通过
     *
     * @param uPas
     */
    void onUnPass(String[] uPas);
}
