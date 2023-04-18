package com.example.crud.service;

import com.example.crud.dto.LoginRequestDto;
import com.example.crud.dto.SignupRequestDto;
import com.example.crud.entity.User;
import com.example.crud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public String signUp(SignupRequestDto requestDto) {
        String userName = requestDto.getUserName();

        //회원 중복 확인
        Optional<User> found = userRepository.findByUserName(userName);
        if(found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자가 존재합니다.");
        }

        User user = new User(requestDto);
        userRepository.save(user);
        return "회원가입 완료!";
    }

//    @Transactional(readOnly = true)
//    public String login(LoginRequestDto requestDto) {
//        String userName = requestDto.getUserName();
//        String password = requestDto.getPassword();
//
//        //사용자 확인
//        User user = userRepository.findByUserName(userName).orElseThrow(
//                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
//        );
//
//        //비밀번호 확인
//        if(!user.getPassword().equals(password)) {
//
//        }
//        return "로그인 성공!";
//    }
}
/*
@Transactional(readOnly = true)
    public void login(LoginRequestDto loginRequestDto) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        // 사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );

        // 비밀번호 확인
        if(!user.getPassword().equals(password)){
            throw  new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
 */
/*************************************************************
 //        try {
 //            if (userRepository.existsById(userEmail))
 //                return ResponseDto.setFailed("Existed Email");
 //        } catch (Exception error) {
 //            return ResponseDto.setFailed("Data Base Error!");
 //        }
 //        if (!userPwd.equals(userPwdChk))
 //            return ResponseDto.setFailed("Password does not matched!");
 //
 //        UserEntity userEntity = new UserEntity(dto);
 //
 //        String encodedPwd = passwordEncoder.encode(userPwd);
 //        userEntity.setUserPwd(encodedPwd);
 //
 //        try {
 //            userRepository.save(userEntity);
 //        } catch (Exception e) {
 //            return ResponseDto.setFailed("Data Base Error");
 //        }
 //
 //        return ResponseDto.setSuccess("SignUp Success!", null);

 ***********************************************************/