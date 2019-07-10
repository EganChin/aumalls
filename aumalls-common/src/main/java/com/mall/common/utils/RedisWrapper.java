package com.mall.common.utils;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Egan
 * @date 2019/3/10 14:44
 **/
public class RedisWrapper{

	private RedisTemplate<String, Object> template;

	private static final String TOKENS = "tokenTable";

    public RedisWrapper(RedisTemplate<String, Object> template) {
        this.template = template;
    }

    public ValueOperations<String, Object> value(){
		return template.opsForValue();
	}

    public RedisTemplate<String, Object> getTemplate() {
        return template;
    }

    /**
     * 尝试获取锁，若获取失败立刻返回
     *
     * @param lock   锁关键字
     * @param expire 锁过期时间
     * @param unit   时间单位
     * @return 获取到锁返回 true，否则返回 false
     */
    public boolean tryLock(String lock, long expire, TimeUnit unit) {
        Boolean b = template.opsForValue().setIfAbsent(lock, lock, expire, unit);
        return b != null && b;
    }

    /**
     * 尝试获取锁，在一定时间内未获取到锁则返回
     *
     * @param lock    锁关键字
     * @param expire  锁过期时间
     * @param unit    时间单位
     * @param timeout 尝试获取的时间, 单位：ms
     * @return 获取到锁返回 true，否则返回 false
     */
    public boolean tryLock(String lock, long expire, TimeUnit unit, long timeout) {
        Boolean b;
        long now = System.currentTimeMillis();
        do {
            if (System.currentTimeMillis() - now > timeout) {
                return false;
            }
            b = template.opsForValue().setIfAbsent(lock, lock, expire, unit);
        } while (!(b != null && b));
        return true;
    }

    public void unlock(String lock) {
        template.delete(lock);
    }

	public void deleteAllToken(Integer id) {
		HashOperations<String, Object, Object> hash = template.opsForHash();
		List<String> tokens = (List<String>) hash.get(TOKENS, id.toString());
		if (tokens != null) {
			template.delete(tokens);
			hash.delete(TOKENS, id.toString());
		}
	}

	public void addToken(Integer id, String token) {
		HashOperations<String, String, Object> hashOperations = template.opsForHash();
		List<String> tokens = (List<String>) hashOperations.get(TOKENS, id.toString());
		if (tokens == null) {
			tokens = new ArrayList<>();
		} else {
			// 清除过期token
			List<String> timeout = new ArrayList<>();
			Iterator<String> iterator = tokens.iterator();
			while (iterator.hasNext()) {
				String next = iterator.next();
				if (!template.hasKey(next)) {
					timeout.add(next);
					iterator.remove();
				}
			}
			if (timeout.size() != 0) {
				template.delete(timeout);
			}
		}
		tokens.add(token);
		hashOperations.put(TOKENS, id.toString(), tokens);
	}

}
