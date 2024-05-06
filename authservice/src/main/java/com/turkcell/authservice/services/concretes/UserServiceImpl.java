package com.turkcell.authservice.services.concretes;

import com.turkcell.authservice.entities.Role;
import com.turkcell.authservice.entities.User;
import com.turkcell.authservice.repositories.RoleRepository;
import com.turkcell.authservice.repositories.UserRepository;
import com.turkcell.authservice.services.abstracts.UserService;
import com.turkcell.pair3.core.services.abstracts.MessageService;
import com.turkcell.pair3.events.RegisterEvent;
import com.turkcell.pair3.messages.Messages;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final MessageService messageService;
    private final RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new AccessDeniedException(messageService.getMessage(Messages.BusinessErrors.BILL_ACCOUNT_HAS_PRODUCT)));
    }

    @Override
    public Integer add(RegisterEvent request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return userRepository.save(user).getId();
    }

    @Override
    public void giveRole(Integer id, Integer roleId) {
        User user = userRepository.findById(id).orElseThrow(() -> new AccessDeniedException(messageService.getMessage(Messages.BusinessErrors.BILL_ACCOUNT_HAS_PRODUCT)));
        //find role with roleId
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new AccessDeniedException(messageService.getMessage(Messages.BusinessErrors.BILL_ACCOUNT_HAS_PRODUCT)));
        user.getAuthorities().add(role);
        userRepository.save(user);
    }
}