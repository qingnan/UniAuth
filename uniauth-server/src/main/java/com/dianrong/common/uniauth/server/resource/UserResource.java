package com.dianrong.common.uniauth.server.resource;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.dianrong.common.uniauth.common.bean.Response;
import com.dianrong.common.uniauth.common.bean.dto.UserDto;
import com.dianrong.common.uniauth.common.bean.request.UserParam;
import com.dianrong.common.uniauth.common.bean.request.UserQuery;
import com.dianrong.common.uniauth.common.interfaces.IUserResource;

/**
 * Created by Arc on 14/1/16.
 */
@RestController
public class UserResource implements IUserResource {
    @Override
    public Response<String> testResult(UserQuery userQuery) {
        throw new RuntimeException();
        //return Response.success();
    }

	@Override
	public Response<String> addUser(UserParam userParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<List<UserDto>> searchUser(UserQuery userQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response<String> updateUser(UserParam userParam) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
