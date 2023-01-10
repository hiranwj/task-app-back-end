package lk.hiranwj.app.api;

import lk.hiranwj.app.dto.UserDTO;
import lk.hiranwj.app.util.ValidationGroups;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void createUserAccount(@Validated(ValidationGroups.Create.class) @Valid @RequestBody UserDTO user) {
//    public void createUserAccount(@Valid @RequestBody UserDTO user, Errors errors) {
        System.out.println(user);
//        Optional<FieldError> firstError = errors.getFieldErrors().stream().findFirst();
//        if (firstError.isPresent()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, firstError.get().getDefaultMessage());
//        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(value = "/me", consumes = "application/json")
    public void updateUserAccountDetails(@Valid @RequestBody UserDTO user) {
        System.out.println(user);
    }

    @GetMapping("/me")
    public void getUserAccountDetails(){

    }

    @DeleteMapping("/me")
    public void deleteUserAccount(){

    }
}
