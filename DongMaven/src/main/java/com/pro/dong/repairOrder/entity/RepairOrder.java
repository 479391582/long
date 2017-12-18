package com.pro.dong.repairOrder.entity;



import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="RepairOrder") //Î¬ÐÞ¶©µ¥
public class RepairOrder{
					private String reid  ;
					private String rtype  ;
					private String rbrand  ;
					private String fault   ;
					private String remarks   ;
					private String status   ;
					private String cname    ;
					private String cphone     ;
					@GeneratedValue
					@Id
					public String getReid() {
						return reid;
					}
					public void setReid(String reid) {
						this.reid = reid;
					}
					public String getRtype() {
						return rtype;
					}
					public void setRtype(String rtype) {
						this.rtype = rtype;
					}
					public String getRbrand() {
						return rbrand;
					}
					public void setRbrand(String rbrand) {
						this.rbrand = rbrand;
					}
					public String getFault() {
						return fault;
					}
					public void setFault(String fault) {
						this.fault = fault;
					}
					public String getRemarks() {
						return remarks;
					}
					public void setRemarks(String remarks) {
						this.remarks = remarks;
					}
					public String getStatus() {
						return status;
					}
					public void setStatus(String status) {
						this.status = status;
					}
					public String getCname() {
						return cname;
					}
					public void setCname(String cname) {
						this.cname = cname;
					}
					public String getCphone() {
						return cphone;
					}
					public void setCphone(String cphone) {
						this.cphone = cphone;
					}
					
					
					
}
