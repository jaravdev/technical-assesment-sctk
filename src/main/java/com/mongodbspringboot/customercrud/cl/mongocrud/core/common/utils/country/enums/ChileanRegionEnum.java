package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.enums;

public enum ChileanRegionEnum {
  REGION_METROPOLITANA(1, "RM"),
  REGION_VALPARAISO(2, "VP");

  private final Integer id;
  private final String regionEnum;

  ChileanRegionEnum(Integer id, String regionEnum) {
    this.id = id;
    this.regionEnum = regionEnum;
  }

  public Integer getId() {
    return id;
  }

  public String getRegionEnum() {
    return regionEnum;
  }

  public static ChileanRegionEnum regionEnumById(Integer id) {
    for (ChileanRegionEnum chileanRegionEnum : values()) {
      if (chileanRegionEnum.id.equals(id)) {
        return chileanRegionEnum;
      }
    }
    return null;
  }

  public static ChileanRegionEnum fromRegion(String region) {
    for (ChileanRegionEnum chileanRegionEnum : values()) {
      if (chileanRegionEnum.regionEnum.equals(region)) {
        return chileanRegionEnum;
      }
    }
    return null;
  }
}
