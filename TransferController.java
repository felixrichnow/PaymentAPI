package Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@RestController
public class TransferController {

    @Autowired
    private AuthorizeService authorizeService;

    @Autowired
    private UserService userService;

    @Autowired
    private TransferService transferService;

    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    public ResponseEntity<Object> authorize(@RequestBody Transfer transaction) {

        if (transaction != null) {
            //Here we will check if there is an authorization for this

            //authorizeService.checkAuthorInfoAuthCode(transaction.getAuthCode())
            if (authorizeService.checkAuthorInfoAuthCode(transaction.getAuthCode())) {

                UserInfo userInfo = userService.getUserInfo(transaction.getUserId());

                //Float is a weakness here, should be Number, but Number isn't very specific
                Float floatFee = Float.valueOf(transaction.getTxAmount().toString());
                //For some reason, doing toString helps prevents bugs
                BigDecimal c = new BigDecimal(userInfo.getBalance().floatValue()).add(new BigDecimal(floatFee));
                BigDecimal d = new BigDecimal(transaction.getFee()).add(c);

                userService.updateBalanceInfo(userInfo.getUserId(), d);
                userInfo.setBalance(d);

                //Translate it it a transfer info unit, which is stored to keep track of transactions
                TransferInfo transferStorage = new TransferInfo(transaction.getTxId(), transaction.getUserId(),
                        transaction.getAccountId().toString(), transaction.getTxPspAmount(), (transaction.getTxTypeId()).toString()
                        , transaction.getMerchantTxId());
                transferService.putTransferInfo(transferStorage);

                AuthorizeInfo removeInfo = authorizeService.getAuthorInfo(transaction.getUserId());
                authorizeService.removeAuthorInfo(removeInfo);
                return new ResponseEntity<Object>(removeInfo, HttpStatus.OK);
            } else {
                //If there is no Authcode it is still supposed to transfer the money
                UserInfo userInfo = userService.getUserInfo(transaction.getUserId());
                Float floatFee = Float.valueOf(transaction.getTxAmount().toString());
                BigDecimal c = new BigDecimal(userInfo.getBalance().floatValue()).add(new BigDecimal(floatFee));
                BigDecimal d = new BigDecimal(transaction.getFee()).add(c);
                userService.updateBalanceInfo(userInfo.getUserId(), d);

                //Translate it into a transfer info unit, which is stored to keep track of transactions
                //Also we generate a unique transaction ID for the merchant (random)
                TransferInfo transferStorage = new TransferInfo(transaction.getTxId(), transaction.getUserId(),
                        transaction.getAccountId().toString(), transaction.getTxPspAmount(), (transaction.getTxTypeId()).toString(),
                        UUID.randomUUID().toString());
                transferService.putTransferInfo(transferStorage);

                //To formate correct response I use a class just made for it
                TransferResponse transferResponse = new TransferResponse(transferStorage.getUserId(),
                        true, transferStorage.getTxId(), transferStorage.getMerchantTxId());

                return new ResponseEntity<Object>(transferResponse, HttpStatus.OK);
            }
        }
        //If Authorization is null, empty so no JSON
        else {
            FalseResponse falseResponse = new FalseResponse();
            falseResponse.setUserId(transaction.getUserId());
            falseResponse.setErrCode("2");
            falseResponse.setErrMsg("Empty JSON");
            falseResponse.setSuccess(false);
            return new ResponseEntity<Object>(falseResponse, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/transfers", method = RequestMethod.GET)
    public List<TransferInfo> getAllTransfers() {
        return transferService.getTransfersList();
    }
}
