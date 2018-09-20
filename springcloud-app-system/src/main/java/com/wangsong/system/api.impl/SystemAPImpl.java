package com.wangsong.system.controller;

import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangsong.common.controller.BaseController;
import com.wangsong.system.model.Resources;
import com.wangsong.system.model.User;
import com.wangsong.system.service.ResourcesService;
import com.wangsong.system.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/api")
public class SystemAPImpl  extends BaseController {
	
		
	@Autowired
	private UserService userService;

	@Autowired
	private ResourcesService resourcesService;
	
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public Result<User> getUser(@RequestBody  User u) {
    	return new Result(CodeEnum.SUCCESS.getCode(), userService.findTByT(u));
    }

  
    @RequestMapping(value = "/getResources", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Resources>> getResources(@RequestBody  Resources r) {
    	return new Result(CodeEnum.SUCCESS.getCode(), resourcesService.findTByT(r));
    }

    
}
