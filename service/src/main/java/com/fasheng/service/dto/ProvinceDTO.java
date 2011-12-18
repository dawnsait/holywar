package com.fasheng.service.dto;

public class ProvinceDTO extends BaseDTO {
	private static final long serialVersionUID = -6171494285549722542L;

	private Integer id;

    private String provinceName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }
}