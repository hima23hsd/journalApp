package net.edigest.journalApp.journalApp.service;

import net.edigest.journalApp.journalApp.entity.User;
import net.edigest.journalApp.journalApp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class UserDetailsServiceImplTests {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Use openMocks instead of deprecated initMocks
    }

    @Test
    void loadUserByUsernameTest() {
        // Arrange
        User mockUser = User.builder()
                .userName("ram")
                .password("skajhdsd")
                .roles(new ArrayList<>())
                .build();

        when(userRepository.findByUserName(anyString())).thenReturn(mockUser);

        // Act
        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername("ram");

        // Assert
        assertNotNull(userDetails);
        assertEquals("ram", userDetails.getUsername());
    }
}
