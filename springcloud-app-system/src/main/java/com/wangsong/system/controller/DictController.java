package com.wangsong.system.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangsong.common.controller.BaseController;
import com.wangsong.system.groups.DictAdd;
import com.wangsong.system.groups.DictUpdate;
import com.wangsong.system.model.Dict;
import com.wangsong.system.model.DictPage;
import com.wangsong.system.service.DictService;
@RefreshScope//test
@Controller
@RequestMapping("/system/dict")
public class DictController extends BaseController{

	@Value(value = "${shiro_redis_cache}")
	private int shiro_redis_cache;//test

	@Autowired
	private DictService dictService;
	
	@RequiresPermissions("/system/dict/list")
	@RequestMapping(value="/list")
	@ResponseBody
	public Object list(DictPage dict) {
		return dictService.findTByPage(dict);
	}
	@RequiresPermissions("/system/dict/add")
	@RequestMapping(value="/add")
	@ResponseBody
	public Object add(@Validated({DictAdd.class}) Dict dict,BindingResult bindingResult) {
		return dictService.insertDict(dict);
	}
	
	@RequiresPermissions("/system/dict/update")
	@RequestMapping(value="/update")
	@ResponseBody
	public Object update(@Validated({DictUpdate.class}) Dict dict,BindingResult bindingResult) {
		return dictService.updateByPrimaryKeyDict(dict);
	}
	
	@RequiresPermissions("/system/dict/delete")
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object delete(String[] id) {
		return dictService.deleteByPrimaryKeyDict(id);
	}
	
	@RequestMapping(value="/findDictByDict")
	@ResponseBody
	public Object findDictByDict(Dict dict) {
		return dictService.findTByT(dict);
	}
	
	@RequestMapping(value="/selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String id) {
		return dictService.selectByPrimaryKey(id);
	}


	@HystrixCommand(fallbackMethod = "test2")
	@RequestMapping(value="/test")
	@ResponseBody
	public Object test() {
		return 1;
	}

	public Object test2() {
		return 2;
	}
}
