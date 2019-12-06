package com.example.jiyin.home.Activity.sonview.sonimpl;

import com.example.jiyin.common.net.netlisenter.NetBeanListener;
import com.example.jiyin.common.net.netunti.BeanNetUnit;
import com.example.jiyin.home.Activity.sonview.activity.WorkSurfaceActivity;
import com.example.jiyin.home.Activity.sonview.base.WorkDetailsBase;
import com.example.jiyin.home.Activity.sonview.base.WorkProjectbase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopLabelBase;
import com.example.jiyin.home.Activity.sonview.base.WorkshopMainBase;
import com.example.jiyin.home.Activity.sonview.impl.WorkRoomPresenter;
import com.example.jiyin.home.Activity.sonview.sonview.WorkRoomView;
import com.example.jiyin.home.UserCallManager;
import com.example.rootlib.utils.CollectionUtil;
import com.example.rootlib.widget.common.ThrowLayout;

/**
 * 工作坊 网络层
 * <p><p/>
 */
public class WorkRoomImpl extends WorkRoomPresenter<WorkRoomView> {

    private BeanNetUnit workroomUnit;

    @Override
    public void cancelBiz() {
        cancelRequest(workroomUnit);
    }

    //获取工作仿标签
    @Override
    public void workshoplabel() {
        workroomUnit = new BeanNetUnit<WorkshopLabelBase>()
                .setCall(UserCallManager.getWorkroom())
                .request(new NetBeanListener<WorkshopLabelBase>() {
                    @Override
                    public void onSuc(WorkshopLabelBase bean) {
                        if (CollectionUtil.isEmpty(bean.getData())) {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    workshoplabel();
                                }
                            });
                        }else{
                            v.hideExpectionPages();
                        }
                        v.returnDatalabel(bean);
                    }

                    @Override
                    public void onFail(int status, String message) {

                    }

                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

                    }

                    @Override
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                workshoplabel();
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                workshoplabel();
                            }
                        });
                    }
                });


    }

    /**
     * 获取工作坊首页数据
     * @param pages
     * @param ification_id
     */
    @Override
    public void globaldata(int pages, int ification_id) {
        workroomUnit = new BeanNetUnit<WorkshopMainBase>()
                .setCall(UserCallManager.getWorkshopMainCall(pages,ification_id))
                .request(new NetBeanListener<WorkshopMainBase>() {
                    @Override
                    public void onSuc(WorkshopMainBase bean) {
                        if (bean==null) {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    globaldata(pages,ification_id);
                                }
                            });
                        }else{
                            v.hideExpectionPages();
                        }
                        v.retWorkShopMainData(bean);
                    }
                    @Override
                    public void onFail(int status, String message) {

                    }
                    @Override
                    public void onLoadStart() {

                    }
                    @Override
                    public void onLoadFinished() {

                    }
                    @Override
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                globaldata(pages,ification_id);
                            }
                        });
                    }
                    @Override
                    public void onSysErr(int httpCode, String msg) {

                    }
                });
    }


    /**
     * 获取工作坊详情
     * @param workshop_id
     */
    @Override
    public void inFormation(int workshop_id) {
        workroomUnit=new BeanNetUnit<WorkDetailsBase>()
                .setCall(UserCallManager.getFormation(workshop_id))
                .request(new NetBeanListener<WorkDetailsBase>() {
                    @Override
                    public void onSuc(WorkDetailsBase bean) {
                        if (bean.getData()==null) {
                            v.showNullMessageLayout(new ThrowLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    inFormation(workshop_id);
                                }
                            });
                        }else{
                            v.hideExpectionPages();
                        }
                        v.retDataWorkDetails(bean);
                    }

                    @Override
                    public void onFail(int status, String message) {

                    }

                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

                    }

                    @Override
                    public void onNetErr() {
                        v.showNetErrorLayout(new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                inFormation(workshop_id);
                            }
                        });
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.showSysErrLayout(msg, new ThrowLayout.OnRetryListener() {
                            @Override
                            public void onRetry() {
                                inFormation(workshop_id);
                            }
                        });
                    }
                });


    }

    //工作坊申请提交
    @Override
    public void workShenQing(int workId, String etTeamnameEditStr, String etYourschoolEditStr,
                             String etTeamsizeEditStr, String etEstablishTimeEditStr, String etProjectTypeEditStr,String isregistereds,
                             String etTeamleaderEditStr, String etTelephoneEditStr, String etWorkMailboxEditStr, String etPersonalEditStr) {
        workroomUnit=new BeanNetUnit<WorkSurfaceActivity.breakCode>()
                .setCall(UserCallManager.getWorkShenQing(workId,etTeamnameEditStr,etYourschoolEditStr,etTeamsizeEditStr
                    ,etEstablishTimeEditStr,etProjectTypeEditStr,isregistereds,etTeamleaderEditStr,etTelephoneEditStr,etWorkMailboxEditStr,etPersonalEditStr
                    )).request(new NetBeanListener<WorkSurfaceActivity.breakCode>() {
                    @Override
                    public void onSuc(WorkSurfaceActivity.breakCode bean) {
                        if (bean!=null) {
                            v.retworkShenQ(bean);
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                        v.onfailure(message);
                    }

                    @Override
                    public void onLoadStart() {

                    }

                    @Override
                    public void onLoadFinished() {

                    }

                    @Override
                    public void onNetErr() {
                        v.onfailure("网络异常");
                    }

                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.onfailure(httpCode+"***"+msg);
                    }
                });
    }

    /**
     * 工作坊 项目类型标签
     * @param workId
     */
    @Override
    public void studioLabel(int workId) {
        workroomUnit = new BeanNetUnit<WorkProjectbase>()
                .setCall(UserCallManager.getStudioLabel(workId))
                .request(new NetBeanListener<WorkProjectbase>(){
                    @Override
                    public void onSuc(WorkProjectbase bean) {
                        if (bean!=null) {
                            v.retStudioLabel(bean);
                        }else{
                            v.onfailure(bean.getMsg()+"");
                        }
                    }

                    @Override
                    public void onFail(int status, String message) {
                            v.onfailure(message);
                    }
                    @Override
                    public void onLoadStart() {

                    }
                    @Override
                    public void onLoadFinished() {

                    }
                    @Override
                    public void onNetErr() {
                        v.onfailure("请检测网络");
                    }
                    @Override
                    public void onSysErr(int httpCode, String msg) {
                        v.onfailure(httpCode+"****"+msg);
                    }
                });


    }


}
