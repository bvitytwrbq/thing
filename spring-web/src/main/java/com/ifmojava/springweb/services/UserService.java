package com.ifmojava.springweb.services;

import com.ifmojava.springweb.entity.Role;
import com.ifmojava.springweb.entity.User;
import com.ifmojava.springweb.repository.RoleRepository;
import com.ifmojava.springweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UserService implements UserDetailsService {

    private EntityManager entityManager;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException("User not found, y'all");
        }
        return user;
    }

    public boolean saveUser(User user){
        User userFromDB = userRepository.findByUsername(user.getUsername());
        if(userFromDB!=null){
            return false;
        }
        Role role = roleRepository.findById(1).get();
        user.getRoles().add(role);
        user.setPassword(encoder.encode(user.getPassword()));
        role.getUsers().add(user);
        userRepository.save(user);
        return true;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Autowired
    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }
}
