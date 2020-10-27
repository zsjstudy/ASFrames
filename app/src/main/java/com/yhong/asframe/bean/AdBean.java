package com.yhong.asframe.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by 17639 on 2020/6/8.
 */

public class AdBean implements Serializable {

    /**
     * images : {"1125x2436":"http://9y.toushizhiku.com/upload/portal/20200318/3f0bdbbc9d1060c6010c69d39a3f4404.png","1242x2688":"http://9y.toushizhiku.com/upload/portal/20200318/2f073d86a602db4d28d80e079c0904ad.png"}
     * user : {"user_type":0,"end_time":""}
     * recruit : 1
     * review : 1
     * redirect_data : {"type":5,"profession_show_status":0,"act_type":0,"profession_name":"山东","object_id":14,"url":""}
     * meizu : 1
     */

    private ImagesBean images;
    private UserBean user;
    private int recruit;
    private int review;
    private RedirectDataBean redirect_data;
    private int meizu;

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getRecruit() {
        return recruit;
    }

    public void setRecruit(int recruit) {
        this.recruit = recruit;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public RedirectDataBean getRedirect_data() {
        return redirect_data;
    }

    public void setRedirect_data(RedirectDataBean redirect_data) {
        this.redirect_data = redirect_data;
    }

    public int getMeizu() {
        return meizu;
    }

    public void setMeizu(int meizu) {
        this.meizu = meizu;
    }

    public static class ImagesBean implements Serializable{
        /**
         * 1125x2436 : http://9y.toushizhiku.com/upload/portal/20200318/3f0bdbbc9d1060c6010c69d39a3f4404.png
         * 1242x2688 : http://9y.toushizhiku.com/upload/portal/20200318/2f073d86a602db4d28d80e079c0904ad.png
         */

        @SerializedName("1125x2436")
        private String _$1125x2436;
        @SerializedName("1242x2688")
        private String _$1242x2688;

        public String get_$1125x2436() {
            return _$1125x2436;
        }

        public void set_$1125x2436(String _$1125x2436) {
            this._$1125x2436 = _$1125x2436;
        }

        public String get_$1242x2688() {
            return _$1242x2688;
        }

        public void set_$1242x2688(String _$1242x2688) {
            this._$1242x2688 = _$1242x2688;
        }
    }

    public static class UserBean implements Serializable{
        /**
         * user_type : 0
         * end_time :
         */

        private int user_type;
        private String end_time;

        public int getUser_type() {
            return user_type;
        }

        public void setUser_type(int user_type) {
            this.user_type = user_type;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }
    }

    public static class RedirectDataBean implements Serializable{
        /**
         * type : 5
         * profession_show_status : 0
         * act_type : 0
         * profession_name : 山东
         * object_id : 14
         * url :
         */

        private int type;
        private int profession_show_status;
        private int act_type;
        private String profession_name;
        private int object_id;
        private String url;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getProfession_show_status() {
            return profession_show_status;
        }

        public void setProfession_show_status(int profession_show_status) {
            this.profession_show_status = profession_show_status;
        }

        public int getAct_type() {
            return act_type;
        }

        public void setAct_type(int act_type) {
            this.act_type = act_type;
        }

        public String getProfession_name() {
            return profession_name;
        }

        public void setProfession_name(String profession_name) {
            this.profession_name = profession_name;
        }

        public int getObject_id() {
            return object_id;
        }

        public void setObject_id(int object_id) {
            this.object_id = object_id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

}
