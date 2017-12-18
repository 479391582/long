package com.pro.dong.T_ROLE.entity;



import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="T_USER_ROLE") //员工角色表
public class T_USER_ROLE{
					private String urid                ;
					private String userid            ;
					private String rid                ;
					@GeneratedValue
					@Id
					public String getUrid() {
						return urid;
					}
					public void setUrid(String urid) {
						this.urid = urid;
					}
					public String getUserid() {
						return userid;
					}
					public void setUserid(String userid) {
						this.userid = userid;
					}
					public String getRid() {
						return rid;
					}
					public void setRid(String rid) {
						this.rid = rid;
					}
					
				
					
					
					
					
}
