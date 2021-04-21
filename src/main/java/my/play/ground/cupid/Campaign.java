package my.play.ground.cupid;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class Campaign {
    boolean acquirable = true;
    boolean acquireStopped;
    int acquiredTotal = 0;
    String createdStoreId = "s1";
    String createdUserId = "nevec-user5";
    int dataCompletionStatus = 0;
    DiscountRule discountRule = new DiscountRule();
    boolean hasCodeList = false;
    List<String> participantStoreIds = Arrays.asList("s1", "s2");
    boolean personal = false;
    String property = "NEVEC";
    boolean recommended = true;
    RedeemConditions redeemConditions = new RedeemConditions();
    String acquireEndTs = "2029-10-18T09:50:00Z";
    String acquireStartTs = "2029-10-18T09:50:00Z";
    String redeemEndTs = "2029-10-18T09:50:00Z";
    String redeemStartTs = "2029-10-18T09:50:00Z";
    boolean referral = false;
    boolean referrerCanRedeem = false;
    String title = "test title";

    @Getter
    @Setter
    @Accessors(chain = true)
    class DiscountRule {
        String fixed = "11";
        String percentage = "-1";
        String target = "ITEM";
        String type = "PERCENTAGE_BASED";
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    class RedeemConditions {
        List<String> deviceTags = Collections.emptyList();
        String lineType = "ITEM";
        int minQuantityThreshold = -1;
        int minTotalThreshold = -1;
        List<String> payTypes = Collections.emptyList();
        List<String> shippingTypes = Arrays.asList("7-11");
        List<String> userTags = Collections.emptyList();
        String expression = "true";
    }
}
