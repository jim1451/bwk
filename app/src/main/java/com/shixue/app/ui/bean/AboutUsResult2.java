package com.shixue.app.ui.bean;

/**
 * Created by MZ安卓 on 2017/11/13.
 */

public class AboutUsResult2 {


    /**
     * agent : {"aboutUs":"","address":"","agentDetail":"","agentIcon":"http://119.29.194.199/sxAgent/attached/agent/20171105110116.png","agentId":3,"agentName":"广州德立","contact":"林金秀","invalid":1,"memberTip":"","mobile":"13250289550","serviceContent":""}
     * examTypeId : 0
     */

    private AgentBean agent;
    private int examTypeId;

    public AgentBean getAgent() {
        return agent;
    }

    public void setAgent(AgentBean agent) {
        this.agent = agent;
    }

    public int getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(int examTypeId) {
        this.examTypeId = examTypeId;
    }

    public static class AgentBean {
        /**
         * aboutUs :
         * address :
         * agentDetail :
         * agentIcon : http://119.29.194.199/sxAgent/attached/agent/20171105110116.png
         * agentId : 3
         * agentName : 广州德立
         * contact : 林金秀
         * invalid : 1
         * memberTip :
         * mobile : 13250289550
         * serviceContent :
         */

        private String aboutUs;
        private String address;
        private String agentDetail;
        private String agentIcon;
        private int agentId;
        private String agentName;
        private String contact;
        private int invalid;
        private String memberTip;
        private String mobile;
        private String serviceContent;

        public String getAboutUs() {
            return aboutUs;
        }

        public void setAboutUs(String aboutUs) {
            this.aboutUs = aboutUs;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAgentDetail() {
            return agentDetail;
        }

        public void setAgentDetail(String agentDetail) {
            this.agentDetail = agentDetail;
        }

        public String getAgentIcon() {
            return agentIcon;
        }

        public void setAgentIcon(String agentIcon) {
            this.agentIcon = agentIcon;
        }

        public int getAgentId() {
            return agentId;
        }

        public void setAgentId(int agentId) {
            this.agentId = agentId;
        }

        public String getAgentName() {
            return agentName;
        }

        public void setAgentName(String agentName) {
            this.agentName = agentName;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public int getInvalid() {
            return invalid;
        }

        public void setInvalid(int invalid) {
            this.invalid = invalid;
        }

        public String getMemberTip() {
            return memberTip;
        }

        public void setMemberTip(String memberTip) {
            this.memberTip = memberTip;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getServiceContent() {
            return serviceContent;
        }

        public void setServiceContent(String serviceContent) {
            this.serviceContent = serviceContent;
        }
    }
}
