package io.swagger.client.model;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Location implements Serializable{
  
  @SerializedName("location_id")
  private BigDecimal locationId = null;
  @SerializedName("title")
  private String title = null;
  @SerializedName("description")
  private String description = null;
  @SerializedName("radius")
  private Double radius = null;
  @SerializedName("latitude")
  private Double latitude = null;
  @SerializedName("longitude")
  private Double longitude = null;
  @SerializedName("type")
  private String type = null;
  @SerializedName("address")
  private String address = null;
  @SerializedName("image")
  private String image = null;

  
  /**
   * Unique identifier representing a specific location for a given latitude & longitude.
   **/
  @ApiModelProperty(value = "Unique identifier representing a specific location for a given latitude & longitude.")
  public BigDecimal getLocationId() {
    return locationId;
  }
  public void setLocationId(BigDecimal locationId) {
    this.locationId = locationId;
  }

  
  /**
   * Title of the location.
   **/
  @ApiModelProperty(value = "Title of the location.")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  
  /**
   * Description of the location.
   **/
  @ApiModelProperty(value = "Description of the location.")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   * Radius of the location.
   **/
  @ApiModelProperty(value = "Radius of the location.")
  public Double getRadius() {
    return radius;
  }
  public void setRadius(Double radius) {
    this.radius = radius;
  }

  
  /**
   * Latitude of the location.
   **/
  @ApiModelProperty(value = "Latitude of the location.")
  public Double getLatitude() {
    return latitude;
  }
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  
  /**
   * Longitude of the location.
   **/
  @ApiModelProperty(value = "Longitude of the location.")
  public Double getLongitude() {
    return longitude;
  }
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  
  /**
   * Type of the location.
   **/
  @ApiModelProperty(value = "Type of the location.")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  
  /**
   * Address of the location.
   **/
  @ApiModelProperty(value = "Address of the location.")
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }

  
  /**
   * Image URL representing the location.
   **/
  @ApiModelProperty(value = "Image URL representing the location.")
  public String getImage() {
    return image;
  }
  public void setImage(String image) {
    this.image = image;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("  locationId: ").append(locationId).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  radius: ").append(radius).append("\n");
    sb.append("  latitude: ").append(latitude).append("\n");
    sb.append("  longitude: ").append(longitude).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  address: ").append(address).append("\n");
    sb.append("  image: ").append(image).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
