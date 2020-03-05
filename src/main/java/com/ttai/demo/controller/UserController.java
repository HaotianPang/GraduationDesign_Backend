package com.ttai.demo.controller;


import com.google.gson.Gson;
import com.ttai.demo.entity.User;
import com.ttai.demo.pojo.ResponseResult;
import com.ttai.demo.pojo.ResultEnum;
import com.ttai.demo.pojo.dto.Token;
import com.ttai.demo.pojo.dto.UserRegister;
import com.ttai.demo.service.UserService;
import com.ttai.demo.utils.TokenUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "sign")
/**
 * 用户登录于注册的逻辑
 */
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "up")
    public ResponseResult userSignUp(@RequestParam("UserData") String userData){
        System.out.println("+++++++++++执行注册流程+++++++");
        Gson gson=new Gson();
        UserRegister userRegister=gson.fromJson(userData, UserRegister.class);
        if(userService.getIdByPhone(userRegister.getPhoneNumber())==null){
            User user=new User();
            user.setPassword(userRegister.getPassword());
            user.setPhonenumber(userRegister.getPhoneNumber());
            userService.insertUser(user);
            User temp=userService.getIdByPhone(userRegister.getPhoneNumber());
            Token token=new Token();
            token.setToken(TokenUtil.createJWT(String .valueOf(temp.getId()),"pht","rightful_user"));
            String data=gson.toJson(token);
            return new ResponseResult(ResultEnum.SUCCESS,data);
        }else{
            return new ResponseResult(ResultEnum.ACCOUNT_ALREADY_EXIST);
        }
    }

    /**
     *
     * @param userInfo 用户上传电话号码和密码，filter查询过数据库后添加上id
     * @return
     */
    @PostMapping(value = "in")
    public ResponseResult userSignIn(@RequestParam("UserInfo")String userInfo){
        Gson gson=new Gson();
        UserRegister userRegister=gson.fromJson(userInfo,UserRegister.class);
        User temp=userService.getIdByPhone(userRegister.getPhoneNumber());
        if(temp!=null){
            if(temp.getPassword().equals(userRegister.getPassword())){
//                Token token=new Token();
//                String jwtToken= TokenUtil.createJWT(String .valueOf(temp.getId()),"pht","rightful_user");
//                token.setToken(jwtToken);
//                String data=gson.toJson(token);
//                System.out.println("Token is +++++++++:"+data);
                Token token=new Token();
                token.setToken(TokenUtil.createJWT(String .valueOf(temp.getId()),"pht","rightful_user"));
                String data=gson.toJson(token);
                return new ResponseResult(ResultEnum.SUCCESS,data);
            }
            return new ResponseResult(ResultEnum.ACCOUNT_PASSWORD_WRONG);
        }else{
            return new ResponseResult(ResultEnum.ACCOUNT_DONOT_EXIST);
        }

    }

    @PostMapping(value = "token")
    public ResponseResult loginByToken(@RequestParam("token") String token){
        String id=TokenUtil.parseJWT(token);
        if (id == null) {
            return new ResponseResult(ResultEnum.COMMON_TOKEN_ERROR);
        }else{
            Gson gson=new Gson();
            String tokenJWT=TokenUtil.createJWT(id,"pht","rightful_user");
            Token temp=new Token();
            temp.setToken(tokenJWT);
            String reToken=gson.toJson(temp);
            return new ResponseResult(ResultEnum.SUCCESS,reToken);
        }
    }
}
