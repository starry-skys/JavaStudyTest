////
//// Source code recreated from a .class file by IntelliJ IDEA
//// (powered by Fernflower decompiler)
////
//
//package com.onecard.core.support.lock;
//
//import com.google.common.collect.Maps;
//import com.onecard.core.support.cache.CacheUtil;
//import com.onecard.core.support.util.StringUtils;
//import java.util.Objects;
//import java.util.concurrent.ConcurrentMap;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang3.RandomUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.data.redis.connection.RedisStringCommands.SetOption;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.types.Expiration;
//import org.springframework.data.redis.serializer.RedisSerializer;
//
//public class RedisLock {
//    private static final Logger log = LoggerFactory.getLogger(RedisLock.class);
//    public static final String MODULE = "LOCK";
//    public static final int EXPIRE = 60;
//    private static final long TIME_OUT = 5L;
//    private static ConcurrentMap<String, RedisLock> map = Maps.newConcurrentMap();
//    private static RedisTemplate<String, String> redisTemplate;
//    private final String value;
//    private final String key;
//
//    private RedisLock(String key, boolean isJoin) {
//        String instanceId = RandomStringUtils.randomAlphabetic(10);
//        if (isJoin) {
//            this.key = CacheUtil.getKey("LOCK", key);
//        } else {
//            this.key = key;
//        }
//
//        this.value = System.currentTimeMillis() + instanceId;
//    }
//
//    public static RedisLock getInstance(String key, boolean isJoin) {
//        if (isJoin) {
//            map.putIfAbsent(key, new RedisLock(key, true));
//            return (RedisLock)map.get(key);
//        } else {
//            return new RedisLock(key, false);
//        }
//    }
//
//    public boolean isLocked() {
//        String val = (String)this.getRedisTemplate().opsForValue().get(this.key);
//        return StringUtils.isNotNull(val);
//    }
//
//    public boolean lockedBySelf() {
//        return Objects.equals(this.getRedisTemplate().opsForValue().get(this.key), this.value);
//    }
//
//    public boolean lock(long timeout) {
//        return this.lock(timeout, 60);
//    }
//
//    public boolean lock() {
//        return this.lock(5L, 60);
//    }
//
//    public synchronized boolean lock(long timeout, int lockTime) {
//        if (this.lockedBySelf()) {
//            return true;
//        } else if (timeout == 0L) {
//            return this.tryLock(lockTime);
//        } else {
//            long nano = System.nanoTime();
//            timeout *= 1000000000L;
//
//            try {
//                while(System.nanoTime() - nano < timeout) {
//                    if (this.tryLock(lockTime)) {
//                        return true;
//                    }
//
//                    Thread.sleep(3L, RandomUtils.nextInt(0, 1000));
//                }
//            } catch (Exception var7) {
//                if (log.isErrorEnabled()) {
//                    log.error("", var7);
//                }
//            }
//
//            return false;
//        }
//    }
//
//    public boolean tryLock() {
//        return this.tryLock(60);
//    }
//
//    public boolean tryLock(int lockTime) {
//        try {
//            if (log.isDebugEnabled()) {
//                log.debug("add RedisLock[" + this.key + "].");
//            }
//
//            return this.setNX(this.key, this.value, lockTime > 0 ? (long)lockTime : 60L);
//        } catch (Exception var3) {
//            log.error("locked error.", var3);
//            return false;
//        }
//    }
//
//    public boolean locked(int lockTime) {
//        return this.tryLock(lockTime);
//    }
//
//    public void unlock() {
//        if (this.lockedBySelf()) {
//            map.remove(this.key);
//            this.getRedisTemplate().delete(this.key);
//            if (log.isDebugEnabled()) {
//                log.debug("release RedisLock[" + this.key + "].");
//            }
//        }
//
//    }
//
//    private Boolean setNX(final String key, final String value, long timeout) {
//        RedisSerializer keySerializer = this.getRedisTemplate().getKeySerializer();
//        RedisSerializer valueSerializer = this.getRedisTemplate().getValueSerializer();
//        byte[] keys = keySerializer.serialize(key);
//        byte[] values = valueSerializer.serialize(value);
//        return Objects.nonNull(keys) && Objects.nonNull(values) ? (Boolean)this.getRedisTemplate().execute((connection) -> {
//            return connection.set(keys, values, Expiration.seconds(timeout), SetOption.SET_IF_ABSENT);
//        }) : false;
//    }
//
//    private RedisTemplate<String, String> getRedisTemplate() {
//        return redisTemplate;
//    }
//
//    public static void setRedisTemplate(RedisTemplate<String, String> resetTemplate) {
//        redisTemplate = resetTemplate;
//    }
//}