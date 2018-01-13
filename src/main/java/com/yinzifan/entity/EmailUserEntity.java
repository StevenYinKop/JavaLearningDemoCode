package com.yinzifan.entity;
/**
* @author Cin
* @time 2018/01/03 21:00:39
*/
public class EmailUserEntity {

	/*
	 * CREATE TABLE USER(
       uid INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(20) DEFAULT NULL,
       password VARCHAR(20) DEFAULT NULL,
       nickname VARCHAR(20) DEFAULT NULL,
       email  VARCHAR(30) DEFAULT NULL,
       state INT(11) DEFAULT NULL,
       CODE VARCHAR(64) DEFAULT NULL
       )
       ENGINE=INNODB DEFAULT CHARSET=utf8;
	 */
	private Integer uid;
	private String userName;
	private String password;
	private String nickName;
	private String email;
	private Integer state;
	private String code;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
