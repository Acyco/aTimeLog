package cn.acyco.atimelog;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    SQLiteDatabase mDb;
    EventLogModel eventLogModel;
    private Button btnAddEvent;
    private EditText editTextEvent;
    View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.btn_add_event) {
                //添加记录
                addEvent();
            }
        }
    };

    private void addEvent() {
        Log.i(TAG, "onClick: btn add ");
        EventLogBean eventLog = new EventLogBean(editTextEvent.getText().toString(), new Date());
        long id= eventLogModel.insert(eventLog);
        if (id > 0) {
            editTextEvent.setText("");
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        //隐藏应用程序标题栏    (能看到手机通知栏)
         requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        /*Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
        ATimeLogApp.getDb(this);
        this.btnAddEvent = findViewById(R.id.btn_add_event);
        this.editTextEvent = findViewById(R.id.edit_text_event);
        this.btnAddEvent.setOnClickListener(mOnClickListener);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        eventLogModel = new EventLogModel(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }
}