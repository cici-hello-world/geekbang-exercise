package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImp;
import org.geektimes.web.mvc.controller.PageController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * author:cici
 */
@Path("/user")
public class UserController implements PageController {
    private final UserService userService=new UserServiceImp();


    @POST
    @Path("/register")
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        System.out.println("请求成功");
        String mobile = (String) request.getAttribute("mobile");
        System.out.println("mobile:"+mobile);
        User user = new User();
        user.setPhoneNumber(mobile);
        if (userService.register(user)){
            return "register-success.jsp";
        }
         return "注册失败";
    }

}
