package com.yoprogramo.allinone.login.presenter;

import com.yoprogramo.allinone.login.LoginActivityMVP;
import com.yoprogramo.allinone.login.model.User;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;


public class PresenterImplTests {

    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockLoginView;
    PresenterImpl presenter;
    User user;

    @Before
    public void setup(){
        mockLoginModel = mock(LoginActivityMVP.Model.class);
        user = new User(0, "Fox", "Muller");

        mockLoginView = mock(LoginActivityMVP.View.class);
        presenter = new PresenterImpl(mockLoginModel);
//        presenter.setView(mockLoginView);
    }


    @Test
    public void noInteractionWithView(){
//        when(mockLoginModel.getUser()).thenReturn(null);
        presenter.getCurrentUser();
        verifyNoInteractions(mockLoginView);
    }


    @Test
    public void load_the_user_from_repository_when_valid_user_is_present(){
        when(mockLoginModel.getUser()).thenReturn(user);
        presenter.getCurrentUser();
        verify(mockLoginModel, times(1)).getUser();

        //verify view interaction
        verify(mockLoginView, times(1)).setFirstName(user.getUserName());
        verify(mockLoginView,times(1)).setLastName(user.getLastName());
        verify(mockLoginView, never()).shouldNotNotAvailable();
    }

}
