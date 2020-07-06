package com.jas.projectone.dto;

import java.io.Serializable;

public interface InterfaceDto<T> extends Serializable {

	public T parse();

}
