package com.yinzifan.poi.koala;

import java.math.BigDecimal;

class RecordInfo {
    private Integer rowIndex;
    private Integer paymentCellIndex;
    private String orderId;
    private String sales;
    private String patientName;
    private String performanceMonth;
    private String incomeMonth;
    private BigDecimal payment;

    public Integer getRowIndexInExcel() {
        return Integer.sum(1, rowIndex);
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
    }

    public Integer getPaymentCellIndex() {
        return paymentCellIndex;
    }

    public void setPaymentCellIndex(Integer paymentCellIndex) {
        this.paymentCellIndex = paymentCellIndex;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((incomeMonth == null) ? 0 : incomeMonth.hashCode());
        result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
        result = prime * result + ((patientName == null) ? 0 : patientName.hashCode());
        result = prime * result + ((performanceMonth == null) ? 0 : performanceMonth.hashCode());
        result = prime * result + ((sales == null) ? 0 : sales.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RecordInfo other = (RecordInfo) obj;
        if (incomeMonth == null) {
            if (other.incomeMonth != null)
                return false;
        } else if (!incomeMonth.equals(other.incomeMonth))
            return false;
        if (orderId == null) {
            if (other.orderId != null)
                return false;
        } else if (!orderId.equals(other.orderId))
            return false;
        if (patientName == null) {
            if (other.patientName != null)
                return false;
        } else if (!patientName.equals(other.patientName))
            return false;
        if (performanceMonth == null) {
            if (other.performanceMonth != null)
                return false;
        } else if (!performanceMonth.equals(other.performanceMonth))
            return false;
        if (sales == null) {
            if (other.sales != null)
                return false;
        } else if (!sales.equals(other.sales))
            return false;
        return true;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPerformanceMonth() {
        return performanceMonth;
    }

    public void setPerformanceMonth(String performanceMonth) {
        this.performanceMonth = performanceMonth;
    }

    public String getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(String incomeMonth) {
        this.incomeMonth = incomeMonth;
    }

    @Override
    public String toString() {
        return "当前行数: " + getRowIndexInExcel() + ", 订单编号:" + orderId + ", 销售代表: " + sales + ", 患者姓名: " + patientName
                + ", 业绩月份: " + performanceMonth + ", 收入月份: " + incomeMonth + ", 单笔收费金额: " + payment;
    }
}
