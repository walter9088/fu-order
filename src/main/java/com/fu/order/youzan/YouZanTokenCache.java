package com.fu.order.youzan;

import com.alibaba.fastjson.JSON;
import com.fu.order.dto.OauthToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

/**
 * Created by walter on 17/7/11.
 */
@Configuration
@EnableScheduling
public class YouZanTokenCache {

    private static Logger logger = LoggerFactory.getLogger(YouZanTokenCache.class);

    private static OauthToken token;

    /**
     * 一个cron表达式有至少6个（也可能7个）有空格分隔的时间元素。按顺序依次为
     * 秒（0~59）
     * 分钟（0~59）
     * 小时（0~23）
     * 天（月）（0~31，但是你需要考虑你月的天数）
     * 月（0~11）
     * 天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
     * 年份（1970－2099）
     * <p/>
     * 其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),通配符。由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?
     * <p/>
     * 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
     * 0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
     * 0 0 12 ? * WED 表示每个星期三中午12点
     * "0 0 12 * * ?" 每天中午12点触发
     * "0 15 10 ? * *" 每天上午10:15触发
     * "0 15 10 * * ?" 每天上午10:15触发
     * "0 15 10 * * ? *" 每天上午10:15触发
     * "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
     * "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
     * "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
     * "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
     * "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
     * "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
     * "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
     * "0 15 10 15 * ?" 每月15日上午10:15触发
     * "0 15 10 L * ?" 每月最后一日的上午10:15触发
     * "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
     * "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
     * "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
     */
    @Scheduled(cron = "0/604800 * * * * ?") //每20秒执行一次
    public void schedule() {
        cacheYouZanToken();
        logger.info("get youzan token successfly!");
    }

    /**
     * get youzan token
     */
    private static synchronized void cacheYouZanToken() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://open.youzan.com/oauth/token";
        HttpMethod method = HttpMethod.POST;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String body = "client_id=814bf40919ed7ae8bd&client_secret=f884f4c9ac9dee6cba8dc86c2c25cef4&grant_type=silent&kdt_id=19091763";

        HttpEntity requestEntity = new HttpEntity(body, headers);

        try {

            ResponseEntity<String> entity = restTemplate.exchange(url, method, requestEntity, String.class);

            token = JSON.parseObject(entity.getBody(), OauthToken.class);

        } catch (Exception e) {
            logger.error("schedule get youzan token error!", e);
        }
    }

    /**
     * 提供对外youzan access_token获取接口
     * @return youzan access_token
     */
    public static String getToken() {

        if (null == token) {
            cacheYouZanToken();
        }
        return token.getAccess_token();

    }


}
