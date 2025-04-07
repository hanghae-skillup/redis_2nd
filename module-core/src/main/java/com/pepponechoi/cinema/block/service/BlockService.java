package com.pepponechoi.cinema.block.service;

import com.pepponechoi.cinema.blockIps.entity.Block;
import java.time.LocalDateTime;

public interface BlockService {
    boolean isBlocked(String ip);
    void block(String ip, LocalDateTime expireTime);
    Block getBlock(String ip);
    void unblock(String ip);
    void cleanUpBlocks();
}
