package com.dianrong.common.uniauth.common.bean.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Arc on 13/1/16.
 */
@ApiModel("用户信息")
public class UserDto extends TenancyBaseDto {
    private static final long serialVersionUID = -1969133233179816584L;

    @ApiModelProperty("主键id")
    private Long id;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("密码")
    private String password;
    @ApiModelProperty("密码盐")
    private String passwordSalt;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("创建时间")
    private Date createDate;
    @ApiModelProperty("最新更新时间")
    private Date lastUpdate;
    @ApiModelProperty("状态(0:启用,1:禁用)")
    private Byte status;
    private Byte userGroupType;
    @ApiModelProperty("用户对应的标签")
    private List<TagDto> tagDtos;
    @ApiModelProperty("用户对应的扩展属性值")
    private List<UserExtendValDto> userExtendValDtos;
    @ApiModelProperty("辅助字段,与userExtendValDtos内容一致")
    private Map<String, String> userExtendValMap;

    public List<UserExtendValDto> getUserExtendValDtos() {
        return userExtendValDtos;
    }

    public void setUserExtendValDtos(List<UserExtendValDto> userExtendValDtos) {
        this.userExtendValDtos = userExtendValDtos;
    }

    // whether this user directly connected with a role
    @ApiModelProperty("辅助字段,判断是否与某个角色有关联关系")
    private Boolean roleChecked;
    // whether this user directly connected with a tag
    @ApiModelProperty("辅助字段,判断是否与某个标签有关联关系")
    private Boolean tagChecked;

    public Boolean getTagChecked() {
        return tagChecked;
    }

    public UserDto setTagChecked(Boolean tagChecked) {
        this.tagChecked = tagChecked;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public UserDto setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Boolean getRoleChecked() {
        return roleChecked;
    }

    public UserDto setRoleChecked(Boolean roleChecked) {
        this.roleChecked = roleChecked;
        return this;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public UserDto setCreateDate(Date createDate) {
        this.createDate = createDate;
        return this;
    }

    public Byte getStatus() {
        return status;
    }

    public UserDto setStatus(Byte status) {
        this.status = status;
        return this;
    }

    public Byte getUserGroupType() {
        return userGroupType;
    }

    public UserDto setUserGroupType(Byte userGroupType) {
        this.userGroupType = userGroupType;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public UserDto setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public List<TagDto> getTagDtos() {
        return tagDtos;
    }

    public UserDto setTagDtos(List<TagDto> tagDtos) {
        this.tagDtos = tagDtos;
        return this;
    }

    /**
     * <pre>
     * 根据eva的code获取对应的值
     * 用户禁用该值或者未设置该值返回null
     * </pre>
     * 
     * @param code
     * @return
     */
    public String getEavByCode(String code) {
        if (userExtendValMap == null) {
            if (userExtendValDtos == null) {
                return null;
            }
            userExtendValMap = new HashMap<String, String>();
            for (UserExtendValDto userExtendValDto : userExtendValDtos) {
                if (userExtendValDto.getStatus() == 0) {
                    userExtendValMap.put(userExtendValDto.getExtendCode(), userExtendValDto.getValue());
                }
            }
        }
        return userExtendValMap.get(code);
    }

    @Override
    public String toString() {
        return "UserDto [id=" + id + ", name=" + name + ", password=" + password + ", passwordSalt=" + passwordSalt + ", email=" + email + ", phone=" + phone + ", createDate="
                + createDate + ", lastUpdate=" + lastUpdate + ", status=" + status + ", userGroupType=" + userGroupType + ", tagDtos=" + tagDtos + ", userExtendValDtos="
                + userExtendValDtos + ", userExtendValMap=" + userExtendValMap + ", roleChecked=" + roleChecked + ", tagChecked=" + tagChecked + "]";
    }
}
