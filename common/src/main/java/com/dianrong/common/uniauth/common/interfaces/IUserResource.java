package com.dianrong.common.uniauth.common.interfaces;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dianrong.common.uniauth.common.bean.Response;
import com.dianrong.common.uniauth.common.bean.dto.UserDto;
import com.dianrong.common.uniauth.common.bean.request.UserParam;
import com.dianrong.common.uniauth.common.bean.request.UserQuery;

/**
 * Created by Arc on 14/1/16.
 */
@Path("user")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public interface IUserResource {
    @POST
    @Path("test")
    Response<String> testResult(UserQuery userQuery);
    
    @POST
    @Path("add")
    //scenario: add user
    Response<String> addUser(UserParam userParam);
    
    @POST
    @Path("search")
    //scenario: search user
    Response<List<UserDto>> searchUser(UserQuery userQuery);
    
    @POST
    @Path("update")
    //scenario: update user(including lock, disable, reset password, update profile)
    Response<String> updateUser(UserParam userParam);
    
}
