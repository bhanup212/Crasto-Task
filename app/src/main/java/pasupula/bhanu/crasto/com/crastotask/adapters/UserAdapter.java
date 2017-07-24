package pasupula.bhanu.crasto.com.crastotask.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

import pasupula.bhanu.crasto.com.crastotask.Bean.UserBean;
import pasupula.bhanu.crasto.com.crastotask.R;
import pasupula.bhanu.crasto.com.crastotask.projectUtils.VolleyRequestHandler;
import pasupula.bhanu.crasto.com.crastotask.viewHolders.UserViewHolder;

/**
 * Created by Bhanu on 7/24/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private List<UserBean> userBeen;
    private ImageLoader imageLoader;
    private Activity activity;

    public UserAdapter(List<UserBean> userBeen, Activity activity) {
        this.userBeen = userBeen;
        this.activity = activity;
        imageLoader = VolleyRequestHandler.getInstance(activity).getImageLoader();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, null);
        layoutView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        UserViewHolder rcv = new UserViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        ImageLoader.ImageContainer imageContainer = imageLoader.get(userBeen.get(0).getData().get(position).getProfile_pic(), ImageLoader.getImageListener(holder.ivProfile,
                R.drawable.user, R.drawable
                        .user));
        holder.ivProfile.setImageBitmap(imageContainer.getBitmap());
        holder.tvId.setText("User Id : " + userBeen.get(0).getData().get(position).getUser_id());
        holder.tvRank.setText("Rank : " + userBeen.get(0).getData().get(position).getRank());
        holder.tvName.setText("Name : " + userBeen.get(0).getData().get(position).getName());

    }

    @Override
    public int getItemCount() {
        return userBeen.get(0).getData().size();
    }
}
