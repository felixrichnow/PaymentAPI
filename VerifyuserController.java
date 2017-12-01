package Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VerifyuserController {

    @Autowired
    private UserService userService;

    public VerifyuserController() {
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public ResponseEntity<Object> verifyuser(@RequestBody Verifyuser verifyuser) {

        if (verifyuser != null) {
            //If condition is TRUE
            if (userService.checkUserInfo(verifyuser.getUserId())) {

                String tempId = verifyuser.getUserId();
                UserInfo userInfo = userService.getUserInfo(tempId);


                return new ResponseEntity<>(userInfo, HttpStatus.OK);
            }
            //If condition is FALSE
            else {

                FalseResponse falseResponse = new FalseResponse();

                falseResponse.setUserId(verifyuser.getUserId());
                falseResponse.setErrCode("123");
                falseResponse.setErrMsg("Unknown userId");
                falseResponse.setSuccess(false);

                return new ResponseEntity<Object>(falseResponse, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<Object>(verifyuser, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserInfo> getAllUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public UserInfo getUserInfo(@PathVariable String id) {
        return userService.getUserInfo(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void putUserInfo(@RequestBody UserInfo putuser) {
        userService.putUserInfo(putuser);
    }

    @RequestMapping(value = "/removeuser", method = RequestMethod.POST)
    public void removeUserInfo(@RequestBody UserInfo removeuser) {
        userService.removeUserInfo(removeuser);
    }

}