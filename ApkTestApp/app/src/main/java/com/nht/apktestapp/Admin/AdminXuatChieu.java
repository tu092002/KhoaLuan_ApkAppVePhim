package com.nht.apktestapp.Admin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.nht.apktestapp.Adapters.XuatChieuAdapter;
import com.nht.apktestapp.MainActivity;
import com.nht.apktestapp.Model.XuatChieu;
import com.nht.apktestapp.R;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AdminXuatChieu extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    Button btnTimeStart, btnThemXuatChieu,btnSuaXuatChieu, btnHienThi,btnDateStart;
    ListView lvListXuatChieu;
    List<XuatChieu> ls  =  new ArrayList<XuatChieu>();
    LocalTime  timeStart;
    LocalDate dateStart;
    public static LocalDateTime dateTimeStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_xuat_chieu);
        btnDateStart = (Button) findViewById(R.id.btnDateStart);
        lvListXuatChieu = (ListView) findViewById(R.id.lvListXuatChieu);
        btnTimeStart = (Button) findViewById(R.id.btnTimeStart);
        btnThemXuatChieu = (Button) findViewById(R.id.btnThemXuatChieu);
        btnSuaXuatChieu = (Button) findViewById(R.id.btnSuaXuatChieu);
        btnHienThi = (Button) findViewById(R.id.btnHienThiXuatChieu);
    // Điền dữ liệu vào showList
        ls = MainActivity.database.getAllXuatChieuToString();
        XuatChieuAdapter xuatChieuAdapter = new XuatChieuAdapter(AdminXuatChieu.this, ls);
        lvListXuatChieu.setAdapter(xuatChieuAdapter);

        // Tạo một DatePickerDialog
        // Tạo một DatePickerDialog
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this, // Trỏ đến chính Activity này
                year, month, dayOfMonth);

        // Hiển thị DatePickerDialog

        // Tạo một OnTimeSetListener
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                // Xử lý thời gian  được chọn tại  đây
                 timeStart = LocalTime.of(hourOfDay,minute);

                btnTimeStart.setText(hourOfDay + ":" + minute);
            }
        };

        // Khởi tạo TimePickerDialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this, // Context
                listener, // OnTimeSetListener
                12, // Giờ mặc  định
                0, // Phút mặc  định
                false // Hiển thị theo  24 giờ
        );
        // hiển thị DatePickerDialog
        btnDateStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();

            }
        });
        // Hiển thị TimePickerDialog
        btnTimeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();

            }
        });

        btnThemXuatChieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateTimeStart = LocalDateTime.of(dateStart,timeStart);
                XuatChieu p = new XuatChieu(0,dateTimeStart);
               int kq = MainActivity.database.InsertXuatChieu(p);
                if (kq == -1) {
                    Toast.makeText(AdminXuatChieu.this, "Thêm Xuất chiếu Thất bại !", Toast.LENGTH_SHORT).show();

                } else{
                    Toast.makeText(AdminXuatChieu.this, "Thêm Xuất chiếu Thành công !", Toast.LENGTH_SHORT).show();
                    btnTimeStart.setText("Chọn thời gian bắt đầu");
                }
            }
        });
        btnHienThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ls = MainActivity.database.getAllXuatChieuToString();
                XuatChieuAdapter xuatChieuAdapter = new XuatChieuAdapter(AdminXuatChieu.this, ls);
                lvListXuatChieu.setAdapter(xuatChieuAdapter);
            }
        });

        lvListXuatChieu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // xử lí sự kiện code tại vị trí position

                androidx.appcompat.app.AlertDialog.Builder dialog = new androidx.appcompat.app.AlertDialog.Builder(AdminXuatChieu.this);
                dialog.setTitle("XÁC NHẬN");
                dialog.setMessage("Bạn có đồng ý xóa không ? ");
                dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

//                      int  kq = MainActivity.database.DeletePhimToDb(position);
                        try {
//                            String maPhimView = parent.getItemAtPosition(position).toString();
                            MainActivity.database.Querydata("Delete from XuatChieu where " + ls.get(position).getMaXuatChieu() + " == MaXuatChieu ");

                        } catch (Exception e) {
                            Toast.makeText(AdminXuatChieu.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                        }
                        ls.remove(position);
                        xuatChieuAdapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
//                edtTenPhim.setText(list.get(position).getTenPhim().toString());


                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        // Xử lý ngày được chọn
        String date = dayOfMonth + "/" + (month + 1) + "/" + year;
         dateStart = LocalDate.of(year,month +1,dayOfMonth);
        btnDateStart.setText(dayOfMonth + "-" + month + "-" + year);

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}


