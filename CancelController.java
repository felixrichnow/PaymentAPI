package Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CancelController {

    @Autowired
    private AuthorizeService authorizeService;

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public ResponseEntity<Object> authorize(@RequestBody Cancel cancelation) {

        if (cancelation != null) {
            //Here we will check if there is an authorization for this
            if (authorizeService.checkAuthorInfo(cancelation.getUserId())) {

                CancelInfo cancelInfo = new CancelInfo(cancelation.getAuthCode(), cancelation.getTxAmount(),
                        cancelation.getTxAmountCy(), cancelation.getTxId(),
                        cancelation.getTxTypeId(), cancelation.getTxName(), cancelation.getProvider(),
                        cancelation.getOriginTxId(), cancelation.getAccountId(), cancelation.getMaskedAccount(),
                        cancelation.getStatusCode(), cancelation.getPspStatusCode(), cancelation.getPspFee(),
                        cancelation.getPspFeeCy(), cancelation.getPspFeeBase(), cancelation.getPspRefId(),
                        cancelation.getPspStatusMessage(), cancelation.getAttributes());

                AuthorizeInfo removeInfo = authorizeService.getAuthorInfo(cancelation.getUserId());
                authorizeService.removeAuthorInfo(removeInfo);
                return new ResponseEntity<Object>(cancelInfo, HttpStatus.OK);
            } else {

                FalseResponse falseResponse = new FalseResponse();

                falseResponse.setUserId(cancelation.getUserId());
                falseResponse.setErrCode("123");
                falseResponse.setErrMsg("Unknown Authorizationcode");
                falseResponse.setSuccess(false);
                return new ResponseEntity<Object>(falseResponse, HttpStatus.OK);
            }
        }
        //If Authorization is null, empty so no JSON
        else {

            FalseResponse falseResponse = new FalseResponse();

            falseResponse.setUserId(cancelation.getUserId());
            falseResponse.setErrCode("1");
            falseResponse.setErrMsg("Empty JSON");
            falseResponse.setSuccess(false);

            return new ResponseEntity<Object>(cancelation, HttpStatus.OK);
        }

    }

}


