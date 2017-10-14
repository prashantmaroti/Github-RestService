package com.stackroute.gitapp.Github.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.stackroute.gitapp.Github.Domain.UserModel;
import com.stackroute.gitapp.Github.Repository.UserDetails;
import com.stackroute.gitapp.Github.Services.GitService_db;

public class ServiceTest {
	private GitService_db service;
    @Mock
    private UserDetails userrepo;
    @Mock
    private UserModel user;
    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        service=new GitService_db();
        service.setUserDetails(userrepo);
    }
    @Test
    public void shouldReturnProduct_whenGetProductByIdIsCalled() throws Exception {
        // Arrange
        when(userrepo.findOne("5")).thenReturn(user);
        // Act
        UserModel retrievedUser = service.getUserbyId("5");
        // Assert
        assertThat(retrievedUser, is(equalTo(user)));

   }
    @Test
    public void shouldReturnUser_whenSaveUserIsCalled() throws Exception {
        // Arrange
        when(userrepo.save(user)).thenReturn(user);
        // Act
       UserModel saveduser = service.addUser(user);
        // Assert
        assertThat(saveduser, is(equalTo(user)));
    }
    @Test
    public void shouldCallDeleteMethodOfProductRepository_whenDeleteProductIsCalled() throws Exception {
        // Arrange
        doNothing().when(userrepo).delete("5");
        UserDetails my = Mockito.mock(UserDetails.class);
        // Act
        service.DeletebyId("5");
        // Assert
        verify(userrepo, times(1)).delete("5");
    }
}
