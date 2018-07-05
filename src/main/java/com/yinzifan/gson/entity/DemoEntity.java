package com.yinzifan.gson.entity;

/**
 * @author yinzf2
 * 2018/07/05	14:39:53
 */
public class DemoEntity {
    private String id;
    private String object;
    private Long created;
    private Boolean livemode;
    private Boolean paid;
    private Boolean refunded;
    private Boolean reversed;
    private String app;
    private String channel;
    private Long order_no;
    private String client_ip;
    private Integer amount;
    private Integer amount_settle;
    private String currency;
    private String subject;
    private String body;
    private Object extra; // unknown type;
    private Long time_paid;
    private Long time_expire;
    private Long time_settle;
    private Integer transaction_no;
    private Refunds refunds;
    private Integer amount_refunded;
    private Integer failure;
    private String failure_msg;
    // TODO  不知道这个field的数据类型, 暂时没有写上去
    // private String metadata  unknown type
    private Credential credential;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public Boolean getLivemode() {
        return livemode;
    }

    public void setLivemode(Boolean livemode) {
        this.livemode = livemode;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getRefunded() {
        return refunded;
    }

    public void setRefunded(Boolean refunded) {
        this.refunded = refunded;
    }

    public Boolean getReversed() {
        return reversed;
    }

    public void setReversed(Boolean reversed) {
        this.reversed = reversed;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Long getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Long order_no) {
        this.order_no = order_no;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getAmount_settle() {
        return amount_settle;
    }

    public void setAmount_settle(Integer amount_settle) {
        this.amount_settle = amount_settle;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public Long getTime_paid() {
        return time_paid;
    }

    public void setTime_paid(Long time_paid) {
        this.time_paid = time_paid;
    }

    public Long getTime_expire() {
        return time_expire;
    }

    public void setTime_expire(Long time_expire) {
        this.time_expire = time_expire;
    }

    public Long getTime_settle() {
        return time_settle;
    }

    public void setTime_settle(Long time_settle) {
        this.time_settle = time_settle;
    }

    public Integer getTransaction_no() {
        return transaction_no;
    }

    public void setTransaction_no(Integer transaction_no) {
        this.transaction_no = transaction_no;
    }

    public Refunds getRefunds() {
        return refunds;
    }

    public void setRefunds(Refunds refunds) {
        this.refunds = refunds;
    }

    public Integer getAmount_refunded() {
        return amount_refunded;
    }

    public void setAmount_refunded(Integer amount_refunded) {
        this.amount_refunded = amount_refunded;
    }

    public Integer getFailure() {
        return failure;
    }

    public void setFailure(Integer failure) {
        this.failure = failure;
    }

    public String getFailure_msg() {
        return failure_msg;
    }

    public void setFailure_msg(String failure_msg) {
        this.failure_msg = failure_msg;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DemoEntity [id=" + id + ", object=" + object + ", created=" + created + ", livemode=" + livemode + ", paid=" + paid + ", refunded="
                + refunded + ", reversed=" + reversed + ", app=" + app + ", channel=" + channel + ", order_no=" + order_no + ", client_ip="
                + client_ip + ", amount=" + amount + ", amount_settle=" + amount_settle + ", currency=" + currency + ", subject=" + subject
                + ", body=" + body + ", extra=" + extra + ", time_paid=" + time_paid + ", time_expire=" + time_expire + ", time_settle=" + time_settle
                + ", transaction_no=" + transaction_no + ", refunds=" + refunds + ", amount_refunded=" + amount_refunded + ", failure=" + failure
                + ", failure_msg=" + failure_msg + ", credential=" + credential + ", description=" + description + "]";
    }
    
    
    
}
