package com.pro.dong.Shopping.entity;



import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="shopping") //½ÇÉ«±í
public class Shop{
					private String shid  ;
					private String shname  ;
					private String shprice  ;
					private String shtype    ;
					private String shbrand    ;
					private String shdescribe   ;
					private String cname;
					@GeneratedValue
					@Id
					public String getShid() {
						return shid;
					}
					public void setShid(String shid) {
						this.shid = shid;
					}
					public String getShname() {
						return shname;
					}
					public void setShname(String shname) {
						this.shname = shname;
					}
					public String getShprice() {
						return shprice;
					}
					public void setShprice(String shprice) {
						this.shprice = shprice;
					}
					public String getShtype() {
						return shtype;
					}
					public void setShtype(String shtype) {
						this.shtype = shtype;
					}
					public String getShbrand() {
						return shbrand;
					}
					public void setShbrand(String shbrand) {
						this.shbrand = shbrand;
					}
					public String getShdescribe() {
						return shdescribe;
					}
					public void setShdescribe(String shdescribe) {
						this.shdescribe = shdescribe;
					}
					public String getCname() {
						return cname;
					}
					public void setCname(String cname) {
						this.cname = cname;
					}
					
					
				
					
					
					
					
					
}
