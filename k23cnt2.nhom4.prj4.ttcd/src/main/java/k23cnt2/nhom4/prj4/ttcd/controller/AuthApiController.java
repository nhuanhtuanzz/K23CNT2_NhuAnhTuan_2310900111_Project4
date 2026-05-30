package k23cnt2.nhom4.prj4.ttcd.controller;

import k23cnt2.nhom4.prj4.ttcd.dto.AuthResponse;
import k23cnt2.nhom4.prj4.ttcd.dto.LoginRequest;
import k23cnt2.nhom4.prj4.ttcd.dto.RegisterRequest;
import k23cnt2.nhom4.prj4.ttcd.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthApiController {

    @Autowired
    private AuthService authService;

    // ================= REGISTER =================

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest registerRequest
    ) {

        try {

            AuthResponse authResponse =
                    authService.register(registerRequest);

            return ResponseEntity.ok(authResponse);

        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(

                    new AuthResponse(
                            null,
                            e.getMessage(),
                            null
                    )
            );

        } catch (Exception e) {

            return ResponseEntity.internalServerError().body(

                    new AuthResponse(
                            null,
                            "Có lỗi xảy ra trong quá trình đăng ký!",
                            null
                    )
            );
        }
    }

    // ================= LOGIN =================

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(
            @RequestBody LoginRequest loginRequest
    ) {

        try {

            AuthResponse response =
                    authService.login(loginRequest);

            return ResponseEntity.ok(response);

        } catch (Exception e) {

            return ResponseEntity.badRequest().body(

                    new AuthResponse(
                            null,
                            "Email hoặc mật khẩu không chính xác!",
                            null
                    )
            );
        }
    }
}