package com.example.webapp.service;

import java.util.List;

import com.example.webapp.entity.ToDo;


/**
 * ToDo:サービス
 */
public interface ToDoService {
	/**
	 * 「すること」の全検索
	 */
	List<ToDo> findAllToDo();
	
	/**
	 * 指定されたIDのすること検索
	 */
	ToDo findByIdToDo(Integer id);
	
	/**
	 * 新規登録
	 */
	void insertToDo(ToDo toDo);
	
	/**
	 * 更新
	 */
	void updateToDo(ToDo toDo);
	
	/**
	 * 指定されたIDのすること削除
	 */
	void deleteToDo(Integer id);

}
