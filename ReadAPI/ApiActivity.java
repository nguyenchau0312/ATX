package com.atid.app.atx.ReadAPI;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.atid.app.atx.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import java.io.File;
import java.util.Locale;
import java.util.Map;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import retrofit2.Call;
import retrofit2.Response;


public class ApiActivity extends Activity {

    Button btnxem;
    TextView tvXem, tvXem2;
    ListView lstNV,lstCode;
    private WebApi mAPIService;

    String client_id = "3b95665a-8c28-492f-85f5-d1a095e541a9";
    String client_secret = "5D593843B1E1AF345598ADD93B484171C058A367";
    String grant_type = "client_credentials";
    String scopes = "PublicApi.Access";
    String Content = " application/x-www-form-urlencoded";
    String Retailer = "ifd";
    String Authorization = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYmYiOjE1NDQzMjg2MzQsImV4cCI6MTU0NDQxNTAzNCwiaXNzIjoiaHR0cDovL2lkLmtpb3R2aWV0LnZuIiwiYXVkIjpbImh0dHA6Ly9pZC5raW90dmlldC52bi9yZXNvdXJjZXMiLCJLaW90VmlldC5BcGkuUHVibGljIl0sImNsaWVudF9pZCI6IjNiOTU2NjVhLThjMjgtNDkyZi04NWY1LWQxYTA5NWU1NDFhOSIsImNsaWVudF9SZXRhaWxlckNvZGUiOiJpZmQiLCJjbGllbnRfUmV0YWlsZXJJZCI6IjUxMDczIiwiY2xpZW50X1VzZXJJZCI6IjIxMjk1MiIsInNjb3BlIjpbIlB1YmxpY0FwaS5BY2Nlc3MiXX0.mGSPmcn7KVen4b6f7-esCaXYSe3yq6iqYakoc7ynmIyTjy4s71M7KO86BqzEzMNyQRaG5mz4v4eg4USs2myDrxTG53b8qO_DGo7fsGmK9xRe7A71ORUaBslV_Ey6LBI9NmlQ_06l8BMOA08Bnh3MDGqv2D7QsdyO9OxaTuvozAWcLgUlnvBVY8lT4MHrl2P153Q2FU7sgojXmzTiNdQWuGqnyr11-wlGiLBQ2DWgGS3gqQQeCxyK6wWcuLqE1wwtsymagyxLvbJFvSqH9coguWo6T8FKXsQ_C04xAIMmXoKolJuDnOOZScOM9CE-3HLXKU6lxszeRe-mwc5ZAT0XCQ";
    // List<NhanVien> listnv = new ArrayList<>();

