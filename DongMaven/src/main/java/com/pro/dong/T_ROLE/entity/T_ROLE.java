package com.pro.dong.T_ROLE.entity;



import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="T_ROLE") //½ÇÉ«±í
public class T_ROLE{
					private String rid                ;
					private String rname            ;
					private String rdescribe                ;
					private String fid            ;
					@GeneratedValue
					@Id
					public String getRid() {
						return rid;
					}
					public void setRid(String rid) {
						this.rid = rid;
					}
					public String getRname() {
						return rname;
					}
					public void setRname(String rname) {
						this.rname = rname;
					}
					public String getRdescribe() {
						return rdescribe;
					}
					public void setRdescribe(String rdescribe) {
						this.rdescribe = rdescribe;
					}
					public String getFid() {
						return fid;
					}
					public void setFid(String fid) {
						this.fid = fid;
					}
					
					
					
					
					
}
