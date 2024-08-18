package com.example.webapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.webapp.entity.ToDo;


/**
 * ToDo:リポジトリ
 */
@Mapper
public interface ToDoMapper {
	/**
	 * すべての「すること」を取得する
	 */
	List<ToDo> selectAll();
	
	/**
	 * 指定されたIDに対応する「すること」を取得する
	 */
	ToDo selectById(@Param("id") Integer id);
	
	/**
	 * 「すること」を登録する
	 */
	void insert(ToDo toDo);
	
	/**
	 * 「すること」を更新する
	 */
	void update(ToDo toDo);
	
	/**
	 * 指定されたIDの「すること」を削除する
	 */
	void delete(@Param("id") Integer id);
	
}
