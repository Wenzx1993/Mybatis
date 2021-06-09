package com.lagou.utils;

import java.util.ArrayList;
import java.util.List;


/**
 * 参数处理器
 */
public class ParameterMappingTokenHandler implements TokenHandler {
	/**
	 * 参数集合
	 */
	private List<ParameterMapping> parameterMappings = new ArrayList<ParameterMapping>();

	// context是参数名称 #{id} #{username}

	/**
	 * 替换参数
	 *  将参数放入集合
	 * @param content
	 * @return
	 */
	public String handleToken(String content) {
		parameterMappings.add(buildParameterMapping(content));
		return "?";
	}

	/**
	 * 封装参数
	 * @param content
	 * @return
	 */
	private ParameterMapping buildParameterMapping(String content) {
		ParameterMapping parameterMapping = new ParameterMapping(content);
		return parameterMapping;
	}

	public List<ParameterMapping> getParameterMappings() {
		return parameterMappings;
	}

	public void setParameterMappings(List<ParameterMapping> parameterMappings) {
		this.parameterMappings = parameterMappings;
	}

}
