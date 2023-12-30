package bahlawan.com.salesmanagementsystem.AOP;

import bahlawan.com.salesmanagementsystem.models.Sale;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger LOG = LoggerFactory.getLogger(LoggingAspect.class);

    private final static String CREATE_POINT_CUT_EXPRESSION = "execution(public bahlawan.com.salesmanagementsystem.models.Sale create(bahlawan.com.salesmanagementsystem.dtos.CreateSaleRequest))";

    private final static String UPDATE_POINT_CUT_EXPRESSION = "execution(public bahlawan.com.salesmanagementsystem.models.Sale update(int, bahlawan.com.salesmanagementsystem.dtos.UpdateSaleRequest))";

    @AfterReturning(pointcut = CREATE_POINT_CUT_EXPRESSION, returning = "sale")
    public void afterCreate(Sale sale) {
        LOG.info("new sale created at " + sale.getCreationDte() + " with id: " + sale.getSaleId() + " for the client: " + sale.getClient().getName());
    }

    @AfterReturning(pointcut = UPDATE_POINT_CUT_EXPRESSION, returning = "sale")
    public void afterUpdate(Sale sale) {
        LOG.info("quantity and price of the sale with id: "+ sale.getSaleId() + " have been modified");
    }
}
