package com.j.ui.listView.extendsArrayAdapter.chat;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.j.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/9.
 */
public class MsgActivity extends Activity {
    private ListView listView;
    private EditText receiverContent;
    private EditText sendContent;
    private Button receiver;
    private Button send;
    private MsgAdapter adapter;
    private ArrayList<Msg> msgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.msg);

        sendContent = (EditText) findViewById(R.id.msg_send_content);
        receiverContent = (EditText) findViewById(R.id.msg_receiver_content);
        send = (Button) findViewById(R.id.msg_send);
        receiver = (Button) findViewById(R.id.msg_receiver);
        listView = (ListView) findViewById(R.id.msg_listView);
        initMsg();
        adapter = new MsgAdapter(MsgActivity.this, R.layout.msg_item, msgList);
        listView.setAdapter(adapter);

        receiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = receiverContent.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_RECEIVED);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    listView.setSelection(msgList.size());
                    receiverContent.setText("");
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = sendContent.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    listView.setSelection(msgList.size());
                    sendContent.setText("");
                }
            }
        });
    }

    private void initMsg() {
        msgList.add(new Msg("Hello guy.", Msg.TYPE_RECEIVED));
        msgList.add(new Msg("Hello, who is what?", Msg.TYPE_SENT));
        msgList.add(new Msg("This is tom, Nice to meeting you!.", Msg.TYPE_RECEIVED));
    }
}
