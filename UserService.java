package Payment;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<UserInfo> users = new ArrayList<>(Arrays.asList(
            new UserInfo("1234567", "Storgatan 1", "Storby", "11245", "SWE",
                    "kalle.andersson@gmail.com", "1981-01-01",
                    "+46-733123123", 1000.50, "SEK", "sv_SE",
                    "Kalle", "Andersson"),
            new UserInfo("1234561", "Storgatan 2", "Storby", "11245", "SWE",
                    "kalle.andersson@gmail.com", "1981-01-01",
                    "+46-733123123", 500.50, "SEK",
                    "sv_SE", "Felix", "Andersson")

    ));

    public UserService() {
    }

    public List<UserInfo> getUsers() {
        return users;
    }

    public UserInfo getUserInfo(String userId) {
        return users.stream().filter(t -> t.getUserId().equals(userId)).findFirst().get();
    }

    public Boolean checkUserInfo(String userId) {
        return users.stream().filter(t -> t.getUserId().equals(userId)).findAny().isPresent();
    }

    public void removeUserInfo(UserInfo removeUser) {
        users.remove(removeUser);
    }

    public void putUserInfo(UserInfo userInfo) {
        users.add(userInfo);
    }

    public void updateBalanceInfo(String userId, Number balanceUpdate) {
        users.stream().filter(t -> t.getUserId().equals(userId)).findFirst().get().setBalance(balanceUpdate);
    }


}
