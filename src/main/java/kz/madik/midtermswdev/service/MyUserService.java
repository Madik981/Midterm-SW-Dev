package kz.madik.midtermswdev.service;

import kz.madik.midtermswdev.entity.Permission;
import kz.madik.midtermswdev.entity.User;
import kz.madik.midtermswdev.repository.PermissionRepository;
import kz.madik.midtermswdev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Objects;

public class MyUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermissionRepository permissionRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(Objects.nonNull(user)) {     // if user != null
            return user;
        }

        throw new UsernameNotFoundException("User Not Found");
    }

    public void registr(User model){
        User check = userRepository.findByUsername(model.getUsername());
        if (check == null){
            model.setPassword(passwordEncoder.encode(model.getPassword()));
            List<Permission> permissions = List.of(permissionRep.findByName("ROLE_USER"));

            model.setPermissions(permissions);
            userRepository.save(model);
        }
    }

}
