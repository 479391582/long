package com.pro.dong.commOrder.entity;



import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="commOrder") //…Ã∆∑∂©µ•
public class CommOrder{
					private String coid   ;
					private String coname   ;
					private String coprice   ;
					private String cotype    ;
					private String cobrand    ;
					private String status    ;
					private String cname     ;
					private String cphone     ;
					@GeneratedValue
					@Id
					public String getCoid() {
						return coid;
					}
					public void setCoid(String coid) {
						this.coid = coid;
					}
					public String getConame() {
						return coname;
					}
					public void setConame(String coname) {
						this.coname = coname;
					}
					public String getCoprice() {
						return coprice;
					}
					public void setCoprice(String coprice) {
						this.coprice = coprice;
					}
					public String getCotype() {
						return cotype;
					}
					public void setCotype(String cotype) {
						this.cotype = cotype;
					}
					public String getCobrand() {
						return cobrand;
					}
					public void setCobrand(String cobrand) {
						this.cobrand = cobrand;
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
