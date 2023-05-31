package capstone.petbible.controller;

import capstone.petbible.dto.UserDTO;
import capstone.petbible.request.CreateUserRequest;
import capstone.petbible.request.UpdateUserRequest;
import capstone.petbible.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userNo}")
    public ResponseEntity<UserDTO> getUserByUserNo(@PathVariable Long userNo) {
        UserDTO userDTO = userService.getUserByUserNo(userNo);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserRequest request) {
        UserDTO userDTO = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @PatchMapping("/{userNo}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userNo, @RequestBody UpdateUserRequest request) {
        UserDTO userDTO = userService.updateUser(userNo, request.getUserPw(), request.getNewEmail());
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{userNo}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long userNo) {
        userService.deleteUser(userNo);
        return ResponseEntity.noContent().build();
    }
}
