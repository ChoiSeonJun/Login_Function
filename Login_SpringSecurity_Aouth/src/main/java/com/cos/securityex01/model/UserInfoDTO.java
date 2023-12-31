package com.cos.securityex01.model;

import org.apache.ibatis.type.Alias;

// 마이페이지 또는 추가 정보용 DTO

@Alias("UserInfoDTO")
public class UserInfoDTO {
	int id;
	String createDate;
	String email;
	String password;
	String provider;
	String providerId;
	String role;
	String username;
	
	String nickname;
	String profileImage;
	String pofoLink;
	String phone;
	String intro;
	
	public UserInfoDTO() {}

	public UserInfoDTO(int id, String createDate, String email, String password, String provider, String providerId,
			String role, String username, String nickname, String profileImage, String pofoLink, String phone,
			String intro) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.email = email;
		this.password = password;
		this.provider = provider;
		this.providerId = providerId;
		this.role = role;
		this.username = username;
		this.nickname = nickname;
		this.profileImage = profileImage;
		this.pofoLink = pofoLink;
		this.phone = phone;
		this.intro = intro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getPofoLink() {
		return pofoLink;
	}

	public void setPofoLink(String pofoLink) {
		this.pofoLink = pofoLink;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [id=" + id + ", createDate=" + createDate + ", email=" + email + ", password=" + password
				+ ", provider=" + provider + ", providerId=" + providerId + ", role=" + role + ", username=" + username
				+ ", nickname=" + nickname + ", profileImage=" + profileImage + ", pofoLink=" + pofoLink + ", phone="
				+ phone + ", intro=" + intro + "]";
	}
	
	
}
