
package AISS.BitbucketMiner.model.CommentData;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Links__1 {

    @JsonProperty("self")
    private AISS.BitbucketMiner.model.CommentData.Self__1 self;
    @JsonProperty("html")
    private Html__1 html;
    @JsonProperty("avatar")
    private Avatar__1 avatar;

    @JsonProperty("self")
    public AISS.BitbucketMiner.model.CommentData.Self__1 getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(AISS.BitbucketMiner.model.CommentData.Self__1 self) {
        this.self = self;
    }

    @JsonProperty("html")
    public Html__1 getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(Html__1 html) {
        this.html = html;
    }

    @JsonProperty("avatar")
    public Avatar__1 getAvatar() {
        return avatar;
    }

    @JsonProperty("avatar")
    public void setAvatar(Avatar__1 avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Links__1 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("self");
        sb.append('=');
        sb.append(((this.self == null)?"<null>":this.self));
        sb.append(',');
        sb.append("html");
        sb.append('=');
        sb.append(((this.html == null)?"<null>":this.html));
        sb.append(',');
        sb.append("avatar");
        sb.append('=');
        sb.append(((this.avatar == null)?"<null>":this.avatar));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
