package lk.hiranwj.app.api;

import lk.hiranwj.app.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void createUserAccount(@RequestBody UserDTO user) {

    }

    @PatchMapping("/me")
    public void updateUserAccountDetails() {

    }

    @GetMapping("/me")
    public void getUserAccountDetails(){

    }

    @DeleteMapping("/me")
    public void deleteUserAccount(){

    }
}
