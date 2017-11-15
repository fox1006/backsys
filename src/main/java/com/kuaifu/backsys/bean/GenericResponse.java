package com.kuaifu.backsys.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;


/**
 * 后面试试加入lombok包，这样用的时候就不需要添加这么多getter和setter了
 * @author 
 *
 */
@SuppressWarnings("rawtypes")
@Getter
@Setter
public  class GenericResponse implements Serializable {
	
	
	/**
	 * Serial version UID for the class to uniquely identify the object during serialization process
	 */
	public static final long serialVersionUID = 1L;
	
	/**
	 * An array that contains the actual objects
	 */
	private Collection rows;
	
	/**
	 * An Map that contains the actual objects
	 */
	private Map mapData;
	
	/**
	 * A String containing response code.
	 */
	private String code;
	
	/**
	 * An int that contains the count of all records
	 */
	private int count;
	
	/**
	 * A String containing message.
	 */
	private String message;
	

	
}
