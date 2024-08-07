package com.mongodbspringboot.customercrud.cl.mongocrud.core.common.utils.country.enums;

public enum UsaRegionEnum {
  ALABAMA(1, "AL"),
  ALASKA(2, "AK"),
  ARIZONA(3, "AZ"),
  ARKANSAS(4, "AR"),
  CALIFORNIA(5, "CA"),
  COLORADO(6, "CO"),
  CONNECTICUT(7, "CT"),
  DELAWARE(8, "DE"),
  FLORIDA(9, "FL"),
  GEORGIA(10, "GA"),
  HAWAII(11, "HI"),
  IDAHO(12, "ID"),
  ILLINOIS(13, "IL"),
  INDIANA(14, "IN"),
  IOWA(15, "IA"),
  KANSAS(16, "KS"),
  KENTUCKY(17, "KY"),
  LOUISIANA(18, "LA"),
  MAINE(19, "ME"),
  MARYLAND(20, "MD"),
  MASSACHUSETTS(21, "MA"),
  MICHIGAN(22, "MI"),
  MINNESOTA(23, "MN"),
  MISSISSIPPI(24, "MS"),
  MISSOURI(25, "MO"),
  MONTANA(26, "MT"),
  NEBRASKA(27, "NE"),
  NEVADA(28, "NV"),
  NEW_HAMPSHIRE(29, "NH"),
  NEW_JERSEY(30, "NJ"),
  NEW_MEXICO(31, "NM"),
  NEW_YORK(32, "NY"),
  NORTH_CAROLINA(33, "NC"),
  NORTH_DAKOTA(34, "ND"),
  OHIO(35, "OH"),
  OKLAHOMA(36, "OK"),
  OREGON(37, "OR"),
  PENNSYLVANIA(38, "PA"),
  RHODE_ISLAND(39, "RI"),
  SOUTH_CAROLINA(40, "SC"),
  SOUTH_DAKOTA(41, "SD"),
  TENNESSEE(42, "TN"),
  TEXAS(43, "TX"),
  UTAH(44, "UT"),
  VERMONT(45, "VT"),
  VIRGINIA(46, "VA"),
  WASHINGTON(47, "WA"),
  WEST_VIRGINIA(48, "WV"),
  WISCONSIN(49, "WI"),
  WYOMING(50, "WY");

  private final Integer id;
  private final String regionEnum;

  UsaRegionEnum(Integer id, String regionEnum) {
    this.id = id;
    this.regionEnum = regionEnum;
  }

  public Integer getId() {
    return id;
  }

  public String getRegionEnum() {
    return regionEnum;
  }

  public static UsaRegionEnum regionEnumById(Integer id) {
    for (UsaRegionEnum usaRegionEnum : values()) {
      if (usaRegionEnum.id.equals(id)) {
        return usaRegionEnum;
      }
    }
    return null;
  }

  public static UsaRegionEnum fromState(String region) {
    for (UsaRegionEnum usaRegionEnum : values()) {
      if (usaRegionEnum.regionEnum.equals(region)) {
        return usaRegionEnum;
      }
    }
    return null;
  }
}
