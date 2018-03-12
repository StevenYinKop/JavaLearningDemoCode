package com.yinzifan.reflect;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class BugInfoEntity implements Serializable, Historicable{
    
    private static final long serialVersionUID = -8762413904827082807L;
    private Integer prjId;
    private Integer bugId;
    private Integer submitCount;
    private String moduleId;
    private Integer pKind;
    private String onVer;
    private String summary;
    private String stepText;
    private String assignEmp;
    private String ccEmp;
    private Integer priority;
    private Date expectDate;
    private Integer repRod;
    private String reporter;
    private Timestamp reportTime;
    private String findStep;
    private String occurStep;
    private String modEmp;
    private Integer errType;
    private Integer errReason1;
    private Integer errReason2;
    private Integer designErrReason1;
    private Integer designErrReason2;
    private String dealMethod;
    private String chgSrcList;
    private Integer verifyVer;
    private Timestamp doneTime;
    private Timestamp finiTime;
    private Integer status;
    private String comments;
    private String attach;
    private Integer degrade;
    private String creator;
    private Integer testTimes;
    private String custFieldValue1;
    private String custFieldValue2;
    private String custFieldValue3;
    private String custFieldValue4;
    private String custFieldValue5;
    private String custFieldValue6;
    private String custFieldValue7;
    private String custFieldValue8;
    private String updId;
    private Timestamp updTime;
    private Integer spreadId;
    private Integer qaId;
    
    private String bugInfoSign;

    public Integer getPrjId() {
        return prjId;
    }

    public void setPrjId(Integer prjId) {
        this.prjId = prjId;
    }

    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public Integer getSubmitCount() {
        return submitCount;
    }

    public void setSubmitCount(Integer submitCount) {
        this.submitCount = submitCount;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public Integer getpKind() {
        return pKind;
    }

    public void setpKind(Integer pKind) {
        this.pKind = pKind;
    }

    public String getOnVer() {
        return onVer;
    }

    public void setOnVer(String onVer) {
        this.onVer = onVer;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStepText() {
        return stepText;
    }

    public void setStepText(String stepText) {
        this.stepText = stepText;
    }

    public String getAssignEmp() {
        return assignEmp;
    }

    public void setAssignEmp(String assignEmp) {
        this.assignEmp = assignEmp;
    }

    public String getCcEmp() {
        return ccEmp;
    }

    public void setCcEmp(String ccEmp) {
        this.ccEmp = ccEmp;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Date expectDate) {
        this.expectDate = expectDate;
    }

    public Integer getRepRod() {
        return repRod;
    }

    public void setRepRod(Integer repRod) {
        this.repRod = repRod;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    public String getFindStep() {
        return findStep;
    }

    public void setFindStep(String findStep) {
        this.findStep = findStep;
    }

    public String getOccurStep() {
        return occurStep;
    }

    public void setOccurStep(String occurStep) {
        this.occurStep = occurStep;
    }

    public String getModEmp() {
        return modEmp;
    }

    public void setModEmp(String modEmp) {
        this.modEmp = modEmp;
    }

    public Integer getErrType() {
        return errType;
    }

    public void setErrType(Integer errType) {
        this.errType = errType;
    }

    public Integer getErrReason1() {
        return errReason1;
    }

    public void setErrReason1(Integer errReason1) {
        this.errReason1 = errReason1;
    }

    public Integer getErrReason2() {
        return errReason2;
    }

    public void setErrReason2(Integer errReason2) {
        this.errReason2 = errReason2;
    }

    public Integer getDesignErrReason1() {
        return designErrReason1;
    }

    public void setDesignErrReason1(Integer designErrReason1) {
        this.designErrReason1 = designErrReason1;
    }

    public Integer getDesignErrReason2() {
        return designErrReason2;
    }

    public void setDesignErrReason2(Integer designErrReason2) {
        this.designErrReason2 = designErrReason2;
    }

    public String getDealMethod() {
        return dealMethod;
    }

    public void setDealMethod(String dealMethod) {
        this.dealMethod = dealMethod;
    }

    public String getChgSrcList() {
        return chgSrcList;
    }

    public void setChgSrcList(String chgSrcList) {
        this.chgSrcList = chgSrcList;
    }

    public Integer getVerifyVer() {
        return verifyVer;
    }

    public void setVerifyVer(Integer verifyVer) {
        this.verifyVer = verifyVer;
    }

    public Timestamp getDoneTime() {
        return doneTime;
    }

    public void setDoneTime(Timestamp doneTime) {
        this.doneTime = doneTime;
    }

    public Timestamp getFiniTime() {
        return finiTime;
    }

    public void setFiniTime(Timestamp finiTime) {
        this.finiTime = finiTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public Integer getDegrade() {
        return degrade;
    }

    public void setDegrade(Integer degrade) {
        this.degrade = degrade;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getTestTimes() {
        return testTimes;
    }

    public void setTestTimes(Integer testTimes) {
        this.testTimes = testTimes;
    }

    public String getCustFieldValue1() {
        return custFieldValue1;
    }

    public void setCustFieldValue1(String custFieldValue1) {
        this.custFieldValue1 = custFieldValue1;
    }

    public String getCustFieldValue2() {
        return custFieldValue2;
    }

    public void setCustFieldValue2(String custFieldValue2) {
        this.custFieldValue2 = custFieldValue2;
    }

    public String getCustFieldValue3() {
        return custFieldValue3;
    }

    public void setCustFieldValue3(String custFieldValue3) {
        this.custFieldValue3 = custFieldValue3;
    }

    public String getCustFieldValue4() {
        return custFieldValue4;
    }

    public void setCustFieldValue4(String custFieldValue4) {
        this.custFieldValue4 = custFieldValue4;
    }

    public String getCustFieldValue5() {
        return custFieldValue5;
    }

    public void setCustFieldValue5(String custFieldValue5) {
        this.custFieldValue5 = custFieldValue5;
    }

    public String getCustFieldValue6() {
        return custFieldValue6;
    }

    public void setCustFieldValue6(String custFieldValue6) {
        this.custFieldValue6 = custFieldValue6;
    }

    public String getCustFieldValue7() {
        return custFieldValue7;
    }

    public void setCustFieldValue7(String custFieldValue7) {
        this.custFieldValue7 = custFieldValue7;
    }

    public String getCustFieldValue8() {
        return custFieldValue8;
    }

    public void setCustFieldValue8(String custFieldValue8) {
        this.custFieldValue8 = custFieldValue8;
    }

    public String getUpdId() {
        return updId;
    }

    public void setUpdId(String updId) {
        this.updId = updId;
    }

    public Timestamp getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Timestamp updTime) {
        this.updTime = updTime;
    }

    public Integer getSpreadId() {
        return spreadId;
    }

    public void setSpreadId(Integer spreadId) {
        this.spreadId = spreadId;
    }

    public Integer getQaId() {
        return qaId;
    }

    public void setQaId(Integer qaId) {
        this.qaId = qaId;
    }

    public String getBugInfoSign() {
        return bugInfoSign;
    }

    public void setBugInfoSign(String bugInfoSign) {
        this.bugInfoSign = bugInfoSign;
    }

    @Override
    public String toString() {
        return "BugInfoEntity [prjId=" + prjId + ", bugId=" + bugId + ", submitCount=" + submitCount + ", moduleId=" + moduleId + ", pKind=" + pKind
                + ", onVer=" + onVer + ", summary=" + summary + ", stepText=" + stepText + ", assignEmp=" + assignEmp + ", ccEmp=" + ccEmp
                + ", priority=" + priority + ", expectDate=" + expectDate + ", repRod=" + repRod + ", reporter=" + reporter + ", reportTime="
                + reportTime + ", findStep=" + findStep + ", occurStep=" + occurStep + ", modEmp=" + modEmp + ", errType=" + errType + ", errReason1="
                + errReason1 + ", errReason2=" + errReason2 + ", designErrReason1=" + designErrReason1 + ", designErrReason2=" + designErrReason2
                + ", dealMethod=" + dealMethod + ", chgSrcList=" + chgSrcList + ", verifyVer=" + verifyVer + ", doneTime=" + doneTime + ", finiTime="
                + finiTime + ", status=" + status + ", comments=" + comments + ", attach=" + attach + ", degrade=" + degrade + ", creator=" + creator
                + ", testTimes=" + testTimes + ", custFieldValue1=" + custFieldValue1 + ", custFieldValue2=" + custFieldValue2 + ", custFieldValue3="
                + custFieldValue3 + ", custFieldValue4=" + custFieldValue4 + ", custFieldValue5=" + custFieldValue5 + ", custFieldValue6="
                + custFieldValue6 + ", custFieldValue7=" + custFieldValue7 + ", custFieldValue8=" + custFieldValue8 + ", updId=" + updId
                + ", updTime=" + updTime + ", spreadId=" + spreadId + ", qaId=" + qaId + ", bugInfoSign=" + bugInfoSign + "]";
    }

}
