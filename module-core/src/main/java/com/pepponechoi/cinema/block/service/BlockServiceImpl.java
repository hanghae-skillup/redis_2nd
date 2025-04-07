package com.pepponechoi.cinema.block.service;

import com.pepponechoi.cinema.blockIps.entity.Block;
import com.pepponechoi.cinema.blockIps.repository.BlockRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BlockServiceImpl implements BlockService {
    private final BlockRepository blockRepository;


    @Override
    public boolean isBlocked(String ip) {
        Optional<Block> block = blockRepository.findByIp(ip);
        return block.isPresent() && block.get().getExpireTime().isAfter(LocalDateTime.now());
    }

    @Override
    public void block(String ip, LocalDateTime expireTime) {
        Block block = Block.of(ip, expireTime);
        blockRepository.save(block);
    }

    @Override
    public Block getBlock(String ip) {
        Optional<Block> block = blockRepository.findByIp(ip);
        return block.orElse(null);
    }

    @Override
    public void unblock(String ip) {
        Optional<Block> block = blockRepository.findByIp(ip);
        if (block.isPresent()) {
            blockRepository.deleteByIp(ip);
        }
    }

    @Override
    @Scheduled(cron = "0 0 * * * *")
    public void cleanUpBlocks() {
        blockRepository.deleteByExpireTimeBefore(LocalDateTime.now());
    }
}
