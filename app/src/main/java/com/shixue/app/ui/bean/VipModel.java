package com.shixue.app.ui.bean;

/**
 * 作者：Jacky
 * 日期：2016-01-06
 */
public class VipModel {

    /**
     * content : 一个月(送7天):25元
     * day : 37
     * money : 25
     */

        private String content;
        private int day;
        private int money;

        public void setContent(String content) {
            this.content = content;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getContent() {
            return content;
        }

        public int getDay() {
            return day;
        }

        public int getMoney() {
            return money;
        }

}
