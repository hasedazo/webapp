package com.example.webapp.form;

import com.example.webapp.validation.ValidCharacter;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * すること:Form
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoForm {
	/** することID */
	private Integer id;
	/** すること */
	//@NotBlank(message="ToDoは必須です。")
	@NotBlank
	private String todo;
	/** すること詳細 */
	//@Size(min=1,max=100,message="詳細は{min}～{max}文字以内で入力してください。")
	@ValidCharacter
	private String detail;
	/** 新規判定*/
	private Boolean isNew;
}
