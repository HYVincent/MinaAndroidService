package com.example.vincent.minaandroidservice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vincent.minaandroidservice.adapter.MsgAdapter;
import com.example.vincent.minaandroidservice.bean.MsgBean;
import com.example.vincent.minaandroidservice.mina_service.MinaUtil;
import com.example.vincent.minaandroidservice.util.IpUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final String TAG = "MainActivity";
    private Button btnSend;
    private EditText etPort;
    private RecyclerView rlvMsg;
    //默认端口
    private int port = 9999;
    //本地ip地址
    private String localServiceIpAddress;
    private List<MsgBean> data = new ArrayList<>();
    private MsgAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlvMsg = findViewById(R.id.main_rv_msg_list);
        etPort = findViewById(R.id.main_et_port);
        btnSend = findViewById(R.id.main_btn_start_mina_service);
        localServiceIpAddress = IpUtil.getIPAddress(this);
        initRecycleVeiw();
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMina(port);
            }
        });
    }


    private void startMina(int port){
        String p = etPort.getText().toString();
        if(!TextUtils.isEmpty(p)){
            port = Integer.valueOf(p);
        }
        refreshMsg(1,"mina will starting run..");
        boolean isSuccess = MinaUtil.startMina(port);
        if(isSuccess){
            refreshMsg(1,"mina start successfuly.local ip address is "+localServiceIpAddress + " port is "+String.valueOf(port));
        }else {
            refreshMsg(1,"mina start fail.");
        }
    }

    /**
     * 添加消息
     * @param msgType   // 0 客户端 1 服务器
     * @param msg //消息内容
     */
    private void refreshMsg(int msgType,String msg){
        MsgBean msgBean = new MsgBean();
        msgBean.setType(msgType);
        msgBean.setContent(msg);
        data.add(msgBean);
        adapter.setData(data);
        rlvMsg.smoothScrollToPosition(data.size()-1);
    }

    private void initRecycleVeiw() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rlvMsg.setLayoutManager(linearLayoutManager);
        adapter = new MsgAdapter(MainActivity.this);
        adapter.setData(data);
        rlvMsg.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MinaUtil.stopMina();
    }
}
