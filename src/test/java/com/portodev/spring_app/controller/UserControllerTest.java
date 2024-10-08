package com.portodev.spring_app.controller;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.portodev.spring_app.controller.UserController;
import com.portodev.spring_app.model.User;
import com.portodev.spring_app.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
    }

    @Test
    public void testDeleteUser_Success() throws Exception {
        Long userId = 1L;
        User existingUser = new User();
        existingUser.setId(userId);

        // Configurando o mock para retornar um Optional com o usuário existente
        when(userService.findById(userId)).thenReturn(Optional.of(existingUser));

        // É chamado o metodo deleteUser do controlador
        ResponseEntity<User> response = userController.deleteUser(userId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode()); // HTTP 204
        verify(userService).findById(userId);
        verify(userService).deleteById(userId);

    }

    @Test
    public void testDeleteUser_NotFound() throws Exception {
        Long userId = 1L;

        // Configurando o mock para retornar um Optional vazio (usuário não encontrado)
        when(userService.findById(userId)).thenReturn(Optional.empty());

        // É chamado o metodo deleteUser do controlador
        ResponseEntity<User> response = userController.deleteUser(userId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode()); // HTTP 404
        verify(userService).findById(userId); // Verifica se o metodo de busca foi chamado
        verify(userService, never()).deleteById(anyLong()); // Garante que o metodo de deletar não foi chamado
    }
}
