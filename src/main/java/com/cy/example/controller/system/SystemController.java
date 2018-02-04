package com.cy.example.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.cy.example.config.WebConfig;
import com.cy.example.entity.system.LoginRecordEntity;
import com.cy.example.entity.system.SysDepartmentEntity;
import com.cy.example.entity.system.SysMenuEntity;
import com.cy.example.entity.system.SysPermissionEntity;
import com.cy.example.entity.system.SysRoleEntity;
import com.cy.example.entity.system.SysUserEntity;
import com.cy.example.service.IDepartmentService;
import com.cy.example.service.ILoginRecordService;
import com.cy.example.service.IMenuService;
import com.cy.example.service.IPermissionService;
import com.cy.example.service.IRoleService;
import com.cy.example.service.IUserService;

@Controller
public class SystemController {
	
	@Autowired
	private IPermissionService permisService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IMenuService menuService;
	
	@Autowired
	private ILoginRecordService loginRecordService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Value("${swallow.system.name}")
	private String SYS_NAME;

	@RequestMapping("/index")
	public String showIndex(ModelMap map) {
		map.put("SYS_NAME", SYS_NAME);
		return "index";
	}

	@RequestMapping("/main")
	public String showMain(HttpSession session, ModelMap map) {
		SysUserEntity user = (SysUserEntity) session
				.getAttribute(WebConfig.LOGIN_USER);
		List<SysMenuEntity> menuList = menuService.findAll();
		Map<String, List<SysMenuEntity>> data = new HashMap<String, List<SysMenuEntity>>();
		for (int i = 0; i < menuList.size(); i++) {
			if("[root]".equals(menuList.get(i).getC_node())){
				List<SysMenuEntity> tool = new ArrayList<SysMenuEntity>();
				for (int j = 0; j < menuList.size(); j++) {
					if(String.valueOf(menuList.get(i).getId()).equals(menuList.get(j).getC_node())){
						tool.add(menuList.get(j));
					}
				}
				data.put(menuList.get(i).getC_menuName(), tool);
			}
		}
		//在线人数统计
		map.put("user", user);
		map.put("menuList", data);
		map.put("SYS_NAME", SYS_NAME);
		map.put("activeNum", WebConfig.getActiveUserSum());
		return "main/main";
	}

	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session, ModelMap map) {
		map.put("SYS_NAME", SYS_NAME);
		session.removeAttribute(WebConfig.LOGIN_USER);
		return "index";
	}
	
	@RequestMapping("/menu/home")
	public String showHome(ModelMap map) {
		Map<String, Object> loginRecord = loginRecordService.recentLoginCount();
		Page<LoginRecordEntity> recordList = loginRecordService.selectPage(new Page<LoginRecordEntity>(1, 20)
				, new EntityWrapper<LoginRecordEntity>().orderBy("c_createDate",false));
		
		map.put("loginRecord", loginRecord);
		map.put("recordList", recordList.getRecords());
		return "main/home";
	}

	@RequestMapping("/menu/calendarManage")
	public String calendarManage() {
		return "calendarManage";
	}

	@RequestMapping("/menu/userManage")
	public String userManage(ModelMap map) {
		List<SysDepartmentEntity> departList = departmentService.selectList(new EntityWrapper<SysDepartmentEntity>());
		map.put("departList", departList); 
		return "userManage";
	}
	
	@RequestMapping("/menu/menuManage")
	public String menuManage(ModelMap map) {
		List<SysMenuEntity> menuList = menuService.findRoot();
		map.put("menuList", menuList);
		return "menuManage";
	}

	@RequestMapping("/menu/loginRecordManage")
	public String loginRecordManage() {
		return "loginRecordManage";
	}

	@RequestMapping("/menu/uploadFile")
	public String uploadFile() {
		return "test_uploadFile";
	}
	
	@RequestMapping("/menu/roleManage")
	public String roleManage() {
		return "roleManage";
	}
	
	@RequestMapping("/menu/permissionManage")
	public String permissionManage() {
		return "permissionManage";
	}
	
	@RequestMapping("/menu/user_roleManage")
	public String user_roleManage(ModelMap map) {
		List<SysUserEntity> userList = userService.selectList(new EntityWrapper<SysUserEntity>());
		List<SysRoleEntity> roleList = roleService.selectList(new EntityWrapper<SysRoleEntity>());
		map.put("userList", userList);
		map.put("roleList", roleList);
		return "user_roleManage";
	}
	
	@RequestMapping("/menu/role_permisManage")
	public String role_permisManage(ModelMap map) {
		List<SysPermissionEntity> permisList = permisService.selectList(new EntityWrapper<SysPermissionEntity>());
		List<SysRoleEntity> roleList = roleService.selectList(new EntityWrapper<SysRoleEntity>());
		map.put("permisList", permisList);
		map.put("roleList", roleList);
		return "role_permisManage";
	}
	
	@RequestMapping("/menu/workflow/deployManage")
	public String deployManage(ModelMap map) {
		
		return "workflow/deployManage";
	}
	
	@RequestMapping("/menu/workflow/processDefinitionManage")
	public String processDefinitionManage(ModelMap map) {
		return "workflow/processDefinitionManage";
	}
	
	@RequestMapping("/menu/workflow/leaveBillManage")
	public String leaveBillManage(ModelMap map) {
		return "workflow/leaveBillManage";
	}
	
	@RequestMapping("/menu/workflow/taskManage")
	public String taskManage(ModelMap map) {
		return "workflow/taskManage";
	}
	
	@RequestMapping("/menu/departmentManage")
	public String departmentManage(ModelMap map) {
		return "departmentManage";
	}
	
	@RequestMapping("/courtBusiness/nonStandardProductAttr/api.sdo")
	@ResponseBody
	public Map<String, Object> test() {
		List<Map<String, Object>> l = new ArrayList<Map<String, Object>>();
		
//		l.add('SL':'','SHLL':'','JXLX':'','QXRQ':'','ZXRQ':'','SFBB':'','FHMS':'','JYSC':'','CPNM':'','JYBZ':'','FXSJ':'','MSGS':'','BJYZ':'','JSFS':''");
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("SHR", "0");
		m.put("BZ", "");
		m.put("CPLX", "");
		m.put("GZFS", "");
		m.put("PMJE", "");
		m.put("DQSJ", "");
		m.put("FXPL", "");
		m.put("SQLL", "");
		m.put("", "");
		m.put("", "");
		m.put("", "");
		m.put("", "");
		m.put("PZDM", "ZYZX06");
		m.put("PZMC", "招盈智兴六号资管管理计划");
		m.put("GLR", "");
		m.put("YJFL", "");
		m.put("EJFL", "");
		m.put("SJFL", "254");
		m.put("JZLY", "");
		m.put("JXFS", "");
		m.put("F", "ZYZX06招盈智兴六号资管管理计划");
		m.put("LWBS", "0");
		m.put("BDZZXS", "");
		m.put("BAQK", "");
		m.put("DKLXSR", "");
		m.put("JRCPZLSR", "");
		m.put("SIJFL", "");
		m.put("JXBADM", "");
		m.put("ZT", "2");
		m.put("WHSJ", "2017-07-24 15:11:05.0");
		l.add(m);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "1");
		map.put("note", "1");
		map.put("data",l );
		return map;
	}
}
