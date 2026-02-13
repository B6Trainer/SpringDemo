package com.bala.spring.app.rest.controller;

import com.bala.spring.app.rest.dto.BaseRequest;
import com.bala.spring.app.rest.dto.BaseResponse;
import com.bala.spring.app.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseController  implements AppConstants {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
//    @Autowired
//    private ServiceFacade serviceFacade ;

    protected BaseResponse processNewRequest(BaseRequest request) {

        LOGGER.info(request.getRequestAction()
                +" request received. Request body: " + request.toString());

        BaseResponse response= null;//serviceFacade.processRequest(request);

        //LOGGER.info("Response sent : " + response.toString());
        return response;
    }

}

