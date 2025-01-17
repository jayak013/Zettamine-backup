package com.zettamine.boot.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
//@ConfigurationProperties(prefix = "jdbc")
//@PropertySource(value = "classpath:dbconfig.properties")
public class DBConfiguration {
	//@Value("${driverClass}")
	private String driverClass;
	private String url;
	private String username;
	private String password;

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "DBConfiguration [driverClass=" + driverClass + ", url=" + url + ", username=" + username + ", password="
				+ password + "]";
	}

}
