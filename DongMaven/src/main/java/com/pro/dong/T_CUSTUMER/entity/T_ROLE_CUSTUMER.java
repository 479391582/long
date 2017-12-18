package com.pro.dong.T_CUSTUMER.entity;



import javax.persistence.Entity;
import javax.persistence.Table;



import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="T_ROLE_CUSTUMER") //¿Í»§±í
public class T_ROLE_CUSTUMER{
								private String	trcid; 
								private String	 cid ;
								private String	 rid ;
								@GeneratedValue
								@Id
								public String getTrcid() {
									return trcid;
								}
								public void setTrcid(String trcid) {
									this.trcid = trcid;
								}
								public String getCid() {
									return cid;
								}
								public void setCid(String cid) {
									this.cid = cid;
								}
								public String getRid() {
									return rid;
								}
								public void setRid(String rid) {
									this.rid = rid;
								}
							
					
					
					
					
					
}
