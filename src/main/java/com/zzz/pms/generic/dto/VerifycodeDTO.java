package com.zzz.pms.generic.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class VerifycodeDTO extends BaseDTO {

    private Long id;

    /**
     * 验证码类型
     */
    private Integer codeType;

    /**
     * 验证码
     */
    private String codeNumber;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 接收端(手机号码，邮箱)
     */
    @NotBlank(message = "手机号不能为空!")
    private String receiver;

}
