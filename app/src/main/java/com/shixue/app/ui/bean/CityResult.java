package com.shixue.app.ui.bean;

import java.util.List;

/**
 * 本页：省份城市信息
 * Created by jjs on 2016-11-26.
 */

public class CityResult {

    private List<ProvListBean> provList;

    public List<ProvListBean> getProvList() {
        return provList;
    }

    public void setProvList(List<ProvListBean> provList) {
        this.provList = provList;
    }

    public static class ProvListBean {
        /**
         * cityList : [{"cityId":1,"cityName":"南昌","provinceId":1},{"cityId":10,"cityName":"吉安","provinceId":1},{"cityId":6,"cityName":"鹰潭","provinceId":1},{"cityId":9,"cityName":"上饶","provinceId":1},{"cityId":8,"cityName":"宜春","provinceId":1},{"cityId":4,"cityName":"萍乡","provinceId":1},{"cityId":2,"cityName":"景德镇","provinceId":1},{"cityId":11,"cityName":"抚州","provinceId":1},{"cityId":7,"cityName":"赣州","provinceId":1},{"cityId":3,"cityName":"九江","provinceId":1},{"cityId":5,"cityName":"新余","provinceId":1}]
         * provinceId : 1
         * provinceName : 江西
         */

        private int provinceId;
        private String provinceName;
        private List<CityListBean> cityList;

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public List<CityListBean> getCityList() {
            return cityList;
        }

        public void setCityList(List<CityListBean> cityList) {
            this.cityList = cityList;
        }

        public static class CityListBean {
            /**
             * cityId : 1
             * cityName : 南昌
             * provinceId : 1
             */

            private int cityId;
            private String cityName;
            private int provinceId;

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }
        }
    }
}
