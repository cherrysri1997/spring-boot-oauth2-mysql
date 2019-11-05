package com.hcc.oAuth2WithMySql.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2RefreshToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth2")
public class RevokeTokenController {
	
	@Autowired
	private TokenStore tokenStore;
	
	@RequestMapping("/revoke-token")
	public String logout(HttpServletRequest request) {
		try {
			String token = request.getHeader("Authorization").replace("bearer ", "").trim();
			if(token != null) {				
				OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
				if(accessToken != null) {					
					OAuth2RefreshToken refreshToken = accessToken.getRefreshToken();
					tokenStore.removeAccessToken(accessToken);
					if(refreshToken != null)
						tokenStore.removeRefreshToken(refreshToken);
				}
			}
			return "Successful Logout";
		} catch(Exception e) {
			return "Logout Failed";
		}
	}

}
