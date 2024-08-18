package com.example.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Menuコントローラー
 */

@Controller
@RequestMapping("/")
public class MenuController {
	/**
	 * メニュー画面を表示する
	 */
	@GetMapping
	public String showMenu() {
		//templatesフォルダは以下のmenu.htmlに遷移
		return "menu";
	}
	

}
