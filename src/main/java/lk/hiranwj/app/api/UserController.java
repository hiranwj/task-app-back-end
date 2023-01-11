package lk.hiranwj.app.api;

import lk.hiranwj.app.dto.UserDTO;
import lk.hiranwj.app.service.custom.UserService;
import lk.hiranwj.app.util.ValidationGroups;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void createUserAccount(@Validated(ValidationGroups.Create.class) @Valid @RequestBody UserDTO user) {
        userService.createNewUserAccount(user);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/me", consumes = "application/json")
    public void updateUserAccountDetails(@Valid @RequestBody UserDTO user) {
        System.out.println(user);
    }

    @GetMapping(value = "/me", produces = "application/json")
    public UserDTO getUserAccountDetails(){
        System.out.println("getUserAccountDetails()");
        return new UserDTO();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/me")
    public void deleteUserAccount(){
        System.out.println("deleteUserAccount()");
    }
}
