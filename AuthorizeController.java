package Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

public class AuthorizeController {

    @Autowired
    private AuthorizeService authorizeService;


    @RequestMapping(value = "/authorize", method = RequestMethod.POST)
    public ResponseEntity<Object> authorize(@RequestBody Authorization authorization) {

        if (authorization != null) {

            AuthorizeInfo authorizeInfo = new AuthorizeInfo(authorization.getUserId(),
                    UUID.randomUUID().toString(), authorization.getTxAmount(), authorization.getTxAmountCy(),
                    authorization.getTxId(), authorization.getTxTypeId(), authorization.getTxName(),
                    authorization.getProvider(), authorization.getPspService(), authorization.getOriginTxId(),
                    authorization.getAccountId(), authorization.getAccountHolder(), authorization.getMaskedAccount(),
                    authorization.getPspFee(), authorization.getPspFeeCy(), authorization.getPspFeeBase(),
                    authorization.getPspFeeBaseCy(), authorization.getAttributes());

            AuthorizeInfo authorizeInfo1 = authorizeInfo;
            authorizeService.putAuthorizationInfo(authorizeInfo);

            AuthorResponse authorResponse = new AuthorResponse(
                    authorizeInfo1.getUserId(), true, authorizeInfo1.getAuthCode()
            );

            return new ResponseEntity<Object>(authorResponse, HttpStatus.OK);

        }
        //If Authorization is null, empty so no JSON
        else {

            FalseResponse falseResponse = new FalseResponse();

            falseResponse.setUserId(authorization.getUserId());
            falseResponse.setErrCode("123");
            falseResponse.setErrMsg("Empty JSON");
            falseResponse.setSuccess(false);
            return new ResponseEntity<Object>(authorization, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/authorz", method = RequestMethod.GET)
    public List<AuthorizeInfo> getAllAuthorz() {
        return authorizeService.getAuthorizations();
    }

}
