package Payment;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorizeService {

    private List<AuthorizeInfo> authorizeInformations = new ArrayList<>(Arrays.asList(
            new AuthorizeInfo("1234567", "testCode1", "100.50.", "SEK",
                    "2", 101, "NetellerDeposit", "Neteller", "IDEAL",
                    "1", UUID.fromString("dd14cb2d-623f-46a9-9210-beb8d1f033c9"), "Kalle", "4118122410",
                    "50", "SEK", "50", "SEK", null),
            new AuthorizeInfo("1234561", "testCode2", "100.50.", "SEK",
                    "2", 101, "NetellerDeposit", "Neteller", "IDEAL",
                    "1", UUID.fromString("dd14cb2d-623f-46a9-9210-beb8d1f033c9"), "Felix", "4118122410",
                    "50", "SEK", "50", "SEK", null)

    ));


    public List<AuthorizeInfo> getAuthorizations() {
        return authorizeInformations;
    }

    public AuthorizeInfo getAuthorInfo(String userId) {
        return authorizeInformations.stream().filter(t -> t.getUserId().equals(userId)).findFirst().get();
    }

    public Boolean checkAuthorInfo(String userId) {
        return authorizeInformations.stream().filter(t -> t.getUserId().equals(userId)).findAny().isPresent();
    }

    public Boolean checkAuthorInfoAuthCode(String authCode) {
        return authorizeInformations.stream().filter(t -> t.getAuthCode().equals(authCode)).findAny().isPresent();
    }

    public void putAuthorizationInfo(AuthorizeInfo authorizeInformation) {
        authorizeInformations.add(authorizeInformation);
    }

    public void removeAuthorInfoString(String userId) {
        authorizeInformations.remove(authorizeInformations.stream().filter(t -> t.getUserId().equals(userId)).findFirst().get());
    }

    public void removeAuthorInfo(AuthorizeInfo authorizeInfo) {
        authorizeInformations.remove(authorizeInfo);
    }


}
