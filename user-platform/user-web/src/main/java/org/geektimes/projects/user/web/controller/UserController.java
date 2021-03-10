package org.geektimes.projects.user.web.controller;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.service.impl.UserServiceImpl;
import org.geektimes.web.mvc.controller.PageController;

import javax.annotation.Resource;
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

    private UserService userService= new UserServiceImpl();
    @Path("/register/form")
    @GET
    public String registerJsp(HttpServletRequest request, HttpServletResponse response){
        return "register-form.jsp";
    }

    @POST
    @Path("/register")
    public String register(HttpServletRequest request, HttpServletResponse response) throws Throwable {
        System.out.println("请求成功");
        String mobile = (String) request.getParameter("inputMobile");
        String email = (String) request.getParameter("inputEmail");
        String name = (String) request.getParameter("inputName");
        String password = (String) request.getParameter("inputPassword");
        String repeatPassword = (String) request.getParameter("repeatPassword");
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(mobile);
        user.setEmail(email);
        user.setPassword(password);
        System.out.println(userService);
        userService.register(user);
        return "register-success.jsp";
    }
    public UserController(){}

}
