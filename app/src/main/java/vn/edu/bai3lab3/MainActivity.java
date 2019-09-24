package vn.edu.bai3lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String code = intent.getStringExtra("key");

                if (code.length() != 9 ){
                    Toast.makeText(MainActivity.this,"Yêu cầu bạn nhập chuổi gồm 9 ký tự",Toast.LENGTH_LONG).show();
                }
                if (code.startsWith("mem",0)!=true && code.startsWith("vip",0)!=true ){
                    Toast.makeText(MainActivity.this,"Yêu cầu bạn nhập chuổi bắt đầu bằng ký tự MEM hoặc VIP",Toast.LENGTH_LONG).show();
                }
                if (code.equalsIgnoreCase("mem537128")){
                    Toast.makeText(MainActivity.this,"Bạn được khuyến mãi 10% ",Toast.LENGTH_LONG).show();
                }else if (code.equalsIgnoreCase("mem537129")){
                    Toast.makeText(MainActivity.this,"Bạn được khuyến mãi 20% ",Toast.LENGTH_LONG).show();
                }else if (code.equalsIgnoreCase("vip537128")){
                    Toast.makeText(MainActivity.this,"Bạn được khuyến mãi 30% ",Toast.LENGTH_LONG).show();
                }else if (code.equalsIgnoreCase("vip537129")){
                    Toast.makeText(MainActivity.this,"Bạn được khuyến mãi 50% ",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"Bạn không được khuyến mãi",Toast.LENGTH_LONG).show();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("hello");
        registerReceiver(broadcastReceiver, intentFilter);

    }

    public void Check(View view) {
        String name = editText.getText().toString().trim().toLowerCase();
        Intent intent = new Intent("hello");
        intent.putExtra("key", name);
        sendBroadcast(intent);

    }
}
