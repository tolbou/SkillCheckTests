//package com.example.demo.entitiy;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.ui.Model;
//
//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;
//
//@Entity
//@Data
//@Table(name = "employee")
//public class User {
//	private static void dd(Model model) {
//
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		// Principalからログインユーザの情報を取得
//		String id = auth.getName();
//		model.addAttribute("id", id);
//	}
//
//	/**
//	 * ID
//	 */
//	@Id
//	@Column(name = "id")
//// @GeneratedValue(strategy = GenerationType.IDENTITY)
//	private String id;
//	/**
//	 * 名前
//	 */
//	@Column(name = "name")
//	private String name;
//
//	@Column(name = "upn")
//	private String upn;
//
//	@Column(name = "password")
//	@Getter
//	@Setter
//	private String password;
//}
