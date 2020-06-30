package com.getan.mobileluoyang0505.bean;

import java.util.List;

/**
 * Created by Administrator on 2020/5/6.
 * 邮箱：405181076@qq.com
 */
public class HomeCateBean {

    /**
     * result : success
     * data : {"cate_list":[{"cateId":"14","cate":"news_luoyang","cateName":"推荐","status":"1","islock":"1","weight":"120"},{"cateId":"1","cate":"news_all","cateName":"洛阳","status":"1","islock":"1","weight":"100"},{"cateId":"19","cate":"news_xinhuashe","cateName":"时事","status":"1","islock":"0","weight":"90"},{"cateId":"32","cate":"news_mengjin","cateName":"孟津","status":"1","islock":"0","weight":"80"},{"cateId":"34","cate":"news_luanchuan","cateName":"栾川","status":"1","islock":"0","weight":"78"},{"cateId":"23","cate":"news_jianxi","cateName":"涧西","status":"1","islock":"0","weight":"76"},{"cateId":"36","cate":"news_ruyang","cateName":"汝阳","status":"1","islock":"0","weight":"74"},{"cateId":"21","cate":"news_luolong","cateName":"洛龙","status":"1","islock":"0","weight":"72"},{"cateId":"37","cate":"news_yiyang","cateName":"宜阳","status":"1","islock":"0","weight":"70"},{"cateId":"35","cate":"news_songxian","cateName":"嵩县","status":"1","islock":"0","weight":"68"},{"cateId":"10","cate":"news_edu","cateName":"教育","status":"1","islock":"0","weight":"0"},{"cateId":"18","cate":"news_shangye","cateName":"商业","status":"1","islock":"0","weight":"0"},{"cateId":"22","cate":"news_xigong","cateName":"西工","status":"1","islock":"0","weight":"0"},{"cateId":"24","cate":"news_laocheng","cateName":"老城","status":"1","islock":"0","weight":"0"},{"cateId":"25","cate":"news_chanhe","cateName":"瀍河","status":"1","islock":"0","weight":"0"},{"cateId":"26","cate":"news_jili","cateName":"吉利","status":"1","islock":"0","weight":"0"},{"cateId":"27","cate":"news_yibin","cateName":"伊滨","status":"1","islock":"0","weight":"0"},{"cateId":"31","cate":"news_yanshi","cateName":"偃师","status":"1","islock":"0","weight":"0"},{"cateId":"33","cate":"news_xinan","cateName":"新安","status":"1","islock":"0","weight":"0"},{"cateId":"38","cate":"news_luoning","cateName":"洛宁","status":"1","islock":"0","weight":"0"},{"cateId":"39","cate":"news_yichuan","cateName":"伊川","status":"1","islock":"0","weight":"0"},{"cateId":"40","cate":"news_luoyanghao","cateName":"洛阳号","status":"1","islock":"0","weight":"0"}],"cate_time":1493827200}
     */

    private String result;
    private DataBean data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cate_list : [{"cateId":"14","cate":"news_luoyang","cateName":"推荐","status":"1","islock":"1","weight":"120"},{"cateId":"1","cate":"news_all","cateName":"洛阳","status":"1","islock":"1","weight":"100"},{"cateId":"19","cate":"news_xinhuashe","cateName":"时事","status":"1","islock":"0","weight":"90"},{"cateId":"32","cate":"news_mengjin","cateName":"孟津","status":"1","islock":"0","weight":"80"},{"cateId":"34","cate":"news_luanchuan","cateName":"栾川","status":"1","islock":"0","weight":"78"},{"cateId":"23","cate":"news_jianxi","cateName":"涧西","status":"1","islock":"0","weight":"76"},{"cateId":"36","cate":"news_ruyang","cateName":"汝阳","status":"1","islock":"0","weight":"74"},{"cateId":"21","cate":"news_luolong","cateName":"洛龙","status":"1","islock":"0","weight":"72"},{"cateId":"37","cate":"news_yiyang","cateName":"宜阳","status":"1","islock":"0","weight":"70"},{"cateId":"35","cate":"news_songxian","cateName":"嵩县","status":"1","islock":"0","weight":"68"},{"cateId":"10","cate":"news_edu","cateName":"教育","status":"1","islock":"0","weight":"0"},{"cateId":"18","cate":"news_shangye","cateName":"商业","status":"1","islock":"0","weight":"0"},{"cateId":"22","cate":"news_xigong","cateName":"西工","status":"1","islock":"0","weight":"0"},{"cateId":"24","cate":"news_laocheng","cateName":"老城","status":"1","islock":"0","weight":"0"},{"cateId":"25","cate":"news_chanhe","cateName":"瀍河","status":"1","islock":"0","weight":"0"},{"cateId":"26","cate":"news_jili","cateName":"吉利","status":"1","islock":"0","weight":"0"},{"cateId":"27","cate":"news_yibin","cateName":"伊滨","status":"1","islock":"0","weight":"0"},{"cateId":"31","cate":"news_yanshi","cateName":"偃师","status":"1","islock":"0","weight":"0"},{"cateId":"33","cate":"news_xinan","cateName":"新安","status":"1","islock":"0","weight":"0"},{"cateId":"38","cate":"news_luoning","cateName":"洛宁","status":"1","islock":"0","weight":"0"},{"cateId":"39","cate":"news_yichuan","cateName":"伊川","status":"1","islock":"0","weight":"0"},{"cateId":"40","cate":"news_luoyanghao","cateName":"洛阳号","status":"1","islock":"0","weight":"0"}]
         * cate_time : 1493827200
         */

        private int cate_time;
        private List<CateListBean> cate_list;

        public int getCate_time() {
            return cate_time;
        }

        public void setCate_time(int cate_time) {
            this.cate_time = cate_time;
        }

        public List<CateListBean> getCate_list() {
            return cate_list;
        }

        public void setCate_list(List<CateListBean> cate_list) {
            this.cate_list = cate_list;
        }

        public static class CateListBean {
            /**
             * cateId : 14
             * cate : news_luoyang
             * cateName : 推荐
             * status : 1
             * islock : 1
             * weight : 120
             */

            private String cateId;
            private String cate;
            private String cateName;
            private String status;
            private String islock;
            private String weight;

            public String getCateId() {
                return cateId;
            }

            public void setCateId(String cateId) {
                this.cateId = cateId;
            }

            public String getCate() {
                return cate;
            }

            public void setCate(String cate) {
                this.cate = cate;
            }

            public String getCateName() {
                return cateName;
            }

            public void setCateName(String cateName) {
                this.cateName = cateName;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIslock() {
                return islock;
            }

            public void setIslock(String islock) {
                this.islock = islock;
            }

            public String getWeight() {
                return weight;
            }

            public void setWeight(String weight) {
                this.weight = weight;
            }
        }
    }
}
