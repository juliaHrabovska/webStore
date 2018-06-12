package com.epam.preprod.hrabovska.util.captcha;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import nl.captcha.Captcha;

/**
 * Captcha handler
 */
public class CaptchaUtil {

    private static final Logger LOG = Logger.getLogger(CaptchaUtil.class);

    private final int CAPTCHA_VALUE_DIAPASON = 999999;
    private long captchaAge;
    private Map<String, CaptchaCreator> container;

    public CaptchaUtil(long captchaAge) {
        container = new ConcurrentHashMap<>();
        this.captchaAge = captchaAge;
    }

    private class RemoverOldCaptcha extends TimerTask {

        private String captchaKey;

        RemoverOldCaptcha(String captchaKey) {
            this.captchaKey = captchaKey;
        }

        @Override
        public void run() {
            removeCaptcha();
        }

        private void removeCaptcha() {
            LOG.info("Start removing");
            container.remove(captchaKey);
            LOG.info("End removing");
        }
    }

    public class CaptchaCreator {
        private int value;
        private long time;

        public CaptchaCreator() {
            time = System.currentTimeMillis() + captchaAge;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void invalidateCaptcha() {
            this.time = 0;
        }

        public boolean isAlive() {
            long currentTime = System.currentTimeMillis();
            return time > currentTime;
        }

        public void createCaptchaImage(OutputStream out) {
            Captcha captcha = new Captcha.Builder(200, 50).addText(() -> String.valueOf(value)).build();
            try {
                ImageIO.write(captcha.getImage(), "jpg", out);
            } catch (IOException e) {
                LOG.error(e.getMessage());
            }
        }
    }

    public String generateCaptcha() {
        CaptchaCreator captcha = new CaptchaCreator();
        Random random = ThreadLocalRandom.current();
        String key = String.valueOf(random.nextInt());
        captcha.setValue(random.nextInt(CAPTCHA_VALUE_DIAPASON));
        container.put(key, captcha);
        Timer timer = new Timer(true);
        timer.schedule(new RemoverOldCaptcha(key), captchaAge);
        return key;
    }

    public CaptchaCreator getCaptcha(String key) {
        return container.get(key);
    }

}
