package pasupula.bhanu.crasto.com.crastotask.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bhanu on 7/24/2017.
 */

public class UserBean implements Serializable {


    /**
     * metadata : {"last_entry":false,"pointer":15}
     * data : [{"name":"Sukoon Sharma ","user_id":"3123","profile_pic":"https://png.icons8.com/human-head/color/48","rank":11},{"name":"Ramesh Margie","user_id":"389","profile_pic":"https://png.icons8.com/human-head/color/24","rank":12},{"name":"Muthu Dsuza","user_id":"8231","profile_pic":"https://png.icons8.com/human-head/color/24","rank":13},{"name":"Rachel Antony","user_id":"170","profile_pic":"https://png.icons8.com/human-head/color/24","rank":14},{"name":"Ronit Ratan","user_id":"421","profile_pic":"https://png.icons8.com/human-head/color/24","rank":15}]
     */

    private MetadataBean metadata;
    private List<DataBean> data;

    public MetadataBean getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataBean metadata) {
        this.metadata = metadata;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class MetadataBean implements Serializable{
        /**
         * last_entry : false
         * pointer : 15
         */

        private boolean last_entry;
        private int pointer;

        public boolean isLast_entry() {
            return last_entry;
        }

        public void setLast_entry(boolean last_entry) {
            this.last_entry = last_entry;
        }

        public int getPointer() {
            return pointer;
        }

        public void setPointer(int pointer) {
            this.pointer = pointer;
        }
    }

    public static class DataBean implements Serializable{
        /**
         * name : Sukoon Sharma
         * user_id : 3123
         * profile_pic : https://png.icons8.com/human-head/color/48
         * rank : 11
         */

        private String name;
        private String user_id;
        private String profile_pic;
        private int rank;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getProfile_pic() {
            return profile_pic;
        }

        public void setProfile_pic(String profile_pic) {
            this.profile_pic = profile_pic;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}
