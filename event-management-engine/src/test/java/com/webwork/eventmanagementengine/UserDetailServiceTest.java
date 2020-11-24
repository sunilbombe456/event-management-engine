//package com.webwork.eventmanagementengine;
//
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.Test;
//
//import com.webwork.eventmanagementengine.entity.User;
//import com.webwork.eventmanagementengine.service.impl.UserDetailServiceImpl;
//
//public class UserDetailServiceTest {
//	
//	private UserDetailServiceImpl  userDetailService;
//	
//	@Before
//	public void setup() throws Exception{
//		userDetailService = new UserDetailServiceImpl(new User());
//	}
//	
//	@Test
//	public void testUserDetaisl() throws Exception {
//		userDetailService.getAuthorities();
//		assertNotNull(actual);
//		
//	}
//
//	@after
//	public void tearDown() throws Exception{
//		userDetailService = null;
//	}
//	
//}
