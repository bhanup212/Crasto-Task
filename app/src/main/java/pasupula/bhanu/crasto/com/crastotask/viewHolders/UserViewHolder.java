package pasupula.bhanu.crasto.com.crastotask.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import pasupula.bhanu.crasto.com.crastotask.R;

/**
 * Created by Bhanu on 7/24/2017.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView tvRank, tvId, tvName;
    public ImageView ivProfile;

    public UserViewHolder(View itemView) {
        super(itemView);
        tvId = (TextView) itemView.findViewById(R.id.tv_user_id);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvRank = (TextView) itemView.findViewById(R.id.tv_rank);
        ivProfile = (ImageView) itemView.findViewById(R.id.iv_profile);

    }
}
