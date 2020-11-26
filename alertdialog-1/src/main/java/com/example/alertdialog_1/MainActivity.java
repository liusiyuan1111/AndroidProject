package com.example.alertdialog_1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.普通按钮对话框
        button1 = findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建对话框
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setIcon(R.drawable.ic_launcher_background);
            alertDialog.setTitle("友情提示");
            alertDialog.setMessage("您已离开地球，确定继续，取消返回");

            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this,"准备返回",Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(MainActivity.this,"确定离开",Toast.LENGTH_SHORT).show();
                }
            });

            alertDialog.show();
            }
        });

        //2.普通列表对话框
        Button button2 = findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String str[] = new String[]{"LOL","王者荣耀","炉石传说","DOTA"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setTitle("你喜欢玩什么游戏？");
                builder.setItems(str, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"我喜欢玩"+str[i],Toast.LENGTH_SHORT).show();
                    }
                });
                builder.create().show();
            }
        });

        //3.单选按钮对话框
        Button button3 = findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String str[] = new String[]{"LOL","王者荣耀","炉石传说","DOTA"};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setTitle("你喜欢玩什么游戏？");

                builder.setSingleChoiceItems(str, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"我喜欢玩"+str[i],Toast.LENGTH_SHORT).show();
                    }
                });

                builder.create().show();
            }
        });

        Button button4 = findViewById(R.id.btn4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String str[] = new String[]{"LOL","王者荣耀","炉石传说","DOTA"};
                final boolean checkID[] = {false,false,false,false};
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setTitle("你喜欢玩什么游戏？");

                builder.setMultiChoiceItems(str, checkID, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean checked) {
                        checkID[i] = checked;
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String text = "";
                        for(int j = 0; j < checkID.length; j++){
                            if (checkID[j]){
                                text += str[j]+";";
                            }
                        }
                        if(text.equals("")){
                            Toast.makeText(MainActivity.this,"什么都不爱玩",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this, "我喜欢玩" + text, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.create().show();
            }
        });
    }
}
