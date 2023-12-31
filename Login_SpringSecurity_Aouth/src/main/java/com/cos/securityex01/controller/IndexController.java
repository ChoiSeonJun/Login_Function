package com.cos.securityex01.controller;

import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.securityex01.config.auth.PrincipalDetails;
import com.cos.securityex01.model.User;
import com.cos.securityex01.model.UserInfoDTO;
import com.cos.securityex01.repository.UserRepository;
import com.cos.securityex01.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	UserService service;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/index")
	public String main() {
		return "index";
	}

	@GetMapping({ "", "/app" })
	public String index(
			Authentication authentication,
			@AuthenticationPrincipal PrincipalDetails principal, HttpSession session) {
		
		// 'getPrincipal()' 메서드는 현재 사용자(Principal)를 나타내는 정보를 반환합니다. 이것은 현재 사용자의 식별 정보입니다.
		PrincipalDetails principalDetails = (PrincipalDetails) authentication.getPrincipal();
		System.out.println("authentication: " + principalDetails.getUser()); //getPrincipal()로 principalDetails에 정보를 가져왔기에 거기서 User를 추출
		User user = principalDetails.getUser();	// user에 로그인된 User정보 담기.
		
		UserInfoDTO dto = service.selectAll(user.getUsername());
		System.out.println(dto);
		
		session.setAttribute("loginInfo", dto); // 중요: 세션에 로그인 정보를 "loginInfo"라는 키의 이름으로 저장함.
		
		return "redirect:index";
	}

	@GetMapping("/user")
	public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principal) {
		System.out.println("Principal : " + principal);
//		System.out.println("OAuth2 : "+principal.getUser().getProvider());
//		// iterator 순차 출력 해보기
//		Iterator<? extends GrantedAuthority> iter = principal.getAuthorities().iterator();
//		while (iter.hasNext()) {
//			GrantedAuthority auth = iter.next();
//			System.out.println(auth.getAuthority());
//		}

		return "유저 페이지입니다.";
	}

	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "어드민 페이지입니다.";
	}
	
	
	// 매니저만 들어갈 수 있는 페이지
	//@PostAuthorize("hasRole('ROLE_MANAGER')")
	//@PreAuthorize("hasRole('ROLE_MANAGER')")
	@Secured("ROLE_MANAGER")
	@GetMapping("/manager")
	public @ResponseBody String manager() {
		return "매니저 페이지입니다.";
	}

	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}

	// 회원가입 창
	@GetMapping("/join")
	public String join() {
		return "joinForm";
	}
	
	// 회원가입 정보 전송
	@PostMapping("/joinProc")
	public String joinProc(User user) {
		System.out.println("회원가입 진행 : " + user);
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER");
		userRepository.save(user);
		return "redirect:/";
	}
	
	// 아이디 중복 확인
	@GetMapping(value="/UserIdCheckServlet", 
				produces = "text/plain;charset=utf-8") // 한글이 깨져서 utf-8설정
	@ResponseBody // 응답을 jsp가 아닌 일반 데이터(문자열, JSON 형태)로 전송
	public String idCheck(@RequestParam("username")
								String username) {
		User user = service.idCheck(username);
		
		String mesg = "아이디 사용 가능";
		if(user!=null) {
			mesg = "아이디 중복";
		}
		
		return mesg; //@ResponseBody이니 문자열로 리턴하고, .jsp는 맵핑값을 따라간다  
		// /WEB-INF/views/MemberIdCheckServlet.jsp
		}
	

}
