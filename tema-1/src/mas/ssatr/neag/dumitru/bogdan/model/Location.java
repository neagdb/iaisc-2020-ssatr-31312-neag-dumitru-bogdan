package mas.ssatr.neag.dumitru.bogdan.model;

/**
 * author: Bogdan
 */
public class Location extends ObjectualModel {

    private int token;

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public boolean decreaseTokens(){
        if(token == 0){
            return false;
        }else {
            return true;
        }
    }
    public void addToken(){
        token++;
    }
}
