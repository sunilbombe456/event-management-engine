package com.webwork.event.management.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import com.webwork.event.management.dto.ResponseError;
import com.webwork.event.management.exception.AuthorizationException;
import com.webwork.event.management.service.impl.CustomUserDetailService;
import com.webwork.event.management.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	private Logger myLogger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	@CrossOrigin(origins="*")
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		String authorizationHeader = request.getHeader("authorization");

		String token = null;
		String userName = null;

		if (null != authorizationHeader) {

			token = authorizationHeader;
			
			// here we handle filter exception
			try {
				userName = jwtUtil.extractUsername(token);
			}catch(AuthorizationException e) {
				ResponseError error = new ResponseError();
				error.setStatus(HttpStatus.NOT_FOUND.value());
				error.setMessage(e.getMessage());
				error.setTimeStamp(System.currentTimeMillis());
				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	            response.getWriter().print(error);
				
			}

			// catch the filter exception
		}

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = customUserDetailService.loadUserByUsername(userName);

			if (jwtUtil.validateToken(authorizationHeader, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}

		}
		filterChain.doFilter(request, response);

	}

}
