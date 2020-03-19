package com.bliss.print.model;

import java.util.List;

public class JobDescribe {

    /**
     * status : 200
     * job : [{"title":"印刷工程师","salary":"6千-8千/月","name":"上海艺森印务技术有限公司","describe":"上海 | 南翔 | 经验不限 | 学历不限| 全职","contact":"上海艺森/行政部"},{"title":"印前完稿设计","salary":"6千-8千/月","name":"上海赛肯德印刷有限公司","describe":"上海 | 浦江镇 | 1-3年 | 学历不限 | 全职","contact":"张经理/总经理"},{"title":"标书专员/图文排版","salary":"8千-1万/月","name":"融信集团有限公司上海分公司","describe":"上海 | 徐泾1-3年 | 本科 | 全职","contact":"赵小姐/人事经理"}]
     */

    private int status;
    private List<JobBean> job;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<JobBean> getJob() {
        return job;
    }

    public void setJob(List<JobBean> job) {
        this.job = job;
    }

    public static class JobBean {
        /**
         * title : 印刷工程师
         * salary : 6千-8千/月
         * name : 上海艺森印务技术有限公司
         * describe : 上海 | 南翔 | 经验不限 | 学历不限| 全职
         * contact : 上海艺森/行政部
         */

        private String title;
        private String salary;
        private String name;
        private String describe;
        private String contact;
        private int img;

        public int getImg() {
            return img;
        }

        public void setImg(int img) {
            this.img = img;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSalary() {
            return salary;
        }

        public void setSalary(String salary) {
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescribe() {
            return describe;
        }

        public void setDescribe(String describe) {
            this.describe = describe;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        @Override
        public String toString() {
            return "JobBean{" +
                    "title='" + title + '\'' +
                    ", salary='" + salary + '\'' +
                    ", name='" + name + '\'' +
                    ", describe='" + describe + '\'' +
                    ", contact='" + contact + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "JobDescribe{" +
                "status=" + status +
                ", job=" + job +
                '}';
    }
}
