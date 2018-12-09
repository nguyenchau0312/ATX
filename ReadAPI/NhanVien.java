package com.atid.app.atx.ReadAPI;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

import org.json.JSONArray;
import org.json.JSONObject;

public class NhanVien {

    @SerializedName("EmployeeCode")
    @Expose
    private String maNV;
    @SerializedName("Name")
    @Expose
    private String Tennv;

    @SerializedName("access_token")
    @Expose   //@Expose chỉ ra rằng thành viên lớp nên được trình bày cho JSON serialization hoặc deserialization
    private String access_token;
    private ArrayList<NhanVien> Data;
    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getaccess_token() {
        return access_token;
    }

    public void setaccess_token(String access_token) {
        this.access_token = access_token;
    }
///------------------------------------Customer--------------------------------------------------
@SerializedName("total")
@Expose
private Integer total;
    @SerializedName("pageSize")
    @Expose
    private Integer pageSize;
    @SerializedName("data")
    @Expose
    public ArrayList<NhanvienInfo> datanum = new ArrayList<>();
    @SerializedName("timestamp")
    @Expose
    private String timestamp;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getTimestamp() {
        return timestamp;
    }


    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
//    public ArrayList getData() {
//        return data;
//    }

//    public void setData(ArrayList data) {
//        this.data = data;
//    }

    //----------------
    public class NhanvienInfo {
        @SerializedName("createdDate")
        @Expose
        private String createdDate;
        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("retailerId")
        @Expose
        private Integer retailerId;
        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("fullName")
        @Expose
        private String fullName;
        @SerializedName("categoryId")
        @Expose
        private Integer categoryId;
        @SerializedName("categoryName")
        @Expose
        private String categoryName;
        @SerializedName("allowsSale")
        @Expose
        private Boolean allowsSale;
        @SerializedName("type")
        @Expose
        private Integer type;
        @SerializedName("hasVariants")
        @Expose
        private Boolean hasVariants;
        @SerializedName("basePrice")
        @Expose
        private Integer basePrice;
        @SerializedName("unit")
        @Expose
        private String unit;
        @SerializedName("conversionValue")
        @Expose
        private Integer conversionValue;
        @SerializedName("modifiedDate")
        @Expose
        private String modifiedDate;
        @SerializedName("isActive")
        @Expose
        private Boolean isActive;

        public String getCreatedDate() {
            return createdDate;
        }

        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getRetailerId() {
            return retailerId;
        }

        public void setRetailerId(Integer retailerId) {
            this.retailerId = retailerId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public Boolean getAllowsSale() {
            return allowsSale;
        }

        public void setAllowsSale(Boolean allowsSale) {
            this.allowsSale = allowsSale;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Boolean getHasVariants() {
            return hasVariants;
        }

        public void setHasVariants(Boolean hasVariants) {
            this.hasVariants = hasVariants;
        }

        public Integer getBasePrice() {
            return basePrice;
        }

        public void setBasePrice(Integer basePrice) {
            this.basePrice = basePrice;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public Integer getConversionValue() {
            return conversionValue;
        }

        public void setConversionValue(Integer conversionValue) {
            this.conversionValue = conversionValue;
        }

        public String getModifiedDate() {
            return modifiedDate;
        }

        public void setModifiedDate(String modifiedDate) {
            this.modifiedDate = modifiedDate;
        }

        public Boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(Boolean isActive) {
            this.isActive = isActive;
        }

    }



}

