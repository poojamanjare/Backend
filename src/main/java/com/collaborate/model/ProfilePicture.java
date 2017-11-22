package com.collaborate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class ProfilePicture 
{
	@Id
	private String userId;
		@Lob
		
	private byte[] pimage;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public byte[] getPimage() {
			return pimage;
		}
		public void setPimage(byte[] pimage) {
this.pimage = pimage;
		}
}
