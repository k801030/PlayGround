package my.play.ground.cupid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class HttpClient extends HttpClientBase {
    ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        final int SIZE = 100000;
        final String EXPRESSION = "jsonLogic-2";

        // test
        HttpClient app = new HttpClient();
        app.getStatus();
        app.getCampaign();

        // init
        RateLimiter rateLimiter = RateLimiter.create(400);
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);
        ThreadPoolExecutor executor = initThreads();

        // run
        String expression = FileUtil.readFromResource(EXPRESSION);
        for (int i = 0; i < SIZE; i++) {
            executor.execute(() -> {
                rateLimiter.acquire();
                app.postLargeCampaign(expression);
                countDownLatch.countDown();
                log.info("current count={}", countDownLatch.getCount());
            });
        }

        // finish
        countDownLatch.await();
        System.exit(0);

    }

    private static ThreadPoolExecutor initThreads() {
        int corePoolSize = 100;
        int maxPoolSize = 100;
        long keepAliveTime = 1000;
        TimeUnit unit = TimeUnit.SECONDS;
        return new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                unit,
                new LinkedBlockingQueue<>()
        );
    }

    public void postCampaign() {
        Campaign campaign = new Campaign();
        campaign.getRedeemConditions().setExpression("{\"in\":[{\"var\":\"productId\"},[\"p0788133180273\",\"p0788118890223\"]]}");
        log.info("expression length={}", campaign.getRedeemConditions().getExpression().length());
        try {
            post("/api/cupid/v1/campaigns", objectMapper.writeValueAsString(campaign));
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException, message={}", e.getMessage(), e);
        }
    }

    public void postLargeCampaign(String expression) {
        Campaign campaign = new Campaign();

        // log.info("expression length={}", expression.length());
        campaign.getRedeemConditions().setExpression(expression);
        // log.info("expression={}", objectMapper.writeValueAsString(campaign.getRedeemConditions().getexpression()));
        try {
            post("/api/cupid/v1/campaigns", objectMapper.writeValueAsString(campaign));
        } catch (JsonProcessingException e) {
        log.error("JsonProcessingException, message={}", e.getMessage(), e);
    }
    }

    public void getCampaign() {
        get("/api/cupid/v1/campaigns/90374");
    }

    public void getStatus() {
        get("/status.html");
    }

}
