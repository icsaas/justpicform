package com.numerx.formweb.common;

import java.util.Date;

/**
 * @author matrixorz
 * @data 2019-08-13 16:51
 */
public class BaseEntity<T> {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 199327361052220940L;

    private Boolean deleted;
    private Date createTime;

}
