package Payment;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TransferService {
    private List<TransferInfo> transfers = new ArrayList<>(Arrays.asList(
            new TransferInfo("2", "1234567",
                    "dd14cb2d-623f-46a9-9210-beb8d1f033c9",
                    "169.5", "101", "1337")

    ));

    public TransferService() {
    }

    public List<TransferInfo> getTransfersList() {
        return transfers;
    }

    public TransferInfo getUserInfo(String userId) {
        return transfers.stream().filter(t -> t.getUserId().equals(userId)).findFirst().get();
    }

    public Boolean checkUserInfo(String userId) {
        return transfers.stream().filter(t -> t.getUserId().equals(userId)).findAny().isPresent();
    }

    public void removeUserInfo(TransferInfo removeUser) {
        transfers.remove(removeUser);
    }

    public void putTransferInfo(TransferInfo transferInfo) {
        transfers.add(transferInfo);
    }
}
