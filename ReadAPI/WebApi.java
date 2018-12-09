package com.atid.app.atx.ReadAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface WebApi {


    @GET("web/api/Employees/")
    @Headers({"Content-Type: application/x-www-form-urlencoded"})
    Call<List<NhanVien>> getAllNhanVien();


    //lấy token
    @POST("/connect/token")
    @FormUrlEncoded
    Call<NhanVien> oathToken(@Field("client_id") String clientId,
                             @Field("client_secret") String clientSecret,
                             @Field("grant_type") String grant_type,
                             @Field("scopes") String scopes
    );


    // lấy ra 1 nhân viên
    @GET("/customers")
    //@Headers({"Content-Type : application/x-www-form-urlencoded",
           // "Retailer : ifd",
         //   "Authorization : Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYmYiOjE1NDQzMjA2NjIsImV4cCI6MTU0NDQwNzA2MiwiaXNzIjoiaHR0cDovL2lkLmtpb3R2aWV0LnZuIiwiYXVkIjpbImh0dHA6Ly9pZC5raW90dmlldC52bi9yZXNvdXJjZXMiLCJLaW90VmlldC5BcGkuUHVibGljIl0sImNsaWVudF9pZCI6IjNiOTU2NjVhLThjMjgtNDkyZi04NWY1LWQxYTA5NWU1NDFhOSIsImNsaWVudF9SZXRhaWxlckNvZGUiOiJpZmQiLCJjbGllbnRfUmV0YWlsZXJJZCI6IjUxMDczIiwiY2xpZW50X1VzZXJJZCI6IjIxMjk1MiIsInNjb3BlIjpbIlB1YmxpY0FwaS5BY2Nlc3MiXX0.c3I44g4JuCmUImA1_piasi7QDsD3k8gEY_rXiphckQWb5a8hJsmvXtmlDWXfvzuaqncFbzKOoeZzo58DMI0XIWA4n1Nyb0CqFMKKK2xXgsod2aU2giDbJsOythnwMr4ZV0GgkX8uWi7X219TCYh-VrXQ4VgMMHrzmzIU3bmgTHlB5xETIBX6Cq_lEdJ4Uy8EarlfJg_-aoEd3UHoXe4ByzOneF8Wrv6uHhS3uigINGSTRCDZuqAflPT-a-o9oIK0YiE-jTDMNg2AvUiUn2YPGzV1S-JZLcz5sdONkFF-yFUvOUhYOigEftV0kK9wMQ0Za3dhGDuIa0uRMcYOvJ7E3Q"})
    Call<List<NhanVien>> customers(@Header("Content-Type") String token,
                              @Header("Retailer") String Retailer,
                              @Header("Authorization") String Authorization
                              );
    @GET("/products/")
        //@Headers({"Content-Type : application/x-www-form-urlencoded",
        // "Retailer : ifd",
        //   "Authorization : Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYmYiOjE1NDQzMjA2NjIsImV4cCI6MTU0NDQwNzA2MiwiaXNzIjoiaHR0cDovL2lkLmtpb3R2aWV0LnZuIiwiYXVkIjpbImh0dHA6Ly9pZC5raW90dmlldC52bi9yZXNvdXJjZXMiLCJLaW90VmlldC5BcGkuUHVibGljIl0sImNsaWVudF9pZCI6IjNiOTU2NjVhLThjMjgtNDkyZi04NWY1LWQxYTA5NWU1NDFhOSIsImNsaWVudF9SZXRhaWxlckNvZGUiOiJpZmQiLCJjbGllbnRfUmV0YWlsZXJJZCI6IjUxMDczIiwiY2xpZW50X1VzZXJJZCI6IjIxMjk1MiIsInNjb3BlIjpbIlB1YmxpY0FwaS5BY2Nlc3MiXX0.c3I44g4JuCmUImA1_piasi7QDsD3k8gEY_rXiphckQWb5a8hJsmvXtmlDWXfvzuaqncFbzKOoeZzo58DMI0XIWA4n1Nyb0CqFMKKK2xXgsod2aU2giDbJsOythnwMr4ZV0GgkX8uWi7X219TCYh-VrXQ4VgMMHrzmzIU3bmgTHlB5xETIBX6Cq_lEdJ4Uy8EarlfJg_-aoEd3UHoXe4ByzOneF8Wrv6uHhS3uigINGSTRCDZuqAflPT-a-o9oIK0YiE-jTDMNg2AvUiUn2YPGzV1S-JZLcz5sdONkFF-yFUvOUhYOigEftV0kK9wMQ0Za3dhGDuIa0uRMcYOvJ7E3Q"})
    Call<NhanVien> listProduct(@Header("Content-Type") String token,
                             @Header("Retailer") String Retailer,
                             @Header("Authorization") String Authorization
    );


    //thêm nhân viên
    @POST("wws/api/nv/")
    @FormUrlEncoded
    Call<NhanVien> ThemNV(@Field("MaNV") String manv,
                          @Field("TenNV") String TenNV,
                          @Field("DiaChi") String DiaChi,
                          @Field("DienThoai") String DienThoai,
                          @Field("CMND") String CMND
    );
}