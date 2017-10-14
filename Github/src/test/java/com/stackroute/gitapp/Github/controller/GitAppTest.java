package com.stackroute.gitapp.Github.controller;

//import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.gitapp.Github.GitApplication;
import com.stackroute.gitapp.Github.Domain.UserModel;


/**
 * Unit test for simple App.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GitApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GitAppTest extends TestCase {
	 String user1;
	    @LocalServerPort
	    private int port;
	    TestRestTemplate restTemplate = new TestRestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    UserModel user;
//	    @Before
//	    public void setUp() throws Exception {
//	         user = new UserModel("3","Paul Dawson");
//	    }
	    private String createURLWithPort(String uri) {
	        return "http://localhost:" + port + uri;
	    }
	    
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSaveUser() throws Exception {
	    HttpEntity<UserModel> entity = new HttpEntity<UserModel>(user, headers);
	    ResponseEntity<String> response = restTemplate.exchange(
	            createURLWithPort("/home/user/add"),
	            HttpMethod.POST, entity, String.class);
	    assertNotNull(response);
	    String actual = response.getBody();
	    System.out.println(actual);
	    assertEquals("User saved successfully",actual);
	}
	@Test
	public void testList() throws Exception {
	    HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	    ResponseEntity<String> response = restTemplate.exchange(
	            createURLWithPort("home/user/list"),
	            HttpMethod.GET, entity, String.class);
	    assertNotNull(response);
	}
	@Test
	public void testGetUserbyId() throws Exception {
		HttpEntity<UserModel> entity = new HttpEntity<UserModel>(user, headers);
	    ResponseEntity<String> response = restTemplate.exchange(
	            createURLWithPort("home/user/userbyId/101"),
	            HttpMethod.GET, entity, String.class);
	    assertNotNull(response);
	}
	//@Test
	//public void testDeleteUser() throws Exception {
//}
}