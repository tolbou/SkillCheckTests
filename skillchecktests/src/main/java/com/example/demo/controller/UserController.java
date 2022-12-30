package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entitiy.UserEntity;
import com.example.demo.request.UserRequest;
import com.example.demo.request.UserUpdateRequest;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	/**
	 * ユーザー情報 Service
	 */
	@Autowired
	UserService userService;

	/**
	 * ユーザー情報一覧画面を表示
	 * 
	 * @param model Model
	 * @return ユーザー情報一覧画面のHTML
	 */
	@GetMapping(value = "/list")
	public String displayList(Model model) {
		List<UserEntity> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);
		return "list";
	}

	/**
	 * ユーザー作成画面表示
	 * 
	 * @param model Model
	 * @return ユーザー作成画面のHTML
	 */
	@GetMapping(value = "/newuser")
	public String displayAdd(Model model) {
		model.addAttribute("userRequest", new UserRequest());
		return "newuser";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute UserRequest userRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "newuser";
		}

		// ユーザー情報の登録
		userService.create(userRequest);
		return "redirect:/list";
	}

	//ユーザーの詳細画面
	@GetMapping(value = "/list/{id}")
	public String displayShow(@PathVariable Long id, Model model) {
		UserEntity userEntity = userService.findById(id);
		model.addAttribute("userData", userEntity);
		return "show";
	}

	// ユーザー編集
	@GetMapping(value = "/list/{id}/edit")
	public String displayEdit(@PathVariable Long id, Model model) {
		UserEntity userEntity = userService.findById(id);
		UserUpdateRequest userUpdateRequest = new UserUpdateRequest();
		userUpdateRequest.setId(userEntity.getId());
		userUpdateRequest.setName(userEntity.getName());
		userUpdateRequest.setUpn(userEntity.getUpn());
		userUpdateRequest.setPassword(userEntity.getPassword());
		model.addAttribute("userUpdateRequest", userUpdateRequest);
		return "edit";
	}

	// ユーザー編集
	@RequestMapping(value = "/list/update", method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute UserUpdateRequest userUpdateRequest, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "edit";
		}
		// ユーザー情報の更新
		userService.update(userUpdateRequest);
		return String.format("redirect:/list/%d", userUpdateRequest.getId());
	}

	// ユーザー情報の削除
	@GetMapping("/list/{id}/delete")
	public String delete(@PathVariable Long id, Model model) {

		userService.delete(id);
		return "redirect:/list";
	}
	
	//ログイン画面
	 @GetMapping("/login")
	    public String disp1() {
	        return "login";
	    }
	    @PostMapping("/list")
	    public String testPage() {
	        return "list";
	    }
}////
