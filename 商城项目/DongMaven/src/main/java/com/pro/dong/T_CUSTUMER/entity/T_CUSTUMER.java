package com.pro.dong.T_CUSTUMER.entity;



import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="T_CUSTUMER") //¿Í»§±í
public class T_CUSTUMER{
					private String cid   ;
					private String cname   ;
					private String cpwd         ;
					private String crealname     ;
					private String cphone        ;
					private String address       ;
					@GeneratedValue
					@Id
					public String getCid() {
						return cid;
					}
					public void setCid(String cid) {
						this.cid = cid;
					}
					public String getCname() {
						return cname;
					}
					public void setCname(String cname) {
						this.cname = cname;
					}
					public String getCpwd() {
						return cpwd;
					}
					public void setCpwd(String cpwd) {
						this.cpwd = cpwd;
					}
					public String getCrealname() {
						return crealname;
					}
					public void setCrealname(String crealname) {
						this.crealname = crealname;
					}
					public String getCphone() {
						return cphone;
					}
					public void setCphone(String cphone) {
						this.cphone = cphone;
					}
					public String getAddress() {
						return address;
					}
					public void setAddress(String address) {
						this.address = address;
					}
					
					
					
					
					
}
