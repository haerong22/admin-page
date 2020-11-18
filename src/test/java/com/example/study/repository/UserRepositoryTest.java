package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email ="Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedBy(createdBy);
        user.setCreatedAt(createdAt);

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("---------주문 묶음--------");
            System.out.println(orderGroup.getRevName());
            System.out.println(orderGroup.getRevAddress());
            System.out.println(orderGroup.getTotalPrice());

            System.out.println("---------주문 묶음--------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println(orderDetail.getItem().getPartner().getName());
                System.out.println(orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println(orderDetail.getStatus());
                System.out.println(orderDetail.getArrivalDate());
                System.out.println(orderDetail.getItem().getName());
                System.out.println(orderDetail.getItem().getPartner().getCallCenter());
            });
        });

        Assertions.assertNotNull(user);
    }

    @Test
    public void update() {
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    public void delete() {
        Optional<User> user = userRepository.findById(1L);

        Assertions.assertTrue(user.isPresent());

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(1L);

        Assertions.assertFalse(deleteUser.isPresent());
    }
}
