package com.codegym.meeting_room_management.webservice.controller.userController;

import com.codegym.meeting_room_management.dao.entity.Role;
import com.codegym.meeting_room_management.dao.entity.User;
import com.codegym.meeting_room_management.service.RoleService;
import com.codegym.meeting_room_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RequestMapping("")public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;
    //------------------------------- list role -------------------------
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    public ResponseEntity<List<Role>> listAllRole() {
        List<Role> roles = roleService.findAllRole();
        return roles.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(roles, HttpStatus.OK);
    }

    //--------------------------------- details role ---------------------------
    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Role> getRole(@PathVariable("id") int id) {
        Role role = roleService.findRoleById(id);
        return role == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(role, HttpStatus.OK);
    }

    //------------------------------- list user -------------------------
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUserList() {
        List<User> users = userService.getListAllUser();
        return users.isEmpty() ? new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    //---------------------- list user ---------------------------------
    @RequestMapping(value = "/user", method = RequestMethod.GET, params = {"page", "size", "search"})
    public ResponseEntity<Page<User>> listAllUser(@RequestParam("page") int page,
                                                        @RequestParam("size") int size,
                                                        @RequestParam("search") String search,
                                                        @RequestParam("role") String nameRole) {
        Page<User> userPage = userService.findAllUserWithPage(search, PageRequest.of(page, size, Sort.by("userId").ascending()));
        return userPage.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(userPage, HttpStatus.OK);
    }

    //--------------------- create user --------------------------------------------------
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        User user1 = userService.findUserByUserName(user.getUsername());
        if (user1 != null) {
            throw new UsernameNotFoundException("Tên đăng nhập đã tồn tại");
        } else {
            user.setPassword((passwordEncoder.encode(user.getPassword())));
            userService.save(user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponentsBuilder.path("user?page=0&size=5&search=").buildAndExpand(user.getUserId()).toUri());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        }
    }
}
