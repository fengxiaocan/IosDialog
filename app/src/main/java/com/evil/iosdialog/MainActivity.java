package com.evil.iosdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.evil.ioslibs.DialogCancelListener;
import com.evil.ioslibs.InputDialog;
import com.evil.ioslibs.InputResultListener;
import com.evil.ioslibs.IosDialog;
import com.evil.ioslibs.IosSheetDialog;
import com.evil.ioslibs.OnSheetItemClickListener;
import com.evil.ioslibs.SheetItemColor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtClear;
    private Button mBtSet;
    private Button mBtExit;
    private Button mBtTip;
    private Button mBtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtClear = (Button) findViewById(R.id.bt_clear);
        mBtSet = (Button) findViewById(R.id.bt_set);
        mBtExit = (Button) findViewById(R.id.bt_exit);
        mBtTip = (Button) findViewById(R.id.bt_tip);
        mBtInput = (Button) findViewById(R.id.bt_input);

        mBtClear.setOnClickListener(this);
        mBtSet.setOnClickListener(this);
        mBtExit.setOnClickListener(this);
        mBtTip.setOnClickListener(this);
        mBtInput.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_clear:
                new IosSheetDialog(MainActivity.this)
                        .builder()
                        .setTitle("清空消息列表后，聊天记录依然保留，确定要清空消息列表？")
                        .setCanceledOnTouchOutside(false)
                        .addSheetItem("清空消息列表", SheetItemColor.Red,
                                new OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {

                                    }
                                }).show();
                break;
            case R.id.bt_set:
                new IosSheetDialog(MainActivity.this)
                        .builder()
                        .setCanceledOnTouchOutside(false)
                        .addSheetItem("发送给好友", SheetItemColor.Blue,
                                new OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {

                                    }
                                })
                        .addSheetItem("转载到空间相册", SheetItemColor.Blue,
                                new OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {

                                    }
                                })
                        .addSheetItem("上传到群相册", SheetItemColor.Blue,
                                new OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {

                                    }
                                })
                        .addSheetItem("保存到手机", SheetItemColor.Blue,
                                new OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {

                                    }
                                })
                        .addSheetItem("收藏", SheetItemColor.Blue,
                                new OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {

                                    }
                                })
                        .addSheetItem("查看聊天图片", SheetItemColor.Blue,
                                new OnSheetItemClickListener() {
                                    @Override
                                    public void onClick(int which) {

                                    }
                                }).show();
                break;
            case R.id.bt_exit:
                new IosDialog(this).setTitle("退出提示").setMessage("是否确认退出").setLeftButton("确定",
                        new DialogCancelListener()).setRightButton("取消", new DialogCancelListener
                        ()).show();
                break;
            case R.id.bt_tip:
                new IosDialog(this).setTitle("提示").setMessage("异常登录").setMiddleButton("知道了",
                        new DialogCancelListener
                                ()).show();
                break;
            case R.id.bt_input:
                new InputDialog(this).setTitle("输入").setInputHint("请输入密码")
                        .setInputResultListener(new InputResultListener() {
                            @Override
                            public void onResult(String result) {

                            }
                        }).show();
                break;
        }
    }
}
