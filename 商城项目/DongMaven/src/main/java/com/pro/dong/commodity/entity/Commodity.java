package com.pro.dong.commodity.entity;



import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="commodity") //…Ã∆∑±Ì
public class Commodity{
					private String cid ;
					private String cname ;
					private String cprice ;
					private String fid  ;
					private String ctype  ;
					private String cbrand  ;
					private String describe   ;
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
					public String getCprice() {
						return cprice;
					}
					public void setCprice(String cprice) {
						this.cprice = cprice;
					}
					public String getFid() {
						return fid;
					}
					public void setFid(String fid) {
						this.fid = fid;
					}
					public String getCtype() {
						return ctype;
					}
					public void setCtype(String ctype) {
						this.ctype = ctype;
					}
					public String getCbrand() {
						return cbrand;
					}
					public void setCbrand(String cbrand) {
						this.cbrand = cbrand;
					}
					public String getDescribe() {
						return describe;
					}
					public void setDescribe(String describe) {
						this.describe = describe;
					}
			
					
					
}
