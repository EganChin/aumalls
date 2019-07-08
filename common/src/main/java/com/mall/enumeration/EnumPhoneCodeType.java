package com.mall.enumeration;

public enum EnumPhoneCodeType implements BaseEnum {
	/**
	 * 值为 1，则手机号必须不存在
	 * 值为 2，则手机号必须存在
	 */
	REGISTER(1),
	RETRIEVAL_PASSWD(2),
	;

	EnumPhoneCodeType(int value) {
		this.value = value;

	}

	private int value;
	public int value(){
		return value;
	}

}
