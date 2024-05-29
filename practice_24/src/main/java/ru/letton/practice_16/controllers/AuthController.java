package ru.letton.practice_16.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.letton.practice_16.dto.request.SignInRequest;
import ru.letton.practice_16.dto.request.SignUpRequest;
import ru.letton.practice_16.dto.response.CustomErrorResponse;
import ru.letton.practice_16.dto.response.JwtAuthenticationResponse;
import ru.letton.practice_16.exceptions.BadRequestException;
import ru.letton.practice_16.services.AuthenticationService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public JwtAuthenticationResponse signUp(@RequestBody @Valid SignUpRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append(";");
            }
            throw new BadRequestException(errors.toString());
        }
        return authenticationService.signUp(request);
    }

    @PostMapping("/sign-in")
    public JwtAuthenticationResponse signIn(@RequestBody @Valid SignInRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            for (ObjectError error : bindingResult.getAllErrors()) {
                errors.append(error.getDefaultMessage()).append(";");
            }
            throw new BadRequestException(errors.toString());
        }
        return authenticationService.signIn(request);
    }

    @ExceptionHandler
    private ResponseEntity<CustomErrorResponse> handleException(BadRequestException e) {
        return new ResponseEntity<>(new CustomErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}