package org.butu.common.response;

import lombok.Data;

/**
 * @program: MoYu
 * @description: 统一返回类
 * @packagename: org.butu.common
 * @author: BUTUbird
 * @date: 2022-04-09 00:08
 *
 * 数据有
 * - 是否成功： success true/false 类型为boolean
 * - 状态码  ： code  类型为int
 * - 消息    ： msg 对code的描述  类型为String
 * - 返回的数据： data 类型为Object
 **/
@Data
public class R {
    public static final int CODE_SUCCESS = 20000;
    public static final int CODE_FAILED = 40000;
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 状态码
     */
    private int code;
    /**
     * 消息
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Object data;


    //提供一些静态方法，可以快速创建返回对象

    public static R SUCCESS(String msg){
        R r = new R();
        r.code = CODE_SUCCESS;
        r.msg = msg;
        r.success = true;
        return r;
    }

    public static R SUCCESS(String msg,Object data){
        R success = SUCCESS(msg);
        success.data = data;
        return success;
    }

    public static R FAIL(String msg){
        R r = new R();
        r.code = CODE_FAILED;
        r.msg = msg;
        r.success = false;
        return r;
    }

    public static R FAIL(String msg,Object data){
        R fail = FAIL(msg);
        fail.data = data;
        return fail;
    }
}
