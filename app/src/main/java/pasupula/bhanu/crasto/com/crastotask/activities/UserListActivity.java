package pasupula.bhanu.crasto.com.crastotask.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pasupula.bhanu.crasto.com.crastotask.Bean.UserBean;
import pasupula.bhanu.crasto.com.crastotask.R;
import pasupula.bhanu.crasto.com.crastotask.adapters.UserAdapter;

/**
 * Created by Bhanu on 7/24/2017.
 */

public class UserListActivity extends AppCompatActivity {
    private List<UserBean> userBeenList;
    private UserBean userBean;
    private UserAdapter userAdapter;
    private RecyclerView rvUsers;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        rvUsers = (RecyclerView) findViewById(R.id.rv_users);
        linearLayoutManager = new LinearLayoutManager(UserListActivity.this, LinearLayoutManager.VERTICAL, false);
        rvUsers.setLayoutManager(linearLayoutManager);
        userBeenList = new ArrayList<>();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            userBean = (UserBean) bundle.getSerializable("value");
            userBeenList.add(userBean);
            userAdapter = new UserAdapter(userBeenList, UserListActivity.this);
            rvUsers.setAdapter(userAdapter);

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(UserListActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
