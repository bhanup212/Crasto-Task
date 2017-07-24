package pasupula.bhanu.crasto.com.crastotask.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pasupula.bhanu.crasto.com.crastotask.Bean.UserBean;
import pasupula.bhanu.crasto.com.crastotask.R;
import pasupula.bhanu.crasto.com.crastotask.projectUtils.VolleyRequestHandler;

public class MainActivity extends AppCompatActivity {
    private List<UserBean> userBeenList;
    private EditText etPointer, etOffset;
    private Button btnSubmit;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etOffset = (EditText) findViewById(R.id.et_offset);
        etPointer = (EditText) findViewById(R.id.et_pointer);
        btnSubmit = (Button) findViewById(R.id.btn_submit);
        userBeenList = new ArrayList<>();
        progressDialog = new ProgressDialog(MainActivity.this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pointer = etPointer.getText().toString().trim();
                String offSet = etOffset.getText().toString().trim();
                if (!pointer.isEmpty()) {
                    if (!offSet.isEmpty()) {
                        getUserData(offSet, pointer);
                    } else {
                        etOffset.setError("Enter offset Value");
                    }
                } else {
                    etPointer.setError("Enter Pointer Value");
                }
            }
        });

    }

    public void getUserData(String offset, String pointer) {
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        StringRequest userDataRequest = new StringRequest(Request.Method.GET,
                "https://us-central1-cratso-171712.cloudfunctions.net/cratso_internship/leaderboard?pointer=" + pointer + "&offset=" + offset + "", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                progressDialog.dismiss();
                try {
                    UserBean userBean = gson.fromJson(response, UserBean.class);
                    if (userBean.getData().size() > 0) {
                        Intent intent = new Intent(MainActivity.this, UserListActivity.class);
                        intent.putExtra("value", userBean);
                        startActivity(intent);
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage() + "", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
        VolleyRequestHandler.getInstance(getApplicationContext()).addToRequestQueue(userDataRequest);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