    String tempNV="";
    ArrayList datumList=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);
        btnxem = (Button) findViewById(R.id.btnCheck);
        tvXem = (TextView) findViewById(R.id.tvXem);
        tvXem2 = (TextView) findViewById(R.id.tvXem2);
        lstNV = (ListView) findViewById(R.id.lstDs);
        lstCode=(ListView) findViewById(R.id.lstCode);
        //Call API_local
        // mAPIService = ApiUnit.getNVService();
        //sendGetAllNV();


        //Call Api_kiotviet
        mAPIService = ApiUnit.getTokentProduct();
        sendGetProduct();

        btnxem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  docexcel();

                Toast.makeText(ApiActivity.this, "respoces" + lstNV.getAdapter().getCount(), Toast.LENGTH_SHORT).show();

                Saveexcel();
               // Toast.makeText(ApiActivity.this, "respoces" + tempNV, Toast.LENGTH_SHORT).show();
              //  ArrayList<NhanVien.NhanvienInfo> datumList = lsNV.datanum;
                ArrayList<String> list = new ArrayList<String>();
                try {

                    JSONArray mainObject = new JSONArray(tempNV);

                    for (int i = 0; i < mainObject.length(); i++) {
                        JSONObject SP = new JSONObject(mainObject.get(i).toString());
                       // String typeTxt = SP.getString("Name").toLowerCase();
                       // tvXem.append(typeTxt);
                       // list.add();
                        list.add(SP.getString("fullName"));
                    }
                   //lstNV.setAdapter(new ArrayAdapter<String>(ApiActivity.this,android.R.layout.simple_list_item_1, list));
                }catch (Exception ex)
                {}
            }
        });


    }

    public void sendToken() {
        //lấy tokent key
        mAPIService.oathToken(client_id, client_secret, grant_type, scopes).enqueue(new retrofit2.Callback<NhanVien>() {
            @Override
            public void onResponse(retrofit2.Call<NhanVien> call, retrofit2.Response<NhanVien> response) {
                String token = response.body().getaccess_token().toString();
                tvXem.setText(token);
            }

            @Override
            public void onFailure(retrofit2.Call<NhanVien> call, Throwable t) {

                Toast.makeText(ApiActivity.this, "Lỗi hệ thống", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void sendGetAllNV() {
        mAPIService.getAllNhanVien().enqueue(new retrofit2.Callback<List<NhanVien>>() {
            @Override
            public void onResponse(Call<List<NhanVien>> call, Response<List<NhanVien>> response) {
                if (response.isSuccessful()) {
                   // listnv = new Gson().toJson(response.body());
                    Toast.makeText(ApiActivity.this, "respoces" + new Gson().toJson(response.body()), Toast.LENGTH_SHORT).show();
                 }
            }

            @Override
            public void onFailure(retrofit2.Call<List<NhanVien>> call, Throwable t) {
                Toast.makeText(ApiActivity.this, "Lỗi hệ thống", Toast.LENGTH_LONG).show();
            }
        });

    }

    public void sendGetProduct() {
        mAPIService.listProduct(Content, Retailer, Authorization).enqueue(new retrofit2.Callback<NhanVien>() {
            @Override
            public void onResponse(retrofit2.Call<NhanVien> call, retrofit2.Response<NhanVien> response) {
                if (response.isSuccessful())
                {
                    try
                    {
                        NhanVien lsNV = response.body();
                        tempNV= new Gson().toJson(response.body());
                       ArrayList<NhanVien.NhanvienInfo> datumList = lsNV.datanum;

                        int dem=1;
                        String[] nv = new String[datumList.size()];
                        String[] nv2 = new String[datumList.size()];
                        for(int i=0;i<datumList.size();i++)
                        {
                            nv[i]=datumList.get(i).getFullName();
                            nv2[i]=datumList.get(i).getCode();
                            dem+=1;

                        }

                      lstNV.setAdapter(new ArrayAdapter<String>(ApiActivity.this,android.R.layout.simple_list_item_1, nv));
                        lstCode.setAdapter(new ArrayAdapter<String>(ApiActivity.this,android.R.layout.simple_list_item_1, nv2));
                        tvXem.setText("asdas"+dem);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else
                    Toast.makeText(ApiActivity.this, "Thất bại!!!!!!!", Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(retrofit2.Call<NhanVien> call, Throwable t) {
                Toast.makeText(ApiActivity.this, "Lỗi hệ thống", Toast.LENGTH_LONG).show();
            }
        });
    }


    void Saveexcel() {
        File sd = Environment.getExternalStorageDirectory();
        String csvFile = "TestApi" +Calendar.getInstance().getTimeInMillis()+Calendar.getInstance().getFirstDayOfWeek() + ".xls";
        //String csvFile = "myData.xls";

        File directory = new File(sd.getAbsolutePath());
        //create directory if not exist
        if (!directory.isDirectory()) {
            directory.mkdirs();
        }
        try {

           // ArrayList<String> list = new ArrayList<String>();
          //  JSONArray mainObject = new JSONArray(listnv);
            //file path
            File file = new File(directory, csvFile);
            WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setLocale(new Locale("en", "EN"));
            WritableWorkbook workbook;
            workbook = Workbook.createWorkbook(file, wbSettings);
            //Excel sheet name. 0 represents first sheet
            WritableSheet sheet = workbook.createSheet("userList", 0);

            sheet.addCell(new Label(0, 0, "TagID")); // column and row
            sheet.addCell(new Label(1, 0, "ProductCode"));
            for (int i = 0; i < lstNV.getAdapter().getCount(); i++) {

                sheet.addCell(new Label(0, i+1 ,  lstNV.getItemAtPosition(i).toString()));
                sheet.addCell(new Label(1, i+1 , lstCode.getItemAtPosition(i).toString()));
            }
           // lstNV.setAdapter(new ArrayAdapter<String>(ApiActivity.this, android.R.layout.simple_list_item_1, list));
            workbook.write();
            workbook.close();
            Toast.makeText(getApplication(), "Data Exported in a Excel Sheet", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void docexcel() {
        File sd = Environment.getExternalStorageDirectory();
        String csvFile = "TestApi" + System.currentTimeMillis() + ".xls";
        //String csvFile = "myData.xls";

        File directory = new File(sd.getAbsolutePath());
        //create directory if not exist
        if (!directory.isDirectory()) {
            directory.mkdirs();
        }
        try {

            ArrayList<String> list = new ArrayList<String>();
           // JSONArray mainObject = new JSONArray(listnv);
            //file path
            File file = new File(directory, csvFile);
            WorkbookSettings wbSettings = new WorkbookSettings();
            wbSettings.setLocale(new Locale("en", "EN"));
            WritableWorkbook workbook;
            workbook = Workbook.createWorkbook(file, wbSettings);
            //Excel sheet name. 0 represents first sheet
            WritableSheet sheet = workbook.createSheet("userList", 0);

            sheet.addCell(new Label(0, 0, "TagID")); // column and row
            sheet.addCell(new Label(1, 0, "ProductCode"));
            for (int i = 0; i < 10; i++) {
               // JSONObject SP = new JSONObject(mainObject.get(i).toString());
              //  list.add(SP.getString("EmployeeCode"));
             //   list.add(SP.getString("Name"));
               // sheet.addCell(new Label(0, i + 1, SP.getString("EmployeeCode")));
            //    sheet.addCell(new Label(1, i + 1, SP.getString("Name")));
            }
            lstNV.setAdapter(new ArrayAdapter<String>(ApiActivity.this, android.R.layout.simple_list_item_1, list));
            workbook.write();
            workbook.close();
            Toast.makeText(getApplication(), "Data Exported in a Excel Sheet", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}


