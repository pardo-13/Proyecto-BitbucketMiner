package AISS.BitbucketMiner.model;

import AISS.BitbucketMiner.model.ProjectData.ProjectData;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;
    private String username;
    private String name;
    private String avatar_url;
    private String web_url;

    public User() {}
    public User( String id, String username, String name, String avatar_url, String web_url) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.avatar_url = avatar_url;
        this.web_url = web_url;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAvatar_url() { return avatar_url; }
    public void setAvatar_url(String avatar_url) { this.avatar_url = avatar_url; }

    public String getWeb_url() { return web_url; }
    public void setWeb_url(String web_url) { this.web_url = web_url; }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ProjectData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("Username");
        sb.append('=');
        sb.append(((this.username == null)?"<null>":this.username));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("Avatar_url");
        sb.append('=');
        sb.append(((this.avatar_url == null)?"<null>":this.avatar_url));
        sb.append(',');
        sb.append(" Web_url");
        sb.append('=');
        sb.append(((this.web_url == null)?"<null>":this.web_url));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
