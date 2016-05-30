package io.swagger.client.api;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cz.msebera.android.httpclient.entity.mime.MultipartEntityBuilder;
import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;
import io.swagger.client.model.Location;

public class DefaultApi {
  String basePath = "http://192.168.0.106:8080/barradar/servlet";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public void addHeader(String key, String value) {
    getInvoker().addDefaultHeader(key, value);
  }

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  
  /**
   * 
   * Deletes the given location. The query parameter `id` specifies the location which should be deleted.\n
   * @param id Id of the location which should be deleted
   * @return void
   */
  public void  locationsDelete (BigDecimal id) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'id' is set
    if (id == null) {
       throw new ApiException(400, "Missing the required parameter 'id' when calling locationsDelete");
    }
    

    // create path and map variables
    String localVarPath = "/locations".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "id", id));
    

    

    String[] localVarContentTypes = {
      
    };
    String localVarContentType = localVarContentTypes.length > 0 ? localVarContentTypes[0] : "application/json";

    if (localVarContentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      
    }

    try {
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return ;
      }
      else {
        return ;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * 
   * Gets all location `Location` objects in the users proximity.\nQuery parameters `latitude`and `longitude` specify the users current position.\nThe query parameter `radius` specifies the searching area. So if its for example 50km\nthe barRadar searches for bars in a radius of 50km around the users current position.\n
   * @param latitude Latitude component of the users current location.
   * @param longitude Longitude component of the users current location.
   * @param radius Searching radius
   * @return List<Location>
   */
  public List<Location>  locationsGet (Double latitude, Double longitude, Double radius) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'latitude' is set
    if (latitude == null) {
       throw new ApiException(400, "Missing the required parameter 'latitude' when calling locationsGet");
    }
    
    // verify the required parameter 'longitude' is set
    if (longitude == null) {
       throw new ApiException(400, "Missing the required parameter 'longitude' when calling locationsGet");
    }
    
    // verify the required parameter 'radius' is set
    if (radius == null) {
       throw new ApiException(400, "Missing the required parameter 'radius' when calling locationsGet");
    }
    

    // create path and map variables
    String localVarPath = "/locations".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "latitude", latitude));
    
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "longitude", longitude));
    
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "radius", radius));
    

    

    String[] localVarContentTypes = {
      
    };
    String localVarContentType = localVarContentTypes.length > 0 ? localVarContentTypes[0] : "application/json";

    if (localVarContentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      
    }

    try {
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (List<Location>) ApiInvoker.deserialize(localVarResponse, "array", Location.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * 
   * Creates new location or updated the given existing location. \n
   * @param title Title/ Name of the location.
   * @param type Type of the location e.g. \&quot;Bar\&quot;, \&quot;Pub\&quot; etc.
   * @param latitude Latitude component of the users current location.
   * @param longitude Longitude component of the users current location.
   * @param radius Searching radius
   * @param address Address of the location
   * @param id Unique id of the location. (only necessary for update, for tge creation the id is going to be auto generated)
   * @param description Description of the location.
   * @param image Image URL representing the product.
   * @return Location
   */
  public Location  locationsPut (String title, String type, Double latitude, Double longitude, Double radius, String address, BigDecimal id, String description, String image) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'title' is set
    if (title == null) {
       throw new ApiException(400, "Missing the required parameter 'title' when calling locationsPut");
    }
    
    // verify the required parameter 'type' is set
    if (type == null) {
       throw new ApiException(400, "Missing the required parameter 'type' when calling locationsPut");
    }
    
    // verify the required parameter 'latitude' is set
    if (latitude == null) {
       throw new ApiException(400, "Missing the required parameter 'latitude' when calling locationsPut");
    }
    
    // verify the required parameter 'longitude' is set
    if (longitude == null) {
       throw new ApiException(400, "Missing the required parameter 'longitude' when calling locationsPut");
    }
    
    // verify the required parameter 'radius' is set
    if (radius == null) {
       throw new ApiException(400, "Missing the required parameter 'radius' when calling locationsPut");
    }
    
    // verify the required parameter 'address' is set
    if (address == null) {
       throw new ApiException(400, "Missing the required parameter 'address' when calling locationsPut");
    }
    

    // create path and map variables
    String localVarPath = "/locations".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    // form params
    Map<String, String> localVarFormParams = new HashMap<String, String>();

    
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "id", id));

    try {
      localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "title", URLEncoder.encode(title, "UTF-8")));
      localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "description", URLEncoder.encode(description, "UTF-8")));
      localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "type", URLEncoder.encode(type, "UTF-8")));
      localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "address", URLEncoder.encode(address, "UTF-8")));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }


    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "latitude", latitude));
    
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "longitude", longitude));
    
    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "radius", radius));

    localVarQueryParams.addAll(ApiInvoker.parameterToPairs("", "image", image));
    

    

    String[] localVarContentTypes = {
      
    };
    String localVarContentType = localVarContentTypes.length > 0 ? localVarContentTypes[0] : "application/json";

    if (localVarContentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder localVarBuilder = MultipartEntityBuilder.create();
      

      localVarPostBody = localVarBuilder.build();
    } else {
      // normal form params
      
    }

    try {
      String localVarResponse = apiInvoker.invokeAPI(basePath, localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarContentType);
      if(localVarResponse != null){
        return (Location) ApiInvoker.deserialize(localVarResponse, "", Location.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
}
