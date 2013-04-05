package jk.sunlabs.kms.controller;

import javax.servlet.http.HttpSession;

import jk.sunlabs.kms.vo.LoginStatusVO;
import jk.sunlabs.kms.vo.RoleVO;
import jk.sunlabs.kms.vo.UserVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {


 @RequestMapping(value="login.do",method=RequestMethod.GET,produces="application/json")
 @ResponseBody
	public LoginStatusVO doLogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password,HttpSession session)throws Exception
	{
	
	 LoginStatusVO loginStatus = new LoginStatusVO();
	 
	 if(!userName.equalsIgnoreCase("ejk"))
	 {
		 loginStatus.setStatus(false);
		 return loginStatus;
		 
	 }
		System.out.println(userName);
		System.out.println(password);
		
		RoleVO role = new RoleVO();
		role.setRoleDescription("Administrator role");
		role.setRoleID(1);
		role.setRoleName("Administrator");
		
		UserVO user = new UserVO();
		user.setFirstName("Jagadish Kumar");
		user.setLastName("Ekambaram");
		user.setPassword("ejk");
		user.setUserID(1);
		user.setUserName("ejk");
		user.setRole(role);
		
		session.setAttribute("USER_CREDS", user);
		
		loginStatus.setStatus(true);
		loginStatus.setUserName(userName);
		
		return loginStatus;
	}

}
