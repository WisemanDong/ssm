package com.qf.controller;

import com.qf.pojo.User;
import com.qf.service.UserService;
import com.qf.util.SendSMSUtil;
import com.qf.vo.ResultVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.qf.constant.SsmConstant.*;
import static com.yunpian.sdk.constant.YunpianConstant.USER;

/**
 * @BelongsProject: Java1904P3
 * @BelongsPackage: com.qf.controller
 * @Author: WisemanDong
 * @CreateTime: 2019-07-15 10:28
 * @Description: todo
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //发短信工具类
    @Autowired
    private SendSMSUtil sendSMSUtil;

    //跳转到注册页面
    @GetMapping("/register-ui")
    public String registerUi(){
        //转发到注册页面
        return "user/register";
    }

    //check-username
    @PostMapping("/check-username")
    @ResponseBody //不走驶入解析器,直接响应. 如果返回结果为pojo/Map类,自动映射成json.
    public ResultVO checkUsername(@RequestBody User user){
        //1.json数据需要反序列化成pojo对象
        //jsonlib               比较古老的json工具.           第三方依赖过多. 当pojo类过于复杂时可能出现问题
        //jackson               spring 默认使用的工具.        三个依赖
        //gson                  google的json工具              一个依赖
        //fastJSON              阿里巴巴的json工具            一个依赖

        //页面发送json数据时,接收的数据类型->map或者pojo类
        //1.调用service,判断用户名是否可用.
        Integer count = userService.checkUsername(user.getUsername());

        ////2.封装响应数据的Map
        //Map<String,Object> result =  new HashMap<>();
        //result.put("code",0);
        //result.put("msg","成功");
        //result.put("data",count);

        //2.使用ResultVO响应数据
        return new ResultVO(0,"成功",count);
    }

    //发送短信
    @PostMapping(value = "/send-sms",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String sendSMS(@RequestParam String phone, HttpSession session){
        //1.调用工具发短信
        String result = sendSMSUtil.sendSMS(session, phone);
        //2.将result响应给ajax引擎
        return result;
    }

    //执行注册
    @PostMapping("/register")
    public String register(@Valid User user,
                           BindingResult bindingResult,
                           String registerCode,
                           HttpSession session,
                           RedirectAttributes redirectAttributes){
        //1.校验验证码.
        if(!StringUtils.isEmpty(registerCode)){
            //验证码不为空.
            String code = (int)session.getAttribute(CODE)+"";
            if(!registerCode.equals(code)){
                //验证码不正确
                redirectAttributes.addAttribute("registerInfo","验证码错误!");
                return REDIRECT+REGISTER_UI;
            }
        }
        //2.校验参数是否合法.
        if(bindingResult.hasErrors()||StringUtils.isEmpty(registerCode)){
            //参数不合法
            String msg = bindingResult.getFieldError().getDefaultMessage();
            if(StringUtils.isEmpty(msg)){
                msg = "验证码为必填项,岂能不填!";
            }
            redirectAttributes.addAttribute("registerInfo",msg);
            return REDIRECT+REGISTER_UI;
        }
        //3.调用service执行注册功能.
        Integer count = userService.register(user);
        //4.根据service返回的结果跳转到指定页面.
        if(count == 1){
            //注册成功.
            return REDIRECT + LOGIN_UI;
        }else{
            //注册失败
            redirectAttributes.addAttribute("registerInfo","服务器炸了!!!");
            return REDIRECT+REGISTER_UI;
        }
    }

    //跳转到登录页面
    @GetMapping("/login-ui")
    public String loginUI(){
        return "user/login";
    }

    //执行登录
    @PostMapping("/login")
    @ResponseBody
    public ResultVO login(String username,String password,HttpSession session){
        //1.校验参数是否合法.
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            //参数不和法
            return new ResultVO(1,"用户名和密码为必填项,岂能不填!",null);
        }
        //2.调用service执行登录.
        User user = userService.login(username,password);
        //User user = null;
        //3.根据service返回结果并判断登录是否成功.
        if(user != null){
            //4.如果成功,将用户的信息放到session域中.
            session.setAttribute(USER,user);
            return new ResultVO(0,"成功",null);
        }else{
            //5.如果失败,响应错误信息给ajax引擎.
            return new ResultVO(2,"用户名或密码错误!",null);
        }
    }

}
